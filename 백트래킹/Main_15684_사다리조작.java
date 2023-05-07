package day0507;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15684_사다리조작 {
    static int N, M, H;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // b번 세로선과 b+1번 세로선을 a번 가로선으로 연결
            map[a][b] = 1;
            map[a][b + 1] = 2;
        }


        for (int i = 0; i <= 3; i++) {
            dfs(1, 0, i);
        }
        System.out.println(-1);
    }

    private static void dfs(int y, int cnt, int size) {

        if (cnt == size) { // 사다리를 다 놓았다면
            if (check()) { // 체크한다
                System.out.println(size);
                System.exit(0);
            }
            return;
        }

        for (int ny = y; ny <= H; ny++) {
            for (int nx = 1; nx < N; nx++) {
                if (map[ny][nx] == 0 && map[ny][nx + 1] == 0) {
                    map[ny][nx] = 1;
                    map[ny][nx + 1] = 2;
                    dfs(ny, cnt + 1, size);
                    map[ny][nx] = map[ny][nx + 1] = 0;
                }
            }
        }

    }

    private static boolean check() {
        for (int x = 1; x <= N; x++) {
            int nx = x;
            for (int y = 1; y <= H; y++) {
                if (map[y][nx] == 1) nx++;
                else if (map[y][nx] == 2) nx--;
            }

            if (nx != x) return false;
        }
        return true;
    }
}
