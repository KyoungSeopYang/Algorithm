package day0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 조합
public class Main_9375_패션왕신해빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> hm = new HashMap<>();

            while (N-- > 0) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String kind = st.nextToken();

                hm.put(kind, hm.getOrDefault(kind, 0) + 1);
            }

            int result = 1;

            for (int val : hm.values()) {
                result *= (val + 1);
            }
            System.out.println(result - 1);
        }
    }
}
