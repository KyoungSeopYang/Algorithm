package day0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B1_10798 {
    /*
        author : yangksks
        10798번 : 세로읽기
        https://www.acmicpc.net/problem/10798
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char list[][] = new char[5][15];

        int max = 0;
        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            int size = input.length();
            max = Math.max(size, max);

            for (int j = 0; j < size; j++) {
                list[i][j] = input.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                if (list[j][i] != 0)
                    sb.append(list[j][i]);
            }
        }
        System.out.println(sb);
    }
}
