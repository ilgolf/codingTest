package 복습;

import java.util.Random;
import java.util.Scanner;

public class day1103_카카오택시게임문제 {

	/*
	 * # 카카오 택시 1. 손님을 태워 목적지까지 이동하는 게임이다. 2. -10~10 사이의 랜덤 숫자 2개를 저장해 목적지로 설정한다. 3.
	 * 메뉴는 아래와 같다. 1) 속도설정 : 1~3까지만 가능 2) 방향설정 : 동(1)서(2)남(3)북(4) 3) 이동하기 : 설정된 방향으로
	 * 설정된 속도만큼 이동 4. 거리 1칸 당 50원씩 추가되어 도착시 요금도 출력한다.
	 *
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();

		int x = 0;
		int y = 0;

		// 목적지(destination)
		int desX = ran.nextInt(20) - 10;
		int desY = ran.nextInt(20) - 10;

		// 방향(direction)
		int dir = 0;

		// 요금
		int fee = 0;

		int power = 0;

		while (true) {
			
			if(desX == x && desY == y) {
				System.out.println("도착 !");
				System.out.println("요금은 " + fee + "원 입니다.");
				break;
			}

			System.out.println("===== KaKao Texi =====");
			System.out.println("목적지 :" + desY + " : " + desX);
			System.out.println("현 위치 : " + y + " : " + x);
			System.out.println("1. Setting Speed(1~3) >>> ");
			System.out.println("2. Setting direction(1~4) >>> ");
			System.out.println("3. Move Texi");
			System.out.println("0. exit");
			int sel = sc.nextInt();

			if (sel == 1) {
				System.out.println("Power >>> ");
				power = sc.nextInt();

				if (power > 3) {
					System.out.println("잘못입력 : ");
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
