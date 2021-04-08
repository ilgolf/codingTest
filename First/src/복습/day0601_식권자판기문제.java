package ����;

import java.util.Scanner;

public class day0601_�ı����Ǳ⹮�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int[] money = { 50000, 10000, 5000, 1000, 500, 100 };
		int[] charges = { 1, 1, 1, 1, 5, 10 };

		int tickets = 5; // �ı� ����
		int price = 3200; // �ı� ����

		while (true) {

			System.out.println("[1]������");
			System.out.println("[2]�����");

			System.out.print("�޴� ���� : ");
			int sel = sc.nextInt();

			if (sel == 1) {
				while (true) {
					System.out.println("1)�ı�����");
					System.out.println("2)�ܵ�����");
					System.out.println("3)�ڷΰ���");

					System.out.print("�޴� ���� : ");
					int choice = sc.nextInt();
					if (choice == 1) {
						System.out.println("�ı� ���� �Է� >>> ");
						int t = sc.nextInt();
						tickets += t;
					} else if (choice == 2) {
						for(int i=0; i<money.length; i++) {
							System.out.println((i+1) + ". " + money[i] + " : " + charges[i]);
						}
						
						System.out.println("������ ���� ����ּ��� >>> ");
						int idx = sc.nextInt() - 1;
						
						System.out.println("���� �����Ͻðڽ��ϱ�? >>> ");
						int count = sc.nextInt();
						
						money[idx] += count;
					} else if (choice == 3) {
						break;
					}
				}

			} else if (sel == 2) {
				while (true) {
					
					System.out.println("========================");
					System.out.println("Ƽ�� : " + tickets);
					System.out.println("���� : " + price);
					System.out.println("========= �ܵ� ���� ========");
					for(int i=0; i<money.length; i++) {
						System.out.println((i+1) + ". " + money[i] + " :  " + charges[i]);
					}
					System.out.println("========================");
					System.out.println("1)����");
					System.out.println("2)�ڷΰ���");

					System.out.print("�޴� ���� : ");
					int choice = sc.nextInt();
					if (choice == 1) {
						System.out.println("�Ա��� �ݾ��� �Է��ϼ���. >>> ");
						int[] input_count = new int[charges.length];
						int input_money = 0;
						while(true) {
							System.out.println("[1.������] [2.�ϸ���] [3.��õ��] [4.��õ��] [5.�����] [6.�Ϲ��] [0.����]");
							int num = sc.nextInt();
							if(num == 0) {
								break;
							}
							else {
								input_count[num - 1] += 1;
							}
							input_money = 0;
							for(int i=0; i<money.length; i++) {
								input_money += input_count[i]*money[i];
							}
							System.out.println("�Ա��� �ݾ� : " + input_money);
						}
						if(input_money < price) {
							break;
						}
						System.out.println("�ı� �ż��� �Է��ϼ��� >>> ");
						int price_count = sc.nextInt();
						if(tickets < price_count) {
							break;
						}
						int price_total = (price_count * price);
						int result = input_money - price_total;
						if(result < 0) {
							System.out.println("�Ա��� �ݾ��� �����ϴ�.");
						} else {
							
							int[] check_charge = new int[money.length];
							for(int i=0; i<money.length; i++) {
								check_charge[i] = charges[i];
							}
							int result_check = result;
							for(int i=0; i<money.length; i++) {
								int check_run = 1;
								while(check_run == 1) {
									if(result_check >= money[i] && check_charge[i] > 0) {
										result_check -= money[i];
										check_charge[i] -= 1;
									}else {
										check_run = 0;
										break;
									}
								}
							}
						}
					} else if (choice == 2) {
						break;
					}
				}
			}
		}
	}
}