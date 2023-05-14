package day0514;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1748_수이어쓰기1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long cnt = 0;
        int plus = 1;
        int num = 10;

        for (int i = 1; i <= N; i++) {
            if (i % num == 0) {
                plus++;
                num *= 10;
            }
            cnt += plus;
        }

        System.out.println(cnt);
    }
}
