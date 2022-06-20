package com.ssafy.day0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3234_준환이의양팔저울 {

	static int ans, N, weight[];
	static boolean isSelected[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			weight = new int[N];
			isSelected = new boolean[N];
			ans = 0;
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
				sum += weight[i];
			}

			solve(0, 0, 0, sum);
			System.out.println(ans);
		}

	}

	private static void solve(int cnt, int left, int right, int sum) {
		if (left + sum < right) {
			return;
		}

		if (cnt == N) {
			ans++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isSelected[i])
				continue;

			isSelected[i] = true;
			solve(cnt + 1, left + weight[i], right, sum - weight[i]);
			solve(cnt + 1, left, right + weight[i], sum - weight[i]);
			isSelected[i] = false;

		}
	}

}
