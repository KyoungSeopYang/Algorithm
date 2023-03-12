package day0312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1259_팰린드롬수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String tmp = br.readLine();
            if (tmp.equals("0")) break;

            int size = tmp.length();

            boolean flag = true;

            for (int i = 0; i < size / 2; i++) {
                if (tmp.charAt(i) != tmp.charAt(size - i - 1)) {
                    flag = false;
                    break;
                }
            }
            sb.append(flag ? "yes" : "no").append("\n");
        }

        System.out.println(sb);
    }
}
