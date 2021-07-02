/*
 * ���� 1157 �ܾ����
 * ��ҹ��ڷ� �־��� �ܾ�� ���� ���� ���� ���ĺ��� �빮�ڷ� ���
 * �� ��ҹ��� ������ �����ʴ´�.
 * 
 * �� ���ĺ��� �����ϴ� �迭�����ϰ�, �ش� ���ĺ��� ���ö����� �迭���� ++
 */
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		String input=bf.readLine(); 
		
		//������ ������ 26��
		int [] arr = new int[26];
				
		for(int i=0;i<input.length();i++) {
			
			//�빮�ڴ� 65���� 90
			if(65<=input.charAt(i) && input.charAt(i)<=90) {
				arr[input.charAt(i)-65]++;
			}
			else
			{
				//�ҹ��ڴ� 97~122
				arr[input.charAt(i)-97]++;
			}
		}
		
		int max=0;
		char ch='?';
		
		for(int i=0;i<26;i++)
		{
			if(arr[i]>max)
			{
				max=arr[i];
				ch=(char)(i+65);
			}
			else if(arr[i]==max) {
				ch='?';
			}
			
		}
		
		System.out.println(ch);
			
	}
}
