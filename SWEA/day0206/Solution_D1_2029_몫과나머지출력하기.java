package com.ssafy.day0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D1_2029_몫과나머지출력하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String[] str = br.readLine().split(" ");
			
			int n1 = Integer.parseInt(str[0]);
			int n2 = Integer.parseInt(str[1]);
			
			System.out.printf("#%d %d %d\n",tc,n1/n2,n1%n2);
		}
	}

}
