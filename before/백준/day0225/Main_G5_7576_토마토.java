package com.ssafy.day0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_7576_토마토 {

	static class Pos {
		int x, y, time;

		public Pos(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int M, N;
	static Queue<Pos> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		int[][] box = new int[N][M];
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1)
					queue.add(new Pos(i, j, 0));
				else if (box[i][j] == 0)
					cnt++;
			}
		}

		int ans = 0;

		while (!queue.isEmpty()) {
			Pos cur = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (isSpread(nx, ny) && box[nx][ny] == 0) {
					box[nx][ny] = 1;
					cnt--;
					queue.add(new Pos(nx, ny, cur.time + 1));
				}
			}
			ans = Math.max(ans, cur.time);
		}
		
		if(cnt > 0 )System.out.println(-1);
		else System.out.println(ans);

	}

	static boolean isSpread(int x, int y) {
		if(x>=0 && x<N && y>=0 && y<M)
			return true;
		else
			return false;
	}

}
