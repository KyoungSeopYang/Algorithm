package com.ssafy.day0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_S2_2304_창고다각형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		List<Top> list = new ArrayList<>();

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Top(x, y));
		}
		Collections.sort(list);
		
		int maxX = 0;
		int ans = 0;
		Top currenttop = list.get(0);
		for (int i = 1; i < N; i++) {
			if (currenttop.y <= list.get(i).y) {
				ans += (list.get(i).x - currenttop.x) * currenttop.y;
				currenttop = list.get(i);
				maxX = i;
			}
		}
		
		currenttop = list.get(N - 1);
		for (int i = 0; i < N - maxX; i++) {
			if (currenttop.y <= list.get(N-i-1).y) {
				ans += (currenttop.x - list.get(N-i-1).x) * currenttop.y;
				currenttop = list.get(N-i-1);
			}
		}
		ans += currenttop.y;
		System.out.println(ans);
	}

	static class Top implements Comparable<Top> {
		int x, y;

		public Top(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Top o) {
			return this.x - o.x;
		}
	}

}
