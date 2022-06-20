package com.ssafy.day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2578_빙고 {

	static String[][] my;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cnt = 0;
		my = new String[5][5];

		StringTokenizer st;

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				my[i][j] = st.nextToken();
			}
		}

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				cnt++;
				findElement(st.nextToken());
				if (serch()) {
					System.out.println(cnt);
					return;
				}
			}
		}

	}

	// 사회자가 부른 수 제거
	private static void findElement(String str) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (my[i][j].equals(str)) {
					my[i][j] = "0";
				}
			}
		}
	}

	// 탐색 메서드 모아둔 메서드
	static boolean serch() {
		int bingo = 0;
		
		if (my[0][0].equals("0"))
			bingo = rightSerch() ? bingo + 1 : bingo;
		
		if (my[0][4].equals("0"))
			bingo = leftSerch() ? bingo + 1 : bingo;

		for (int i = 0; i < 5; i++) {
			if (my[0][i].equals("0")) {
				bingo = rowSerch(i) ? bingo + 1 : bingo;
			}
			if (my[i][0].equals("0")) {
				bingo = colSerch(i) ? bingo + 1 : bingo;
			}
			if(bingo == 3 ) return true;
		}
		
		return bingo == 3 ? true : false;
	}

	// 우상좌하 대각선
	private static boolean leftSerch() {
		for (int i = 0; i < 5; i++) {
			if (!my[i][4 - i].equals("0")) {
				return false;
			}
		}
		return true;
	}

	// 좌상우하 대각선
	private static boolean rightSerch() {
		for (int i = 0; i < 5; i++) {
			if (!my[i][i].equals("0")) {
				return false;
			}
		}
		return true;
	}

	// 행 검색
	static boolean rowSerch(int col) {
		for (int i = 0; i < 5; i++) {
			if (!my[i][col].equals("0")) {
				return false;
			}
		}
		return true;
	}

	// 열 검색
	static boolean colSerch(int row) {
		for (int i = 0; i < 5; i++) {
			if (!my[row][i].equals("0")) {
				return false;
			}
		}
		return true;
	}
}
