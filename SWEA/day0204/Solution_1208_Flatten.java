package com.ssafy.day0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1208_Flatten {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			int[] map = new int[100];
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st=new StringTokenizer(br.readLine());

			for (int i = 0; i < 100; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(map);

			
			for(int i=0;i<N;i++) {
				map[0]++;
				map[99]--;
				sort(map);
				if(map[99]-map[0]<=1) {
					sb.append("#"+tc+" ").append(map[99]-map[0]+"\n");
					break;
				}
			}
			
			sb.append("#"+tc+" ").append(map[99]-map[0]+"\n");
		}
		System.out.println(sb);
	
	}

	private static void sort(int[] map) {
		for (int i = 0; i <99 ; i++) {
			if(map[i]>map[i+1]) {
				int temp = map[i+1];
				map[i+1] = map[i];
				map[i] = temp;
			}
		}
	}
}
