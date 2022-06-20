package com.ssafy.day0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244_스위치켜고끄기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int stuN = Integer.parseInt(br.readLine());
		int[] switchArr = new int[N + 1];
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			switchArr[i] = Integer.parseInt(st.nextToken());
		}

		for (int tc = 0; tc < stuN; tc++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());

			if (gender == 1) { // 남자면
				for (int i = number; i <= N; i += number) {
					switchArr[i] ^= 1;
				}
			} else { // 여자면
				switchArr[number] ^= 1;
				int idx = 1;
				while (number - idx > 0 && number + idx <= N) {
					if (switchArr[number - idx] == switchArr[number + idx]) {
						switchArr[number - idx] ^= 1;
						switchArr[number + idx] ^= 1;
						idx++;
					} else
						break;
				}
			}

		}
		for (int i = 1; i < switchArr.length; i++) {
			sb.append(switchArr[i] + " ");
			if (i % 20 == 0)
				sb.append("\n");
		}
		System.out.println(sb);

	}

}
