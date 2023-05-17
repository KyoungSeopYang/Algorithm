package day0517;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15685_드래곤커브 {

    static boolean[][] map = new boolean[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        for (int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            List<Integer> directions = new ArrayList<>();
            // 방향 구하기
            directions.add(d);

            while (g-- > 0) {
                for (int i = directions.size() - 1; i >= 0; i--) {
                    int direction = (directions.get(i) + 1) % 4;
                    directions.add(direction);
                }
            }
            // 꼭짓점 찍기
            draw(x, y, directions);
        }

        int count = 0;
        // 정사각형 구하기
        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {
                if (map[x][y] && map[x + 1][y] && map[x][y + 1] && map[x + 1][y + 1])
                    count++;
            }
        }

        System.out.println(count);
    }

    private static void draw(int x, int y, List<Integer> directions) {
        map[x][y] = true;

        for (int direction : directions) {
            if (direction == 0)
                map[++x][y] = true;
            else if (direction == 1)
                map[x][--y] = true;
            else if (direction == 2)
                map[--x][y] = true;
            else if (direction == 3)
                map[x][++y] = true;
        }
    }
}
