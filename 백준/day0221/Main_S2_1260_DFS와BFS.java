package com.ssafy.day0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_1260_DFS와BFS {

	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int N, M, V;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
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
			Collections.sort(list[i]);
		}
		
		dfs(V);
		sb.append("\n");
		bfs(V);

		System.out.println(sb);

	}

	static void dfs(int cnt) {

		visited[cnt] = true;
		sb.append(cnt + " ");

		for (int i = 0; i < list[cnt].size(); i++) {
			if (!visited[list[cnt].get(i)]) {
				dfs(list[cnt].get(i));
			}
		}
	}

	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited = new boolean[N+1];
		
		queue.offer(start);
		visited[start]=true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current+" ");
			
			for (int i = 0; i < list[current].size(); i++) {
				if(!visited[list[current].get(i)]) {
					visited[list[current].get(i)] = true;
					queue.offer(list[current].get(i));
				}
			}
		}
		
	}

}
