package com.ssafy.day0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * i 랑 i+2의 변의 방향이 같은 i값을 찾아서 i+1 * i+3 를 하면 비어있는 직사각형의 넓이를 구할 수 있다. 
 * 전체 직사각형의 넓이 - 비어있는 직사각형의 넓이 를 구하고 K를 곱하면 답.
 */

// 11576kb, 76ms
public class Main_S4_2477_참외밭 {

	// 1 :동, 2 :서, 3 :남, 4 :북
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());

		int input[][] = new int[6][2];
		int area = 0;	// 비어있는 직사각형 넓이
		int width = 0;	// 가장 긴 가로 길이
		int height = 0; // 가장 긴 세로 길이

		// 입력값
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			input[i][0] = dir;
			input[i][1] = val;
		}

		for (int i = 0; i < 6; i++) {	// 순회하면서 i == i+2 && i+1 == i+3를 만족하는 i 값을 찾아서 area넓이를 구함
			if (input[i][0] == input[(i + 2) % 6][0] && 
					input[(i + 1) % 6][0] == input[(i + 3) % 6][0]) {
				area = input[(i + 1) % 6][1] * input[(i + 2) % 6][1];
			}
			
			if(input[i][0] == 1 || input[i][0] == 2) {
				width = Math.max(width, input[i][1]);
			} else {
				height = Math.max(height, input[i][1]);
			}
		}
		
		long output = ((width * height) - area) * K;
		System.out.println(output);

	}
}
