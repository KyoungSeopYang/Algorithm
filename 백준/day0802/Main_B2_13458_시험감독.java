package com.ssafy.day0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2_13458_시험감독 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer peoples = new StringTokenizer(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		long answer = 0;

		for (int i = 0; i < N; i++) {
			int people = Integer.parseInt(peoples.nextToken());

			answer++;
			people -= B;

			if (people < 0)
				continue;

			answer += (people / C);
			answer += people % C != 0 ? 1 : 0;
		}

		System.out.println(answer);

	}

}
