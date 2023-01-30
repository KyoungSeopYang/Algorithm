package com.ssafy.day0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_D5_1247_최적경로 {

	static int N, com_x, com_y, home_x, home_y, ans;
	static List<int[]> list;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			ans = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<>(N);
			visited = new boolean[N];
			StringTokenizer st = new StringTokenizer(br.readLine());

			com_x = Integer.parseInt(st.nextToken());
			com_y = Integer.parseInt(st.nextToken());
			home_x = Integer.parseInt(st.nextToken());
			home_y = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new int[] { x, y });
			}

			solve(0, 0, com_x, com_y);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	private static void solve(int n, int dis, int x, int y) {

		if (N == n) {
			dis += Math.abs(x - home_x) + Math.abs(y - home_y);
			ans = Math.min(dis, ans);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			int pos[] = list.get(i);

			int n_x = pos[0];
			int n_y = pos[1];
			int n_dis = dis + Math.abs(x - n_x) + Math.abs(y - n_y);

			if (ans < n_dis)
				continue;

			visited[i] = true;
			solve(n + 1, n_dis, n_x, n_y);
			visited[i] = false;
		}
	}
}
