package day0512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BFS
public class Main_7562_나이트의이동 {
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int I = Integer.parseInt(br.readLine());
            int[][] board = new int[I][I];
            int[][] cnt = new int[I][I];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur_y = Integer.parseInt(st.nextToken());
            int cur_x = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int end_y = Integer.parseInt(st.nextToken());
            int end_x = Integer.parseInt(st.nextToken());

            Queue<Pos> que = new LinkedList<>();
            que.offer(new Pos(cur_y, cur_x));

            while (!que.isEmpty()) {
                Pos cur = que.poll();

                if (cur.y == end_y && cur.x == end_x) {
                    sb.append(cnt[cur.y][cur.x]).append("\n");
                    break;
                }

                for (int i = 0; i < 8; i++) {
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];

                    if (nx < 0 || ny < 0 || nx >= I || ny >= I) continue;
                    if (cnt[ny][nx] != 0) continue;

                    que.offer(new Pos(ny, nx));
                    cnt[ny][nx] = cnt[cur.y][cur.x] + 1;
                }
            }
        }

        System.out.println(sb);
    }

    public static class Pos {
        int y, x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
