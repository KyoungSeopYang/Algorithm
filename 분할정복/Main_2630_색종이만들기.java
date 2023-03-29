package day0329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630_색종이만들기 {
    static int N, blue, white;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sol(0, 0, N);

        System.out.println(white);
        System.out.println(blue);

    }

    private static void sol(int x, int y, int size) {
        if (check(x, y, size)) {
            if (paper[x][y] == 1)
                blue++;
            else
                white++;
            return;
        }

        int halfSize = size / 2;

        sol(x, y, halfSize);
        sol(x, y + halfSize, halfSize);
        sol(x + halfSize, y, halfSize);
        sol(x + halfSize, y + halfSize, halfSize);

    }

    private static boolean check(int x, int y, int size) {
        int val = paper[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (val != paper[i][j])
                    return false;
            }
        }

        return true;
    }
}
