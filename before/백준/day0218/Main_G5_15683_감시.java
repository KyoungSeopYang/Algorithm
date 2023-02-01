package com.ssafy.day0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 56796kb 432ms
public class Main_G5_15683_감시 {

	static char map[][], copymap[][];
	static List<CCTV> cctv = new ArrayList<>(8);
	static List<CCTV> cctv5 = new ArrayList<>(8);	// 5번카메라만 저장
	static int ans = Integer.MAX_VALUE;
	static int N, R, dir[]; // dir : i번 카메라의 방향

	public static class CCTV {
		int x, y;
		char val;

		public CCTV(int x, int y, char val) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 가로 크기
		R = Integer.parseInt(st.nextToken()); // 세로 크기
		map = new char[N][R];

		// map 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < R; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j]=='5') {
					cctv5.add(new CCTV(i, j, map[i][j]));	// 5번 카메라만 저장
				} else if (map[i][j] != '0' && map[i][j] != '6') {
					cctv.add(new CCTV(i, j, map[i][j])); // 카메라 정보를 저장
				} 
			}
		}
		// 5번 카메라는 방향전환이 없으니까 미리 체크
		for (int i = 0; i < cctv5.size(); i++) {
				fourWay_Watch(cctv5.get(i));
		}
		
		dir = new int[cctv.size()]; // 5번 카메라 외의 카메라의 방향을 저장할 배열

		// 해결
		per(0, cctv.size());
		System.out.println(ans);

	}

	private static void per(int cnt, int r) { // 카메라 방향을 찾는 순열
		if (cnt == r) {
			copymap = new char[N][R]; // 맵을 복사
			for (int i = 0; i < N; i++) {
				System.arraycopy(map[i], 0, copymap[i], 0, R);
			}

			for (int i = 0; i < cctv.size(); i++) {
				direction(cctv.get(i), dir[i]); // i번 카메라와, 보고있는 방향을 전달
			}

			blindSpot(); // 사각지대 카운트 메서드
			return;
		}

		for (int i = 0; i < 4; i++) { // 순열로 카메라 방향을 뽑는다.
			dir[cnt] = i;
			per(cnt + 1, r);
		}
	}

	// 순열로 뽑은 카메라 방향에 따라 watch 메서드를 호출하는 메서드
	private static void direction(CCTV cctv, int dir) {

		// 0 :상 , 1 :하, 2:좌, 3 :우
		if (cctv.val == '1') {
			watch(cctv, dir);
		} else if (cctv.val == '2') {
			if (dir == 0 || dir == 1) {
				watch(cctv, 0);
				watch(cctv, 1);
			} else {
				watch(cctv, 2);
				watch(cctv, 3);
			}
		} else if (cctv.val == '3') {
			if (dir == 0) {
				watch(cctv, 0); // 상
				watch(cctv, 3); // 우
			} else if (dir == 1) {
				watch(cctv, 1); // 하
				watch(cctv, 2); // 좌
			} else if (dir == 2) {
				watch(cctv, 0); // 상
				watch(cctv, 2); // 좌
			} else if (dir == 3) {
				watch(cctv, 1); // 하
				watch(cctv, 3); // 우
			}
		} else if (cctv.val == '4') {
			if (dir == 0) {
				watch(cctv, 0);
				watch(cctv, 2);
				watch(cctv, 3);
			} else if (dir == 1) {
				watch(cctv, 1);
				watch(cctv, 2);
				watch(cctv, 3);
			} else if (dir == 2) {
				watch(cctv, 0);
				watch(cctv, 1);
				watch(cctv, 2);
			} else if (dir == 3) {
				watch(cctv, 0);
				watch(cctv, 1);
				watch(cctv, 3);
			}
		}

	}

	// cctv와 방향을 입력받아서 방향에 맞춰 #값을 넣는 메서드
	private static void watch(CCTV cctv, int dir) {
		int x = cctv.x;
		int y = cctv.y;

		if (dir == 0) { // 상
			for (int i = x - 1; i >= 0; i--) {
				if (copymap[i][y] == '6')
					break;
				if (copymap[i][y] == '0')
					copymap[i][y] = '#';
			}
		} else if (dir == 1) { // 하
			for (int i = x + 1; i < N; i++) {
				if (copymap[i][y] == '6')
					break;
				if (copymap[i][y] == '0')
					copymap[i][y] = '#';
			}

		} else if (dir == 2) { // 좌
			for (int i = y - 1; i >= 0; i--) {
				if (copymap[x][i] == '6')
					break;
				if (copymap[x][i] == '0')
					copymap[x][i] = '#';
			}
		} else if (dir == 3) { // 우
			for (int i = y + 1; i < R; i++) {
				if (copymap[x][i] == '6')
					break;
				if (copymap[x][i] == '0')
					copymap[x][i] = '#';
			}
		}
	}

	// copymap 에서 0값 카운트 하고 ans와 비교하는 메서드
	private static void blindSpot() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < R; j++) {
				if (copymap[i][j] == '0')
					count++;
			}
		}
		ans = Math.min(ans, count);
	}

	// 5번 카메라가 있다면 해당 메서드를 통해 map의 값을 먼저 변경시킨다.
	private static void fourWay_Watch(CCTV cctv) {
		int x = cctv.x;
		int y = cctv.y;

		for (int i = x - 1; i >= 0; i--) {
			if (map[i][y] == '6')
				break;
			if (map[i][y] == '0')
				map[i][y] = '#';
		}
		for (int i = x + 1; i < N; i++) {
			if (map[i][y] == '6')
				break;
			if (map[i][y] == '0')
				map[i][y] = '#';
		}
		for (int i = y - 1; i >= 0; i--) {
			if (map[x][i] == '6')
				break;
			if (map[x][i] == '0')
				map[x][i] = '#';
		}
		for (int i = y + 1; i < R; i++) {
			if (map[x][i] == '6')
				break;
			if (map[x][i] == '0')
				map[x][i] = '#';
		}

	}

}
