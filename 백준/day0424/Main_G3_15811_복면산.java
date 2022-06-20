package com.ssafy.day0424;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//15404kb 540ms
public class Main_G3_15811_복면산 {

	static char[] str1, str2, ans; // 입력받은 문자열 3개를 저장할 char[]
	static List<Integer> list;	   // 입력받은 문자열에서 문자 중복을 제거하여 저장할 list
	static boolean[] isSelected = new boolean[10];	// 0~9의 숫자중에서 사용된 숫자를 체크할 배열
	static int[] numOfAlpha = new int[26];			// 각 문자에 할당된 숫자를 저장할 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		str1 = st.nextToken().toCharArray();
		str2 = st.nextToken().toCharArray();
		ans = st.nextToken().toCharArray();

		boolean alpha[] = new boolean[26];	// idx에 해당하는 문자가 입력됬는지 체크할 배열

		for (int i = 0; i < str1.length; i++) {
			alpha[str1[i] - 'A'] = true;
		}
		for (int i = 0; i < str2.length; i++) {
			alpha[str2[i] - 'A'] = true;
		}
		for (int i = 0; i < ans.length; i++) {
			alpha[ans[i] - 'A'] = true;
		}

		list = new ArrayList<>();

		for (int i = 0; i < 26; i++) {
			if (alpha[i])	// 해당 위치의 문자를 입력받았었다면
				list.add(i);	// 리스트에 해당 문자를 저장한다.
		}

		// 사용할 수 있는 숫자는 0~9까지니까 입력받은 문자가 10종류가 넘어가면 예외처리
		if (list.size() > 10) {	
			System.out.println("NO");
			System.exit(0);
		}
		// DFS로 순열을 생성한다.
		dfs(0);
		
		//dfs에서 종료되지 않았다면 연산이 불가능한 입력이다.
		System.out.println("NO");
	}

	private static void dfs(int cnt) {
		// 순열 생성이 완료됬다면 연산 가능한지 체크를 해본다.
		if (cnt == list.size()) {
			int op1 = getNum(str1);
			int op2 = getNum(str2);
			int answer = getNum(ans);

			if (op1 + op2 == answer) {	// 해당 연산이 가능하다면
				System.out.println("YES");
				System.exit(0);	// 프로그램 종료
			}
			return;
		}

		// 순열을 생성하는 코드
		for (int i = 0; i < 10; i++) {
			if (isSelected[i])	// 숫자 i가 사용된 적이 있는가?
				continue;

			isSelected[i] = true;
			numOfAlpha[list.get(cnt)] = i;	//list의 cnt번째 문자에 숫자 i를 할당한다.
			dfs(cnt + 1);	// 다음 문자로 넘어간다
			isSelected[i] = false;
		}

	}

	private static int getNum(char[] str) {
		int hap = 0;
		for (int i = 0; i < str.length; i++) {
			// hap에 10을 곱하고 i번째 문자에 할당된 숫자를 더한다.
			hap = hap * 10 + numOfAlpha[str[i] - 'A'];
		}

		return hap;
	}

}
