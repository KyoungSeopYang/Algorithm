package day0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1063_킹 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] king = st.nextToken().toCharArray();
        char[] stone = st.nextToken().toCharArray();
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            char[] next_king = move(input, king);
            if (isRange(next_king)) {
                if (next_king[0] == stone[0] && next_king[1] == stone[1]) {
                    char[] next_stone = move(input, stone);

                    if (isRange(next_stone)) {
                        king = next_king;
                        stone = next_stone;
                    } else continue;
                } else {
                    king = next_king;
                }
            } else continue;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(king[0]).append(king[1]).append("\n");
        sb.append(stone[0]).append(stone[1]).append("\n");
        System.out.println(sb);

    }

    static Boolean isRange(char[] a) {
        if (a[0] < 'A' || a[0] > 'H' || a[1] < '1' || a[1] > '8') return false;
        else return true;
    }

    static char[] move(String input, char[] king) {
        char[] result = king.clone();

        switch (input) {
            case "R":
                result[0]++;
                break;
            case "L":
                result[0]--;
                break;
            case "B":
                result[1]--;
                break;
            case "T":
                result[1]++;
                break;
            case "RT":
                result[0]++;
                result[1]++;
                break;
            case "LT":
                result[0]--;
                result[1]++;
                break;
            case "RB":
                result[0]++;
                result[1]--;
                break;
            case "LB":
                result[0]--;
                result[1]--;
        }
        return result;
    }
}
