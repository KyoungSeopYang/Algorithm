package day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로탐색 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        boolean[][] visit = new boolean[N][M];
        for (int i = 0; i < map.length; i++) {
            map[i] = br.readLine().toCharArray();
        }

        Queue<Pos> que = new LinkedList<>();
        que.offer(new Pos(0, 0, 1));
        visit[0][0] = true;

        while (!que.isEmpty()) {
            Pos cur = que.poll();
            if (cur.x == N - 1 && cur.y == M - 1) {
                System.out.println(cur.cnt);
                System.exit(0);
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= N || ny >= M || nx < 0 || ny < 0) continue;
                if (visit[nx][ny] || map[nx][ny] == '0') continue;

                que.offer(new Pos(nx, ny, cur.cnt + 1));
                visit[nx][ny] = true;
            }
        }

    }

    public static class Pos {
        int x, y, cnt;

        public Pos(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
