package com.ssafy.day0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493_탑 {
	static int[] input, output;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N+1];
		output = new int[N+1];
		Stack<Integer> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			
			while (true) {
				if (stack.isEmpty())
					break;
				if (input[stack.peek()] < input[i]) {
					stack.pop();
				} else {
					output[i] = stack.peek();
					break;
				}
			}

			stack.add(i);
		}

		for (int i = 1; i <= N; i++) {
			sb.append(output[i]).append(" ");
		}

		System.out.println(sb);
	}

}
