package com.ssafy.day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1210_Ladder1 {

	static int[] dx = { 0, 0, -1 };
	static int[] dy = { -1, +1, 0 };
	static String[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 0; tc < 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			map = new String[100][100];

			for (int i = 0; i < map.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map.length; j++) {
					map[i][j] = st.nextToken();
				}
			}

			for (int i = 0; i < map.length; i++) {
				if (map[99][i].equals("2")) {
					System.out.print("#" + T + " ");
					start(i);
					break;
				}
			}

		}
	}

	private static void start(int y) {
		int x = 99;

		while (x != 0) {
			for (int i = 0; i < 3; i++) {
				if (y + dy[i] >= 0 && y + dy[i] <= 99) {
					if (map[x + dx[i]][y + dy[i]].equals("1")) {
						map[x][y] = "0";
						x += dx[i];
						y += dy[i];
						break;
					}
				}
			}
		}
		System.out.println(y);
	}

}
