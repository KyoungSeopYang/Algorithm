package day0315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1874_스택수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        int temp = 1;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            for (; temp <= num; temp++) {
                stack.push(temp);
                sb.append("+\n");
            }
            if (stack.peek() == num) {
                stack.pop();
                sb.append("-\n");
            } else {
                sb.setLength(0);
                sb.append("NO");
                break;
            }
        }

        System.out.println(sb);


    }
}
