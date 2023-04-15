package day0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

// 우선순위 큐
public class Main_11286_절댓값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2))
                    return o1 > o2 ? 1 : -1;
                if (Math.abs(o1) > Math.abs(o2))
                    return 1;
                if (Math.abs(o1) < Math.abs(o2))
                    return -1;

                return 0;
            }
        });

        while (N-- > 0) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) {
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
            } else {
                pq.add(input);
            }
        }

        System.out.println(sb);
    }
}
