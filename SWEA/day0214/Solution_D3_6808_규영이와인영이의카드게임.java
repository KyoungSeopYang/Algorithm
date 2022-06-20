package com.ssafy.day0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_6808_규영이와인영이의카드게임 {

	static int[] my_deq, your_deq;
	static boolean isSelected[];
	static int win, lose;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			isSelected = new boolean[9];
			my_deq = new int[9];
			your_deq = new int[9];
			win = 0;
			lose = 0;
			for (int i = 0; i < 9; i++) {
				my_deq[i] = Integer.parseInt(st.nextToken());
			}

			loops: for (int i = 1, cnt = 0; i <= 18; i++) {
				for (int j = 0; j < 9; j++) {
					if (my_deq[j] == i)
						continue loops;
				}
				your_deq[cnt++] = i;
			}
			permutation(0, 0, 0);
			System.out.println("#" + tc + " " + win + " " + lose);
		}

	}

	public static void permutation(int cnt, int my_score, int your_score) {
		if (cnt == 9) {
			if (my_score > your_score)
				win++;
			else if (your_score > my_score)
				lose++;
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (isSelected[i])
				continue;
			isSelected[i] = true;

			int sum = my_deq[cnt] + your_deq[i];

			if (my_deq[cnt] > your_deq[i]) {
				permutation(cnt + 1, my_score + sum, your_score);
			} else if (my_deq[cnt] < your_deq[i]) {
				permutation(cnt + 1, my_score, your_score + sum);
			}
			isSelected[i] = false;
		}
	}
}
