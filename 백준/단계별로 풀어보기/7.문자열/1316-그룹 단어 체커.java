/*
 * 백준 1316 그룹 단어 체커
 * 단어에 존재하는 모든 문자가 각각 연속해서 나오는 경우의 단어= 그룹단어 ex) happy, abc
 * N개를 입력받아 그룹 단어의 개수를 출력하시오
 */
import java.io.IOException;
import java.util.Scanner;

public class Main {

	static boolean check(String str) {
		//사용 된 알파벳 확인용 변수
		boolean[] check = new boolean[26];
		
		// 마지막으로 나온 알파벳의 인덱스값
		int prev =0;
		
		for(int i=0;i<str.length();i++)
		{
			//해당 알파벳이 나온적이 있는가?
			if(check[str.charAt(i)-97])
			{
				//직전에 나왔던 알파벳과 현재 알파벳이 같은가?
				if(prev!=str.charAt(i)-97)
				{
					return false;
				} 
			}
			else //해당 알파벳이 나온적이 없다면
			{
				check[str.charAt(i)-97]=true;
				// 마지막 으로 나온 알파벳의 인덱스 값 저장
				prev=str.charAt(i)-97;
			}	
		}
		
		//여기 까지 왓으면 그룹단어이다.
		return true;
	}
	
	public static void main(String[] args)throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n=Integer.parseInt(sc.nextLine());
		int count=0;
		
		for(int i=0;i<n;i++)
		{
			
			if(check(sc.nextLine()))
			{
				count++;
			}
			
		}
		
		System.out.print(count);
	}
}
