package day0508;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1922_네트워크연결 {

    public static void union(int[] parent, int a, int b) {
        int a_parent = find(parent, a);
        int b_parent = find(parent, b);

        if (a_parent < b_parent)
            parent[b_parent] = a_parent;
        else
            parent[a_parent] = b_parent;
    }

    private static int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] graph = new int[M][3];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken()); // a
            graph[i][1] = Integer.parseInt(st.nextToken()); // b
            graph[i][2] = Integer.parseInt(st.nextToken()); // 비용
        }
        int[] parent = new int[N + 1];
        int total = 0;

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        for (int i = 0; i < M; i++) {
            if (find(parent, graph[i][0]) != find(parent, graph[i][1])) {
                total += graph[i][2];
                union(parent, graph[i][0], graph[i][1]);
            }
        }

        System.out.println(total);
    }
}
