package day0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1789_수들의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());

        long sum = 0L;
        int i = 0;

        while (true) {
            sum += ++i;

            if (sum > S) {
                System.out.println(i - 1);
                return;
            }
        }


    }
}
