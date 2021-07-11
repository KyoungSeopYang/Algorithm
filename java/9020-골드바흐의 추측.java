/*
 * 백준 9020 골드바흐의 추측
 * 2보다 큰 짝수 n이 주어졌을때 n= a+b (단 a,b는 소수) 를 골드바흐 파티션이라고 한다.
 * 이때 n의 골드바흐 파티션을 출력하는 프로그램
 * 만약 가능한 골드파흐 파티션이 여러가지인 경우에는 두 소수의 차이가 가장 작은것을 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	//N의 최대값 10000까지의 소수를 구해보자
	static int max=10001;
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] prime = new boolean[max];
		
		prime[0]=prime[1]=true;
		
		for(int i=2;i<=Math.sqrt(max);i++)
		{
			if(prime[i])
				continue;
			for(int j=i*i;j<prime.length;j+=i)
			{
				prime[j]=true;
			}
		}
		// 테스트 케이스
		int t=Integer.parseInt(br.readLine());
		
		//짝수 n을 절반씩 나누어서 a는 1감소 b는 1증가시켜서 a와b가 소수일때 까지 반복한다.
		while(t-->0)
		{
			int n=Integer.parseInt(br.readLine());
			int a= n/2;
			int b= n/2;
			
			while (true) {
				// 두 파티션이 모두 소수면 break;
				if(!prime[a] && !prime[b]) {
					System.out.println(a + " " + b);
					break;
				}
				a--;
				b++;
			}
		}
	}
}