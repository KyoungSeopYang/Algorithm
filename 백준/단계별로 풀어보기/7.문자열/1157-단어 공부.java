/*
 * 백준 1157 단어공부
 * 대소문자로 주어진 단어에서 가장 많이 사용된 알파벳을 대문자로 출력
 * 단 대소문자 구분은 하지않는다.
 * 
 * 각 알파벳에 대응하는 배열생성하고, 해당 알파벳이 나올때마다 배열값을 ++
 */
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		String input=bf.readLine(); 
		
		//영문자 개수는 26개
		int [] arr = new int[26];
				
		for(int i=0;i<input.length();i++) {
			
			//대문자는 65부터 90
			if(65<=input.charAt(i) && input.charAt(i)<=90) {
				arr[input.charAt(i)-65]++;
			}
			else
			{
				//소문자는 97~122
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
