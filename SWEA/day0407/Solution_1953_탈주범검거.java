package com.ssafy.day0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거 {

	static int dr[] = { -1, 1, 0, 0 }, dc[] = { 0, 0, -1, 1 };

	static int tunnelType[][] = { 
			{ 0, 0, 0, 0 }, // 이건 안쓰고
			{ 1, 1, 1, 1 }, // 상하좌우
			{ 1, 1, 0, 0 }, // 상하
			{ 0, 0, 1, 1 }, // 좌우
			{ 1, 0, 0, 1 }, // 상우
			{ 0, 1, 0, 1 }, // 하우
			{ 0, 1, 1, 0 }, // 하좌
			{ 1, 0, 1, 0 } // 상좌
	};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 세로
			int M = Integer.parseInt(st.nextToken()); // 가로
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken()); // 탈출후 지난 시간

			int map[][] = new int[N][M];
			boolean visited[][] = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int ans = 0;

			Queue<Pos> que = new LinkedList();
			que.add(new Pos(R, C, 1));
			visited[R][C] = true;

			while (!que.isEmpty()) {
				Pos cur = que.poll();

				if (cur.time > L)
					break;
				
				ans++;
				int type = map[cur.r][cur.c];

				for (int i = 0; i < 4; i++) {
					// 해당 방향에 길이 있는지 체크
					if (tunnelType[type][i] == 0)
						continue;

					int nr = cur.r + dr[i];
					int nc = cur.c + dc[i];

					if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 0 || visited[nr][nc])
						continue;
					
					int nextType =map[nr][nc];	
					if (i==0 && tunnelType[nextType][1] == 0)
						continue;
					else if (i==1 && tunnelType[nextType][0] == 0)
						continue;
					else if (i==2 && tunnelType[nextType][3] == 0)
						continue;
					else if (i==3 && tunnelType[nextType][2] == 0)
						continue;
						
					visited[nr][nc] = true;
					que.add(new Pos(nr, nc, cur.time + 1));
				}
				
			}
			sb.append("#"+tc).append(" ").append(ans).append("\n");
		} // 테케 종료
		System.out.println(sb);
	}

	static class Pos {
		int r, c, time;

		public Pos(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}

}
