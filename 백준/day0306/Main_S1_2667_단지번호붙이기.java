package com.ssafy.day0306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

// 11672, 88ms
public class Main_S1_2667_단지번호붙이기 {

	static char[][] map;
	static boolean visit[][];
	static int N;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		visit = new boolean[N][N];
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// 해결
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j] && map[i][j] == '1') {
					list.add(bfs(i, j));
				}
			}
		}

		// 출력
		sb.append(list.size()).append("\n");

		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(sb);

	}

	// BFS
	private static int bfs(int x, int y) {
		Queue<Pos> queue = new LinkedList<>();
		visit[x][y] = true;
		queue.offer(new Pos(x, y));
		int count = 1;

		while (!queue.isEmpty()) {
			Pos cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (isHome(nx, ny)) {
					queue.offer(new Pos(nx, ny));
					visit[nx][ny] = true;
					count++;
				}
			}
		}
		return count;
	}

	private static boolean isHome(int nx, int ny) {
		if (nx < 0 || nx >= N || ny < 0 || ny >= N)
			return false;
		if (map[nx][ny] != '1' || visit[nx][ny])
			return false;

		return true;
	}

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

}
