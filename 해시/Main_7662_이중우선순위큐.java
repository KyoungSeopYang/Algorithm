package day0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_7662_이중우선순위큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> tm = new TreeMap();

            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                String order = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (order.equals("I")) {
                    tm.put(num, tm.getOrDefault(num, 0) + 1);
                } else {
                    if (tm.isEmpty()) continue;

                    int key = num == 1 ? tm.lastKey() : tm.firstKey();
                    if (tm.put(key, tm.get(key) - 1) == 1)
                        tm.remove(key);
                }
            }
            sb.append(tm.isEmpty() ? "EMPTY" : tm.lastKey() + " " + tm.firstKey()).append("\n");
        }

        System.out.println(sb);
    }
}
