package com.ssafy.day0501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//51528kb 172ms
public class Main_G5_12865_평범한배낭 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int obj[][] = new int[N + 1][2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			obj[i][0] = Integer.parseInt(st.nextToken()); // 물건의 무게
			obj[i][1] = Integer.parseInt(st.nextToken()); // 해당 물건의 가치
		}

		// row 번째까지의 물건을 이용해서 col 무게를 만들때의 최대 가치
		int dp[][] = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				int weight = obj[i][0];
				int value = obj[i][1];

				// 현재 물건무게보다 배낭 크기가 작다 or
				// 현재 물건의가치 + 현재 물건을 담고 남은 무게에서 얻을 수 있는 최대가치가
				// 현재 물건을 담지 않았을때의 최대 가치보다 작다면
				if (j < weight || dp[i - 1][j] > dp[i - 1][j - weight] + value )
					dp[i][j] = dp[i - 1][j]; // 현재 물건을 담지 않는다
				else 
					dp[i][j] = dp[i - 1][j - weight] + value; // 그렇지 않다면 현재 물건을 담는다

			}
		}
		
		System.out.println(dp[N][K]);
	}

}
