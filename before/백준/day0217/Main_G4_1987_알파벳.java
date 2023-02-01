package com.ssafy.day0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_1987_알파벳 {
	static char[][] map;
	static int R, C, ans;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[] visited = new boolean[26];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		solve(0, 0, 0);
		System.out.println(ans);

	}

	static void solve(int x, int y, int count) {
		int idx = map[x][y] - 'A';

		if (visited[idx]) {
			ans = Math.max(ans, count);
			return;
		} 
		
		visited[idx] =true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
				solve(nx, ny, count + 1);
			}
			
		}
		visited[idx] = false;
	}
}
