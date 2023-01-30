package com.ssafy.day0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_4485_녹색옷입은애가젤다지 {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cnt = 1;

		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) {
				System.out.println(sb);
				return;
			}

			StringTokenizer st = null;
			int map[][] = new int[N][N];
			int distance[][] = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
				Arrays.fill(distance[i], Integer.MAX_VALUE);
			}

			PriorityQueue<Pos> pq = new PriorityQueue<Pos>();
			distance[0][0] = map[0][0]; 
			pq.offer(new Pos(0, 0, map[0][0])); 

			while (!pq.isEmpty()) {
				Pos p = pq.poll();

				// 사방탐색
				for (int k = 0; k < 4; k++) {
					int nx = p.x + dx[k];
					int ny = p.y + dy[k];

					// 범위 검사
					if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
						if (distance[nx][ny] > distance[p.x][p.y] + map[nx][ny]) { 
							distance[nx][ny] = distance[p.x][p.y] + map[nx][ny]; 
							pq.offer(new Pos(nx, ny, distance[nx][ny]));
						}
					}
				}
			}
			
			sb.append("Problem "+cnt++).append(": ").append(distance[N-1][N-1]).append("\n");
		}

	}

	static class Pos implements Comparable<Pos> {
		int x, y, rupee;

		public Pos(int x, int y, int rupee) {
			super();
			this.x = x;
			this.y = y;
			this.rupee = rupee;
		}

		@Override
		public int compareTo(Pos o) {
			return this.rupee - o.rupee;
		}

	}

}
