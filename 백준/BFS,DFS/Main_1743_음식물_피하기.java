package day0307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1743_음식물_피하기 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int max = 0;

        int[][] map = new int[N][M];
        boolean[][] visit = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 1;
        }

        Queue<Pos> que = new LinkedList<>();

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (map[x][y] == 1 && !visit[x][y]) {
                    que.add(new Pos(x, y));
                    visit[x][y] = true;
                    int cnt = 1;

                    while (!que.isEmpty()) {
                        Pos cur = que.poll();

                        for (int i = 0; i < 4; i++) {
                            int nx = cur.x + dx[i];
                            int ny = cur.y + dy[i];

                            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                            if (visit[nx][ny] || map[nx][ny] == 0) continue;

                            que.add(new Pos(nx, ny));
                            visit[nx][ny] = true;
                            cnt++;
                        }
                    }

                    max = Math.max(max, cnt);
                }
            }

        }

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
