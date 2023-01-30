package com.ssafy.day0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//12784kb 96ms
public class Main_G4_17471_게리맨더링 {

	static List<Integer> list[];
	static int population[], N, min = Integer.MAX_VALUE;
	static boolean selected[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		population = new int[N + 1];	// 지역구별 인구
		list = new List[N + 1];			// 인접지역
		selected = new boolean[N + 1];	// 선택된 지역

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		select(1);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	private static void select(int idx) {
		if (idx == N + 1) {
			if (check()) {
				int aArea = 0, bArea = 0;
				
				for (int i = 1; i <= N; i++) {
					if(selected[i]) {
						aArea+=population[i];
					} else {
						bArea+=population[i];
					}
				}
				
				min = Math.min(min, Math.abs(aArea-bArea));
			}
			return;
		}

		selected[idx] = true;
		select(idx + 1);

		selected[idx] = false;
		select(idx + 1);

	}

	private static boolean check() {
		int aNode = -1;
		for (int i = 1; i <= N; i++) {
			if (selected[i]) {
				aNode = i;
				break;
			}
		}

		int bNode = -1;
		for (int i = 1; i <= N; i++) {
			if (!selected[i]) {
				bNode = i;
				break;
			}
		}

		if (aNode == -1 || bNode == -1)
			return false;

		boolean[] visited = new boolean[N + 1];

		Queue<Integer> que = new LinkedList<>();
		que.add(aNode);
		visited[aNode] = true;

		while (!que.isEmpty()) {
			int cur = que.poll();

			for (int i = 0; i < list[cur].size(); i++) {
				int node = list[cur].get(i);
				if (visited[node] || !selected[node]) // 해당 노드를 방문했거나 a구역이 아니면
					continue;
				visited[node] = true;
				que.add(node);

			}
		}

		que = new LinkedList<>();
		que.add(bNode);
		visited[bNode] = true;

		while (!que.isEmpty()) {
			int cur = que.poll();

			for (int i = 0; i < list[cur].size(); i++) {
				int node = list[cur].get(i);
				if (visited[node] || selected[node]) // 해당 노드를 방문했거나 b구역이 아니면
					continue;
				visited[node] = true;
				que.add(node);
			}
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i])
				return false;
		}

		return true;
	}

}
