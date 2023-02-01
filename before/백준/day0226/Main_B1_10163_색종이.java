package com.ssafy.day0226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B1_10163_색종이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int map[][] = new int[1001][1001];
		int[] ans = new int[N+1];
		StringTokenizer st = null;

		for (int t = 1; t <= N; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			for (int i = x; i < x + w; i++) {
				for (int j = y; j < y + h; j++) {
					if (map[i][j] != 0) {
						ans[map[i][j]]--;
					}
					map[i][j] = t;
					ans[t]++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <=N; i++) {
			sb.append(ans[i]+"\n");
		}
		System.out.println(sb);
	}

}
