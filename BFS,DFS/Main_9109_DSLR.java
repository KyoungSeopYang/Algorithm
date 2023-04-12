package day0412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BFS
public class Main_9109_DSLR {
    static final int MAX = 10000;
    static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean[] visit = new boolean[MAX];
            String[] command = new String[MAX];

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            Queue<Integer> que = new LinkedList<>();
            que.add(a);
            visit[a] = true;
//            Arrays.fill(command, "");
            command[a] = "";

            while (!que.isEmpty() && !visit[b]) {
                int cur = que.poll();

                int D = (2 * cur) % 10000;
                int S = cur == 0 ? 9999 : cur - 1;
                int L = (cur % 1000) * 10 + (cur / 1000);
                int R = (cur % 10) * 1000 + (cur / 10);

                if (!visit[D]) {
                    visit[D] = true;
                    que.add(D);
                    command[D] = command[cur] + "D";
                }
                if (!visit[S]) {
                    visit[S] = true;
                    que.add(S);
                    command[S] = command[cur] + "S";
                }
                if (!visit[L]) {
                    visit[L] = true;
                    que.add(L);
                    command[L] = command[cur] + "L";
                }
                if (!visit[R]) {
                    visit[R] = true;
                    que.add(R);
                    command[R] = command[cur] + "R";
                }
            }

            System.out.println(command[b]);

        }
    }


}
