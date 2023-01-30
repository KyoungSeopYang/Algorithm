package com.ssafy.day0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution_D4_1223_계산기2 {

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
				} else if (temp.isEmpty()) {
					temp.add(input[i]);
				} else if (input[i] == '*') {
					while (!temp.isEmpty() && temp.peek() == '*') {
						oper.add(temp.pop());
					}
					temp.add(input[i]);
				} else {
					while (!temp.isEmpty()) {
						oper.add(temp.pop());
					}
					temp.add(input[i]);
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

			System.out.println("#"+tc+" "+cal.pop());

		}
	}

}

