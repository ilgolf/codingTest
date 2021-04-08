package 복습;

import java.util.Scanner;

public class day1006_최대값문제 {
	
	/*
	 * # 최대값 구하기[2단계]
	 * 1. 3회 반복을 하면서 정수를 입력받는다.
	 * 2. 입력받은 3개의 숫자 중 가장 큰 값을 출력한다.
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int max = 0;
		
		int i=0;
		while(i < 3) {
			
			int num = sc.nextInt();
			
			if(max < num) {
				max = num;
			}
			
			i++;
		}
		System.out.println(max);
	}
}
