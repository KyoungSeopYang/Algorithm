package com.ssafy.day0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S4_10157_자리배정 {

	static int map[][];
	static boolean visit[][];
	static int r, c, k;

	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int cnt = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		map = new int[r][c];

		k = Integer.parseInt(br.readLine());
		if (r * c < k) {
			System.out.println(0);
			return;
		}
		
		int cnt = 1;

		int x = r - 1;
		int y = 0;
		int dir = 0;
		while (cnt != k) {

			// if(cnt==k)break;
			map[x][y] = cnt;
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx < 0 || ny < 0 || nx >= r || ny >= c || map[nx][ny] != 0) {
				dir++;
				if (dir == 4)
					dir = 0;
				nx = x + dx[dir];
				ny = y + dy[dir];
			}

			x = nx;
			y = ny;

			cnt++;
		}

		System.out.println((y+1) + " "+ (r-x));

	}// main

}
