package day0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1700_멀티탭스케줄링 {

    private static int N, K, ans;
    private static int[] arr;
    private static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        used = new boolean[K + 1];
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int idx = 0, cnt = 0;

        while (true) {
            if (cnt == N) break;
            if (!used[arr[idx]]) {
                used[arr[idx]] = true;
                cnt++;
            }
            idx++;
        }

        while (idx < K) {
            // 지금 사용할 전기용품의 콘센트가 꽃혀있지 않은 경우
            if (!used[arr[idx]]) {
                List<Integer> list = new ArrayList<>();

                for (int i = idx; i < K; i++) {
                    // 이후에 사용될 전기용품 중에 현재 꽃혀있는 전기용품을 List에 담는다
                    if (used[arr[i]] && !list.contains(arr[i])) {
                        list.add(arr[i]);
                    }
                }

                //List의 사이즈가 N이면 지금 멀티탭에 꽃혀있는 콘센트 모두가 다음에
                // 또 사용되기 때문에 가장 마지막 콘센트를 뽑는다
                if (list.size() == N) {
                    int remove = list.get(list.size() - 1);
                    used[remove] = false;
                } else {
                    for (int j = 1; j <= K; j++) {
                        // 현재 꽃혀있는 콘센트 중에 다음에 쓰이지 않는 콘센트는 뺀다
                        if (used[j] && !list.contains(j)) {
                            used[j] = false;
                            break;
                        }
                    }
                }

                used[arr[idx]] = true;
                ans++;
            }
            idx++;
        }

        System.out.println(ans);
    }
}
