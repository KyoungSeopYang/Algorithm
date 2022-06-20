package com.ssafy.day0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1963_1대1가위바위보 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str= br.readLine().split(" ");
		
		int A = Integer.parseInt(str[0]);
		int B = Integer.parseInt(str[1]);
		int result = A%3-B%3;
		//1 < 2 <3 <1
		
		if(result == 1) 
			System.out.println("B");
		 else
			 System.out.println("A");
	
	}

}
