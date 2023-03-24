package day0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_1620_나는야포켓몬마스터이다솜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> pokemon_int = new HashMap<>();
        HashMap<String, Integer> pokemon_str = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String pokemon = br.readLine();
            pokemon_int.put(i, pokemon);
            pokemon_str.put(pokemon, i);
        }

        for (int i = 0; i < M; i++) {
            String quiz = br.readLine();
            if (isNum(quiz)) {
                sb.append(pokemon_int.get(Integer.parseInt(quiz))).append("\n");
            } else {
                sb.append(pokemon_str.get(quiz)).append("\n");
            }
        }

        System.out.println(sb);

    }


    private static boolean isNum(String quiz) {
        try {
            Integer.parseInt(quiz);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
