/*
 * M이상 N이하의 소수를 한 줄에 하나씩 오름차순으로 출력
 * 에라토스테네스의 체로 풀어보자
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int m=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		
		boolean[] prime=new boolean[n+1];
		
		prime[0]=true;
		prime[1]=true;
		
		for(int i=2;i<Math.sqrt(n);i++)
		{
			for(int j=i*i;j<prime.length;j+=i)
			{
				prime[j]=true;
			}
		}
		
		for(int i=m;i<=n;i++)
		{
			if(!prime[i])
				System.out.println(i);
		}
	}
}
