package com.ssafy.day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926_배열돌리기1 {
	static String[][] map;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		map = new String[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = st.nextToken();
			}
		}

		// 해결
		for (int r = 0; r < R; r++) {
			int startRow = 0;
			int endRow = N - 1;
			int startCol = 0;
			int endCol = M - 1;

			for (int i = 0; i < Math.min(N, M) / 2; i++) {
				turnArr(startRow, endRow, startCol, endCol);
				startRow++;
				startCol++;
				endRow--;
				endCol--;
			}
		}
		
		//출력
		for (int i = 0; i < N; i++) {
			for (String str : map[i]) {
				sb.append(str+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void turnArr(int startRow, int endRow, int startCol, int endCol) {
		String temp = map[startRow][startCol];
		
		// 위쪽
		for (int i = startCol; i < endCol; i++) {
			map[startRow][i] = map[startRow][i+1]; 
		}
		//우측
		for (int i = startRow; i < endRow; i++) {
			map[i][endCol] = map[i+1][endCol]; 
		}
		//아래
		for (int i = endCol; i > startCol ; i--) {
			map[endRow][i] = map[endRow][i-1];
		}
		// 좌측
		for (int i = endRow; i > startRow; i--) {
			map[i][startCol] = map[i - 1][startCol];
		}
		map[startRow+1][startCol] = temp;
	}

}
