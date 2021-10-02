import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		String[][] arr=new String[N][2];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			arr[i][0]=st.nextToken();
			arr[i][1]=st.nextToken();
		}
		
		Arrays.sort(arr,(e1,e2) -> {  
			return Integer.parseInt(e1[0])-Integer.parseInt(e2[0]);
		});
		
		StringBuilder sb= new StringBuilder();
		
		for(int i=0;i<N;i++) {
			sb.append(arr[i][0]+" "+arr[i][1]).append("\n");
		}
		System.out.print(sb);
	}
}