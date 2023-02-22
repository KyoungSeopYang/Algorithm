package day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1926_그림 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        boolean[][] visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0; // 그림의 개수
        int max = 0; // 최대 넓이

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (visit[x][y] || map[x][y] == 0) continue;
                int area = 0;
                count++;

                Queue<Pos> que = new LinkedList<>();
                que.offer(new Pos(x, y));
                visit[x][y] = true;

                while (!que.isEmpty()) {
                    Pos cur = que.poll();
                    area++;

                    for (int i = 0; i < 4; i++) {
                        int nx = cur.x + dx[i];
                        int ny = cur.y + dy[i];

                        if (nx >= N || ny >= M || nx < 0 || ny < 0) continue;
                        if (visit[nx][ny] || map[nx][ny] == 0) continue;
                        que.offer(new Pos(nx, ny));
                        visit[nx][ny] = true;

                    }
                }
                max = Math.max(area, max);
            }
        }

        System.out.println(count);
        System.out.println(max);


    }

    public static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
