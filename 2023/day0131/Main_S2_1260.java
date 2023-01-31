package day0131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_S2_1260 {
    /*
        author : yangksks
        1260번 : DFS와 BFS
        https://www.acmicpc.net/problem/1260
     */

    static int N, M, V;
    static ArrayList<Integer>[] list;
    static boolean visited[];
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }


        dfs(V);
        bfs(V);

        System.out.println(sb);
    }

    private static void bfs(int v) {
        visited = new boolean[N + 1];
        sb.append("\n" + v + " ");

        Queue<Integer> que = new LinkedList<>();
        que.offer(v);
        visited[v] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();

            int size = list[cur].size();
            for (int i = 0; i < size; i++) {
                int node = list[cur].get(i);

                if (!visited[node]) {
                    que.offer(node);
                    visited[node] = true;
                    sb.append(node + " ");
                }
            }
        }
    }

    private static void dfs(int v) {

        visited[v] = true;
        sb.append(v + " ");

        int size = list[v].size();
        for (int i = 0; i < size; i++) {
            int node = list[v].get(i);
            if (!visited[node])
                dfs(node);
        }

    }
}
