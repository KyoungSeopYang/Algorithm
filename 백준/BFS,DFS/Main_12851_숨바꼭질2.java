package day0309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12851_숨바꼭질2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;

        if (N >= K) {
            System.out.println((N - K) + "\n1");
            return;
        }


        Queue<Integer> que = new LinkedList<>();
        que.add(N);
        int[] time = new int[100001];
        time[N] = 1;
        time[K] = Integer.MAX_VALUE;

        while (!que.isEmpty()) {
            int x = que.poll();

            if (time[K] < time[x]) continue;

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) next = x + 1;
                else if (i == 1) next = x - 1;
                else next = x * 2;

                if (next < 0 || next > 100000) continue;

                if (next == K) {
                    time[K] = time[x];
                    cnt++;
                }

                if (time[next] == 0 || time[next] == time[x] + 1) {
                    que.add(next);
                    time[next] = time[x] + 1;
                }
            }
        }

        System.out.println(time[K]);
        System.out.println(cnt);
    }


}
