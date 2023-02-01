package com.ssafy.day0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 335540kb	628ms
public class Main_G5_17070_파이프옮기기1 {

	static int N;
	static int[][] home;
	static Queue<Pos> queue;

	static int[] dr = { 0, 1, 1 };
	static int[] dc = { 1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		home = new int[N][N];

		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				home[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(home[N-1][N-1] == 1) {
			System.out.println(0);
			return;
		}

		bfs();
	}

	private static void bfs() {
		queue = new LinkedList<Pos>();
		int cnt = 0;
		
		queue.add(new Pos(0, 0, 0, 1));

		while (!queue.isEmpty()) {
			Pos cur = queue.poll();
		
			if (cur.Col == N - 1 && cur.Row == N - 1) {
				cnt++;
				continue;
			}

			int dir = findDir(cur);

			if (dir == 0) { // 가로방향이면
				moveRight(cur);
				moveDiagonal(cur);
			} else if (dir == 1) { // 세로
				moveDown(cur);
				moveDiagonal(cur);
			} else if (dir == 2) { // 대각선
				moveRight(cur);
				moveDown(cur);
				moveDiagonal(cur);
			}

		}
		System.out.println(cnt);
	}

	private static void moveDown(Pos cur) {
		// 아래로 이동이 가능한가
		if (cur.Row + 1 < N && home[cur.Row + 1][cur.Col] == 0) {
			int sRow = cur.Row;
			int sCol = cur.Col;

			int eRow = cur.Row + 1;
			int eCol = cur.Col;
			queue.add(new Pos(sRow, sCol, eRow, eCol));
		}

	}

	private static void moveRight(Pos cur) {
		// 오른쪽으로 이동이 가능한가?
		if (cur.Col + 1 < N && home[cur.Row][cur.Col + 1] == 0) {
			int sRow = cur.Row;
			int sCol = cur.Col;

			int eRow = cur.Row;
			int eCol = cur.Col + 1;
			queue.add(new Pos(sRow, sCol, eRow, eCol));
		}
	}

	private static void moveDiagonal(Pos cur) {
		// 대각선 이동이 가능한가?
		if ((cur.Col + 1 < N && home[cur.Row][cur.Col + 1] == 0)
				&& (cur.Row + 1 < N && home[cur.Row + 1][cur.Col] == 0) && home[cur.Row + 1][cur.Col + 1] == 0) {
			int sRow = cur.Row;
			int sCol = cur.Col;

			int eRow = cur.Row + 1;
			int eCol = cur.Col + 1;
			queue.add(new Pos(sRow, sCol, eRow, eCol));
		}
	}

	// 0 : 가로 , 1 : 세로 , 2 : 대각선
	private static int findDir(Pos cur) {
		if (Math.abs(cur.sRow - cur.Row) != Math.abs(cur.sCol - cur.Col)) {
			if (cur.sRow == cur.Row)
				return 0;
			if (cur.sCol == cur.Col)
				return 1;
		}
		return 2;
	}

	static class Pos {
		int sRow, sCol, Row, Col;

		public Pos(int sRow, int sCol, int eRow, int eCol) {
			super();
			this.sRow = sRow;
			this.sCol = sCol;
			this.Row = eRow;
			this.Col = eCol;
		}

	}

}
