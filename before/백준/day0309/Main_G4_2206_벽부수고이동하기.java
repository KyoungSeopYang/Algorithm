package com.ssafy.day0309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 벽을 부수고 간 경우가 특정 위치에 먼저 도달 했지만
 * 부수지 않고 간 경우가 더 빠를 수 있는 반례가 존재
		8 8
		01000100
		01010100
		01010100
		01010100
		01010100
		01010100
		01010100
		00010100
		
 * 그래서 visit을 3중 배열로 만들었어요
 *
 */
public class Main_G4_2206_벽부수고이동하기 {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		boolean[][][] visit = new boolean[N][M][2];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		Queue<Pos> queue = new LinkedList<>();
		queue.offer(new Pos(0, 0, 1, true));
		visit[0][0][0] = true;

		while (!queue.isEmpty()) {
			Pos cur = queue.poll();

			if (cur.x == N - 1 && cur.y == M - 1) {
				System.out.println(cur.cnt);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;

				if (map[nx][ny] == 0) {	// 벽이 없을 때
					if (cur.flag && !visit[nx][ny][0]) {
						queue.offer(new Pos(nx, ny, cur.cnt + 1, true));
						visit[nx][ny][0] = true;
					} else if (!cur.flag && !visit[nx][ny][1]) {
						queue.offer(new Pos(nx, ny, cur.cnt + 1, false));
						visit[nx][ny][1] = true;
					}
				} else if (map[nx][ny] == 1) {	// 벽이 있을 때
					if (cur.flag) {
						queue.offer(new Pos(nx, ny, cur.cnt + 1, false));
						visit[nx][ny][1] = true;
					}
				}
			}
		}
		System.out.println(-1);
	}

	static class Pos {
		int x, y, cnt;
		boolean flag;

		public Pos(int x, int y, int cnt, boolean flag) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.flag = flag;
		}
	}

}
