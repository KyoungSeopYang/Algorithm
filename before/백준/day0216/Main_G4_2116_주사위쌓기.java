package com.ssafy.day0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_2116_주사위쌓기 {

	static int N;
	static int[][] dice;
	static int max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		dice = new int[N][6];

		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= 6; i++) {
			solve(0, i, 0);
		}
		System.out.println(max);
	}

	static void solve(int cnt, int down, int sum) {
		if (cnt == N) {
			max = Math.max(sum, max);
			return;
		}

		int idx = 0;
		int top = 0;

		// 아랫면의 인덱스 구하기
		for (int i = 0; i < 6; i++) {
			if (dice[cnt][i] == down) {
				idx = i;
				break;
			}
		}
		// 윗면 값 구하기
		if (idx == 0)
			top = dice[cnt][5];
		else if (idx == 1)
			top = dice[cnt][3];
		else if (idx == 2)
			top = dice[cnt][4];
		else if (idx == 3)
			top = dice[cnt][1];
		else if (idx == 4)
			top = dice[cnt][2];
		else if (idx == 5)
			top = dice[cnt][0];

		if (top != 6 && down != 6) {
			sum += 6;
		} else if (top >= 5 && down >= 5) {
			sum += 4;
		} else {
			sum += 5;
		}

		solve(cnt + 1, top, sum);

	}

}
