package day0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3085_사탕게임 {

    static int[] dx = {0, -1};
    static int[] dy = {1, 0};
    static char[][] map;
    static int max = 0, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            rowCheck(i);
            culCheck(i);
            for (int j = 0; j < N; j++) {
                solve(i, j);
            }
        }

        System.out.println(max);
    }

    private static void solve(int x, int y) {

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

            if (map[x][y] != map[nx][ny]) {
                swap(x, y, nx, ny); // 사탕 위치 바꾸기
                if (x == nx) { // 가로로 swap 했으면
                    rowCheck(x);
                    culCheck(y);
                    culCheck(ny);
                } else { // 세로로 스왑했으면
                    rowCheck(x);
                    rowCheck(nx);
                    culCheck(y);
                }
                swap(x, y, nx, ny); // 사탕 위치 바꾸기
            }
        }

    }

    private static void culCheck(int y) {
        int cnt = 1;
        for (int i = 1; i < N; i++) {
            if (map[i][y] == map[i - 1][y])
                cnt++;
            else
                cnt = 1;
            max = Math.max(cnt, max);
        }
    }

    private static void rowCheck(int x) {
        int cnt = 1;
        for (int i = 1; i < N; i++) {
            if (map[x][i] == map[x][i - 1])
                cnt++;
            else
                cnt = 1;
            max = Math.max(cnt, max);
        }
    }

    private static void swap(int x, int y, int nx, int ny) {
        char tmp = map[x][y];
        map[x][y] = map[nx][ny];
        map[nx][ny] = tmp;
    }


}
