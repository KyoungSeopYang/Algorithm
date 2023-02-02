package com.ssafy.day0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D1_2068_최대수구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int max = 0;

			for (int i = 0; i < 10; i++) {
				max = Math.max(max, Integer.parseInt(st.nextToken()));
			}
			sb.append("#" + tc + " ").append(max + "\n");
		}
		System.out.println(sb);

	}

}
