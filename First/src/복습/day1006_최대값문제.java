package ����;

import java.util.Scanner;

public class day1006_�ִ밪���� {
	
	/*
	 * # �ִ밪 ���ϱ�[2�ܰ�]
	 * 1. 3ȸ �ݺ��� �ϸ鼭 ������ �Է¹޴´�.
	 * 2. �Է¹��� 3���� ���� �� ���� ū ���� ����Ѵ�.
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
