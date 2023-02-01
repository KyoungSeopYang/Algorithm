package com.ssafy.day0225;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B1_2669_직사각형네개의합집합의면적구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int map[][] = new int[101][101];
		int ans = 0;

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());

			for (int j = x; j < p; j++) {
				for (int j2 = y; j2 < q; j2++) {
					if (map[j][j2] == 0) {
						map[j][j2] = 1;
						ans++;
					}
				}
			}
		}
		System.out.println(ans);
	}

}
