package day0316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1966_프린터큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int answer = 0;

            Queue<Integer> que = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            int[] priorities = new int[N];

            for (int i = 0; i < N; i++) {
                priorities[i] = Integer.parseInt(st.nextToken());
                que.offer(priorities[i]);
            }

            Arrays.sort(priorities);
            int lastIdx = N - 1;

            while (!que.isEmpty()) {
                int i = que.poll();
                if (i == priorities[lastIdx]) {
                    answer++;
                    lastIdx--;
                    M--;
                    if (M < 0)
                        break;
                } else {
                    que.add(i);
                    M--;
                    if (M < 0)
                        M = que.size() - 1;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
