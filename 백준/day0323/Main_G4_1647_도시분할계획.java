package com.ssafy.day0323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_1647_도시분할계획 {

	static Edge[] edgelist;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 집의 개수
		int M = Integer.parseInt(st.nextToken()); // 길의 개수
		
		parents = new int[N+1];
		edgelist = new Edge[M];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgelist[i] = new Edge(from, to, weight);
		}
		
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		Arrays.sort(edgelist);
		
		int max = -1;
		int result = 0;
		
		for (Edge edge : edgelist) {
			if(union(edge.from,edge.to)) {
				result += edge.weight;
				max = Math.max(edge.weight, max);
			}
		}
		System.out.println(result-max);
		
	}
	

	private static boolean union(int from, int to) {
		
		int aRoot = find(from);
		int bRoot = find(to);
		
		if (aRoot == bRoot)
			return false;
		
		parents[bRoot] = aRoot; 
		return true;
	}


	private static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}


	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

}


