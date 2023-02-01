package com.ssafy.day0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_3124_최소스패닝트리 {
	
	static int[] parents;
	static Edge[] edgeList;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb =new StringBuilder();
		StringTokenizer st = null;
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			edgeList = new Edge[E];
			parents = new int[V+1];
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				edgeList[i] = new Edge(from, to, weight);
			}
			Arrays.sort(edgeList);
			
			for (int i = 1; i <= V; i++) {
				parents[i] = i;
			}
			
			long result = 0, cnt = 0;
			
			for (Edge edge : edgeList) {
				if (union(edge.from, edge.to)) {
					result += edge.weight;
					if (++cnt == V)
						break;
				}
			}
			sb.append("#").append(tc+" ").append(result).append("\n");
		}
		System.out.println(sb);

	}
	
	private static boolean union(int from, int to) {
		int fromRoot = findSet(from);
		int toRoot = findSet(to);
		
		if(fromRoot == toRoot)
			return false;
		
		parents[fromRoot] = toRoot;
		return true;	
	}

	private static int findSet(int num) {
		if(parents[num] == num) 
			return num;
		return parents[num] = findSet(parents[num]);
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
