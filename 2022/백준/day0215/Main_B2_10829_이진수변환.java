package com.ssafy.day0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B2_10829_이진수변환 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());

		StringBuilder sb = new StringBuilder();

		solution(sb, N);
		System.out.println(sb);
	}

	static void solution(StringBuilder sb, long n) {
		if (n <= 1) {
			sb.append(n);
			return;
		}
		solution(sb, n / 2);
		sb.append(n % 2);
	}

}
