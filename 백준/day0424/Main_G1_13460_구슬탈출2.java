package com.ssafy.day0424;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//148380kb 504ms
public class Main_G1_13460_구슬탈출2 {

	static class Pos {
		int r, c, cnt;

		public Pos(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static char map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new char[N][M]; // 보드의 초기 상태 입력
		Pos red = null;
		Pos blue = null;

		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = input[j];

				if (map[i][j] == 'R') {
					red = new Pos(i, j, 0);
					map[i][j] = '.';
				} else if (map[i][j] == 'B') {
					blue = new Pos(i, j, 0);
					map[i][j] = '.';
				}

			}
		}

		// Solve
		Queue<Pos> redQue = new LinkedList<>();
		Queue<Pos> blueQue = new LinkedList<>();

		redQue.offer(red);
		blueQue.offer(blue);

		while (true) {
			red = redQue.poll();
			blue = blueQue.poll();

			for (int i = 0; i < 4; i++) {
				
				// 먼저 구슬을 움직여 본다.
				Pos nRed = move(red, i);
				Pos nBlue = move(blue, i);

				if (map[nBlue.r][nBlue.c] == 'O') // 파란 구슬이 들어갔으면
					continue;
				else if (map[nRed.r][nRed.c] == 'O') { // 빨간 구슬이 들어갔으면
					System.out.println(nRed.cnt); // 움직인 회수를 출력
					System.exit(0); // 프로그램 종료
				}
				
				if (nRed.cnt > 10) { // 10번의 움직임으로 구멍을 빼내지 못했다
					System.out.println(-1);
					System.exit(0); // 프로그램 종료
				}

				// 빨간구슬과 파란구슬이 같은 위치에 존재한다면?
				if (nRed.r == nBlue.r && nRed.c == nBlue.c) {
					int nr = red.r;
					int nc = red.c;

					while (true) { // 빨간 구슬을 시작지점부터 진행방향으로 이동시켜 본다.
						nr += dr[i];
						nc += dc[i];

						//진행 방향에 파란구슬이 있다면 파란구슬이 먼저 움직여야한다.
						if (blue.r == nr && blue.c == nc) {
							nRed.r -= dr[i];
							nRed.c -= dc[i];
							break;
						} else if (map[nr][nc] == '#') { // 진행방향에 파란구슬이 없다면 빨간구슬이 먼저 움직인다.
							nBlue.r -= dr[i];
							nBlue.c -= dc[i];
							break;
						}
					}
				}

				// 구슬이 구멍에 들어가지 않았다면 다음 움직임을 탐색
				redQue.offer(nRed);
				blueQue.offer(nBlue);
			}
		}
	}

	private static Pos move(Pos bead, int dir) {
		int nr = bead.r;
		int nc = bead.c;

		while (true) {
			nr += dr[dir];
			nc += dc[dir];

			if (map[nr][nc] == '#') { // 벽까지 굴러갔으면 벽 직전의 위치를 리턴한다.
				nr -= dr[dir];
				nc -= dc[dir];
				break;
			} else if (map[nr][nc] == 'O') // 구멍에 들어갔으면 구멍위치를 리턴한다.
				break;
		}
		return new Pos(nr, nc, bead.cnt + 1);
	}

}
