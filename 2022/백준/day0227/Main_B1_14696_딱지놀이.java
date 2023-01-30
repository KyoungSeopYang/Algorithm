package com.ssafy.day0227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B1_14696_딱지놀이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = null;
		for (int t = 0; t < N; t++) {
			int[] A = new int[5];
			int[] B = new int[5];

			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			for (int i = 0; i < a; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				A[tmp]++;
			}
			
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < b; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				B[tmp]++;
			}
			char ans ='D';
			for (int i = 4; i >0 ; i--) {
				if(A[i] > B[i]) {
					ans = 'A';
					break;
				} else if(A[i]<B[i]) {
					ans = 'B';
					break;
				}
			}
			System.out.println(ans);
		}
	}

}
