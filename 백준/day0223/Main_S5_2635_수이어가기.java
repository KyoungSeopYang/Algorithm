package com.ssafy.day0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
 * 브루트포스
 * 반복문으로 2번째 수를 N/2의 값부터 N의 값까지 하나씩 넣어서 하나의 리스트를 만들어보고
 * max 변수를 통해서 만들어진 리스트의 크기가 최대인지 확인한 후
 * 최대라면 output 리스트에 만들어진 리스트를 넣어서
 * 반복문이 끝나고 난 후
 * max 값과 output리스트의 값을 출력한다.
 */

public class Main_S5_2635_수이어가기 {

	static int max = 0;
	static ArrayList<Integer> output;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		// 2번째 수가 N/2보다 작으면 4번째 수는 무조건 음수가 나온다.
		for (int i = N / 2; i <= N; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(N); // 1번째 수
			list.add(i); // 2번째 수

			while (true) {
				int pre = list.get(list.size() - 2);
				int cur = list.get(list.size() - 1);
				if (pre - cur >= 0) {
					list.add(pre - cur);
				} else
					break;
			}
			if (max < list.size()) {
				max = list.size();
				output = list;
			}
		}

		for (int i = 0; i < output.size(); i++) {
			sb.append(output.get(i) + " ");
		}

		System.out.println(max);
		System.out.println(sb);
	}

}
