package com.ssafy.day0323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_14889_스타트와링크 {

	static int N;
	static boolean[] visit;
	static int[][] arr;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		visit = new boolean[N];

		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(0, 0);
		System.out.println(min);
	}

	private static void solve(int idx, int cnt) {

		if (cnt == N / 2) {
			int start = 0;
			int link = 0;

			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if (visit[i] && visit[j]) {
						start += arr[i][j];
						start += arr[j][i];
					} else if (!visit[i] && !visit[j]) {
						link += arr[i][j];
						link += arr[j][i];
					}
				}
			}
			
			int val = Math.abs(start-link);

			if(val == 0) {
				System.out.println(0);
				System.exit(0);
			}
			
			min = Math.min(min, val);
			return;
		}

		for (int i = idx; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				solve(i, cnt + 1);
				visit[i] = false;
			}
		}
	}

}
