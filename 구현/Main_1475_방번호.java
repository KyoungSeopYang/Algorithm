package day0511;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1475_방번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        int[] ans = new int[10];

        for (int i = 0; i < N.length(); i++) {
            int tmp = N.charAt(i) - '0';

            ans[tmp]++;
        }

        int sum = ans[6] + ans[9];
        ans[6] = sum / 2;
        ans[9] = sum / 2 + sum % 2;

        int max = 0;

        for (int i = 0; i < 10; i++) {
            max = Math.max(max, ans[i]);
        }

        System.out.println(max);

    }
}
