package com.ssafy.day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16935_배열돌리기3 {
	static String[][] map;
	static String[][] temp;
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
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < R; i++) {
			switch (st.nextToken()) {
			case "1":
				oper1();
				break;
			case "2":
				oper2();
				break;
			case "3":
				oper3();
				break;
			case "4":
				oper4();
				break;
			case "5":
				oper5();
				break;
			case "6":
				oper6();
				break;
			}
		}

		// 출력
		for (int i = 0; i < N; i++) {
			for (String str : map[i]) {
				sb.append(str + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void oper1() { // 상하반전
		for (int i = 0; i < N / 2; i++) {
			String[] temp = map[i];
			map[i] = map[N - 1 - i];
			map[N - 1 - i] = temp;
		}
	}

	public static void oper2() { // 좌우반전
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				String temp = map[i][j];
				map[i][j] = map[i][M - 1 - j];
				map[i][M - 1 - j] = temp;
			}
		}
	}

	public static void oper3() { // 오른쪽 회전
		String[][] arr = new String[M][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[j][N - 1 - i] = map[i][j];
			}
		}
		map = arr;

		int temp = N;
		N = M;
		M = temp;
	}

	public static void oper4() { // 왼쪽 회전
		String[][] arr = new String[M][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[M - 1 - j][i] = map[i][j];
			}
		}
		map = arr;

		int temp = N;
		N = M;
		M = temp;
	}

	public static void oper5() { // 부분그룹 시계방향
		int row = N / 2;
		int col = M / 2;

		String[][] temp = new String[N][M];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				temp[i][col + j] = map[i][j];
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = col; j < M; j++) {
				temp[i + row][j] = map[i][j];
			}
		}

		for (int i = row; i < N; i++) {
			for (int j = col; j < M; j++) {
				temp[i][j - col] = map[i][j];
			}
		}

		for (int i = row; i < N; i++) {
			for (int j = 0; j < col; j++) {
				temp[i - row][j] = map[i][j];
			}
		}
		map = temp;
	}

	public static void oper6() { // 부분그룹 반시계방향
		int row = N / 2;
		int col = M / 2;

		String[][] temp = new String[N][M];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				temp[row + i][j] = map[i][j];
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = col; j < M; j++) {
				temp[i][j - col] = map[i][j];
			}
		}

		for (int i = row; i < N; i++) {
			for (int j = col; j < M; j++) {
				temp[i - row][j] = map[i][j];
			}
		}

		for (int i = row; i < N; i++) {
			for (int j = 0; j < col; j++) {
				temp[i][j + col] = map[i][j];
			}
		}
		map = temp;
	}
}
