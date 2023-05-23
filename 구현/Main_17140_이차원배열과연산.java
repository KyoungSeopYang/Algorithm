package day0523;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_17140_이차원배열과연산 {
    static int xLength = 3, yLength = 3, r, c, k;
    static int[][] A = new int[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // rowSize >= colSize 이면 R연산
        // rowSize < colSize 이면 C 연산

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution());

    }

    private static int solution() {

        for (int time = 0; time <= 100; time++) {
            if (A[r][c] == k)
                return time;
            Calc();
        }
        return -1;
    }

    private static void Calc() {
        if (xLength >= yLength) {
            for (int i = 1; i <= xLength; i++) {
                R(i);
            }
        } else {
            for (int i = 1; i <= yLength; i++) {
                C(i);
            }
        }
    }

    private static void C(int key) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 1; i <= xLength; i++) {
            if (A[i][key] == 0) continue;

            hm.compute(A[i][key], (number, count) -> count == null ? 1 : count + 1);
        }

        hm.forEach((k, v) -> pq.add(new Pair(k, v)));

        int i = 1;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            A[i++][key] = cur.number;
            A[i++][key] = cur.count;
        }
        xLength = Math.max(xLength, i);

        while (i <= 99) {
            A[i++][key] = 0;
            A[i++][key] = 0;
        }
    }

    private static void R(int key) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 1; i <= yLength; i++) {
            if (A[key][i] == 0) continue;

            hm.compute(A[key][i], (number, count) -> count == null ? 1 : count + 1);
        }

        hm.forEach((k, v) -> pq.add(new Pair(k, v)));

        int i = 1;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            A[key][i++] = cur.number;
            A[key][i++] = cur.count;
        }

        yLength = Math.max(yLength, i);

        while (i <= 99) {
            A[key][i++] = 0;
            A[key][i++] = 0;
        }
    }

    private static class Pair implements Comparable<Pair> {
        int number;
        int count;

        public Pair(int number, int count) {
            this.number = number;
            this.count = count;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.count == o.count)
                return this.number - o.number;
            return this.count - o.count;
        }
    }
}
