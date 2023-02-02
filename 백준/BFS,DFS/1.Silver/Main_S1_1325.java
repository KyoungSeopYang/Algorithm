package day0131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_1325 {
    /*
        author : Yangks
        1325번 : 효율적인 해킹
        https://www.acmicpc.net/problem/1325
     */

    static ArrayList<Integer>[] list;
    static int[] ans;
    static int N, M, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        ans = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            list[from].add(to);
        }

        for (int i = 1; i <= N; i++) {
            bfs(i);
        }

        for (int i = 1; i <= N; i++) {
            if (ans[i] == max)
                sb.append(i + " ");
        }
        System.out.println(sb);
    }

    private static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        que.offer(start);
        visited[start] = true;
        int cnt = 1;

        while (!que.isEmpty()) {
            int from = que.poll();

            for (int to : list[from]) {
                if (!visited[to]) {
                    que.offer(to);
                    visited[to] = true;
                    cnt++;
                }
            }
        }
        ans[start] = cnt;
        max = Math.max(max, cnt);

    }
}
