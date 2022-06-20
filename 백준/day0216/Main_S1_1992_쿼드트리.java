package com.ssafy.day0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S1_1992_쿼드트리 {

	static int map[][];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		solve(0, 0, N);
		System.out.println(sb);

	}

	private static void solve(int x, int y, int size) {

		if (isPossible(x, y, size)) {
			sb.append(map[x][y]);
			return;
		}

		int newsize = size / 2;

		sb.append('(');

		solve(x, y, newsize);
		solve(x, y + newsize, newsize);
		solve(x + newsize, y, newsize);
		solve(x + newsize, y + newsize, newsize);
		
		sb.append(')');
	}

	private static boolean isPossible(int x, int y, int size) {
		int tmp = map[x][y];

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (tmp != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
