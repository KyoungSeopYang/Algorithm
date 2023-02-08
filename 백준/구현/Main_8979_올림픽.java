package day0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_8979_올림픽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Nation[] list = new Nation[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int copper = Integer.parseInt(st.nextToken());

            list[i] = new Nation(num, gold, silver, copper);
        }

        Arrays.sort(list);
        int end_point = 0;
        list[0].rate = 1;

        for (int i = 1; i < N; i++) {
            if (list[i].number == K) {  // 국가의 번호가 k번이면 end_point를 찾고 마지막 정답 출력 할 때 사용
                end_point = i;
            }

            if (list[i].compareTo(list[i - 1]) == 0)
                list[i].rate = list[i - 1].rate;
            else //
                list[i].rate = i + 1;
        }

        System.out.println(list[end_point].rate);


    }

    public static class Nation implements Comparable<Nation> {
        int number;
        int gold;
        int silver;
        int copper;
        int rate;

        public Nation(int number, int gold, int silver, int copper) {
            this.number = number;
            this.gold = gold;
            this.silver = silver;
            this.copper = copper;
        }

        @Override
        public int compareTo(Nation o) {

            if (this.gold == o.gold) {
                if (this.silver == o.silver) {
                    return o.copper - this.copper;
                } else {
                    return o.silver - this.silver;
                }
            } else {
                return o.gold - this.gold;
            }


        }
    }
}
