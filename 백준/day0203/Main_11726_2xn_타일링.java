package com.ssafy.day0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11726_2xn_타일링 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int dp[] = new int[1001];
		dp[1] = 1;
		dp[2] = 2;
		
		//dp[i-1]에 세로 블럭 하나를 합친 것과 dp[i-2]에 가로블럭 두개를 합친것이 dp[i]
		for (int i = 3; i < N + 1; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2])%10007;
		}

		System.out.println(dp[N]);
	}

}
