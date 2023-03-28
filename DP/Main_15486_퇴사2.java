package day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15486_퇴사2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];

        StringTokenizer st;

        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken()) - 1; // 상담 기간
            int cost = Integer.parseInt(st.nextToken()); // 오늘 상담의 cost
            dp[i] = Math.max(dp[i], dp[i - 1]);

            if (i + day > N) continue;
            /*
                1. 1일 부터 순회한다
                2-1. 오늘 잡힌 상담을 한다 : dp[오늘 날짜 + 상담기간] = 어제까지 cost + 오늘 상담 cost
                2-2. 오늘 잡힌 상담은 안한다 : dp[오늘 날짜 + 상담기간] = 어제까지 cost
             */
            // 상담 끝나는 날에 최대 금액
            dp[i + day] = Math.max(dp[i + day], dp[i - 1] + cost);
        }
        System.out.println(dp[N]);

    }
}
