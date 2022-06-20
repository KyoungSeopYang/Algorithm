package com.ssafy.day0420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//11632kb 72ms
public class Main_G3_4577_소코반 {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[] user;
	static int targetCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cnt = 1;

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			if (R == 0 && C == 0)
				break;

			char[][] map = new char[R][C];
			user = new int[2];
			targetCnt = 0;

			for (int i = 0; i < R; i++) {
				String input = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = input.charAt(j);
					if (map[i][j] == 'w' || map[i][j] == 'W') {
						user[0] = i;
						user[1] = j;
					}
					// 여기조건 때문에 50분날림 ㅎㅎ...
					if (map[i][j] == '+' || map[i][j] == 'W')
						targetCnt++;
				}
			}

			char[] order = br.readLine().toCharArray();
			int idx = 0;

			for (int i = 0; i < order.length; i++) {
				switch (order[i]) {
				case 'U':
					idx = 0;
					break;
				case 'D':
					idx = 1;
					break;
				case 'L':
					idx = 2;
					break;
				case 'R':
					idx = 3;
					break;
				}

				move(idx, map);
				if (targetCnt == 0)
					break;
			}
			sb.append("Game ").append(cnt++).append(": ").append(targetCnt == 0 ? "complete" : "incomplete")
					.append("\n");

			for (int i = 0; i < R; i++) {
				sb.append(new String(map[i])).append("\n");
			}
		}
		
		System.out.println(sb);
	}

	private static void move(int idx, char[][] map) {
		int nr = user[0] + dr[idx];
		int nc = user[1] + dc[idx];

		if (map[nr][nc] == 'B' || map[nr][nc] == 'b') {
			int br = nr + dr[idx];
			int bc = nc + dc[idx];
			
			if(map[nr][nc] == 'B' && map[br][bc] == '.') targetCnt++;
			if(map[nr][nc] == 'b' && map[br][bc] == '+') targetCnt--;

			if (map[br][bc] == '.' || map[br][bc] == '+') {
				map[nr][nc] = (map[nr][nc] == 'B') ? '+' : '.';
				map[br][bc] = (map[br][bc] == '.') ? 'b' : 'B';
			}
		}
		
		if (map[nr][nc] == '.' || map[nr][nc] == '+') {
			map[user[0]][user[1]] = (map[user[0]][user[1]] == 'W') ? '+' : '.';
			map[nr][nc] = (map[nr][nc] == '+') ? 'W' : 'w';

			user[0] = nr;
			user[1] = nc;
		}

	}

}
