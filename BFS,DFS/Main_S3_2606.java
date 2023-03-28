package day0130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S3_2606 {

    /*
        2606 : 바이러스
        https://www.acmicpc.net/problem/2606
     */

    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[from].add(end);
            list[end].add(from);
        }

        System.out.println(bfs());

    }

    private static int bfs() {
        Queue<Integer> que = new LinkedList<Integer>();
        int count = 0;
        que.offer(1);
        visited[1] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int i = 0; i < list[cur].size(); i++) {
                if (!visited[list[cur].get(i)]) {
                    visited[list[cur].get(i)] = true;
                    que.offer(list[cur].get(i));
                    count++;
                }
            }
        }

        return count;
    }
}
