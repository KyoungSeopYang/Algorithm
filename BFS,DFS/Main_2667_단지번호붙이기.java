package day0219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2667_단지번호붙이기 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] map;
    static boolean[][] visit;
    static ArrayList<Integer> list;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visit = new boolean[N][N];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '1' && !visit[i][j])
                    bfs(i, j);
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();

        sb.append(list.size()).append("\n");

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        Queue<Pos> que = new LinkedList<>();
        que.offer(new Pos(x, y));
        visit[x][y] = true;
        int cnt = 1;

        while (!que.isEmpty()) {
            Pos cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                if (map[nx][ny] == '1' && !visit[nx][ny]) {
                    que.offer(new Pos(nx, ny));
                    visit[nx][ny] = true;
                    cnt++;
                }
            }
        }
        list.add(cnt);

    }

    public static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
