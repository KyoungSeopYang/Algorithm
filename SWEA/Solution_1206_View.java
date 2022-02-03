package com.algo.swea.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1206_View {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());

			int[] arr = new int[n];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int count = 0;

			for (int i = 2; i < n - 2; i++) {

				int left = Math.min(arr[i] - arr[i - 1], arr[i] - arr[i - 2]);
				int right = Math.min(arr[i] - arr[i + 1], arr[i] - arr[i + 2]);

				if (left <= 0 || right <= 0) {
					continue;
				}

				count += Math.min(left, right);

			}

			System.out.printf("#%d %d\n", t, count);

		}
	}

}
