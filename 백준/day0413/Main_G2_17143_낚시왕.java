package com.ssafy.day0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_G2_17143_낚시왕 {

	static List<Shark> sharkList = new ArrayList<>();
	static int R, C;
	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken()); // 세로
		C = Integer.parseInt(st.nextToken()); // 가로
		int M = Integer.parseInt(st.nextToken()); // 상어 수

		Shark[][] map = new Shark[R + 1][C + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			map[r][c] = new Shark(r, c, s, d, z);
			sharkList.add(map[r][c]);
		}
		int ans = 0; // 낚시왕이 잡은 상어 크기의 합

		for (int col = 1; col <= C; col++) {
			// 해당 열에 있는 상어 중 가장 땅과 가까운 상어를 잡는다.
			for (int row = 1; row <= R; row++) {
				if (map[row][col] != null) {
					ans += map[row][col].z;
					sharkList.remove(map[row][col]);
					map[row][col] = null;
					break;
				}
			}

			// 상어가 이동한다
			int size = sharkList.size();
			for (int i = 0; i < size; i++) {
				Shark shark = sharkList.get(i);
				map[shark.r][shark.c] = null;
				move(shark);
			}

			// 같은 위치에 있는 상어를 잡아먹자
			for (int i = sharkList.size() - 1; i >= 0; i--) {
				Shark shark = sharkList.get(i);

				if (map[shark.r][shark.c] == null)
					map[shark.r][shark.c] = shark;
				
				else {
					
					Shark target = map[shark.r][shark.c];
					if (target.z > shark.z) {
						sharkList.remove(shark);
					} else {
						sharkList.remove(map[shark.r][shark.c]);
						map[shark.r][shark.c] = shark;
					}
					
				}
			}
		}
		System.out.println(ans);

	}

	private static void move(Shark shark) {
		for (int move = 0; move < shark.s; move++) {
			int nr = shark.r + dr[shark.d];
			int nc = shark.c + dc[shark.d];

			// 벽을 만나면 방향을 바꾼다.
			if (nr < 1 || nc < 1 || nr > R || nc > C) {
				changeDirection(shark); // 방향바꾸기
				nr = shark.r + dr[shark.d];
				nc = shark.c + dc[shark.d];
			}

			shark.r = nr;
			shark.c = nc;
		}

	}

	private static void changeDirection(Shark shark) {
		if (shark.d == 1)
			shark.d = 2;
		else if (shark.d == 2)
			shark.d = 1;
		else if (shark.d == 3)
			shark.d = 4;
		else if (shark.d == 4)
			shark.d = 3;
	}

	static class Shark {
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

	}

}
