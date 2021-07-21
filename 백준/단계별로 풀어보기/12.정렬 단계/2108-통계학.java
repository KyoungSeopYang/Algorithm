package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int n= Integer.parseInt(br.readLine());
		
		// 입력값의 범위 : -4000~4000
		int[] arr = new int[8001];
		
		int sum=0;					// 총합
		int max=Integer.MIN_VALUE;	// 최댓값
		int min=Integer.MAX_VALUE;	// 최솟값
		int median=10000;			// 중앙값
		int mode =10000;			// 최빈값
		
		for(int i=0;i<n;i++) {
			int value = Integer.parseInt(br.readLine());
			sum += value;
			// 음수가 입력될수 있기때문에 4000을 0으로 기준한다.
			arr[value+4000]++;
			
			if(max<value) max=value;
			if(min>value) min=value;
		}
		
		int count = 0;				// 중앙값까지 입력ㅑ9값 누적 수
		int mode_max=0;				// 최빈값의 빈도값
		
		// 이전의 동일한 최빈값이 1번만 등장했을경우 true, 아닐경우 false
		boolean flag=false;
		
		// 입력받은 최솟값부터 최댓값까지 탐색
		for(int i= min + 4000; i<= max + 4000;i++) {
			
			if(arr[i]>0) {
				/*
				 * 중앙값 찾기
				 * 누적횟수가 전체 길이의 절반에 못 미친다면.
				 */
				if(count<(n+1)/2) {
					// 중복값이 있을수 있어서
					count +=arr[i];
					median = i -4000;
				}
			}
			
			/*
			 * 최빈값 찾기
			 * 이전 최빈값보다 현재 값의 빈도수가 더 높을 경우
			 */
			
			if(mode_max<arr[i]) {
				mode_max=arr[i];
				mode=i-4000;
				flag=true;
			}
			else if (mode_max==arr[i] && flag==true) {
				mode=i-4000;
				flag = false;
			}
		}
		System.out.println((int)Math.round((double)sum / n));	// 산술평균
		System.out.println(median);								// 중앙값
		System.out.println(mode);								// 최빈값
		System.out.println(max-min);							// 범위
	}
}