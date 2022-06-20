package com.ssafy.day0426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//12608kb 84ms
public class Main_G3_2629_양팔저울 {

	static int N, M, weight[];
	static boolean[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		weight = new int[N + 1];
		dp = new boolean[N + 1][15001];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			int bead = Integer.parseInt(st.nextToken());
			if (bead > 15000)	// 추가 만들 수 있는 최대 크기 15000
				sb.append("N ");
			else // 주어진 추로 구슬의 무게를 만들 수 있는지 확인한다
				sb.append(dp[N][bead] ? "Y " : "N ");

		}
		System.out.println(sb); // 출력문

	}

	// cnt번째 까지의 추를 사용해서 만든 weight 무게
	private static void dfs(int cnt, int w) {
		if (dp[cnt][w]) // 방문한적 있으면 return
			return;

		dp[cnt][w] = true; // cnt 번째까지의 추로 무게 w를 만들 수 있다
		if (cnt == N)	// 모든 추를 사용하는 경우 까지 탐색을 했다.
			return;

		dfs(cnt + 1, w + weight[cnt + 1]);	// 추를 오른쪽에 올린다
		dfs(cnt + 1, Math.abs(w - weight[cnt + 1]));	// 추를 왼쪽에 올린다.
		dfs(cnt + 1, w);	// 추를 올리지 않는다

	}

}
