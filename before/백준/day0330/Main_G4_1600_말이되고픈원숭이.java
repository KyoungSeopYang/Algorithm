package com.ssafy.day0330;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_G4_1600_말이되고픈원숭이 {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[] hx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] hy = { 1, 2, 2, 1, -1, -2, -2, -1 };

	static int K,W,H;
	static int[][] map;
	static boolean[][][] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		visit = new boolean[K+1][H][W];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs(0,0);

	}
	
	public static void bfs(int x, int y) {
		Queue<Pos> queue = new LinkedList<>();
		queue.offer(new Pos(0, 0, K, 0));
		visit[K][0][0] = true;

		while (!queue.isEmpty()) {
			Pos cur = queue.poll();
			
			if(cur.x == H-1 && cur.y ==W-1) {
				System.out.println(cur.move);
				return;
			}
			
			if(cur.k != 0) {
				for (int i = 0; i < 8; i++) {
					int nx = cur.x + hx[i];
					int ny = cur.y + hy[i];
					
					// visit[cur.k]로 해서... 메모리초과... 조심...
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visit[cur.k-1][nx][ny]) {
						if(map[nx][ny] != 1) {
							queue.offer(new Pos(nx,ny,cur.k-1,cur.move+1));
							visit[cur.k-1][nx][ny] = true;
						}
					}
				}
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visit[cur.k][nx][ny]) {
					if(map[nx][ny] != 1) {
						visit[cur.k][nx][ny] = true;
						queue.offer(new Pos(nx,ny,cur.k,cur.move+1));
					}
				}
			}
		}
		System.out.println(-1);
	}
}



class Pos {
	int x, y, k, move;

	public Pos(int x, int y, int k, int move) {
		this.x = x;
		this.y = y;
		this.k = k;
		this.move = move;
	}
}
