package day0131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G3_16236 {
    /*
        author : yangksks
        16236번 : 아기 상어
        https://www.acmicpc.net/problem/16236
     */

    static int map[][], size = 2, satiety = 0, N, time = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static Pos shark;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark = new Pos(i, j);
                    map[i][j] = 0;
                }
            }
        }

        bfs();
        System.out.println(time);
    }

    private static void bfs() {
        Queue<Pos> que = new LinkedList<>();
        Queue<Pos> fish = new LinkedList<>();
        que.offer(new Pos(shark.x, shark.y));

        while (true) {
            int[][] visited = new int[N][N];

            while (!que.isEmpty()) {
                Pos c = que.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = c.x + dx[i];
                    int ny = c.y + dy[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (map[nx][ny] <= size && visited[nx][ny] == 0) {
                            que.offer(new Pos(nx, ny));
                            visited[nx][ny] = visited[c.x][c.y] + 1;
                            if (map[nx][ny] > 0 && map[nx][ny] < size) {
                                fish.offer(new Pos(nx, ny));
                            }
                        }
                    }
                }
            }

            if (fish.isEmpty())
                break;

            Pos target = fish.poll();

            while (!fish.isEmpty()) {
                Pos cur = fish.poll();

                if (visited[target.x][target.y] > visited[cur.x][cur.y]) {
                    target = cur;
                } else if (visited[target.x][target.y] == visited[cur.x][cur.y]) {
                    if (target.x == cur.x) {
                        if (target.y > cur.y)
                            target = cur;
                    } else if (target.x > cur.x)
                        target = cur;
                }
            }
            time += visited[target.x][target.y];
            map[target.x][target.y] = 0;
            shark = target;
            que.offer(shark);
            if (size == ++satiety) {
                size++;
                satiety = 0;
            }
        }

    }

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
