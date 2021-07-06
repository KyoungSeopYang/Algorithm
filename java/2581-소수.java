/*
 * 백준 2581 소수
 * 자연수 M이상 N이하의 자연수 중 소수를 모두 골라 합과 최솟값을 찾는 프로그램
 * 단 M<=N
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int m=Integer.parseInt(br.readLine());
		int n=Integer.parseInt(br.readLine());
		int sum=0,min=-1;
		
		//소수 구하는 3번방법사용
		boolean[] arr=new boolean[n+1];
		arr[0]=true;
		arr[1]=true;
	
		for(int i=2;i<=Math.sqrt(n);i++)
		{
			//i의 배수들은 모두 소수가아니다
			for(int j=i*i;j<arr.length;j+=i)
			{
				arr[j]=true;
			}
		}
		
		
		for(int i=m;i<=n;i++)
		{
			if(arr[i]==false) {
				sum+=i;
				if(min==-1) {
					min=i;
				}
					
			}
		}
		if(sum ==0) {
			System.out.println(-1);
		}else {
			System.out.println(sum);
			System.out.println(min);
		}
		
	}
}
