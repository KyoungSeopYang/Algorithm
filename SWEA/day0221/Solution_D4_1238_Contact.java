package com.ssafy.day0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1238_Contact {

	static ArrayList<Integer>[] list;
	static ArrayList<Integer> last;
	static int[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#" + tc + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());

			list = new ArrayList[101];
			visited = new int[101];
			last = new ArrayList<>();

			for (int i = 1; i <= 100; i++) {
				list[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				list[from].add(to);
			}

			for (int i = 1; i <= 100; i++) {
				HashSet<Integer> arr = new HashSet<>(list[i]);
				list[i] = new ArrayList<>(arr);
			}

			bfs(S);

		}
		System.out.println(sb);

	}

	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visited[start] = 1;
		int depth = 0, ans = 0;

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for (int i = 0; i < list[cur].size(); i++) {
				if (visited[list[cur].get(i)] == 0) {
					visited[list[cur].get(i)] = visited[cur] + 1;
					queue.offer(list[cur].get(i));
				}
			}
			depth = visited[cur];
		}

		for (int i = 1; i <=100; i++) {
			if(depth == visited[i]) {
				ans = Math.max(ans, i);
			}
		}
	}
}
