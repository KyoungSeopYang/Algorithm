package com.ssafy.day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_1707_이분그래프 {

	static ArrayList<Integer>[] list;
	static int[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			list = new ArrayList[V + 1];
			visited = new int[V + 1];

			for (int i = 1; i <= V; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				list[from].add(to);
				list[to].add(from);
			}

			boolean flag=true;
			Queue<Integer> queue=new LinkedList<>();
			
			for(int i=1;i<=V;i++) {
				if(visited[i]==0) {
					queue.add(i);
					visited[i]=1;
					
					while(!queue.isEmpty() && flag) {
						int cur = queue.poll();
						for(int next : list[cur]) {
							if(visited[next] ==0) {
								queue.add(next);
								visited[next]=visited[cur]*-1;
							} else if (visited[next]==visited[cur]) {
								flag=false;
								break;
							}
						}
					}
				}
			}
			if(flag) System.out.println("YES");
			else	System.out.println("NO");
		}
	}

}
