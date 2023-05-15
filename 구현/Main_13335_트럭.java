package day0515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13335_트럭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> truck = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            truck.offer(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> que = new LinkedList<>();
        int time = 0;
        int weight = 0;

        for (int i = 0; i < W; i++) {
            que.offer(0);
        }

        while (!que.isEmpty()) {
            time++;
            weight -= que.poll();

            if (!truck.isEmpty()) {
                if (truck.peek() + weight <= L) {
                    weight += truck.peek();
                    que.offer(truck.poll());
                } else {
                    que.offer(0);
                }
            }
        }
        System.out.println(time);
    }
}
