package com.ssafy.day0419;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//17324kb 144ms
public class Main_G2_12100_2048 {

	static int ans = 0, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int max = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = (map[i][j] > max) ? map[i][j] : max;
			}
		}
		
		int[][] copyMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		// solve
		solve(5, max, copyMap);
		System.out.println(ans);

	}

	private static void solve(int cnt, int max, int[][] map) {

		if (cnt == 0) {
			ans = Math.max(ans, max);
			return;
		}

		if (max * Math.pow(2, cnt) < ans) {
			return;
		}

		for (int dir = 0; dir < 4; dir++) {
			int[][] copyMap = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					copyMap[r][c] = map[r][c];
				}
			}

			solve(cnt - 1, moveBlock(copyMap, dir), copyMap);
		}

	}

	private static int moveBlock(int[][] map, int dir) {
		int max = 0;
        switch(dir) {
        //위로 몰기
        case 0:
            for(int i = 0; i < N; i++) {
                int index = 0;
                int block = 0;
                for(int j = 0; j < N; j++) {
                    if(map[j][i] != 0) {
                        if(block == map[j][i]) {
                            map[index - 1][i] = block * 2;
                            block = 0;
                            map[j][i] = 0;
                        }
                        else {
                            block = map[j][i];
                            map[j][i] = 0;
                            map[index][i] = block;
                            index++;
                        }
                    }
                }
            }
            break;
        //왼쪽으로 몰기
        case 1:
            for(int i = 0; i < N; i++) {
                int index = N - 1;
                int block = 0;
                for(int j = N - 1; j >= 0; j--) {
                    if(map[j][i] != 0) {
                        if(block == map[j][i]) {
                            map[index + 1][i] = block * 2;
                            block = 0;
                            map[j][i] = 0;
                        }
                        else {
                            block = map[j][i];
                            map[j][i] = 0;
                            map[index][i] = block;
                            index--;
                        }
                    }
                }
            }
            break;
        //왼쪽으로 몰기
        case 2:
            for(int i = 0; i < N; i++) {
                int index = 0;
                int block = 0;
                for(int j = 0; j < N; j++) {
                    if(map[i][j] != 0) {
                        if(block == map[i][j]) {
                            map[i][index - 1] = block * 2;
                            block = 0;
                            map[i][j] = 0;
                        }
                        else {
                            block = map[i][j];
                            map[i][j] = 0;
                            map[i][index] = block;
                            index++;
                        }
                    }
                }
            }
            break;
        //오른쪽으로 몰기
        case 3:
            for(int i = 0; i < N; i++) {
                int index = N - 1;
                int block = 0;
                for(int j = N - 1; j >= 0; j--) {
                    if(map[i][j] != 0) {
                        if(block == map[i][j]) {
                            map[i][index + 1] = block * 2;
                            block = 0;
                            map[i][j] = 0;
                        }
                        else {
                            block = map[i][j];
                            map[i][j] = 0;
                            map[i][index] = block;
                            index--;
                        }
                    }
                }
            }
            break;
    }
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = (map[i][j] > max) ? map[i][j] : max;
			}
		}
		return max;

	}

}
