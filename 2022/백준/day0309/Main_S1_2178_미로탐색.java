package com.ssafy.day0309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_2178_미로탐색 {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		boolean[][] visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		Queue<Pos> queue = new LinkedList<>();
		queue.offer(new Pos(0, 0));
		visit[0][0] = true;

		while (!queue.isEmpty()) {
			Pos cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;

				if (!visit[nx][ny] && map[nx][ny] == 1) { // 이동할 수 있다면
					queue.offer(new Pos(nx, ny));
					map[nx][ny] = map[cur.x][cur.y] + 1; // 현재 칸까지 오는데 걸린 최소 칸 수 + 1 
					visit[nx][ny] = true;
				}
			}
		}

		System.out.println(map[N - 1][M - 1]);
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
