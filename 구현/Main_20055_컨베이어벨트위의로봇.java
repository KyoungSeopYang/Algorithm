package day0523;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20055_컨베이어벨트위의로봇 {
    static int N, K;
    static int startIdx, endIdx;
    static boolean[] conveyorBelt;
    static int[] durability;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        conveyorBelt = new boolean[2 * N];
        durability = new int[2 * N];

        startIdx = 0;
        endIdx = N - 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            durability[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve());


    }

    private static int solve() {
        int Time = 1;
        while (true) {
            // 1. 벨트 회전
            startIdx = startIdx == 0 ? 2 * N - 1 : startIdx - 1;
            endIdx = endIdx == 0 ? 2 * N - 1 : endIdx - 1;
            // 1-1. 내리는 위치에 로봇은 바로 내린다.
            conveyorBelt[endIdx] = false;
            // 2. 올라간 로봇부터 한칸 이동한다. -> 로봇이 이동하려면 이동하려는 칸에 로봇이 없으며, 내구도가 1 이상이여야 한
            move();
            // 2-1. 내리는 위치에 로봇은 바로 내린다.
            conveyorBelt[endIdx] = false;
            // 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 로봇을 올린다.
            if (durability[startIdx] > 0) {
                conveyorBelt[startIdx] = true;
                durability[startIdx]--;
            }

            // 4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다.
            if (isEnd()) break;

            Time++;
        }

        return Time;
    }

    private static boolean isEnd() {
        int cnt = 0;
        for (int i = 0; i < 2 * N; i++) {
            if (durability[i] == 0) cnt++;
        }

        if (cnt >= K) return true;
        return false;
    }

    private static void move() {

        for (int i = N - 1; i > 0; i--) {
            int cur = (startIdx + i) % (2 * N);
            int before = cur == 0 ? 2 * N - 1 : cur - 1;

            if (!conveyorBelt[cur] && durability[cur] > 0 && conveyorBelt[before]) {
                conveyorBelt[before] = false;
                conveyorBelt[cur] = true;
                durability[cur]--;
            }

        }
    }

}
