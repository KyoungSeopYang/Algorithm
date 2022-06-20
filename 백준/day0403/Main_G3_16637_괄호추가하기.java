package com.ssafy.day0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 11540kb 80ms
public class Main_G3_16637_괄호추가하기 {

	static ArrayList<Integer> num = new ArrayList<>();
	static ArrayList<Character> op = new ArrayList<>();
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String input = br.readLine();

		for (int i = 0; i < N; i++) {
			if (i % 2 == 0) {
				num.add(input.charAt(i) - '0');
			} else {
				op.add(input.charAt(i));
			}
		}

		dfs(0, num.get(0));
		System.out.println(max);

	}

	private static void dfs(int idx, int sum) {
		if (idx == op.size()) {
			max = Math.max(max, sum);
			return;
		}
			
		int one = cal(idx, sum, num.get(idx + 1));
		dfs(idx + 1, one);

		if(idx+2 <= op.size()) {
			int two = cal(idx + 1, num.get(idx + 1), num.get(idx + 2));
			int result = cal(idx, sum, two);
			dfs(idx + 2, result);
		}
	}

	public static int cal(int op_idx, int a, int b) {
		switch (op.get(op_idx)) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		default:
			return a * b;
		}
	}

}
