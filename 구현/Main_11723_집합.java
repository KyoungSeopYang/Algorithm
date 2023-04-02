package day0402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11723_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] check = new boolean[21];
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            String order = st.nextToken();
            int num = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;

            if (order.equals("add"))
                check[num] = true;
            else if (order.equals("remove"))
                check[num] = false;
            else if (order.equals("check"))
                sb.append(check[num] ? 1 : 0).append("\n");
            else if (order.equals("toggle"))
                check[num] = !check[num];
            else if (order.equals("all"))
                Arrays.fill(check, true);
            else if (order.equals("empty"))
                Arrays.fill(check, false);

        }

        System.out.println(sb);


    }
}
