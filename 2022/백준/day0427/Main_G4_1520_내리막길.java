package com.ssafy.day0427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_1520_내리막길 {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int ans, map[][], dp[][], M, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		dp = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}

		dfs(0, 0);

		System.out.println(dp[0][0]);
		
	}

	private static int dfs(int row, int col) {
		if (row == M - 1 && col == N - 1)
			return 1;
		if(dp[row][col] != -1) 
			return dp[row][col];
		
		dp[row][col] = 0;
		for (int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			if (nr < 0 || nc < 0 || nr >= M || nc >= N)
				continue;
			if (map[row][col] > map[nr][nc]) {
				dp[row][col] += dfs(nr, nc);
				
			}
		}
		return dp[row][col];
	}
	
}