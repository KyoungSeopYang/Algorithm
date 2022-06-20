package com.ssafy.day0416;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//11732kb 80ms
public class Main_G4_11559_puyopuyo {

	static class Puyo {
		int r, c;

		public Puyo(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static char[][] map;
	static int H, W;
	static boolean visited[][];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		W = 6;
		H = 12;
		map = new char[H][W];

		for (int i = 0; i < H; i++) {
			String line = br.readLine();
			map[i] = line.toCharArray();
		}

		int count = 0;

		// solve
		/*
		 * 1. map을 탐색하면서 뿌요가 있는 칸을 찾는다.
		 * 2. 뿌요가 있는 칸을 찾으면 해당 칸에서 부터 BFS를 통해 같은 색의 뿌요를 탐색한다
		 * 3. 같은 색의 뿌요가 4개 이상이라면 연쇄를 일으킨다.
		 * 4. 연쇄가 일어났다면 비어있는 칸을 채우기 위해 뿌요를 아래로 내린다
		 */
		while (true) {
			visited = new boolean[H][W];
			boolean flag = false;
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					if (map[r][c] != '.') {
						if (bfs(r, c)) { // 연쇄가 일어나면 true가 리턴된다.
							flag = true; // flag를 통해서 연쇄가 일어났는지 아닌지 체크한다.
						}
					}
				}
			}

			if (flag) { // 연쇄가 일어났으면
				count++;
				drop(); // 뿌요를 밑으로 내린다.
			} else { // 연쇄가 일어나지 않았다면 반복문 종료
				break; 
			}
		}
		System.out.println(count);

	}

	private static void drop() {
		for (int r = 0; r < W; r++) {
			for (int c = H - 1; c > 0; c--) { //맨 아래 행부터 위로 올라오면서 탐색한다
				if (map[c][r] == '.') { // 해당 위치가 비어있다면
					for (int i = c - 1; i >= 0; i--) { // 해당 위치보다 위에 뿌요가 있는지 탐색한다.
						if (map[i][r] != '.') { // 뿌요를 발견하면 해당위치로 뿌요를 옮겨준다
							map[c][r] = map[i][r];
							map[i][r] = '.';
							break;
						}
					}
				}
			}
		}
	}

	private static boolean bfs(int r, int c) {
		char color = map[r][c];
		List<Puyo> list = new ArrayList<>(); // 같은 색의 뿌요를 모아 둘 리스트

		Queue<Puyo> que = new LinkedList<>();
		que.add(new Puyo(r, c));
		list.add(new Puyo(r, c));
		visited[r][c] = true;

		// BFS
		while (!que.isEmpty()) {
			Puyo cur = que.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= H || nc >= W || visited[nr][nc])
					continue;
				if (map[nr][nc] != color)
					continue;
				visited[nr][nc] = true;
				list.add(new Puyo(nr, nc));
				que.add(new Puyo(nr, nc));
			}
		}
		
		// 인접한 같은색의 뿌요가 4개 이상이면 해당 뿌요들을 터트린다
		if (list.size() >= 4) {
			for (Puyo puyo : list) {
				map[puyo.r][puyo.c] = '.';
			}
			return true; // 연쇄가 일어났다.
		}
		// 연쇄가 일어나지 않았다.
		return false;

	}

}
