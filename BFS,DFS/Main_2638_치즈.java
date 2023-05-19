package day0519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2638_치즈 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int N, M;
    static List<Pos> cheese;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cheese = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) cheese.add(new Pos(i, j));
            }
        }

        int time = 0;

        while (cheese.size() != 0) {
            visited = new boolean[N][M];
            time++;
            bfs();
            melting();
        }

        System.out.println(time);

    }

    private static void melting() {
        for (int i = 0; i < cheese.size(); i++) {
            Pos cur = cheese.get(i);
            int cnt = 0;

            for (int j = 0; j < 4; j++) {
                int nx = cur.x + dx[j];
                int ny = cur.y + dy[j];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] == 2) cnt++;
            }

            if (cnt >= 2) {
                map[cur.x][cur.y] = 0;
                cheese.remove(i);
                i--;
            }

        }
    }

    private static void bfs() {
        Queue<Pos> que = new LinkedList<>();
        que.add(new Pos(0, 0));
        visited[0][0] = true;

        while (!que.isEmpty()) {
            Pos cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] == 1 || visited[nx][ny]) continue;

                map[nx][ny] = 2;
                que.offer(new Pos(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
