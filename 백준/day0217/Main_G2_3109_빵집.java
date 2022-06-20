package com.ssafy.day0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G2_3109_빵집 {

	static int R, C, ans;
	static char map[][];
	static int[] dir = { -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < R; i++) {
			setPipe(i, 0);
		}

		System.out.println(ans);

	}

	private static boolean setPipe(int x, int y) {
		if (y == C-1) {
			ans++;
			return true;
		}

		for (int i = 0; i < 3; i++) {
			int nx = x + dir[i];
			int ny = y + 1;

			if (nx < 0 || ny < 0 || nx == R || ny == C)
				continue;
			
			if (map[nx][ny] == 'x')
				continue;

			map[nx][ny] = 'x';
			
			if (setPipe(nx, ny))
				return true;
		}

		return false;

	}

}