import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		String str=br.readLine();
		StringBuilder sb=new StringBuilder();
		
		int[] arr=new int[26];
		
		Arrays.fill(arr, -1);
		
		for(int i=0; i<str.length(); i++) {
			int idx=str.charAt(i)-97;
			
			if(arr[idx]==-1) arr[idx]=i;
		}
		
		for(int i=0; i<26;i++) {
			sb.append(arr[i]).append(' ');
		}
		
		System.out.println(sb);
	}
}    