package day0307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3568_iSharp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String origin = br.readLine().replace(",", "").replace(";", "");

        String[] input = origin.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int idx = 1; idx < input.length; idx++) {
            String temp = input[idx];
            String valName = "";
            StringBuilder type = new StringBuilder();


            for (int i = temp.length() - 1; i >= 0; i--) {
                char cur = temp.charAt(i);

                if (cur == '*' || cur == '&') {
                    type.append(cur);
                } else if (cur == ']') {
                    type.append("[]");
                    i--;
                } else { // 변수명을 만나면
                    valName = temp.substring(0, i + 1);
                    break;
                }
            }

            sb.append(input[0] + type + " " + valName + ";\n");
        }
        System.out.println(sb);

    }
}
