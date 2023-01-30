package com.ssafy.day0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//34176kb 292ms
public class Main_G4_17135_캐슬디펜스 {

	static int N, M, D, map[][];
	static int max;
	static int dr[] = { 0, -1, 0 };
	static int dc[] = { -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		D = Integer.parseInt(st.nextToken()); // 공격 사정거리
		int enemy = 0;

		map = new int[N + 1][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					enemy++;
			}
		}

		// 궁수 3명의 열을 찾기위해서 NP를 돌립니다.
		int[] temp = new int[M];
		for (int i = M - 1; i > M - 4; i--) {
			temp[i] = 1;
		}
		
		 /*
		  * 1.np로 궁수가 자리할 수 있는 위치를 구한다 
		  * 2.궁수의 위치에서부터 3방 탐색을 통해 가장 가까운 적의 위치를 기억한다.
		  * 3.각 궁수의 타겟을 처리한다.
		  * 4.남은 적을 아래로 한칸씩 움직인다.
		  */
		do {
			defense(temp, enemy);
		} while (np(temp));
		System.out.println(max);
	}

	private static void defense(int[] temp, int enemy) {
		int archer[] = new int[3];
		int idx = 0;
		int kill = 0;

		int copyMap[][] = new int[N][M];

		// 맵을 미리 저장해둡니다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}

		// temp[i] == 1 i번째 열에 궁수가 존재한다
		for (int i = 0; i < M; i++) {
			if (temp[i] == 1)
				archer[idx++] = i;
		}
		
		Queue<Pos> que = new LinkedList<>();
		Queue<Pos> target = new LinkedList<>();
		boolean[][] visit = null;

		while (enemy > 0) {
			for (int i = 0; i < 3; i++) {	// 각 궁수의 적을 찾는 반복문
				que.clear();
				que.add(new Pos(N - 1, archer[i], 1)); // 현재 궁수의 바로 앞 위치를 저장
				visit = new boolean[N][M];
				visit[N - 1][archer[i]] = true;

				while (!que.isEmpty()) {	// BFS
					Pos cur = que.poll();

					if (copyMap[cur.r][cur.c] == 1) { // 해당위치에 적이 있다면 target 큐에 저장
						target.add(cur);
						break;
					}

					for (int j = 0; j < 3; j++) { // 3방 탐색
						int nr = cur.r + dr[j];
						int nc = cur.c + dc[j];

						if (nr < 0 || nc < 0 || nr >= N || nc >= M)
							continue;
						if (cur.dis == D || visit[nr][nc])
							continue;

						visit[nr][nc] = true;
						que.add(new Pos(nr, nc, cur.dis + 1));
					}
				}
			}
			
			// 타겟을 처리할때 같은 적을 여러 궁수가 노릴 수 있어서 체크가 필요하다
			while(!target.isEmpty()) {
				Pos cur = target.poll();
				
				if(copyMap[cur.r][cur.c] == 1) {
					copyMap[cur.r][cur.c] = 0;
					enemy--;
					kill++;
				}
			}

			// 공격할 적을 처리한 후에 남아있는 적들을 아래로 한칸씩 움직여 줍니다.
			for (int i = N - 1; i >= 0; i--) {
				for (int j = 0; j < M; j++) {
					if (copyMap[i][j] == 1) {
						copyMap[i][j] = 0;

						if (i == N - 1)
							enemy--;
						else
							copyMap[i + 1][j] = 1;
					}
				}
			}
		} // 맵에 적이 모두 사라졌다면 max값과 비교

		max = Math.max(max, kill);
	}

	private static boolean np(int[] temp) {

		int N = temp.length;
		int i = N - 1;

		while (i > 0 && temp[i - 1] >= temp[i])
			--i;

		if (i == 0)
			return false;

		int j = N - 1;
		while (temp[i - 1] >= temp[j])
			--j;

		swap(temp, i - 1, j);

		int k = N - 1;
		while (i < k) {
			swap(temp, i++, k--);
		}

		return true;
	}

	private static void swap(int[] temp, int i, int j) {
		int tmp = temp[i];
		temp[i] = temp[j];
		temp[j] = tmp;
	}

	static class Pos {
		int r, c, dis;

		public Pos(int r, int c, int dis) {
			super();
			this.r = r;
			this.c = c;
			this.dis = dis;
		}
	}

}