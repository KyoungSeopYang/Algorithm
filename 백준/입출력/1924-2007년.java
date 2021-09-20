import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int[] day= {31,28,31,30,31,30,31,31,30,31,30,31};
		String[] week= {"SUN","MON","TUE","WED","THU","FRI","SAT"};
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int m=Integer.parseInt(st.nextToken());
		int d=Integer.parseInt(st.nextToken());
		int hap=0;
		
		if(m==1) {
			hap+=d;
		} 
		else {
			m-=2;
			for(int i=0;i<=m;i++) {
				hap+=day[i];
			}
			hap+=d;	
		}
		System.out.println(week[hap%7]);
	}
}