package day0318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15829_Hashing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());

        long sum = 0;
        long pow = 1;

        String input = br.readLine();

        for (int i = 0; i < L; i++) {
            sum += (input.charAt(i) - 96) * pow;
            pow = (pow * 31) % 1234567891;
        }

        System.out.println(sum % 1234567891);
    }
}
