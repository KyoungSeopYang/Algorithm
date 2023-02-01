package com.ssafy.day0306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//13708kb , 120ms
public class Main_S2_1012_유기농배추 {

	static int map[][];
	static boolean[][] visit;
	static int M, N;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			visit = new boolean[N][M];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			
			int ans = 0;
			// 해결
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(!visit[i][j] && map[i][j] == 1) {
						bfs(i,j);
						ans++;
					}
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int x, int y) {
		Queue<Pos> queue = new LinkedList<>();
		visit[x][y] = true;
		queue.offer(new Pos(x, y));

		while (!queue.isEmpty()) {
			Pos cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (isfind(nx,ny)) {
					queue.offer(new Pos(nx, ny));
					visit[nx][ny] = true;
				}
			}
		}
	}
	
	private static boolean isfind(int nx, int ny) {
		if (nx < 0 || nx >= N || ny < 0 || ny >= M)
			return false;
		if (map[nx][ny] != 1 || visit[nx][ny])
			return false;

		return true;
	}
	
	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

}
