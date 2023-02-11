package day0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012_괄호 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {

            char[] arr = br.readLine().toCharArray();

            sb.append(solve(arr)).append("\n");

        }
        System.out.println(sb);
    }

    private static String solve(char[] arr) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];

            if (c == '(')
                stack.push(c);
            else if (stack.empty())
                return "NO";
            else
                stack.pop();

        }

        if (stack.empty())
            return "YES";

        else
            return "NO";

    }
}
