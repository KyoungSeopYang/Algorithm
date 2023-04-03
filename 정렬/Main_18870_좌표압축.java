package day0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_18870_좌표압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] origin = new int[N];
        HashMap<Integer, Integer> rankingMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        int[] clone = Arrays.copyOf(origin, N);

        Arrays.sort(clone);

        int rank = 0;
        for (int cur : clone) {
            if (!rankingMap.containsKey(cur)) {
                rankingMap.put(cur, rank);
                rank++;
            }
        }

        for (int key : origin) {
            int ranking = rankingMap.get(key);
            sb.append(ranking).append(" ");
        }

        System.out.println(sb);
    }
}
