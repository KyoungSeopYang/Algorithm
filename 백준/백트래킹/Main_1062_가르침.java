package day0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1062_가르침 {

    static boolean[] visited;
    static String[] words;
    static int N, K, max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5) {
            System.out.println(0);
            return;
        }
        if (K == 26) {
            System.out.println(N);
            return;
        }

        words = new String[N];

        visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        solve(0, 0);
        System.out.println(max);
    }

    private static void solve(int word, int depth) {
        if (depth == K - 5) {
            int count = 0;

            for (int i = 0; i < N; i++) {
                boolean read = true;
                for (int j = 0; j < words[i].length(); j++) {
                    if (!visited[words[i].charAt(j) - 'a']) {
                        read = false;
                        break;
                    }
                }
                if (read) count++;
            }

            max = Math.max(max, count);
            return;
        }

        for (int i = word; i < 26; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                solve(i, depth + 1);
                visited[i] = false;
            }
        }
    }
}
