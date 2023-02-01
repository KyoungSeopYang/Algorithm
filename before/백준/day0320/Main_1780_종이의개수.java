package com.ssafy.day0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1780_종이의개수 {

	static int N;
	static int map[][];
	static int[] ans = new int[3];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		split(0, 0, N);

		for (int n : ans) {
			System.out.println(n);
		}
	}

	private static void split(int x, int y, int size) {

		if (isAvailable(x, y, size)) {
			ans[map[x][y] + 1]++;
			return;
		}

		int nSize = size / 3;
		split(x, y, nSize);
		split(x, y + nSize, nSize);
		split(x, y + nSize * 2, nSize);

		split(x + nSize, y, nSize);
		split(x + nSize, y + nSize, nSize);
		split(x + nSize, y + nSize * 2, nSize);

		split(x + nSize * 2, y, nSize);
		split(x + nSize * 2, y + nSize, nSize);
		split(x + nSize * 2, y + nSize * 2, nSize);

	}

	private static boolean isAvailable(int x, int y, int size) {
		int cur = map[x][y];

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (map[i][j] != cur) {
					return false;
				}
			}
		}

		return true;
	}

}
