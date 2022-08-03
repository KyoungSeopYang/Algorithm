package com.ssafy.day0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_14499_주사위굴리기 {

	static int[] dice = new int[7];
	static int[] top = { 1, 1 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 세로
		int M = Integer.parseInt(st.nextToken()); // 가로
		int x = Integer.parseInt(st.nextToken()); // x좌표
		int y = Integer.parseInt(st.nextToken()); // y좌표
		int K = Integer.parseInt(st.nextToken()); // 명령의 개수

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < K; i++) {
			int dir = Integer.parseInt(st.nextToken());
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;

			changeDice(dir);

			if (map[nx][ny] == 0) {
				map[nx][ny] = dice[6];
			} else {
				dice[6] = map[nx][ny];
				map[nx][ny] = 0;
			}

			x = nx;
			y = ny;
		}

		System.out.println(sb.toString());

	}

	private static void changeDice(int dir) {
		int[] temp = dice.clone();

		// 동쪽은 1, 서쪽은 2 , 북쪽은 3, 남쪽은 4
		if (dir == 1) {
			dice[1] = temp[4];
			dice[3] = temp[1];
			dice[4] = temp[6];
			dice[6] = temp[3];
		} else if (dir == 2) {
			dice[1] = temp[3];
			dice[3] = temp[6];
			dice[4] = temp[1];
			dice[6] = temp[4];
		} else if (dir == 3) {
			dice[1] = temp[5];
			dice[2] = temp[1];
			dice[5] = temp[6];
			dice[6] = temp[2];
		} else {
			dice[1] = temp[2];
			dice[2] = temp[6];
			dice[5] = temp[1];
			dice[6] = temp[5];
		}

	}

}
