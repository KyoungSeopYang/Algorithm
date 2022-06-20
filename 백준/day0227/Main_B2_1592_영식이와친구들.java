package com.ssafy.day0227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2_1592_영식이와친구들 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] man = new int[N];

		int idx = 0;
		int ans = 0;

		while (true) {
			man[idx]++;
			if (man[idx] == M)
				break;

			if (man[idx] % 2 == 0) {
				idx -= L;
			} else {
				idx = (idx + L) % N;
			}

			if (idx < 0) {
				idx = N+ idx;
			}
			ans++;
		}

		System.out.println(ans);
	}
}
