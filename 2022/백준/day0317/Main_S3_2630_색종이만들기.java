package com.ssafy.day0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_2630_색종이만들기 {

	static int map[][];
	static int ans[] = new int[2];
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(0,0,N);
		System.out.println(ans[0]);
		System.out.println(ans[1]);
	}

	private static void solve(int x, int y, int size) {
		
		if(check(x,y,size)) {
			ans[map[x][y]]++;
			return;
		}
		
		int nSize = size/2;
		
		solve(x,y,nSize);
		solve(x,y+nSize,nSize);
		solve(x+nSize,y,nSize);
		solve(x+nSize,y+nSize,nSize);
		
	}

	private static boolean check(int x, int y, int size) {
		int color = map[x][y];
		
		for (int i = x; i < x+size; i++) {
			for (int j = y; j < y+size; j++) {
				if(map[i][j] != color) {
					return false;
				}
			}
		}
		
		return true;
	}

}
