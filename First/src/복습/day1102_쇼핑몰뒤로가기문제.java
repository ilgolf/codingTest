package ����;

import java.util.Scanner;

public class day1102_���θ��ڷΰ��⹮�� {

	/*
	 * # ���θ� �ڷΰ���
	 * 
	 * ����) ���θ����θ޴����� �����Ƿ��� �����ؼ� �ڷΰ��� ������������ �����Ƿ� ������ �� �����ҷ����Ѵ�. ��Ʈ) ���� ���� �ݺ����� �߰�
	 * ���ָ�ȴ�. 1. �����Ƿ� 1) Ƽ���� 2) ���� 3) �ڷΰ��� 2. �����Ƿ� 1) ����� 2) ġ�� 3) �ڷΰ��� 3. ����
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("===== Home Menu =====");
			System.out.println("1. Men style");
			System.out.println("2. Women style");
			System.out.println("0. exit");
			System.out.println("select Menu >>> ");
			int sel = sc.nextInt();

			if (sel == 1) {
				while (true) {
					System.out.println("===== Men =====");
					System.out.println("1. T-shirts");
					System.out.println("2. pants");
					System.out.println("0. return");

					System.out.println("select Menu >>> ");
					int choice = sc.nextInt();

					if (choice == 0) {
						System.out.println("return");
						break;
					}
				}
			} else if (sel == 2) {
				while (true) {
					System.out.println("===== Women =====");
					System.out.println("1. Cardigan");
					System.out.println("2. skirt");
					System.out.println("0. return");
					
					System.out.println("select Menu >>> ");
					int choice = sc.nextInt();
					
					if (choice == 0) {
						System.out.println("return");
						break;
					}
				}
			} else if (sel == 0) {
				System.out.println("exit");
				break;
			}
		}
	}
}
