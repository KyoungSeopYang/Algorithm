package com.ssafy.day0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution_D4_1861_정사각형방 {

	static int N;
	static int[][] map;
	// 상,하,좌,우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visited;

	static int max;
	static int idx;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			
			max = 0;
			idx = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(i,j,1,map[i][j]);
				}
			}

			sb.append("#"+tc+" "+idx+" "+max).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int x, int y,int cnt , int start) {
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(isInRange(nx, ny)) {
				if (!visited[nx][ny] && map[nx][ny]-map[x][y] ==1)
					dfs(nx,ny,cnt+1,start);
			}
		}
		
		if(cnt>max) {
			max = cnt;
			idx = start;
		}
		if(cnt == max) {
			idx = Math.min(idx, start);
		}
		
		
		visited[x][y] = false;
	}

	static boolean isInRange(int x, int y) {
		if (x < 0 || x > N - 1 || y < 0 || y > N - 1)
			return false;
		return true;
	}

}
