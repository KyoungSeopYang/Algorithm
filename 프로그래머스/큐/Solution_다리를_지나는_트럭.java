package day0212;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_다리를_지나는_트럭 {
    public static void main(String[] args) {
        int[] arr = {7, 4, 5, 6};
        System.out.println(solution(2, 10, arr));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();

        int sum = 0;
        int time = 0;

        for (int i = 0; i < truck_weights.length; i++) {

            int truck = truck_weights[i];

            while (true) {
                if (bridge.isEmpty()) {
                    bridge.offer(truck);
                    sum += truck;
                    time++;
                    break;
                } else if (bridge.size() == bridge_length) {
                    sum -= bridge.poll();
                } else {
                    if (sum + truck > weight) {
                        bridge.offer(0);
                        time++;
                    } else {
                        bridge.offer(truck);
                        sum += truck;
                        time++;
                        break;
                    }

                }
            }
        }


        return time + bridge_length;
    }
}
