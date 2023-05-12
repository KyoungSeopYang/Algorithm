package day0512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    Queue에 불 -> 상근이 순서로 담는다.
    Queue에서 하나씩 꺼내서 BFS를 돌린다.
        그러면 불 -> 상근이 순서로 BFS가 돌아간다.
        만약 불이라면 번지게하고
        상근이라면 해당 위치에 상근이가 도달하는 시간을 cnt[][]에 저장하고,
        배열 범위를 벗어났다면 탈출완료이기때문에 현재상근이 위치 도달시간 +1을 return한다.
   만약 Queue가 비었다면, 상근이가 탈출하지 못했다는 뜻이므로 IMPOSSIBLE
 */

public class Main_5427_불 {

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static String bfs(char[][] building, int[][] cnt, int h, int w, Queue<Pos> que) {

        while (!que.isEmpty()) {
            Pos cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                // 범위를 벗어나면
                if (nx < 0 || ny < 0 || nx >= w || ny >= h) {
                    if (cur.isFire) { // 불은 더이상 번지지 않는다.
                        continue;
                    } else { // 상근이가 벗어났으면 탈출 성공
                        return String.valueOf(cnt[cur.y][cur.x] + 1);
                    }
                }

                if (building[ny][nx] == '#' || building[ny][nx] == '*' || cnt[ny][nx] != 0) continue;

                if (cur.isFire) building[ny][nx] = '*';
                else cnt[ny][nx] = cnt[cur.y][cur.x] + 1;

                que.offer(new Pos(ny, nx, cur.isFire));
            }
        }

        return "IMPOSSIBLE";

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            char[][] building = new char[h][w];
            int[][] cnt = new int[h][w];

            Queue<Pos> que = new LinkedList<>();
            Pos player = null;

            for (int i = 0; i < h; i++) {
                String tmp = br.readLine();
                for (int j = 0; j < w; j++) {
                    building[i][j] = tmp.charAt(j);

                    if (building[i][j] == '*')
                        que.offer(new Pos(i, j, true));
                    if (building[i][j] == '@')
                        player = new Pos(i, j, false);
                }
            }

            que.offer(player);


            sb.append(bfs(building, cnt, h, w, que)).append("\n");
        }

        System.out.println(sb);
    }

    public static class Pos {
        int y, x;
        boolean isFire;

        public Pos(int y, int x, boolean isFire) {
            this.y = y;
            this.x = x;
            this.isFire = isFire;
        }
    }
}
