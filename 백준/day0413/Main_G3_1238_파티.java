package com.ssafy.day0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 41824kb 388ms
public class Main_G3_1238_파티 {

	static class Node implements Comparable<Node> {
		int to, weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		List<Node>[] list = new List[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, weight));
		}

		// 각 학생의 최단 왕복 거리를 담을 배열
		int[] ans = new int[N + 1];

		// X까지의 거리 구하기
		for (int start = 1; start <= N; start++) {
			PriorityQueue<Node> que = new PriorityQueue<>();
			// 현재 선택한 마을의 학생이 각 마을을 방문하는 최단 거리
			int[] dist = new int[N + 1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[start] = 0;
			que.offer(new Node(start, 0));

			while (!que.isEmpty()) {
				Node cur = que.poll();

				// X 까지의 거리를 구했으면 더 이상 탐색을 할 필요가 없다.
				if (start != X && cur.to == X) {
					ans[start] += dist[X];
					break;
				}

				if (dist[cur.to] < cur.weight)
					continue;

				for (int i = 0; i < list[cur.to].size(); i++) {
					Node next = list[cur.to].get(i);

					if (dist[next.to] > cur.weight + next.weight) {
						dist[next.to] = cur.weight + next.weight;
						que.offer(new Node(next.to, dist[next.to]));
					}
				}
			}

			// 현재 선택한 마을의 학생이 X이면
			if (start == X) {
				for (int i = 1; i <= N; i++) {
					ans[i] += dist[i];
				}
			}
		}

		int max = 0;

		for (int i = 1; i <= N; i++) {
			max = Math.max(max, ans[i]);
		}
		System.out.println(max);
	}

}
