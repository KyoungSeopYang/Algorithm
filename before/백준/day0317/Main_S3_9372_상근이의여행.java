package com.ssafy.day0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S3_9372_상근이의여행 {

	static int N, M;
	static boolean visit[];
	static int arr[][];
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());// 노드 수
			M = Integer.parseInt(st.nextToken());// 간선 수
			visit = new boolean[N + 1];
			arr = new int[N + 1][N + 1];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				arr[u][v] = 1;
				arr[v][u] = 1;
			}

			bfs();
		}
		System.out.println(sb);

	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(1);
		visit[1] = true;
		int ans = 0;
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			ans++;
			
			for (int i = 1; i <= N; i++) {
				if(arr[node][i] == 1 && !visit[i]) {
					visit[i] = true;
					queue.add(i);
				}
			}
		}
		sb.append(ans-1).append("\n");
	}

}
