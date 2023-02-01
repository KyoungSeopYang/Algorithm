package com.ssafy.day0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_17144_미세먼지안녕 {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] room;
	static int R, C;
	static Queue<Pos> pos = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 세로길이
		C = Integer.parseInt(st.nextToken()); // 가로길이
		int T = Integer.parseInt(st.nextToken()); // T초 후
		room = new int[R][C];
		ArrayList<Integer> airCleaner = new ArrayList<>();

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if (room[i][j] == -1)
					airCleaner.add(i);
			}
		}

		for (int t = 1; t <= T; t++) {
			spread();
			cleanerTop(airCleaner.get(0));
			cleanerBot(airCleaner.get(1));
		}

		int ans = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (room[i][j] != -1)
					ans += room[i][j];
			}
		}

		System.out.println(ans);

	}

	// 미세먼지가 있는 지점을 찾아 큐에 넣고 serch 호출
	private static void spread() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (room[i][j] > 0)
					pos.offer(new Pos(i, j, room[i][j]));
			}
		}
		while (!pos.isEmpty()) {
			serch(pos.poll());
		}
	}

	// 미세먼지 있는 지점을 매개변수로 받아 처리하는 메서드
	private static void serch(Pos pos) {
		int val = pos.val / 5;
		for (int i = 0; i < 4; i++) {
			int nx = pos.x + dx[i];
			int ny = pos.y + dy[i];
			if (isSpread(nx, ny)) {
				room[pos.x][pos.y] -= val;
				room[nx][ny] += val;
			}
		}
	}

	// 사방탐색이 유효한지 확인하는 메서드
	static boolean isSpread(int x, int y) {
		if (x < 0 || x >= R || y < 0 || y >= C || room[x][y] == -1)
			return false;
		return true;
	}

	private static void cleanerBot(int bot) {
		for (int i = bot + 1; i < R - 1; i++) {
			room[i][0] = room[i + 1][0];
		}
		for (int i = 0; i < C - 1; i++) {
			room[R - 1][i] = room[R - 1][i + 1];
		}
		for (int i = R - 1; i > bot; i--) {
			room[i][C - 1] = room[i - 1][C - 1];
		}
		for (int i = C - 1; i > 1; i--) {
			room[bot][i] = room[bot][i - 1];
		}
		room[bot][1] = 0;

	}

	private static void cleanerTop(int top) {

		for (int i = top - 1; i > 0; i--) {
			room[i][0] = room[i - 1][0];
		}
		for (int i = 0; i < C - 1; i++) {
			room[0][i] = room[0][i + 1];
		}
		for (int i = 0; i < top; i++) {
			room[i][C - 1] = room[i + 1][C - 1];
		}
		for (int i = C - 1; i > 1; i--) {
			room[top][i] = room[top][i - 1];
		}
		room[top][1] = 0;

	}

	static class Pos {
		int x, y, val;

		public Pos(int x, int y, int val) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}

}
