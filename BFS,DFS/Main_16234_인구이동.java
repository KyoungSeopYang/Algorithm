package day0512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16234_인구이동 {
    static int N, L, R, ans = 0;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 연합을 생성한다.
        while (solve(map)) {
            ans++;
        }

        System.out.println(ans);


    }

    private static boolean solve(int[][] map) {
        boolean[][] visited = new boolean[N][N];
        boolean isMove = false;

        Queue<Pos> que = new LinkedList<>();

        // 연합을 만들고 인구수를 나눈다
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (visited[y][x]) continue;

                List<Pos> list = new ArrayList<>(); // map[i][j]와 연합된 국가들의 모임
                que.offer(new Pos(y, x));
                list.add(new Pos(y, x));

                visited[y][x] = true;
                int total = map[y][x];

                while (!que.isEmpty()) {
                    Pos cur = que.poll();
                    for (int i = 0; i < 4; i++) {
                        int ny = cur.y + dy[i];
                        int nx = cur.x + dx[i];

                        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                        if (visited[ny][nx] || Math.abs(map[ny][nx] - map[cur.y][cur.x]) < L || Math.abs(map[ny][nx] - map[cur.y][cur.x]) > R)
                            continue;

                        total += map[ny][nx];
                        visited[ny][nx] = true;

                        que.offer(new Pos(ny, nx));
                        list.add(new Pos(ny, nx));
                    }
                }

                if (list.size() > 1) {
                    isMove = true;
                    total /= list.size();

                    for (int i = 0; i < list.size(); i++) {
                        Pos cur = list.get(i);
                        map[cur.y][cur.x] = total;
                    }
                }
            }
        }

        return isMove;

    }

    public static class Pos {
        int y, x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
