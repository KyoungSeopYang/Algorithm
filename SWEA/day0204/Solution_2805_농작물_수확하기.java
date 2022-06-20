package com.ssafy.day0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2805_농작물_수확하기 {

	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int sum = 0;
			int N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j) - '0';
				}
			}

			for (int i = 0; i < N /2; i++) {
				sum += searchLine(i, N / 2 - i, N / 2 + i);
				sum += searchLine((N-1)-i, N / 2 - i, N / 2 + i);
			}
			sum += searchLine(N / 2, 0, N - 1);
			sb.append("#").append(tc).append(" ").append(sum+"\n");
		}
		System.out.println(sb);

	}

	private static int searchLine(int row, int start, int end) {
		int sum = 0;

		for (int i = start; i <= end; i++) {
			sum += map[row][i];
		}

		return sum;
	}

}
