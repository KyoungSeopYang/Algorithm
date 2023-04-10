package day0410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문자열
public class Main_5525_IOIOI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();

        int cnt = 0;
        int ans = 0;

        for (int i = 1; i < M - 1; i++) {
            if (str[i - 1] == 'I' && str[i] == 'O' && str[i + 1] == 'I') {
                cnt++;

                if (cnt == N) {
                    cnt--;
                    ans++;
                }
                i++;
            } else {
                cnt = 0;
            }

        }

        System.out.println(ans);
    }
}
