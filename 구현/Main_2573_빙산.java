package day0513;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2573_빙산 {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        int cnt = 0;

        while ((cnt = SeparateNum()) < 2) {
            if (cnt == 0) {
                System.out.println(0);
                return;
            }

            Melt();
            ans++;
        }

        System.out.println(ans);
    }

    public static void Melt() {
        boolean[][] visited = new boolean[N][M];

        Queue<Pos> que = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 || visited[i][j]) continue;

                que.offer(new Pos(i, j));
                visited[i][j] = true;

                while (!que.isEmpty()) {
                    Pos cur = que.poll();
                    int seaNum = 0;

                    for (int k = 0; k < 4; k++) {
                        int ny = cur.y + dy[k];
                        int nx = cur.x + dx[k];

                        if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                        if (map[ny][nx] != 0 && !visited[ny][nx]) {
                            que.offer(new Pos(ny, nx));
                            visited[ny][nx] = true;
                        } else if (!visited[ny][nx] && map[ny][nx] == 0) seaNum++;
                    }
                    map[cur.y][cur.x] = map[cur.y][cur.x] - seaNum < 0 ? 0 : map[cur.y][cur.x] - seaNum;
                }
            }
        }
    }

    public static int SeparateNum() {
        boolean[][] visited = new boolean[N][M];

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    DFS(i, j, visited);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void DFS(int y, int x, boolean[][] visited) {

        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
            if (map[ny][nx] != 0 && !visited[ny][nx]) {
                DFS(ny, nx, visited);
            }
        }

    }

    static class Pos {
        int y, x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
