package com.ssafy.day0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//95,924 kb 3,675 ms
public class Solution_5643_키순서 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());

			int adj[][] = new int[N + 1][N + 1];

			StringTokenizer st = null;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				adj[from][to] = 1;
			}

			int ans = 0;
			for (int start = 1; start <= N; start++) {
				int cnt = 0;

				// 나보다 큰 요소 찾기
				Queue<Integer> que = new LinkedList<>();
				boolean[] visited = new boolean[N + 1];
				que.add(start);
				visited[start] = true;

				while (!que.isEmpty()) {
					int cur = que.poll();

					for (int i = 1; i <= N; i++) {
						if (adj[cur][i] == 1 && !visited[i]) {
							que.add(i);
							visited[i] = true;
							cnt++;
						}
					}
				}

				que.offer(start);
				while (!que.isEmpty()) {
					int cur = que.poll();

					for (int i = 1; i <= N; i++) {
						if (adj[i][cur] == 1 && !visited[i]) {
							que.add(i);
							visited[i] = true;
							cnt++;
						}
					}
				}
				if (cnt == N - 1)
					ans++;
			}

			sb.append("#" + tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

}
