package com.ssafy.day0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_5215_햄버거다이어트 {

	static int[][] input;
	static int N, L,max;

	static void combination(int start, int kcal, int satis) {
		if (kcal>=L) return;		
		max = Math.max(max, satis);
		
		for (int i = start; i < N; i++) {
			if(kcal+input[i][1] <= L) {
				combination(i + 1, kcal+input[i][1], satis+input[i][0]);
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			input = new int[N][2];
			max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				input[i][0] = Integer.parseInt(st.nextToken());
				input[i][1] = Integer.parseInt(st.nextToken());
			}

			combination(0, 0, 0);
			System.out.printf("#%d %d\n",tc,max);
			
		}
	}

}
