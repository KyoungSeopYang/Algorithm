package day0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888_연산자_끼워넣기 {

    static int N, MIN = Integer.MAX_VALUE, MAX = Integer.MIN_VALUE;
    static int[] num, operator;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new int[N];
        operator = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        solve(1, num[0]);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void solve(int depth, int sum) {
        if (depth == N) {
            MIN = Math.min(MIN, sum);
            MAX = Math.max(MAX, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] != 0) {
                operator[i]--;
                solve(depth + 1, calc(sum, num[depth], i));
                operator[i]++;
            }
        }

    }

    private static int calc(int sum, int val, int oper) {
        switch (oper) {
            case 0:
                return sum + val;
            case 1:
                return sum - val;
            case 2:
                return sum * val;
            case 3:
                return sum / val;
        }

        return 0;
    }
}
