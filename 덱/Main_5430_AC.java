package day0409;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//덱
public class Main_5430_AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            char[] p = br.readLine().toCharArray();
            int N = Integer.parseInt(br.readLine());
            String input = br.readLine();

            StringTokenizer st = new StringTokenizer(input, "[],");

            ArrayDeque<Integer> deque = new ArrayDeque<>();

            for (int i = 0; i < N; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            AC(deque, sb, p);
        }

        System.out.println(sb);

    }

    private static void AC(ArrayDeque<Integer> deque, StringBuilder sb, char[] p) {
        boolean isRight = true;
        for (int i = 0; i < p.length; i++) {
            if (p[i] == 'R')
                isRight = !isRight;
            else if (deque.isEmpty()) {
                sb.append("error\n");
                return;
            } else if (isRight) {
                deque.pollFirst();
            } else {
                deque.pollLast();
            }
        }

        sb.append("[");
        if (deque.size() > 0) {
            sb.append(isRight ? deque.pollFirst() : deque.pollLast());
            while (!deque.isEmpty()) {
                sb.append(",").append(isRight ? deque.pollFirst() : deque.pollLast());
            }
        }
        sb.append("]\n");
    }
}
