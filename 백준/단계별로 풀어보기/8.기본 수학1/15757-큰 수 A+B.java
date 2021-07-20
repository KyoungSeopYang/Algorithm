/*
 * 백준 10757 큰 수 A+B
 * 두 정수 A + B를 구하시오
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		//long 형의 크기를 넘어서는 입력
		String str_a=st.nextToken();
		String str_b=st.nextToken();
		
		//Math.max함수로 더 큰 length를 저장한다.
		int max_length=Math.max(str_a.length(),str_b.length());
		
		//정수 a b를 int형 배열로 표현하고
		int[] a=new int[max_length+1];
		int[] b=new int[max_length+1];
		
		//1의자리 수 부터 하나씩 초기화한다.
		for(int i= str_a.length()-1,idx=0;i>=0;i--,idx++)
		{
			a[idx]=str_a.charAt(i)-'0';
		}
		
		for(int i= str_b.length()-1,idx=0;i>=0;i--,idx++)
		{
			b[idx]=str_b.charAt(i)-'0';
		}
		
		//같은 자리수의 값을 더하고 합이 10이 넘으면 다음 자리수에 올림한다.
		for(int i=0;i<max_length;i++)
		{
			int value=a[i]+b[i];
			a[i]=value%10;
			
			if(value>9)
				a[i+1]++;
		}
		//하나씩 print하는것보다 StringBuilder에 저장후 한번만 print하는 것이 더 빠르다.
		StringBuilder sb = new StringBuilder();
		if(a[max_length] !=0)
		{
			sb.append(a[max_length]);
		}
		
		for(int i=max_length-1;i>=0;i--)
		{
			sb.append(a[i]);
		}
		
		System.out.println(sb);
	}
}
