import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		String str=br.readLine();
		
		for(int i=0;i<str.length();i++) {
			
			char ch=str.charAt(i);
			
			if(ch>='a' && ch<='z') {
				ch +=13;
				if(ch>'z') {
					int tmp = ch-'z';
					ch='a'-1;
					ch+=tmp;
				}
			}
			
			else if(ch>='A' && ch<='Z') {
				ch +=13;
				if(ch>'Z') {
					int tmp = ch-'Z';
					ch='A'-1;
					ch+=tmp;
				}
			}
			
			sb.append(ch);
			
		}
		
		System.out.println(sb);
	}
	
}    