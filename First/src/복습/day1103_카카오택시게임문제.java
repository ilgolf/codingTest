package ����;

import java.util.Random;
import java.util.Scanner;

public class day1103_īī���ýð��ӹ��� {

	/*
	 * # īī�� �ý� 1. �մ��� �¿� ���������� �̵��ϴ� �����̴�. 2. -10~10 ������ ���� ���� 2���� ������ �������� �����Ѵ�. 3.
	 * �޴��� �Ʒ��� ����. 1) �ӵ����� : 1~3������ ���� 2) ���⼳�� : ��(1)��(2)��(3)��(4) 3) �̵��ϱ� : ������ ��������
	 * ������ �ӵ���ŭ �̵� 4. �Ÿ� 1ĭ �� 50���� �߰��Ǿ� ������ ��ݵ� ����Ѵ�.
	 *
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();

		int x = 0;
		int y = 0;

		// ������(destination)
		int desX = ran.nextInt(20) - 10;
		int desY = ran.nextInt(20) - 10;

		// ����(direction)
		int dir = 0;

		// ���
		int fee = 0;

		int power = 0;

		while (true) {
			
			if(desX == x && desY == y) {
				System.out.println("���� !");
				System.out.println("����� " + fee + "�� �Դϴ�.");
				break;
			}

			System.out.println("===== KaKao Texi =====");
			System.out.println("������ :" + desY + " : " + desX);
			System.out.println("�� ��ġ : " + y + " : " + x);
			System.out.println("1. Setting Speed(1~3) >>> ");
			System.out.println("2. Setting direction(1~4) >>> ");
			System.out.println("3. Move Texi");
			System.out.println("0. exit");
			int sel = sc.nextInt();

			if (sel == 1) {
				System.out.println("Power >>> ");
				power = sc.nextInt();

				if (power > 3) {
					System.out.println("�߸��Է� : ");
					continue;
				}
			} else if (sel == 2) {
				System.out.println("choice direction 1) North 2) South 3) West 4) East");
				dir = sc.nextInt();
			} else if (sel == 3) {
				if(dir == 1) {
					if(y-power >= -10) {
						y = y-power;
					}
				}
				else if(dir == 2) {
					if(y + power <= 10) {
						y = y + power;
					}
				}
				else if(dir == 3) {
					if(x - power >= -10) {
						x = x - power;
					}
				}
				else if(dir == 4) {
					if(x + power <= 10) {
						x = x + power;
					}
				}
				fee += power*50;
			}
		}
	}
}
