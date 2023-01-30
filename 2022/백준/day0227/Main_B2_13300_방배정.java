package com.ssafy.day0227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2_13300_방배정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int ans = 0;
		int[][] room = new int[7][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());// 성별
			int Y = Integer.parseInt(st.nextToken());// 학년
			
			if(S==0) { // 여학생이면
				room[Y][0]++;
				if(room[Y][0] == K) {
					room[Y][0] = 0;
					ans++;
				}
				
			} else { // 남학생이면
				room[Y][1]++;
				if(room[Y][1] == K) {
					room[Y][1] = 0;
					ans++;
				}
			}
		}
		
		// room[i][j] !=0 이면 사람이 1명 이상 있는 꽉 차지않은 방이있다.
		for (int i = 1; i < 7; i++) {
			for (int j = 0; j < 2; j++) {
				if(room[i][j]!=0)
					ans++;
			}
		}
		
		System.out.println(ans);
	}

}
