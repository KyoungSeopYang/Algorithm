package com.ssafy.day0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_G5_9663_NQueen {

	static int N, ans;
	static int col[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		col = new int[N+1];
		setQueen(1);

		System.out.println(ans);
	}

	private static void setQueen(int row) {

		if (!isAvailable(row - 1))
			return;
		
		if (row > N) {
			ans++;
			return;
		}

		for (int i = 1; i <= N; i++) {
			col[row] = i;
			setQueen(row + 1);
		}
	}

	private static boolean isAvailable(int row) {
		for (int i = 1; i < row; i++) {
			if (col[row] == col[i] || row - i == Math.abs(col[row] - col[i]))
				return false;

		}
		return true;
	}

}
