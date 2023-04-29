package day0429;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//bfs
public class Main_2644_촌수계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer>[] list = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()); // 부모
            int b = Integer.parseInt(st.nextToken()); // 자식

            list[a].add(b);
            list[b].add(a);
        }

        boolean[] checked = new boolean[N + 1];
        int[] count = new int[N + 1];
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        checked[x] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int i = 0; i < list[cur].size(); i++) {
                int to = list[cur].get(i);

                if (checked[to]) continue;

                if (to == y) {
                    System.out.println(count[cur] + 1);
                    return;
                }

                count[to] = count[cur] + 1;
                checked[to] = true;
                que.add(to);
            }
        }

        System.out.println(-1);
    }
}
