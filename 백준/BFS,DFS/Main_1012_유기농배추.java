package day0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1012_유기농배추 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int cnt = 0;
            int[][] map = new int[N][M];
            boolean[][] visit = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (map[x][y] == 0 || visit[x][y]) continue;

                    Queue<Pos> q = new LinkedList<>();
                    q.offer(new Pos(x, y));
                    visit[x][y] = true;
                    cnt++;

                    while (!q.isEmpty()) {
                        Pos cur = q.poll();

                        for (int i = 0; i < 4; i++) {
                            int nx = cur.x + dx[i];
                            int ny = cur.y + dy[i];

                            if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 0 || visit[nx][ny]) continue;

                            q.offer(new Pos(nx, ny));
                            visit[nx][ny] = true;
                        }

                    }


                }
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
