package com.ssafy.day0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5644_무선충전 {

	static int map[][];
	static int[] moveA, moveB;
	static int dx[] = { 0, 0, 1, 0, -1 };
	static int dy[] = { 0, -1, 0, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int M = Integer.parseInt(st.nextToken()); // 총 이동 횟수
			int A = Integer.parseInt(st.nextToken()); // BC의 개수

			moveA = new int[M];
			moveB = new int[M];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}

			BC[] bc = new BC[A];
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()); // BC x값
				int y = Integer.parseInt(st.nextToken()); // BC y값
				int c = Integer.parseInt(st.nextToken()); // BC 범위
				int p = Integer.parseInt(st.nextToken()); // BC의 파워

				bc[i] = new BC(x, y, c, p);

			}
			Arrays.sort(bc);

			location a = new location(1, 1);
			location b = new location(10, 10);
			List<Integer> aCharger = new ArrayList<Integer>();
			List<Integer> bCharger = new ArrayList<Integer>();
			int output = 0;

			/*
			 * 각 사용자의 위치에서 충전가능한 모든 BC를 리스트에 넣는다.
			 * 두 리스트의 사이즈가 0이면 둘다 충전 못하므로 넘어간다.
			 * 한 리스트의 사이즈가 0이면 다른 리스트의 최대 충전량을 구한다.
			 * 
			 */
			for (int t = 0; t <= M; t++) { // 사용자 이동
				// 현재 위치에서 충전 가능한 BC 찾기
				int maxP = 0;
				for (int i = 0; i < A; i++) {
					if (isCharge(a, bc[i])) {
						aCharger.add(i);
					}
					if (isCharge(b, bc[i])) {
						bCharger.add(i);
					}
				}

				if (!aCharger.isEmpty() || !bCharger.isEmpty()) {
					if (!aCharger.isEmpty() && !bCharger.isEmpty()) {
						if (aCharger.get(0) == bCharger.get(0)) {
							if (aCharger.size() >= 2)
								maxP = Math.max(bc[aCharger.get(1)].power + bc[bCharger.get(0)].power, maxP);
							if (bCharger.size() >= 2)
								maxP = Math.max(bc[aCharger.get(0)].power + bc[bCharger.get(1)].power, maxP);
						} else
							maxP = Math.max(bc[aCharger.get(0)].power + bc[bCharger.get(0)].power, maxP);
					}
					if (!aCharger.isEmpty()) // a만 충전할 수 있다면
						maxP = Math.max(bc[aCharger.get(0)].power, maxP);
					if (!bCharger.isEmpty()) // b만 충전할 수 있다면
						maxP = Math.max(bc[bCharger.get(0)].power, maxP);
					output += maxP;
				}
				
				if(t==M) break;
				a.x += dx[moveA[t]];
				a.y += dy[moveA[t]];
				b.x += dx[moveB[t]];
				b.y += dy[moveB[t]];

				aCharger.clear();
				bCharger.clear();
			}
			sb.append("#").append(tc).append(" ").append(output).append("\n");

		}

		System.out.println(sb);
	}

	private static boolean isCharge(location p, BC bc) {
		if (Math.abs(p.x - bc.x) + Math.abs(p.y - bc.y) <= bc.cover) {
			return true;
		}
		return false;
	}

	static class BC implements Comparable<BC> {
		int x, y, cover, power;

		public BC(int x, int y, int cover, int power) {
			this.x = x;
			this.y = y;
			this.cover = cover;
			this.power = power;
		}

		@Override
		public int compareTo(BC o) {
			return o.power - this.power;
		}

	}

	static class location {
		int x, y;

		public location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
