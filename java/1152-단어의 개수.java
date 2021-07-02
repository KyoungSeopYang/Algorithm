/*
 * 백준 1152 단어의 개수
 * 영어 대소문자와 띄어쓰기만으로 이루어진 문자열을 입력받았을때 몇개의 단어가있는지 출력
 * 중복단어도 등장한 횟수만큼 카운트, 문자열 앞뒤로 공백이 있을 수 있다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args)throws IOException {
			BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
			
			String input= bf.readLine();
			
			//StringTokenizer로는 배열 크기를 구하기 어렵다. 그래서 split()사용
			String[] str=input.split(" ");
			int count=0;
			
			//앞뒤에 공백문자가 있을수 있기때문에 추가된 for문
			for(int i=0; i<str.length;i++)
			{
				if(str[i]!="")
				{
					count++;
				}
			}
			
			System.out.println(count);		
	}
}
