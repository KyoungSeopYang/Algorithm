/*
 * ���� 10757 ū �� A+B
 * �� ���� A + B�� ���Ͻÿ�
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		//long ���� ũ�⸦ �Ѿ�� �Է�
		String str_a=st.nextToken();
		String str_b=st.nextToken();
		
		//Math.max�Լ��� �� ū length�� �����Ѵ�.
		int max_length=Math.max(str_a.length(),str_b.length());
		
		//���� a b�� int�� �迭�� ǥ���ϰ�
		int[] a=new int[max_length+1];
		int[] b=new int[max_length+1];
		
		//1���ڸ� �� ���� �ϳ��� �ʱ�ȭ�Ѵ�.
		for(int i= str_a.length()-1,idx=0;i>=0;i--,idx++)
		{
			a[idx]=str_a.charAt(i)-'0';
		}
		
		for(int i= str_b.length()-1,idx=0;i>=0;i--,idx++)
		{
			b[idx]=str_b.charAt(i)-'0';
		}
		
		//���� �ڸ����� ���� ���ϰ� ���� 10�� ������ ���� �ڸ����� �ø��Ѵ�.
		for(int i=0;i<max_length;i++)
		{
			int value=a[i]+b[i];
			a[i]=value%10;
			
			if(value>9)
				a[i+1]++;
		}
		//�ϳ��� print�ϴ°ͺ��� StringBuilder�� ������ �ѹ��� print�ϴ� ���� �� ������.
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
