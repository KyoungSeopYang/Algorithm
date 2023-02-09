package day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563_색종이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] paper = new int[100][100];

        int N = Integer.parseInt(br.readLine());
        int over = 0;

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (paper[x + i][y + j] == 1) {
                        over++;
                    } else
                        paper[x + i][y + j] = 1;
                }
            }
        }

        System.out.println(N * 100 - over);
    }
}
