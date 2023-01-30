package com.ssafy.day0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_9229_한빈이와SpotMart {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] snacks = new int[N];
			int max = 0;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < snacks.length; i++) {
				snacks[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < snacks.length; i++) {
				for (int j = i + 1; j < snacks.length; j++) {
					int temp = snacks[i] + snacks[j];
					if (temp <= M && temp > max)
						max = temp;
				}
			}

			sb.append((max == 0 ? -1 : max) + "\n");
		}
		System.out.println(sb);
	}

}
