package com.ssafy.day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2605_줄세우기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int arr[] = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			int temp = Integer.parseInt(st.nextToken());

			if (temp == 0) {
				arr[i] = i;
				continue;
			}

			for (int j = i; j > i - temp; j--) {
				arr[j] = arr[j - 1];
			}

			arr[i - temp] = i;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < arr.length; i++) {
			sb.append(arr[i] + " ");
		}
		System.out.println(sb);
	}

}
