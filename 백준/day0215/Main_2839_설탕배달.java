package com.ssafy.day0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839_설탕배달 {

	static int N, min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

////////// DP
		int dp[] = new int[N + 1];
		int max = Integer.MAX_VALUE;
		for (int i = 0; i < dp.length; i++) {
			dp[i] = max;
		}
		if (N >= 3)
			dp[3] = 1;
		if (N >= 5)
			dp[5] = 1;
		for (int i = 6; i < dp.length; i++) {
			if (dp[i - 3] != max || dp[i - 5] != max) {
				dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
			}
		}
		if(dp[N] == max)
			System.out.println(-1);
		else
			System.out.println(dp[N]);
		
///////////// 그리디
//		int output = 0;
//		
//		while(N>0) {
//			if(N%5==0) {
//				output += N/5;
//				break;
//			} else {
//				N-=3;
//				output++;
//			}
//		}
//		
//		if(N<0) 
//			System.out.println(-1);
//		else
//			System.out.println(output);

	}

}
