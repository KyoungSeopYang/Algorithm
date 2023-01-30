package com.ssafy.day0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D1_2046_스탬프찍기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		if(N%2 != 0)
			sb.append("#");
		
		for (int i = 0; i < N/2; i++) {
			sb.append("##");
		}

		System.out.println(sb);
	}

}
