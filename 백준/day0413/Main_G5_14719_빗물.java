package com.ssafy.day0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//11820kb 96ms
public class Main_G5_14719_빗물 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[] block = new int[W];

		int ans = 0;

		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < W; i++) {
			block[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < W - 1; i++) {
			int cur = block[i];
			int left = 0, right = 0;

			// 왼쪽에서 가장 높은 기둥
			for (int j = i - 1; j >= 0; j--) {
				left = Math.max(left, block[j]);
			}

			// 오른쪽에서 가장 높은 기둥
			for (int j = i + 1; j < W; j++) {
				right = Math.max(right, block[j]);
			}
			
			// 양쪽 기둥이 다 막고있는지 확인
			if (left <= cur || right <= cur)
				continue;

			ans += Math.min(left, right) - cur;
		}
		System.out.println(ans);
	}

}
