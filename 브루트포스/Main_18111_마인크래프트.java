package day0319;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18111_마인크래프트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int max = 0;
        int min = 257;

        int[][] map = new int[N][M];

        for (int x = 0; x < N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < M; y++) {
                map[x][y] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[x][y]);
                min = Math.min(min, map[x][y]);
            }
        }


        int time = Integer.MAX_VALUE;
        int height = -1;

        for (int i = min; i <= max; i++) {
            int seconds = 0;
            int inventory = B;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    int diff = map[j][k] - i;

                    if (diff > 0) {
                        seconds += Math.abs(diff) * 2;
                        inventory += Math.abs(diff);
                    } else if (diff < 0) {
                        seconds += Math.abs(diff);
                        inventory -= Math.abs(diff);
                    }

                }
            }

            if (inventory >= 0) {
                if (seconds <= time) {
                    time = seconds;
                    height = i;
                }
            }

        }


        System.out.println(time + " " + height);
    }
}
