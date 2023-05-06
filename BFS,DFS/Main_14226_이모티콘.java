package day0506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_14226_이모티콘 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int S = Integer.parseInt(br.readLine());
        boolean[][] visited = new boolean[2001][2001];

        Queue<Node> que = new LinkedList<>();

        que.offer(new Node(1, 1, 1));

        while (!que.isEmpty()) {
            Node cur = que.poll();

            if (cur.monitor == S) {
                System.out.println(cur.time);
                return;
            }


            if (cur.monitor > 0 && cur.monitor < 2000) {
                //복사하기
                if (!visited[cur.monitor][cur.monitor]) {
                    visited[cur.monitor][cur.monitor] = true;
                    que.offer(new Node(cur.monitor, cur.monitor, cur.time + 1));
                }

                //삭제하기
                if (!visited[cur.monitor - 1][cur.clipboard]) {
                    visited[cur.monitor - 1][cur.clipboard] = true;
                    que.offer(new Node(cur.clipboard, cur.monitor - 1, cur.time + 1));
                }
            }

            //붙여넣기
            if (cur.monitor > 0 && cur.monitor + cur.clipboard < 2000) {
                if (!visited[cur.monitor + cur.clipboard][cur.clipboard]) {
                    visited[cur.monitor + cur.clipboard][cur.clipboard] = true;
                    que.offer(new Node(cur.clipboard, cur.monitor + cur.clipboard, cur.time + 1));
                }
            }
        }


    }

    public static class Node {
        int clipboard;
        int monitor;
        int time;

        public Node(int clipboard, int monitor, int time) {
            this.clipboard = clipboard;
            this.monitor = monitor;
            this.time = time;
        }
    }
}
