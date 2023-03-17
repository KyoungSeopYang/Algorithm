package day0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10773_제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> st = new Stack<>();
        int sum = 0;

        int K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            int tmp = Integer.parseInt(br.readLine());

            if (tmp == 0)
                sum -= st.pop();
            else {
                sum += tmp;
                st.push(tmp);
            }

        }
        System.out.println(sum);

    }
}
