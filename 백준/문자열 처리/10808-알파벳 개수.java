import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		String str=br.readLine();
		StringBuilder sb=new StringBuilder();
		
		int[] count=new int[26];
		
		for(int i=0; i<str.length(); i++) {
			int idx=str.charAt(i)-97;
			count[idx]++;
		}
		
		for(int i=0; i<26;i++) {
			sb.append(count[i]).append(' ');
		}
		
		System.out.println(sb);
	}
}    