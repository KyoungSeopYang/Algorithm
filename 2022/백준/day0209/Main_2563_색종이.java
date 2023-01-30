package com.ssafy.day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2563_색종이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] paper = new int[100][100];

		int N = Integer.parseInt(br.readLine());
		int over = 0;
		for (int n = 0; n < N; n++) {
			String[] str = br.readLine().split(" ");
			int x = Integer.parseInt(str[1]);
			int y = Integer.parseInt(str[0]);

			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					if (paper[i][j] == 1) {
						over++;
					} else
						paper[i][j]++;
				}
			}
		}
		System.out.println(N * 100 - over);

	}

}
