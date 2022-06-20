package com.ssafy.day0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_S4_11724_연결요소의개수 {

	static List<Integer>[] list;
	static boolean[] visited;
	static int ans, N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new List[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				dfs(i);
				ans++;
			}
		}
		System.out.println(ans);
	}

	static void dfs(int cnt) {
		visited[cnt] = true;

		for (int i = 0; i < list[cnt].size(); i++) {
			if (!visited[list[cnt].get(i)]) {
				dfs(list[cnt].get(i));
			}
		}

	}

}
