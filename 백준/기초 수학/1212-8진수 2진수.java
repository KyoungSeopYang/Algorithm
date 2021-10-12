import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb=new StringBuilder();
		
		String[] binary= {"000","001","010","011","100","101","110","111"};
		
		String N=br.readLine();
		
		if(N.charAt(0)-'0'<2) 
			sb.append(binary[N.charAt(0)-'0'].substring(2));
		else if(N.charAt(0)-'0'<4)
			sb.append(binary[N.charAt(0)-'0'].substring(1));
		else
			sb.append(binary[N.charAt(0)-'0']);
		
		for(int i=1;i<N.length();i++) {
			sb.append(binary[N.charAt(i)-'0']);
		}
		
		System.out.print(sb);
	}	
}    