package day0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14890_경사로 {
    static int[][] map;
    static int N, L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        int answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int idx = 0; idx < N; idx++) {
            if (checkRow(idx)) answer++; // 가로로 진행
            if (checkCol(idx)) answer++; // 세로로 진행
        }
        System.out.println(answer);
    }

    private static boolean checkRow(int row) { // 가로로 진행
        boolean[] stairs = new boolean[N];

        for (int col = 0; col < N - 1; col++) {
            int diff = map[row][col] - map[row][col + 1];

            if (diff > 1 || diff < -1) return false; // 차이가 1 이상이면 false
            else if (diff == -1) { // 다음 계단이 높다
                for (int l = 0; l < L; l++) {
                    if (col - l < 0 || stairs[col - l]) return false;
                    if (map[row][col] != map[row][col - l]) return false;
                    stairs[col - l] = true;
                }
            } else if (diff == 1) { // 다음 계단이 낮다
                for (int l = 1; l <= L; l++) {
                    if (col + l >= N || stairs[col + l]) return false;
                    if (map[row][col] - 1 != map[row][col + l]) return false;
                    stairs[col + l] = true;
                }
            }
        }
        return true;
    }

    private static boolean checkCol(int col) { // 가로로 진행
        boolean[] stairs = new boolean[N];

        for (int row = 0; row < N - 1; row++) {
            int diff = map[row][col] - map[row + 1][col];

            if (diff > 1 || diff < -1) return false; // 차이가 1 이상이면 false
            else if (diff == -1) { // 다음 계단이 높다
                for (int l = 0; l < L; l++) {
                    if (row - l < 0 || stairs[row - l]) return false;
                    if (map[row][col] != map[row - l][col]) return false;
                    stairs[row - l] = true;
                }
            } else if (diff == 1) { // 다음 계단이 낮다
                for (int l = 1; l <= L; l++) {
                    if (row + l >= N || stairs[row + l]) return false;
                    if (map[row][col] - 1 != map[row + l][col]) return false;
                    stairs[row + l] = true;
                }
            }
        }
        return true;
    }

}
