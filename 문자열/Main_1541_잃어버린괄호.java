package day0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1541_잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = Integer.MAX_VALUE;    // 초기 상태 여부 확인을 위한 값으로 설정
        StringTokenizer subtraction = new StringTokenizer(br.readLine(), "-");

        while (subtraction.hasMoreTokens()) {
            int tmp = 0;

            StringTokenizer addition = new StringTokenizer(subtraction.nextToken(), "+");

            while (addition.hasMoreTokens()) {
                tmp += Integer.parseInt(addition.nextToken());
            }

            if (sum == Integer.MAX_VALUE) sum = tmp;
            else sum -= tmp;
        }

        System.out.println(sum);
    }
}
