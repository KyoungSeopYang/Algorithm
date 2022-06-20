package com.ssafy.day0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_2636_치즈 {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] box = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		int time = 0;
		int count = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					count++;
				}
			}
		}

		int val = 0;
		while (count > 0) {
			val = count;
			time++;
			Queue<Pos> queue = new LinkedList<>();
			queue.offer(new Pos(0, 0));
			visit[0][0] = true;
			while (!queue.isEmpty()) {
				Pos cur = queue.poll();

				for (int i = 0; i < 4; i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];

					if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny]) {
						visit[nx][ny] = true;

						if (box[nx][ny] == 1) {
							box[nx][ny] = 0;
							count--;
						} else {
							queue.offer(new Pos(nx, ny));
						}
					}
				}
			}
			// while 돌때마다 visit만드니까 메모리 초과;;
			for (int i = 0; i < N; i++) {
				Arrays.fill(visit[i], false);
			}
		}
		System.out.println(time);
		System.out.println(val);

	}

	static class Pos {
		int x, y;

		public Pos(int x, int y) {

			this.x = x;
			this.y = y;
		}
	}
}
