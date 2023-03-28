package day0313;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2154_카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> que = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            que.add(i);
        }


        while (true) {
            que.poll();

            if (que.size() == 1)
                break;

            que.add(que.poll());
        }

        System.out.println(que.poll());

    }
}
