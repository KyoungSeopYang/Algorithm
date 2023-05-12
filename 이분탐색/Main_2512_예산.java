package day0512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2512_예산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] city = new int[N];
        int right = 0;

        for (int i = 0; i < N; i++) {
            city[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, city[i]);
        }
        int left = 0;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            long total = 0;

            for (int i = 0; i < N; i++) {
                if (city[i] > mid) total += mid;
                else total += city[i];
            }
            if (total <= M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }
}
