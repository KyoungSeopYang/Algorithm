package day0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_4949_균형잡힌세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        loop:
        while (true) {
            String line = br.readLine();
            int size = line.length() - 1;

            if (line.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < size; i++) {
                char cur = line.charAt(i);

                if (cur == '(' || cur == '[') {
                    stack.push(cur);
                } else if ((cur == ')' && (stack.isEmpty() || stack.peek() != '('))
                        || (cur == ']' && (stack.isEmpty() || stack.peek() != '['))) {
                    sb.append("no\n");
                    continue loop;
                } else if (cur == ')' || cur == ']')
                    stack.pop();
            }

            if (stack.isEmpty())
                sb.append("yes\n");
            else
                sb.append("no\n");
        }

        System.out.println(sb);
    }
}
