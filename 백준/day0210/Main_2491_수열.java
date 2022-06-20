package com.ssafy.day0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2491_수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];
		int count = 1;
		int max_count = 1;
		int last_val = Integer.parseInt(st.nextToken());
		arr[0] = last_val;
		
		for (int i = 1; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if (last_val <= tmp) {
				count++;
			} else {
				max_count = max_count < count ? count : max_count;
				count = 1;
			}
			last_val = tmp;
			arr[i] = tmp;
		}
		
		max_count = max_count < count ? count : max_count;
		
		count = 1;
		last_val=arr[0];
		for (int i = 1; i < N; i++) {
			int tmp = arr[i];
			if (last_val >= tmp) {
				count++;
			} else {
				max_count = max_count < count ? count : max_count;
				count = 1;
			}
			last_val = tmp;
		}
		

		System.out.println(max_count < count ? count : max_count);

	}

}
