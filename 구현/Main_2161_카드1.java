package day0517;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2161_카드1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> que = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            que.offer(i);
        }

        while (!que.isEmpty()) {
            sb.append(que.poll() + " ");
            if (!que.isEmpty())
                que.offer(que.poll());
        }

        System.out.println(sb);

    }
}
