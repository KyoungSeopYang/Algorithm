package com.ssafy.day0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1204_최빈수구하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		
		int T = Integer.parseInt(br.readLine());
		int[] arr;
		StringTokenizer st;
		
		for (int i = 0; i < T; i++) {
			int t =Integer.parseInt(br.readLine());
			arr = new int[101];
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				arr[num] +=1;
			}
			int max=0;

			for (int j = 100; j >= 0; j--) {
				if(arr[max]<arr[j]) {
					max=j;
				}
			}
			
			System.out.printf("#%d %d\n",t,max);
		}
		
	}
}
