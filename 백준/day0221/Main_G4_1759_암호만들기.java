package com.ssafy.day0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//12304kb 80ms
public class Main_G4_1759_암호만들기 {

	static boolean[] isSelected;
	static char[] input, output;
	static int C, L;
	static StringBuilder sb;
	static char[] vowel = { 'a', 'e', 'i', 'o', 'u' };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		input = new char[C];
		output = new char[L];
		isSelected = new boolean[C];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			input[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(input);
		for (int i = 0; i <= C - L; i++) {
			isSelected[i] = true;
			output[0] = input[i];
			solve(1, i + 1);
			isSelected[i] = false;
		}
		System.out.println(sb);
	}

	// a c i s t w
	private static void solve(int cnt, int start) {
		if (cnt == L) {
			if (able()) {
				for (int i = 0; i < L; i++) {
					sb.append(output[i]);
				}
				sb.append("\n");
			}
			return;
		}

		for (int i = start; i < C; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				output[cnt] = input[i];
				solve(cnt + 1, i + 1);
				isSelected[i] = false;
			}
		}
	}

	private static boolean able() {
		int vow = 0;
		int con = 0;

		loop: for (int i = 0; i < L; i++) {
			for (int j = 0; j < 5; j++) {
				if (output[i] == vowel[j]) {
					vow++;
					continue loop;
				}
			}
			con++;
		}

		if (con >= 2 && vow >= 1)
			return true;
		else
			return false;
	}

}
