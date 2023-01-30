package com.ssafy.day0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//70,700kb, 243ms
public class Solution_5656_벽돌깨기 {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int W, H, min;

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;

			int map[][] = new int[H][W];
			int total = 0;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0)
						total++;
				}
			}

			solve(total, N, map);
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}

		System.out.println(sb);
	}

	// 0 ~ W-1까지 모든 경우에서 구슬을 쏴봅시다.
	
	private static void solve(int remain, int N, int[][] map) {
		// 아직 기회가 남았는데 더 이상 남은 블럭이 없으면 종료
		if (remain == 0) { 
			min = 0;
			return;
		}
		if (N == 0) { // 발사 횟수가 0이라면 min값 갱신
			min = Math.min(min, remain);
			return;
		}

		int[][] newMap = new int[H][W];

		// [row][0] .... [row][W-1] 까지 탐색
		for (int col = 0; col < W; col++) {
			int row = 0;
			
			// 해당 수직 공간에서 최상단 블럭의 row값 찾기
			while (row < H && map[row][col] == 0) {
				row++;
			}
			
			// 해당 공간에 블럭이 없으니 continue
			if (row == H)
				continue;

			// 새로운 맵에서 벽돌 부수기를 진행하기위해서 복사
			copy(map, newMap);

			// 벽돌을 부수고 부순 벽돌의 개수를 리턴
			int burstCnt = burst(row, col, newMap);
			// 벽돌 부순후 남아있는 벽돌을 밑으로 떨어트린다.
			down(newMap);
			
			// 다음 기회를 위해서 재귀
			solve(remain - burstCnt, N-1, newMap);
		}
	}

	private static void down(int[][] newMap) {
		Queue<Block> que = new LinkedList<>();
		
		for (int col = 0; col < W; col++) {
			int row = H-1;
			
			// 블럭이 남아있으면 큐에 블럭을 저장
			while(row >= 0) {
				if(newMap[row][col] > 0) {
					que.add(new Block(row,col,newMap[row][col]));
					newMap[row][col] = 0;
				}
				row--;
			}
			
			// 맨 아래에서 부터 큐를 하나씩 빼서 값을 넣는다.
			row = H-1;
			while(!que.isEmpty()) {
				Block cur = que.poll();
				newMap[row][col] = cur.cnt;
				row--;
			}
		}
		
	}

	// bfs로 블럭 부수기
	private static int burst(int row, int col, int[][] map) {
		int burstCnt = 0;
		Queue<Block> que = new LinkedList<>();
		// 값이 1이면 큐에 넣지 않는다.
		if (map[row][col] > 1)
			que.add(new Block(row, col, map[row][col]));

		map[row][col] = 0;
		burstCnt++;

		while (!que.isEmpty()) {
			Block cur = que.poll();
			
			for (int i = 0; i < 4; i++) {
				int nRow = cur.row;
				int nCol = cur.col;

				// 현재 블럭의 값-1 만큼 사방탐색 반복
				for (int j = 0; j < cur.cnt - 1; j++) {
					nRow += dx[i];
					nCol += dy[i];
					
					// 범위 확인
					if (nRow < 0 || nCol < 0 || nRow >= H || nCol >= W || map[nRow][nCol] == 0)
						continue;
					
					// 1보다 크면 큐에 넣는다
					if (map[nRow][nCol] > 1) {
						que.add(new Block(nRow, nCol, map[nRow][nCol]));
					}
					
					// 해당 위치의 블럭을 부순다.
					map[nRow][nCol] = 0;
					burstCnt++;
				}
			}
		}

		return burstCnt;
	}

	private static void copy(int[][] map, int[][] newMap) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];
			}
		}

	}

	static class Block {
		int row, col, cnt;

		public Block(int row, int col, int cnt) {
			super();
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
	}

}
