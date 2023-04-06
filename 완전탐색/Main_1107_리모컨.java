package day0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_1107_리모컨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());


        HashSet<Integer> broken = new HashSet<>();

        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken.add(Integer.parseInt(st.nextToken()));
            }
        }

        int result = Math.abs(N - 100);
        for (int i = 0; i <= 999999; i++) {
            String tmp = String.valueOf(i);
            int len = tmp.length();

            boolean isBroken = false;
            for (int j = 0; j < len; j++) {
                if (broken.contains(tmp.charAt(j) - '0')) {
                    isBroken = true;
                    break;
                }
            }
            if (!isBroken) {
                int min = Math.abs(N - i) + len;
                result = Math.min(result, min);
            }
        }

        System.out.println(result);
    }
}
