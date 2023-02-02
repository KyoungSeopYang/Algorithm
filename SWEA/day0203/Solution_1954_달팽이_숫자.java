package com.ssafy.day0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1954_달팽이_숫자 {

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());

			int[][] arr = new int[N][N];

			int num = 1;
			int x = 0;
			int y = 0;
			int dir = 0;

			// 예외처리
			if (N == 1) {
				sb.append("#" + t).append("\n");
				sb.append(1 + "\n");
				continue;
			}

			// 문제 풀이
			while (num <= N * N) {
				arr[x][y] = num;
				if (x + dr[dir] >= N || x + dr[dir] < 0 || y + dc[dir] >= N || y + dc[dir] < 0) {
					if (dir == 3)
						dir = 0;
					else
						dir++;
				}

				if (arr[x + dr[dir]][y + dc[dir]] != 0) {
					if (dir == 3)
						dir = 0;
					else
						dir++;
				}

				x += dr[dir];
				y += dc[dir];
				num++;
			}

			// 출력
			sb.append("#" + t).append("\n");

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(arr[i][j] + " ");
				}
				sb.setLength(sb.length() - 1);
				sb.append("\n");
			}

		}
		System.out.println(sb);
	}
}
