package day0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B3_2490 {

    /*
        author : yangksks
        2490번 : 윷놀이
        https://www.acmicpc.net/problem/2490
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = 0;

            for (int j = 0; j < 4; j++) {
                if (Integer.parseInt(st.nextToken()) == 0)
                    cnt++;
            }

            switch (cnt) {
                case 0:
                    sb.append("E\n");
                    break;
                case 1:
                    sb.append("A\n");
                    break;
                case 2:
                    sb.append("B\n");
                    break;
                case 3:
                    sb.append("C\n");
                    break;
                case 4:
                    sb.append("D\n");
                    break;
            }
        }
        System.out.println(sb);

    }
}
