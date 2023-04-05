package day0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://chb2005.tistory.com/80

public class Main_1389_케빈베이컨의6단계법칙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dist = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dist[a][b] = 1;
            dist[b][a] = 1;
        }

        // i:중간점   j:시작점   k:끝점
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (dist[j][i] == Integer.MAX_VALUE) continue;
                for (int k = 1; k <= N; k++) {
                    if (dist[i][k] == Integer.MAX_VALUE) continue;
                    if (dist[j][k] > dist[j][i] + dist[i][k]) {
                        dist[j][k] = dist[j][i] + dist[i][k];
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int ans = 0;

        for (int i = 1; i <= N; i++) {
            int tmp = 0;
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] != Integer.MAX_VALUE)
                    tmp += dist[i][j];
            }
            if (min > tmp) {
                min = tmp;
                ans = i;
            }
        }

        System.out.println(ans);


    }
}
