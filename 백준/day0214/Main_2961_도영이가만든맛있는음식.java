package com.ssafy.day0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961_도영이가만든맛있는음식 {

	static int[][] taste;
	static int N, min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		taste = new int[N][2];
		min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			taste[i][0] = Integer.parseInt(st.nextToken());
			taste[i][1] = Integer.parseInt(st.nextToken());
		}

		combination(0, 1, 0);
		System.out.println(min);
	}

	private static void combination(int start, int sour, int bitter) {
		if (start == N) {
			if (sour == 1 && bitter == 0)
				return;
			min = Math.min(Math.abs(sour - bitter), min);
			return;
		}
		for (int i = start; i < N; i++) {
			combination(i + 1, sour * taste[i][0], bitter + taste[i][1]);
			combination(i + 1, sour, bitter);
		}
	}
}
