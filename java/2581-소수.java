/*
 * ���� 2581 �Ҽ�
 * �ڿ��� M�̻� N������ �ڿ��� �� �Ҽ��� ��� ��� �հ� �ּڰ��� ã�� ���α׷�
 * �� M<=N
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
		
		//�Ҽ� ���ϴ� 3��������
		boolean[] arr=new boolean[n+1];
		arr[0]=true;
		arr[1]=true;
	
		for(int i=2;i<=Math.sqrt(n);i++)
		{
			//i�� ������� ��� �Ҽ����ƴϴ�
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
