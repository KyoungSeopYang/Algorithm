package com.algo.swea.workshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1289_원재의_메모리_복구하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			String str = br.readLine();
			int count = 1;
			int num = 0;

			while (true) {
				if (str.charAt(num) == '0') {
					num++;
				} else
					break;
			}

			// 그냥 값이 바뀔때마다 +1 하면됨
			for (int j = num; j < str.length() - 1; j++) {
				if (str.charAt(j) != str.charAt(j + 1)) {
					count++;
				}
			}
			System.out.printf("#%d %d\n", i, count);
		}
	}
}
