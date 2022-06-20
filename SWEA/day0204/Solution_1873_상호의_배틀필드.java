package com.ssafy.day0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1873_상호의_배틀필드 {

	// 상,우,하,좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static char[][] map;
	static int r;
	static int c;
	static int dir;
	static int H;
	static int W;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			String s = br.readLine();
			H = Integer.parseInt(s.split(" ")[0]);
			W = Integer.parseInt(s.split(" ")[1]);

			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
			}

			find_location();

			int n = Integer.parseInt(br.readLine());
			char[] cmd = br.readLine().toCharArray();
			for (int i = 0; i < n; i++) {
				if (cmd[i] == 'S')
					shoot(r, c);
				else
					move(cmd[i]);
			}

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	private static void shoot(int r, int c) {
		if (map[r][c] == '#')
			return;
		else if (map[r][c] == '*') {
			map[r][c] = '.';
			return;
		} else if (r + dr[dir] < 0 || r + dr[dir] >= H || c + dc[dir] < 0 || c + dc[dir] >= W)
			return;

		shoot(r + dr[dir], c + dc[dir]);
	}

	private static void move(char way) {
		switch (way) {
		case 'U':
			dir = 0;
			way = '^';
			break;
		case 'R':
			dir = 1;
			way = '>';
			break;
		case 'D':
			dir = 2;
			way = 'v';
			break;
		case 'L':
			dir = 3;
			way = '<';
			break;
		}

		int row = r + dr[dir];
		int cul = c + dc[dir];
		map[r][c] = way;

		if (row < 0 || row >= H || cul < 0 || cul >= W) {

			return;
		}

		if (map[row][cul] == '.') {
			map[r][c] = '.';
			map[row][cul] = way;
			r = row;
			c = cul;
		}
	}

	private static void find_location() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {

				if (map[i][j] == '^') {
					dir = 0;
					r = i;
					c = j;
				} else if (map[i][j] == '>') {
					dir = 1;
					r = i;
					c = j;
				} else if (map[i][j] == 'v') {
					dir = 2;
					r = i;
					c = j;
				} else if (map[i][j] == '<') {
					dir = 3;
					r = i;
					c = j;
				}
			}
		}
	}
}
