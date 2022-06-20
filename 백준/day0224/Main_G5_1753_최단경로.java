package com.ssafy.day0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G5_1753_최단경로 {

	static class Node implements Comparable<Node> {
		int v, weight;
		Node link;

		public Node(int v, int weight, Node link) {
			super();
			this.v = v;
			this.weight = weight;
			this.link = link;
		}

		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		Node[] node = new Node[V + 1];

		PriorityQueue<Node> q = new PriorityQueue<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			node[u] = new Node(v, w, node[u]);
		}

		boolean visited[] = new boolean[V + 1];
		int[] distance = new int[V + 1];

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[K] = 0;

		for (int i = 1; i <= V; i++) {
			int min = Integer.MAX_VALUE, current = 0;
			for (int j = 1; j <= V; j++) {
				if (!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}

			visited[current] = true;

			for (Node n = node[current]; n != null; n = n.link) {
				if (!visited[n.v] && distance[n.v] > distance[current] + n.weight) {
					distance[n.v] = distance[current] + n.weight;
				}
			}

		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if (distance[i] != Integer.MAX_VALUE) {
				sb.append(distance[i]).append("\n");
			} else {
				sb.append("INF").append("\n");
			}
		}
		System.out.println(sb);
	}

}