package day0316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2805_나무자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int tree[] = new int[N];

        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if (max < tree[i]) max = tree[i];
        }

        int min = 0;

        while (min < max) {
            long sum = 0;

            int mid = (min + max) / 2;

            for (int i = 0; i < N; i++) {
                if (tree[i] > mid) sum += tree[i] - mid;
            }

            // 잘랐는데 자른 나무길이가 부족하면?  -> 더 내려야지
            if (sum < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);


    }
}
