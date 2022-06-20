package com.ssafy.day0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution_D1_1933_간단한N의약수 {

	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sqrt = (int) Math.sqrt(N);
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 1; i <= sqrt ; i++) {
			if(N%i ==0) {
				list.add(i);
				if(N/i != i) {
					list.add(N/i);
				}
			}
		}
		Collections.sort(list);
		
		for (int num : list) {
			System.out.print(num+" ");
		}
	}

}
