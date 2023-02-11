package day0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1158_요세푸스_문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        sb.append('<');
        int idx = 0;

        for (int i = 0; i < N; i++) {
            idx += K - 1;
            idx %= list.size();
            sb.append(list.remove(idx) + ", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(">");
        System.out.println(sb);

    }
}
