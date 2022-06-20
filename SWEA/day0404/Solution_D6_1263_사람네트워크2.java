package com.ssafy.day0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D6_1263_사람네트워크2 {

	static int INF = 1000000; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			int min = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] ==0) {
						arr[i][j] = INF;
					}
				}
			}

			for (int k = 0; k < N; k++) {	// 경유
				for (int i = 0; i < N; i++) {	// 출발
					for (int j = 0; j < N; j++) { // 도착
							arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
					}
				}
			}
			
			for (int i = 0; i <N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					if(arr[i][j] < INF && i != j) {
						sum+= arr[i][j];
					}
				}
				
				min = Math.min(sum, min);
			}
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

}
