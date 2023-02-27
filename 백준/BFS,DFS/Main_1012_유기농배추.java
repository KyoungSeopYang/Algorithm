package day0227;

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
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][M];
            int answer = 0;

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            // 탐색하면서 해결하자

            boolean[][] visit = new boolean[N][M];

            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (map[x][y] == 0 || visit[x][y]) continue;

                    Queue<Pos> que = new LinkedList<>();
                    que.add(new Pos(x, y));
                    visit[x][y] = true;
                    answer++;

                    while (!que.isEmpty()) {
                        Pos cur = que.poll();

                        for (int i = 0; i < 4; i++) {
                            int nx = cur.x + dx[i];
                            int ny = cur.y + dy[i];

                            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                            if (map[nx][ny] == 0 || visit[nx][ny]) continue;

                            que.add(new Pos(nx, ny));
                            visit[nx][ny] = true;
                        }
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
