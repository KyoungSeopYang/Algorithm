package com.ssafy.day0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_3499_퍼펙트셔플 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			int N = Integer.parseInt(br.readLine());

			Queue<String> first_deq = new LinkedList<String>();
			Queue<String> second_deq = new LinkedList<String>();
			StringTokenizer st = new StringTokenizer(br.readLine());

			if (N % 2 != 0)
				first_deq.add(st.nextToken());

			for (int i = 0; i < N / 2; i++) {
				first_deq.add(st.nextToken());
			}

			for (int i = 0; i < N / 2; i++) {
				second_deq.add(st.nextToken());
			}

			if (N % 2 == 0) {
				for (int i = 0; i < N / 2; i++) {
					sb.append(first_deq.poll() + " ");
					sb.append(second_deq.poll() + " ");
				}
				sb.append("\n");
			} else {	// n이 홀수면 한번더 뽑아
				for (int i = 0; i < N / 2; i++) {
					sb.append(first_deq.poll() + " ");
					sb.append(second_deq.poll() + " ");
				}
				sb.append(first_deq.poll());
				sb.append("\n");
			}

		}
		System.out.println(sb);
	}

}
