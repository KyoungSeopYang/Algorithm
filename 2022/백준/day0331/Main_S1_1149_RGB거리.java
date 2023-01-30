package com.ssafy.day0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_1149_RGB거리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[3][N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		dp[0][1] = Integer.parseInt(st.nextToken());
		dp[1][1] = Integer.parseInt(st.nextToken());
		dp[2][1] = Integer.parseInt(st.nextToken());
		
		for (int i = 2; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			dp[0][i] = Math.min(dp[1][i-1],dp[2][i-1])+ r;
			dp[1][i] = Math.min(dp[0][i-1],dp[2][i-1])+ g;
			dp[2][i] = Math.min(dp[0][i-1],dp[1][i-1])+ b;
		}
		
		int min = Math.min(dp[0][N], dp[1][N]);
		min = Math.min(dp[2][N], min);
		
		System.out.println(min);
	}

}
