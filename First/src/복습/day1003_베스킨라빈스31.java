package 복습;

import java.util.Scanner;

public class day1003_베스킨라빈스31 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int p1 = 0;
		int p2 = 0;
		
		int br = 0;
		int turn = 0;
		
		while(br < 31) {
			
			if(turn%2 == 0) {
				System.out.println("P1 >>> ");
				p1 = sc.nextInt();
				br += p1;
				turn ++;
			}
			else if(turn%2 == 1) {
				System.out.println("P2 >>> ");
				p2 = sc.nextInt();
				br += p2;
				turn ++;
			}
			System.out.println(br);
		}
	}
}
