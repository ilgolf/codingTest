package 복습;

import java.util.Scanner;

public class day0601_식권자판기문제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int[] money = { 50000, 10000, 5000, 1000, 500, 100 };
		int[] charges = { 1, 1, 1, 1, 5, 10 };

		int tickets = 5; // 식권 개수
		int price = 3200; // 식권 가격

		while (true) {

			System.out.println("[1]관리자");
			System.out.println("[2]사용자");

			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();

			if (sel == 1) {
				while (true) {
					System.out.println("1)식권충전");
					System.out.println("2)잔돈충전");
					System.out.println("3)뒤로가기");

					System.out.print("메뉴 선택 : ");
					int choice = sc.nextInt();
					if (choice == 1) {
						System.out.println("식권 개수 입력 >>> ");
						int t = sc.nextInt();
						tickets += t;
					} else if (choice == 2) {
						for(int i=0; i<money.length; i++) {
							System.out.println((i+1) + ". " + money[i] + " : " + charges[i]);
						}
						
						System.out.println("충전할 지폐를 골라주세요 >>> ");
						int idx = sc.nextInt() - 1;
						
						System.out.println("몇장 충전하시겠습니까? >>> ");
						int count = sc.nextInt();
						
						money[idx] += count;
					} else if (choice == 3) {
						break;
					}
				}

			} else if (sel == 2) {
				while (true) {
					
					System.out.println("========================");
					System.out.println("티켓 : " + tickets);
					System.out.println("가격 : " + price);
					System.out.println("========= 잔돈 개수 ========");
					for(int i=0; i<money.length; i++) {
						System.out.println((i+1) + ". " + money[i] + " :  " + charges[i]);
					}
					System.out.println("========================");
					System.out.println("1)구입");
					System.out.println("2)뒤로가기");

					System.out.print("메뉴 선택 : ");
					int choice = sc.nextInt();
					if (choice == 1) {
						System.out.println("입금할 금액을 입력하세요. >>> ");
						int[] input_count = new int[charges.length];
						int input_money = 0;
						while(true) {
							System.out.println("[1.오만원] [2.일만원] [3.오천원] [4.일천원] [5.오백원] [6.일백원] [0.종료]");
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
							System.out.println("입금한 금액 : " + input_money);
						}
						if(input_money < price) {
							break;
						}
						System.out.println("식권 매수를 입력하세요 >>> ");
						int price_count = sc.nextInt();
						if(tickets < price_count) {
							break;
						}
						int price_total = (price_count * price);
						int result = input_money - price_total;
						if(result < 0) {
							System.out.println("입금한 금액이 적습니다.");
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