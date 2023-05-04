package day0504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17086_아기상어2 {
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int max = 0;


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (map[y][x] == 1) continue;

                boolean[][] visited = new boolean[N][M];
                Queue<Pos> que = new LinkedList<>();
                int[][] cnt = new int[N][M];

                que.add(new Pos(y, x));
                visited[y][x] = true;

                while (!que.isEmpty()) {
                    Pos cur = que.poll();

                    if (map[cur.y][cur.x] == 1) {
                        max = Math.max(max, cnt[cur.y][cur.x]);
                        break;
                    }

                    for (int i = 0; i < 8; i++) {
                        int ny = cur.y + dy[i];
                        int nx = cur.x + dx[i];

                        if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                        if (visited[ny][nx]) continue;

                        que.offer(new Pos(ny, nx));
                        visited[ny][nx] = true;
                        cnt[ny][nx] = cnt[cur.y][cur.x] + 1;
                    }
                }
            }
        }

        System.out.println(max);

    }

    public static class Pos {
        int y, x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
