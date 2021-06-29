/*
 * 백준 2675 문자열 반복
 * 문자열 S를 입력받은 후에 각 문자를 R번 반복해 새 문자열 P를 만들어 출력하는 프로그램
 */
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		//테스트 케이스 수 입력
		int n= Integer.parseInt(bf.readLine());
		
		//테스트 케이스 만큼 반복
		for(int a=0;a<n;a++)
		{
		  String input = bf.readLine();
			
			StringTokenizer st = new StringTokenizer(input);
			
			int t= Integer.parseInt(st.nextToken());
			String str=st.nextToken();
			
			//문자열을 더할땐 StringBuilder 클래스가 유리하다
			StringBuilder sb= new StringBuilder();
			
			for(int i=0;i<str.length();i++) {
				for(int j=0;j<t;j++) {
					sb.append(str.charAt(i));
				}		
			}
			
			System.out.println(sb.toString());
		}
	
	}
}
