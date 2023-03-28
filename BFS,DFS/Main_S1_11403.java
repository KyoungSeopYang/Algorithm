package day0131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_11403 {
    /*
    author : Yangks
    11403번 : 경로찾기
    https://www.acmicpc.net/problem/11403
     */

    static int N;

    static int[][] adjArray;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        adjArray = new int[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                adjArray[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            bfs(i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(visited[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void bfs(int from) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(from);

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int i = 0; i < N; i++) {
                if (adjArray[cur][i] == 1 && visited[from][i] == 0) {
                    que.add(i);
                    visited[from][i] = 1;
                }
            }
        }
    }
}
