package com.ssafy.day0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D3_1228_암호문1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		LinkedList<String> list = new LinkedList<>();

		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#" + tc + " ");
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				list.addLast(st.nextToken());
			}

			int comand = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < comand; i++) {
				st.nextToken();

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				for (int j = 0; j < y; j++) {
					list.add(x + j, st.nextToken());
				}
			}

			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i) + " ");
			}
			sb.append("\n");
			list.clear();
		}
		System.out.println(sb);
	}

}
