package com.ssafy.day0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D1_2071_평균값구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sum = 0;
			double avg = 0;

			for (int i = 0; i < 10; i++) {
				sum += Integer.parseInt(st.nextToken());
			}

			avg = 1.0 * sum / 10;

			sb.append("#" + tc + " ").append(Math.round(avg) + "\n");
		}
		System.out.println(sb);
	}
}
