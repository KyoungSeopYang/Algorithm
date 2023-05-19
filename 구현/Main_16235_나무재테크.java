package day0519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16235_나무재테크 {
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][N + 1];
        int[][] add = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = 5;
                add[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Deque<Tree> trees = new LinkedList<>();
        Queue<Tree> dead = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            trees.addFirst(new Tree(x, y, z));
        }

        Collections.sort((List<Tree>) trees);

        while (K-- > 0) {
            // 봄 ===========================
            int size = trees.size();

            for (int i = 0; i < size; i++) {
                Tree cur = trees.poll();

                if (map[cur.r][cur.c] < cur.age) // 양분이 부족하면
                    dead.offer(cur);
                else {
                    map[cur.r][cur.c] -= cur.age;
                    cur.age++;
                    trees.offer(cur);
                }
            }

            // 여름 ==========================
            while (!dead.isEmpty()) {
                Tree cur = dead.poll();
                map[cur.r][cur.c] += cur.age / 2;
            }

            // 가을 ===========================
            Queue<Tree> tmp = new LinkedList<>();
            for (Tree t : trees) {
                if (t.age % 5 == 0) {
                    tmp.add(t);
                }
            }

            while (!tmp.isEmpty()) {
                Tree cur = tmp.poll();

                for (int i = 0; i < 8; i++) {
                    int nx = cur.r + dx[i];
                    int ny = cur.c + dy[i];
                    if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
                        trees.addFirst(new Tree(nx, ny, 1));
                    }
                }
            }

            // 겨울 ==========================
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    map[i][j] += add[i][j];
                }
            }
        }

        System.out.println(trees.size());
    }

    private static class Tree implements Comparable<Tree> {
        int r, c;
        int age;

        public Tree(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }


        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }
}
