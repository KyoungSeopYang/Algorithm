package com.ssafy.day0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 21896kb , 1052ms
public class Main_S3_2559_수열 {

	static int N,K,max = Integer.MIN_VALUE;
	static int[] day;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		day = new int[N];
		st= new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			day[i] = Integer.parseInt(st.nextToken());
		}
		
		// i로 0 ~N-1 까지 순회하면서 i + (i+1)... (i+k-1)을 반복해서 max를 구함
		for (int i = 0; i < N-K+1; i++) {
			int sum = 0;
			for (int j = 0; j < K; j++) {
				sum +=day[i+j];
			}
			max =Math.max(sum, max);
		}
		System.out.println(max);
	}
}
