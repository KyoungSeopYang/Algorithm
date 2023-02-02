package com.ssafy.day0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_D4_1218_괄호짝짓기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[] input = br.readLine().toCharArray();
			Stack<Character> stack = new Stack<>();
			int ans = 1;

			for (int i = 0; i < N; i++) {
				char c = input[i];

				if (c == '(' || c == '{' || c == '[' || c == '<') {
					stack.push(c);
				}

				else {
					if (stack.isEmpty()) {
						ans = 0;
						break;
					} else if ((stack.peek() == '(' && c == ')') || (stack.peek() == '{' && c == '}')
							|| (stack.peek() == '[' && c == ']') || (stack.peek() == '<' && c == '>')) {
						stack.pop();
					} else {
						ans = 0;
						break;
					}
				}
			}
			System.out.printf("#%d %d\n", tc, ans);

		}
	}
}
