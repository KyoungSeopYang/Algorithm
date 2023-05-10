package day0510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16194_카드구매하기2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] price = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];

        dp[1] = price[1];
        dp[2] = Math.min(dp[1] + dp[1], price[2]);

        for (int i = 3; i <= N; i++) {
            dp[i] = price[i];

            for (int j = 1; j < i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + dp[j]);
            }

        }

        System.out.println(dp[N]);

    }
}
