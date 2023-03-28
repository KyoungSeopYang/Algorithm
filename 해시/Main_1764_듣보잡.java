package day0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1764_듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        List<String> output = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (set.contains(input)) {
                output.add(input);
            }
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(output);

        sb.append(output.size()).append("\n");

        for (int i = 0; i < output.size(); i++) {
            sb.append(output.get(i)).append("\n");
        }

        System.out.println(sb);

    }
}
