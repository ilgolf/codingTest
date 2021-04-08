package 복습;

import java.util.Arrays;
import java.util.Scanner;

public class day0708_테스트문제4 {

	public static void main(String[] args) {
		int arr[] = {10,20,30,40,50};	
		int b[] = new int[5];
		
		// arr의 값중 4의 배수만 b에 거꾸로저장
		// 예) b = {0,0,0,40,20};
		
		int back = 4;
		
		for(int i=0; i<b.length; i++) {
			if(arr[i]%4 == 0) {
				b[back] = arr[i];
				back --;
			}
			System.out.print(b[i] + " ");
		}
		
		Scanner sc = new Scanner(System.in);
		
		int arr2[] = {0,2,0,3,4,0,0,5,0};	
		// 아래 번호를 입력받고 각방향 으로 0 이아닌숫자를 모으시요.
		// 1)left 2)right 
		
		// 예) 1) left ==> arr = {2,3,4,5,0,0,0,0,0};
		// 예) 1) right ==> arr = {0,0,0,0,0,2,3,4,5};
		
		int sel = sc.nextInt();
		if(sel == 1) {
			for(int i=0; i<arr2.length-1; i++) {
				for(int j=0; j<arr2.length-1; j++) {
					if(arr2[j] == 0 && arr2[j+1] != 0) {
						int temp = arr2[j];
						arr2[j] = arr2[j+1];
						arr2[j+1] = temp;
					}
				}
			}
			
			for(int i=0; i<arr2.length; i++) {
				System.out.print(arr2[i]);
			}
		}else if(sel == 2) {
			for(int i=arr2.length-1; i>0; i--) {
				for(int j=arr2.length-1; j>0; j--) {
					if(arr2[j] == 0 && arr2[j-1] != 0) {
						int temp = arr2[j];
						arr2[j] = arr2[j-1];
						arr2[j-1] = temp;
					}
				}
			}
			
			for(int i=0; i<arr2.length; i++) {
				System.out.print(arr2[i]);
			}
		}
	}
}
