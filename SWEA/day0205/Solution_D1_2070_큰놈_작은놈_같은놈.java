package com.ssafy.day0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D1_2070_큰놈_작은놈_같은놈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			String[] input = br.readLine().split(" ");
			int n1 = Integer.parseInt(input[0]);
			int n2 = Integer.parseInt(input[1]);
			sb.append("#" + tc + " ");
			switch (Integer.compare(n1, n2)) {
			case 0:
				sb.append("=\n");
				break;
			case 1:
				sb.append(">\n");
				break;
			case -1:
				sb.append("<\n");
				break;
			}
		}
		System.out.println(sb);
	}

}
