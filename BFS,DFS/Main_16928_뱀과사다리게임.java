package day0417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BFS
public class Main_16928_뱀과사다리게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] count = new int[101];
        boolean[] visited = new boolean[101];

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> labberAndSnake = new HashMap<>();

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            labberAndSnake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }


        Queue<Integer> que = new LinkedList<>();
        visited[1] = true;
        que.add(1);

        while (!que.isEmpty()) {
            int cur = que.poll();

            if (cur == 100) {
                System.out.println(count[cur]);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int x = cur + i;
                if (100 < x) continue;
                if (visited[x]) continue;
                visited[x] = true;

                if (labberAndSnake.containsKey(x)) {
                    if (!visited[labberAndSnake.get(x)]) {
                        que.add(labberAndSnake.get(x));
                        visited[labberAndSnake.get(x)] = true;
                        count[labberAndSnake.get(x)] = count[cur] + 1;
                    }
                } else {
                    que.add(x);
                    count[x] = count[cur] + 1;
                }
            }
        }
    }
}
