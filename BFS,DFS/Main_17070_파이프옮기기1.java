package day0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070_파이프옮기기1 {
    static int N;
    static int[][] map;
    static int[][] pipeCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        pipeCnt = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 1, 1);
        System.out.println(pipeCnt[N - 1][N - 1]);
    }

    // 1 : 가로 2: 세로 3: 대각선
    private static void dfs(int x, int y, int dir) {
        if (x >= N || y >= N || map[x][y] == 1) return;

        if (dir == 1) {
            dfs(x, y + 1, 1);
            dfs(x + 1, y + 1, 3);
        } else if (dir == 2) {
            dfs(x + 1, y, 2);
            dfs(x + 1, y + 1, 3);
        } else {
            if (map[x - 1][y] == 1 || map[x][y - 1] == 1) return;
            dfs(x, y + 1, 1);
            dfs(x + 1, y, 2);
            dfs(x + 1, y + 1, 3);
        }
        pipeCnt[x][y]++;

    }
}
