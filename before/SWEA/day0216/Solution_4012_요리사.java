package com.ssafy.day0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_4012_요리사 {

	static int N, min;
	static int[][] taste;
	static boolean[] isSelected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			taste = new int[N][N];
			isSelected = new boolean[N];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					taste[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			combination(0, 0);
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb);

	}

	public static void combination(int cnt, int start) {

		if (cnt == N / 2) {
			tasteSum();
			return;
		}

		for (int i = start; i < N; i++) {
			isSelected[i] = true;
			combination(cnt + 1, i + 1);
			isSelected[i] = false;
		}

	}

	private static void tasteSum() {
		int a_sum = 0;
		int b_sum = 0;

		List<Integer> aFood = new ArrayList<>();
		List<Integer> bFood = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			if (isSelected[i])
				aFood.add(i);
			else
				bFood.add(i);
		}

		for (int i = 0; i < N / 2; i++) {
			int a = aFood.get(i);
			int b = bFood.get(i);

			for (int j = 0; j < N/2; j++) {
				if (i != j) {
					a_sum+=taste[a][aFood.get(j)];
					b_sum+=taste[b][bFood.get(j)];
				}
			}
		}
		min = Math.min(min, Math.abs(a_sum-b_sum));
		
	}

}
