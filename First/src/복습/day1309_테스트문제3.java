package 복습;

import java.util.Scanner;

public class day1309_테스트문제3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int game[] = { 0, 2, 0, 2, 8, 0, 0, 4, 0 };

		// 1)left , 2)right
		
		// 문제1)번호를 입력받고 각방향으로 숫자를모으시요.
		// 조건) 만약에 같은숫자2개가 붙었을경우는 서로 더해진다.
		// 아래 2단계출력
		// 예) left
		// 1단계 : {2,2,8,4,0,0,0,0,0};
		// 2단계 : {4,8,4,0,0,0,0,0,0}; 2가 2개붙었으니 4가된다.
		
		System.out.println("1)left  2)Right");
		int sel = sc.nextInt();
		
		if(sel == 1) {
			for(int i=0; i<game.length-1; i++) {
				for(int j=0; j<game.length-1; j++) {
					if(game[j] == 0 && game[j+1] != 0) {
						int temp = game[j];
						game[j] = game[j+1];
						game[j+1] = temp;
					}
					if(game[j] == game[j+1]) {
						game[j] += game[j+1];
					}
				}
			}
			
			for(int i=0; i<game.length; i++) {
				System.out.print(game[i]);
			}
		}
		else if(sel == 2) {
			for(int i=game.length-1; i>0; i--) {
				for(int j=game.length-1; j>0; j--) {
					if(game[j] == 0 && game[j-1] != 0) {
						int temp = game[j];
						game[j] = game[j-1];
						game[j-1] = temp;
					}
					if(game[j] == game[j-1]) {
						game[j] += game[j-1];
					}
				}
			}
			
			for(int i=0; i<game.length; i++) {
				System.out.print(game[i]);
			}
		}
	}
}