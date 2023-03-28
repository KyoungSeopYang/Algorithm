package day0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500_테트로미노 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean[][] visit;
    static int[][] map;
    static int ans = 0, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                visit[x][y] = true;
                solve(x, y, 1, 0);
                visit[x][y] = false;
                check(x, y);
            }
        }

        System.out.println(ans);

    }

    static void check(int x, int y) {
        if (x < N - 2 && y < M - 1)
            ans = Math.max(ans, map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 1][y + 1]);

        if (x < N - 2 && y > 0)
            ans = Math.max(ans, map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 1][y - 1]);

        if (x < N - 1 && y < M - 2)
            ans = Math.max(ans, map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x + 1][y + 1]);

        if (x > 0 && y < M - 2)
            ans = Math.max(ans, map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x - 1][y + 1]);
    }

    private static void solve(int x, int y, int dep, int sum) {
        if (dep == 4) {
            ans = Math.max(ans, sum + map[x][y]);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (visit[nx][ny]) continue;

            visit[nx][ny] = true;
            solve(nx, ny, dep + 1, sum + map[x][y]);
            visit[nx][ny] = false;
        }

    }
}
