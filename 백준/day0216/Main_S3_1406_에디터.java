package com.ssafy.day0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_S3_1406_에디터 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char input[] = br.readLine().toCharArray();

		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();

		for (int i = 0, size = input.length; i < size; i++) {
			left.push(input[i]);
		}

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			switch (st.nextToken()) {
			case "L":
				if (left.isEmpty())
					continue;
				right.push(left.pop());
				break;
			case "D":
				if (right.isEmpty())
					continue;
				left.push(right.pop());
				break;
			case "B":
				if (left.isEmpty())
					continue;
				left.pop();
				break;
			case "P":
				left.push(st.nextToken().charAt(0));
				break;
			}

		}
		while (!left.isEmpty()) {
			right.push(left.pop());
		}

		while (!right.isEmpty()) {
			sb.append(right.pop());
		}
		System.out.println(sb);
	}

}
