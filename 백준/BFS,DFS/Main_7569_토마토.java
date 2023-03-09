package day0309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569_토마토 {

    static int[] dx = {-1, 0, 1, 0, 0, 0}; //상하좌우위아래
    static int[] dy = {0, 1, 0, -1, 0, 0}; //상하좌우위아래
    static int[] dz = {0, 0, 0, 0, 1, -1}; //상하좌우위아래

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 가로
        int N = Integer.parseInt(st.nextToken()); // 세로
        int H = Integer.parseInt(st.nextToken()); // 높이

        int[][][] box = new int[H][N][M];
        Queue<Tomato> q = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) q.add(new Tomato(i, j, k));
                }
            }
        }

        while (!q.isEmpty()) {
            Tomato cur = q.poll();

            for (int i = 0; i < 6; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nz = cur.z + dz[i];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H) continue;
                if (box[nz][nx][ny] == 0) {
                    q.add(new Tomato(nz, nx, ny));
                    box[nz][nx][ny] = box[cur.z][cur.x][cur.y] + 1;
                }
            }
        }

        int ans = Integer.MIN_VALUE;


        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }

                    ans = Math.max(ans, box[i][j][k]);
                }
            }
        }


        System.out.println(ans - 1);

    }

    public static class Tomato {
        int z, x, y;

        public Tomato(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }
}
