package com.ssafy.day0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_1249_보급로 {

	static int dr[] = { -1, 1, 0, 0 }, dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int[][] distance = new int[N][N];

			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j) - '0';
				}
				Arrays.fill(distance[i], Integer.MAX_VALUE);
			}

			// ************* solve ****************
			PriorityQueue<Pos> que = new PriorityQueue<>();
			que.add(new Pos(0, 0, 0));
			distance[0][0] = 0;

			while (!que.isEmpty()) {
				Pos cur = que.poll();

				for (int i = 0; i < 4; i++) {
					int nr = cur.r + dr[i];
					int nc = cur.c + dc[i];

					if (nr < 0 || nc < 0 || nr >= N || nc >= N)
						continue;
					
					if(distance[nr][nc] > map[nr][nc]+distance[cur.r][cur.c]) {
						distance[nr][nc] = map[nr][nc]+distance[cur.r][cur.c];
						que.add(new Pos(nr, nc, distance[nr][nc]));
					}
				}
			}
			
			sb.append("#").append(tc+" ").append(distance[N-1][N-1]).append("\n");
		}
		System.out.println(sb);
	}

	static class Pos implements Comparable<Pos> {
		int r, c, depth;

		public Pos(int r, int c, int depth) {
			super();
			this.r = r;
			this.c = c;
			this.depth = depth;
		}

		@Override
		public int compareTo(Pos o) {
			return this.depth - o.depth;
		}

	}
}
