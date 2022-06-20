package com.ssafy.day0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_S3_10799_쇠막대기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		Stack<Character> stack = new Stack<>();
		char[] arr = br.readLine().toCharArray();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(')
				stack.push('(');
			else if(arr[i-1]=='(') {
				stack.pop();
				sum += stack.size();
			} else if(arr[i-1]==')') {
				stack.pop();
				sum+=1;
			}
		}
		System.out.println(sum);

	}

}
