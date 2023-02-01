package com.ssafy.day0408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//132192kn	384ms
public class Main_G5_14502_연구소 {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static List<Pos> zero = new ArrayList<>();
	static int N, M, map[][], max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		int safeZone = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					zero.add(new Pos(i, j));
					safeZone++;
				}
			}
		}

		int[] np = new int[zero.size()];
		for (int i = 1; i <= 3; i++) {
			np[zero.size() - i] = 1;
		}

		do {
			solve(np, safeZone);
		} while (np(np));

		System.out.println(max);
	}

	private static void solve(int[] np, int safeZone) {
		Queue<Pos> que = new LinkedList<>();

		int copyMap[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];
				if (map[i][j] == 2)
					que.add(new Pos(i, j));
			}
		}

		// 벽을 세울수 있는 위치 3곳에 벽을 세운다
		int size = zero.size();
		for (int i = 0; i < size; i++) {
			if (np[i] == 1) {
				Pos cur = zero.get(i);
				copyMap[cur.r][cur.c] = 1;
				safeZone--;
			}
		}

		while (!que.isEmpty()) {
			Pos cur = que.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				if (copyMap[nr][nc] == 1 || copyMap[nr][nc] == 2)
					continue;
				
				// 바이러스 전파
				copyMap[nr][nc]=2;
				safeZone--;
				que.add(new Pos(nr, nc));
			}
		}
		max = Math.max(max, safeZone);
	}

	// NP
	private static boolean np(int[] np) {

		int N = np.length;
		int i = N - 1;

		while (i > 0 && np[i - 1] >= np[i])
			i--;

		if (i == 0)
			return false;

		int j = N - 1;

		while (np[i - 1] >= np[j])
			j--;

		swap(np, i - 1, j);

		int k = N - 1;
		while (i < k) {
			swap(np, i++, k--);
		}

		return true;
	}

	private static void swap(int[] np, int i, int j) {
		int temp = np[i];
		np[i] = np[j];
		np[j] = temp;

	}

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

}
