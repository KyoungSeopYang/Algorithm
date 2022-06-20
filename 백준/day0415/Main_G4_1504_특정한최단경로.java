package com.ssafy.day0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//66976kb 516ms
public class Main_G4_1504_특정한최단경로 {

	static class Node implements Comparable<Node> {
		int to, cost;

		public Node(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	static int N;
	static List<Node> list[];
	static int INF = 200000000;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		list = new List[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, cost));
			list[to].add(new Node(from, cost));
		}

		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int case1 = 0, case2 = 0;
		// 1. 출발지 -> 경유지1 -> 경유지2-> 목적지
		// 2. 출발지 -> 경유지2 -> 경유지1-> 목적지
		// 1,2번 중에서 더 작은 쪽을 찾는다.
		// 단 둘다 INF 값이면 두 경우 모두 목적지까지 도달할 수 없다는 뜻
		case1+=dijkstra(1, A);
		case1+=dijkstra(A, B);
		case1+=dijkstra(B, N);
		
		case2+=dijkstra(1, B);
		case2+=dijkstra(B, A);
		case2+=dijkstra(A, N);
		
		if(case1 >= INF && case2 >=INF) {
			System.out.println(-1);
		} else {
			System.out.println(Math.min(case1, case2));
		}

	}

	private static int dijkstra(int start, int end) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);

		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.offer(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (cur.to == end) {
				break;
			}
			
			if (dist[cur.to] < cur.cost)
				continue;

			for (int i = 0; i < list[cur.to].size(); i++) {
				Node next = list[cur.to].get(i);

				if (dist[next.to] > cur.cost + next.cost) {
					dist[next.to] = cur.cost + next.cost;
					pq.offer(new Node(next.to, dist[next.to]));
				}
			}
		}
		return dist[end];
	}

}
