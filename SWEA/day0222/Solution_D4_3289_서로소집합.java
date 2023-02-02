package com.ssafy.day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 104,172kb 478ms
public class Solution_D4_3289_서로소집합 {

	static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			parents = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				parents[i] = i;
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if(command == 0) {
					union(a, b);
				} else if(findset(a)==findset(b)) {
					sb.append("1");
				} else {
					sb.append("0");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int findset(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = findset(parents[a]);

	}

	private static void union(int a, int b) {
		int aRoot = findset(a);
		int bRoot = findset(b);
		if (aRoot == bRoot)
			return;

		parents[bRoot] = aRoot;
	}

}
