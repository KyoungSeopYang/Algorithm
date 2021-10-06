import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		
		while((str = br.readLine())!=null) {
			StringBuilder sb=new StringBuilder();
			int[] count=new int[4];
			for(int i=0;i<str.length();i++) {
				
				if(str.charAt(i)>='a' && str.charAt(i)<='z') count[0]++;
				else if(str.charAt(i)>='A' && str.charAt(i)<='Z') count[1]++;
				else if(str.charAt(i)>='0' && str.charAt(i)<='9') count[2]++;
				else if(str.charAt(i)==' ') count[3]++;
			}
			
			for(int i : count) {
				sb.append(i).append(' ');
			}
			System.out.println(sb);
		}
		
	}
}    