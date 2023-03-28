package day0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {
    static int N, ans = Integer.MAX_VALUE;
    static int[][] list;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        list = new int[N][N];
        visit = new boolean[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0);

        System.out.println(ans);

    }


    private static void solve(int idx, int cnt) {
        if (idx == N)
            return;

        if (cnt == N / 2) {
            int start = 0;
            int link = 0;

            for (int i = 0; i < N; i++) { // 타겟 선수 뽑기
                for (int j = i + 1; j < N; j++) {
                    if (visit[i] && visit[j]) {
                        start += list[i][j];
                        start += list[j][i];
                    } else if (!visit[i] && !visit[j]) {
                        link += list[i][j];
                        link += list[j][i];
                    }
                }
            }
            ans = Math.min(ans, Math.abs(start - link));
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                solve(i, cnt + 1);
                visit[i] = false;
            }
        }
    }
}
