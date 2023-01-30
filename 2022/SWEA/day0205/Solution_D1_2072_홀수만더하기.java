package com.ssafy.day0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D1_2072_홀수만더하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sum = 0;

			for (int i = 0; i < 10; i++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp % 2 != 0) {
					sum += temp;
				}
			}
			sb.append("#"+tc+" ").append(sum+"\n");

		}
		System.out.println(sb);
	}
}
