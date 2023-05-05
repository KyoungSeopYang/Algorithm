package day0505;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13549_숨바꼭질3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;

        boolean[] visited = new boolean[100001];

        Queue<Node> que = new LinkedList<>();
        que.add(new Node(N, 0));


        while (!que.isEmpty()) {
            Node cur = que.poll();
            visited[cur.x] = true;

            if (cur.x == K) min = Math.min(min, cur.time);

            if (cur.x * 2 <= 100000 && !visited[cur.x * 2])
                que.offer(new Node(cur.x * 2, cur.time));
            if (cur.x + 1 <= 100000 && !visited[cur.x + 1])
                que.offer(new Node(cur.x + 1, cur.time + 1));
            if (cur.x - 1 >= 0 && !visited[cur.x - 1])
                que.offer(new Node(cur.x - 1, cur.time + 1));
        }

        System.out.println(min);
    }

    public static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
