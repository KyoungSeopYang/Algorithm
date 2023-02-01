package com.ssafy.day0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_G4_2239_스도쿠 {

	static List<int[]> list = new ArrayList<>();
	static int arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9][9];

		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				arr[i][j] = str.charAt(j) - '0';

				if (arr[i][j] == 0)
					list.add(new int[] { i, j });
			}
		}

		solve(0);

	}

	private static void solve(int cnt) {

		if (cnt == list.size()) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}

		int r = list.get(cnt)[0], c = list.get(cnt)[1];

		boolean[] check = new boolean[10];

		// 같은 행, 열에 있는 숫자 체크
		for (int i = 0; i < 9; i++) {
			if (arr[r][i] != 0)
				check[arr[r][i]] = true;
			if (arr[i][c] != 0)
				check[arr[i][c]] = true;
		}

		// 3 * 3 보드에 있는 숫자 체크
		int row = (r / 3) * 3;
		int col = (c / 3) * 3;

		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				if (arr[i][j] != 0) {
					check[arr[i][j]] = true;
				}
			}
		}

		for (int i = 1; i < 10; i++) {
			if (!check[i]) {
				arr[r][c] = i;
				solve(cnt + 1);
				arr[r][c] = 0;
			}
		}
	}

}
