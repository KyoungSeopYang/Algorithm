package day0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_3048_개미 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N1 = Integer.parseInt(st.nextToken());
        int N2 = Integer.parseInt(st.nextToken());

        List<Ant> list = new ArrayList<>();

        char[] input1 = br.readLine().toCharArray();
        char[] input2 = br.readLine().toCharArray();

        for (int i = N1 - 1; i >= 0; i--) {
            list.add(new Ant(input1[i], 1));
        }

        for (int i = 0; i < N2; i++) {
            list.add(new Ant(input2[i], 2));
        }

        int T = Integer.parseInt(br.readLine());
        int size = list.size();

        while (T-- > 0) {
            for (int i = 0; i < size - 1; i++) {
                Ant cur = list.get(i);
                Ant next = list.get(i + 1);
                if (cur.team != 2 && cur.team != next.team) {
                    list.set(i, next);
                    list.set(i + 1, cur);
                    i++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            sb.append(list.get(i).name);
        }

        System.out.println(sb);
    }

    public static class Ant {
        char name;
        int team;

        public Ant(char name, int team) {
            this.name = name;
            this.team = team;
        }
    }
}
