package day0311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2920_음계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[8];

        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 7; i++) {
            if (Math.abs(arr[i] - arr[i + 1]) > 1) {
                System.out.println("mixed");
                return;
            }
        }

        if (arr[0] == 1)
            System.out.println("ascending");
        else
            System.out.println("descending");
    }
}
