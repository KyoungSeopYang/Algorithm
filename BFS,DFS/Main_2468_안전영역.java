package day0518;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > maxHeight) maxHeight = map[i][j];
            }
        }


        int ans = 0;

        for (int h = 0; h < maxHeight + 1; h++) {
            boolean[][] visited = new boolean[N][N];
            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] <= h || visited[i][j]) continue;

                    Queue<Pos> que = new LinkedList<>();
                    visited[i][j] = true;
                    que.add(new Pos(i, j));
                    count++;

                    while (!que.isEmpty()) {
                        Pos cur = que.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];

                            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                            if (visited[nx][ny] || map[nx][ny] <= h) continue;

                            visited[nx][ny] = true;
                            que.offer(new Pos(nx, ny));
                        }
                    }

                }
            }
            ans = Math.max(ans, count);

        }


        System.out.println(ans);

    }

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
