package PCCP모의고사;

public class Solution_1_외톨이_알파벳 {
    /*
        author : yangksks
        [PCCP 모의고사 #1] 외톨이 알파벳
     */
    public String solution(String input_string) {
        StringBuilder answer = new StringBuilder();
        int size = input_string.length();

        int[] word = new int[26];
        boolean[] alone = new boolean[26];

        int before = input_string.charAt(0) - 97;
        word[before]++;

        for (int i = 1; i < size; i++) {
            int num = input_string.charAt(i) - 97;

            if (before != num && word[num] != 0) {
                alone[num] = true;
            } else {
                word[num]++;
            }

            before = num;
        }

        for (int i = 0; i < 26; i++) {
            if (alone[i]) {
                char c = (char) (97 + i);
                answer.append(c);
            }
        }

        if (answer.length() == 0)
            answer = new StringBuilder("N");

        return answer.toString();
    }
}
