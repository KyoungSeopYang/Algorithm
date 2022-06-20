package com.ssafy.day0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_Z {

	static int N, r, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		solution(0, 0, 0, (int) Math.pow(2, N));
	}

	public static void solution(int x, int y, int cnt, int size) {

		if (x > r || x + size <= r || y > c || y + size <= c)
			return;

		if (size == 2) {
			int i;
			if (x == r) {
				i = y == c ? 0 : 1;
			} else {
				i = y == c ? 2 : 3;
			}

			System.out.println(cnt + i);
			return;
		}

		int newsize = size / 2;

		// 1 사분면
		solution(x, y,cnt, newsize);
		// 2 사분면
		solution(x, y+newsize,cnt+(newsize*newsize), newsize);
		// 3 사분면
		solution(x+newsize, y,cnt+(newsize*newsize*2), newsize);
		// 4 사분면
		solution(x+newsize, y+newsize,cnt+(newsize*newsize*3), newsize);

	}

}
