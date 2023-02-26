package day0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_20006_랭킹전대기열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Player>> room = new ArrayList<>();

        roomSearch:
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            Player cur = new Player(Integer.parseInt(st.nextToken()), st.nextToken());

            for (int j = 0; j < room.size(); j++) { // 모든 방 순회
                Player host = room.get(j).get(0);
                // 레벨 제한에 걸리지 않고, 방이 꽉 차지않았으면
                if (host.lev - 10 <= cur.lev && host.lev + 10 >= cur.lev && room.get(j).size() < M) {
                    room.get(j).add(cur);
                    continue roomSearch; // 탐색 종료
                }
            }
            // 없으면 방 만들고
            room.add(new ArrayList<>());
            room.get(room.size() - 1).add(cur); // 플레이어 집어넣기
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < room.size(); i++) {
            if (room.get(i).size() == M)
                sb.append("Started!").append("\n");
            else
                sb.append("Waiting!").append("\n");

            Collections.sort(room.get(i));

            for (int j = 0; j < room.get(i).size(); j++) {
                sb.append(room.get(i).get(j)).append("\n");
            }
        }
        System.out.println(sb);
    }

    static class Player implements Comparable<Player> {
        int lev;
        String nickname;

        public Player(int lev, String nickname) {
            this.lev = lev;
            this.nickname = nickname;
        }

        @Override
        public String toString() {
            return this.lev + " " + this.nickname;
        }

        @Override
        public int compareTo(Player o) {
            return this.nickname.compareTo(o.nickname);
        }
    }
}
