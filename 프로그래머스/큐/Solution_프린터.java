package day0212;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_프린터 {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 2};
        System.out.println(solution(arr, 2));
    }

    public static int solution(int[] priorities, int location) {
        Queue<Integer> que = new LinkedList<>();
        int answer = 0;
        int l = location;

        for (int i : priorities) {
            que.offer(i);
        }

        Arrays.sort(priorities);
        int size = priorities.length - 1;

        while (!que.isEmpty()) {
            int i = que.poll();

            if (i == priorities[size - answer]) {
                answer++;
                l--;
                if (l < 0)
                    break;
            } else {
                que.add(i);
                l--;
                if (l < 0)
                    l = que.size() - 1;
            }
        }
        return answer;
    }

//    public static int solution(int[] priorities, int location) {
//        int answer = -1;
//        Queue<Integer> printer = new LinkedList<>();
//        LinkedList<Integer> list = new LinkedList<>();
//
//        for (int i = 0; i < priorities.length; i++) {
//            list.add(i);
//        }
//
//        while (true) {
//            int cur = list.remove(0);
//            boolean flag = false;
//
//            for (int i = 0; i < list.size(); i++) {
//                if (priorities[list.get(i)] > priorities[cur]) {
//                    flag = true;
//                    break;
//                }
//            }
//
//            if (!flag) {
//                if (cur == location) {
//                    answer = printer.size() + 1;
//                    break;
//                }
//                printer.add(cur);
//            } else {
//                list.add(cur);
//            }
//        }
//        return answer;
//    }
}
