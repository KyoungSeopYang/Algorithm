/*
 * 백준 2908 상수
 * 같지않은 세자리 정수 A와 B를 입력받았을때 A와 B를 거꾸로읽어 더 큰 수를 출력
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
			BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
			String input= bf.readLine();
			StringTokenizer st= new StringTokenizer(input);	
			
			String a=st.nextToken();
			String b=st.nextToken();
						
			StringBuilder a1=new StringBuilder();
			StringBuilder b1=new StringBuilder();
			
			for(int i=2;i>=0;i--) {
				a1.append(a.charAt(i));
				b1.append(b.charAt(i));
			}
			
			if(Integer.parseInt(a1.toString())>Integer.parseInt(b1.toString()))
			{
				System.out.println(a1.toString());
			}
			else
			{
				System.out.println(b1.toString());
			}
			
	}
}
