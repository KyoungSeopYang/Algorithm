package com.ssafy.day0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D1_2043_서랍의비밀번호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] numbers = br.readLine().split(" ");
		
		int n1 = Integer.parseInt(numbers[0]);
		int n2 = Integer.parseInt(numbers[1]);
		
		System.out.println(n1-n2+1);
	}

}
