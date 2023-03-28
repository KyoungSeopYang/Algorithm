package com.ssafy.day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2309_일곱난쟁이 {

	static int[] nanjange;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nanjange = new int[9];
		int sum = 0;

		for (int i = 0; i < 9; i++) {
			nanjange[i] = Integer.parseInt(br.readLine());
			sum += nanjange[i];
		}

		Arrays.sort(nanjange);

		loop : for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - nanjange[i] - nanjange[j] == 100) {
					print(i, j);
					break loop;
				}
			}
		}

	}

	private static void print(int a, int b) {
		for (int i = 0; i < nanjange.length; i++) {
			if (i != a && i != b) {
				System.out.println(nanjange[i]);
			}
		}
	}

}