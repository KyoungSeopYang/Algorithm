package day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1303_전쟁 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        boolean[][] visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int myTeam = 0;
        int enemy = 0;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (visit[x][y]) continue;

                int n = 1;
                Queue<Pos> que = new LinkedList<>();
                que.offer(new Pos(x, y));
                visit[x][y] = true;

                while (!que.isEmpty()) {
                    Pos cur = que.poll();

                    for (int i = 0; i < 4; i++) {
                        int nx = cur.x + dx[i];
                        int ny = cur.y + dy[i];

                        if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                        if (visit[nx][ny] || map[nx][ny] != map[x][y]) continue;

                        que.offer(new Pos(nx, ny));
                        visit[nx][ny] = true;
                        n++;
                    }
                }
                if (map[x][y] == 'W')
                    myTeam += n * n;
                else
                    enemy += n * n;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(myTeam + " " + enemy);
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
