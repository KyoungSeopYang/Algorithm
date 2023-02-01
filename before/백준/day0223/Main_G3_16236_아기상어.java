package com.ssafy.day0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 삽질...
// 1.거리를 좌표간 거리 계산으로 구했던거.
// 2.BFS로 처음 만난 먹을 수 있는 물고기가 최선이라고 생각했던거

public class Main_G3_16236_아기상어 {

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	// 상, 좌 ,하, 우
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int map[][];
	static int size = 2, satiety = 0, time = 0, N;
	static Pos shark;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark = new Pos(i, j);
					map[i][j] = 0;
				}
			}
		}

		bfs(shark);
		System.out.println(time);
	}

	private static void bfs(Pos shark) {
		Queue<Pos> q = new LinkedList<>();
		Queue<Pos> fish = new LinkedList<>();
		q.offer(shark);

		while (true) {
			int[][] visited = new int[N][N];

			while (!q.isEmpty()) {
				Pos c = q.poll();

				for (int i = 0; i < 4; i++) {
					int nx = c.x + dx[i];
					int ny = c.y + dy[i];
					if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
						if (map[nx][ny] <= size && visited[nx][ny] == 0) {
							q.offer(new Pos(nx, ny));
							visited[nx][ny] = visited[c.x][c.y] + 1;
							if (map[nx][ny] > 0 && map[nx][ny] < size) {
								fish.offer(new Pos(nx, ny));
							}
						}
					}
				}
			}

			if (fish.isEmpty())
				break;

			Pos target = fish.poll();

			while (!fish.isEmpty()) {
				Pos cur = fish.poll();

				if (visited[target.x][target.y] > visited[cur.x][cur.y]) {
					target = cur;
				} else if (visited[target.x][target.y] == visited[cur.x][cur.y]) {
					if (target.x == cur.x) {
						if (target.y > cur.y)
							target = cur;
					} else if (target.x > cur.x) {
						target = cur;
					}
				}
			}

			time += visited[target.x][target.y];
			map[target.x][target.y] = 0;
			shark = target;
			q.offer(target);
			if (size == ++satiety) {
				size++;
				satiety = 0;
			}

		}
	}

}
