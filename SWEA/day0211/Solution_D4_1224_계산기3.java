package com.ssafy.day0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution_D4_1224_계산기3 {

	static int priority(char c) {
		if (c == '(') {
			return 0;
		} else if (c == '+') {
			return 1;
		} else {
			return 2;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			Queue<Character> oper = new LinkedList<>();
			Stack<Character> temp = new Stack<>();

			char[] input = br.readLine().toCharArray();

			for (int i = 0; i < input.length; i++) {

				if (input[i] >= '0' && input[i] <= '9') {
					oper.add(input[i]);
				} else if (input[i] == '(') {
					temp.add(input[i]);
				} else if (input[i] == ')') {
					while (!temp.isEmpty()) {
						if (temp.peek() == '(') {
							temp.pop();
							break;
						}
						oper.add(temp.pop());
					}
				} else {
					while (!temp.isEmpty() && priority(input[i]) <= priority(temp.peek())) {
						oper.add(temp.pop());
					}
					temp.push(input[i]);
				}
			}

			while (!temp.isEmpty()) {
				oper.add(temp.pop());
			}

			Stack<Integer> cal = new Stack<>();

			while (!oper.isEmpty()) {
				if (oper.peek() >= '0' && oper.peek() <= '9') {
					cal.add(oper.poll() - '0');
				} else {
					int n2 = cal.pop();
					int n1 = cal.pop();

					if (oper.poll() == '*') {
						cal.add(n1 * n2);
					} else {
						cal.add(n1 + n2);
					}
				}
			}

			System.out.println("#" + tc + " " + cal.pop());

		}
	}

}
