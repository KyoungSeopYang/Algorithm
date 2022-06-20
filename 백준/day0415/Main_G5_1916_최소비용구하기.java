package com.ssafy.day0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//	50508kb	368ms
public class Main_G5_1916_최소비용구하기 {

	static class Bus implements Comparable<Bus> {
		int to, cost;

		public Bus(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Bus o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		List<Bus> list[] = new List[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new Bus(to, cost));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		// 다익스트라 시작
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		PriorityQueue<Bus> pq = new PriorityQueue<>();
		// 시작 지점 세팅
		pq.offer(new Bus(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Bus cur = pq.poll();
			
			if(cur.to == end) {
				System.out.println(dist[end]);
				return;
			}
			
			if (dist[cur.to] < cur.cost)
				continue;
			
			for (int i = 0; i < list[cur.to].size(); i++) {
				Bus next = list[cur.to].get(i);
				
				if(dist[next.to] > cur.cost + next.cost ) {
					dist[next.to] = cur.cost + next.cost;
					pq.offer(new Bus(next.to,dist[next.to]));
				}
			}
		}

	}

}
