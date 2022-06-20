package com.ssafy.day0323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S2_11279_최대힙 {

	static int[] heap;
	static int size = 0;	// heap 의 가장 마지막 요소의 인덱스

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		heap = new int[N + 1];

		for (int i = 0; i < N; i++) {
			int command = Integer.parseInt(br.readLine());

			if (command == 0) {
				if (size == 0)
					sb.append(0 + "\n");
				else
					sb.append(getItem() + "\n");
			} else {
				addItem(command);
			}
		}
		System.out.println(sb);
	}

	private static void addItem(int num) {
		// heap 맨 마지막에 add할 값을 추가
		size++;
		heap[size] = num;

		// 힙의 마지막 idx 를 child에 , child의 부모idx 를 parent 에 저장
		int parents = size / 2;
		int child = size;

		while (parents > 0) {
			// 자식이 더 크다면
			if (heap[child] > heap[parents]) {
				int temp = heap[parents];
				heap[parents] = heap[child];
				heap[child] = temp;

				child = parents;
				parents = child / 2;
			} else { // 부모의 값이 더 크면 더 이상 진행할 필요가 없다.
				break;
			}
		}
	}
	
	// 첫번째 값을 뺴고 마지막 idx의 값을 1번에 넣고 자식노드와 값을 비교한다.
	private static int getItem() {
		
		// 첫번째 값을 미리 빼 둔다.
		int result = heap[1];
		int target = heap[size]; // 마지막 값을 미리 저장해두고

		heap[size] = 0;
		size--;
		// 배열의 크기를 하나 줄인다.
		
		int parents = 1; 
		int child;

		// 왼쪽 자식의 idx가 배열의 크기를 넘어가지 않는다면 while
		while ((child = parents * 2) <= size) { 
			int right = parents * 2 + 1;	// 오른쪽 자식의 인덱스

			int childval = heap[child]; // 먼저 왼쪽 자식의 값을 저장

			//오른쪽 자식이 존재하고, 오른쪽 자식의 값이 왼쪽 자식의 값보다 크면
			if (right <= size && heap[right] > childval) {
				// 오른쪽 자식의 idx와 값을 저장해둔다.
				child = right;
				childval = heap[child];
			}

			// 재배치할 노드가 자식 노드보다 클 경우 반복문을 종료한다.
			if (target > childval) {
				break;
			}

			// 현재 부모 인덱스에 자식 노드의 값을 넣어주고
			// parent 변수에 자식 인덱스를 넣는다.
			heap[parents] = childval;
			parents = child;

		}
		// 최종적으로 재배치 될 위치에 target을 넣어준다.
		heap[parents] = target;

		return result;
	}

}
