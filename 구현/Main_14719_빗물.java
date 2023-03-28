package day0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14719_빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] map = new int[W];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < W; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;


        for (int i = 1; i < W - 1; i++) {
            int cur = map[i];
            int left = 0, right = 0;

            for (int j = i - 1; j >= 0; j--) {
                left = Math.max(left, map[j]);
            }

            for (int j = i + 1; j < W; j++) {
                right = Math.max(right, map[j]);
            }

            if (left <= cur || right <= cur)
                continue;
            sum += Math.min(left, right) - cur;

        }
        System.out.println(sum);
    }
}
