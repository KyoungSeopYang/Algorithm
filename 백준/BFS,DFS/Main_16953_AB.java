package day0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16953_AB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int ans = -1;

        Queue<Num> que = new LinkedList<>();
        que.add(new Num(A, 1));

        while (!que.isEmpty()) {
            Num cur = que.poll();

            if (cur.num > B) continue;

            if (cur.num == B) {
                ans = cur.cnt;
                break;
            }

            que.add(Num.calc1(cur));
            que.add(Num.calc2(cur));
        }

        System.out.println(ans);
    }

    public static class Num {
        long num;
        int cnt;

        public Num(long num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        public static Num calc1(Num cur) {
            return new Num(cur.num * 2, cur.cnt + 1);
        }

        public static Num calc2(Num cur) {
            return new Num(cur.num * 10 + 1, cur.cnt + 1);
        }
    }
}
