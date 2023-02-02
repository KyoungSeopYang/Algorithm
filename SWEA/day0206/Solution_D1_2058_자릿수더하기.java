package com.ssafy.day0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D1_2058_자릿수더하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] numbers = br.readLine().toCharArray();
		int sum = 0;

		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i] - '0';
		}

		System.out.println(sum);

	}

}
