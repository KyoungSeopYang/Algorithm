package com.ssafy.day0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1767_프로세서연결하기 {

	static int N, max, min;
	static int map[][];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static List<Core> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			StringTokenizer st = null;
			list = new ArrayList<Core>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						if (i == 0 || j == 0 || i == N-1 || j == N-1)
							continue;
						list.add(new Core(i, j));
					}
				}
			}
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			dfs(0, 0, 0);
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int idx, int coreCnt, int len) {

		if (idx == list.size()) {
			if (max < coreCnt) {
				max = coreCnt;
				min = len;
			} else if (max == coreCnt) {
				min = Math.min(min, len);
			}
			return;
		}

		Core cur = list.get(idx);

		for (int i = 0; i < 4; i++) {
			int count = 0;
			int nx = cur.x;
			int ny = cur.y;

			while (true) {
				nx += dx[i];
				ny += dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					break;

				if (map[nx][ny] == 1) {
					count = 0;
					break;
				}
				count++;
			}

			int x = cur.x;
			int y = cur.y;
			for (int j = 0; j < count; j++) {
				x += dx[i];
				y += dy[i];

				map[x][y] = 1;
			}

			if (count == 0) {
				dfs(idx + 1, coreCnt, len);
			} else {
				dfs(idx + 1, coreCnt + 1, len + count);

				x = cur.x;
				y = cur.y;
				for (int j = 0; j < count; j++) {
					x += dx[i];
					y += dy[i];

					map[x][y] = 0;
				}
			}

		}

	}

	static class Core {
		int x, y;

		public Core(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

}
