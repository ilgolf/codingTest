package ����;

import java.util.Random;
import java.util.Scanner;

public class day0813_�׽�Ʈ����2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		
		/*
		 * # ������ ����[2�ܰ�]
		 * 1. ������ ������ �����ϱ� ����, ���� 2���� �����ϰ� �����Ѵ�.
		 * 2. ����� ���ڸ� ���� ������ ������ ����Ѵ�.
		 * ��)	3 x 7 = ?
		 * 3. ������ �ش��ϴ� ������ �Է¹޴´�.
		 * 4. ������ �� "����" �Ǵ� "��"�� ����Ѵ�.
		 */
		
		int x = ran.nextInt(9)+1;
		int y = ran.nextInt(9)+1;
		
		int ans = x*y;
		
		System.out.println(x + " X " + y + "= ?");
		System.out.println("����  >>> ");
		int myAns = sc.nextInt();
		
		if(myAns == ans) {
			System.out.println("���� !");
		} else {
			System.out.println("�� !");
		}
	}

}
