package ����;

import java.util.Scanner;

public class day1107_�����׽�Ʈ2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		/*
		 * # ����� ���� 
		 * 1. 5ȸ �ݺ��� �ϸ鼭 ������ �Է¹޴´�.
		 * 2. �Է¹��� ������ ���� ���� ����Ѵ�. 
		 * 3. ���࿡ �Է¹��� ���� 100 �̻��̸�  �ݺ��� 5ȸ�� �ƴ����� ��� ���� 
		 * 
		 * ��) 7 ==> �� : 7 ,  14 ==> �� : 21 , 1000 ==> �� : 1021 !����
		 * 
		 */	
		
		int sum = 0;
		int count = 0;
		
		while(true) {
			
			if(count >= 5) {
				break;
			}
			
			System.out.println("���� �Է� >>> ");
			int num = sc.nextInt();
			
			sum += num;
			
			if(sum >= 100) {
				break;
			}
			
			count ++;
		}
		System.out.println(sum);
	}

}
