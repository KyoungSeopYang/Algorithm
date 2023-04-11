package day0411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수학
public class Main_6064_카잉달력 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int lcm = M * N / gcd(M, N);

            int year = x;
            while (true) {
                // 해가 최소공배수보다 크면 -1 출력
                if (year > lcm) {
                    System.out.println(-1);
                    break;
                }
                // year를 N으로 나머지 연산을 하면, y의 값을 알 수 있다.
                else if (((year % N) == 0 ? N : year % N) == y) {
                    System.out.println(year);
                    break;
                }
                // year는 M만큼 증가하고,
                year += M;
            }
        }


    }

    static int gcd(int n1, int n2) {
        if (n2 == 0)
            return n1;
        return gcd(n2, n1 % n2);
    }
}
