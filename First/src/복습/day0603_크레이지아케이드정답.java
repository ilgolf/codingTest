package 복습;

import java.util.Random;
import java.util.Scanner;

public class day0603_크레이지아케이드정답 {
	
	/*
	 * # 크레이지 아케이드
	 * 1. 맵의 크기는 7 x 7 이다. 
	 * 2. 상(1)하(2)좌(3)우(4)로 이동이 가능하며,
	 *    폭탄설치(5), 폭파(6)로 설정한다. 
	 * 3. 벽(3), 플레이어(2), 폭탄(9), 아이템(4)로 설정한다.
	 * 4. 단, 폭탄이 설치된 순서대로 터져야 하며,
	 *    폭파 시 십자가 형태로 터진다.
	 * 5. 벽 파괴시 아이템이 랜덤하게 생성되어,
	 *    아이템을 먹으면 설치할 수 있는 폭탄의 개수가 증가된다.
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		final int SIZE = 7;
		final int WALL = 3;
		final int PLAYER = 2;
		final int BOMB = 9;
		final int ITEM = 4;

		boolean playerDead = false;
		int bombMaxCount = 3;
		int bombCount = bombMaxCount;
		int wallCount = 20;
		int itemCount = 0;
		int pX = 0;
		int pY = 0;
		
		int[] bombX = new int[bombMaxCount];
		int[] bombY = new int[bombMaxCount];
		int[][] map = new int[SIZE][SIZE];
		
		int temp = wallCount;
		while(temp != 0) {
			int rX = ran.nextInt(SIZE);
			int rY = ran.nextInt(SIZE);
			
			if(map[rY][rX] == 0) {
				map[rY][rX] = WALL;
				temp --;
			}
		}
		
		while(true) {
			pX = ran.nextInt(SIZE);
			pY = ran.nextInt(SIZE);
			
			if(map[pY][pX] == 0) {
				map[pY][pX] = PLAYER;
				break;
			}
		}
		
		temp = 0;
		while(temp != 3) {
			int rX = ran.nextInt(SIZE);
			int rY = ran.nextInt(SIZE);
			
			if(map[rY][rX] == 0) {
				map[rY][rX] = BOMB;
				bombX[temp] = rX;
				bombY[temp] = rY;
				temp++;
			}
		}
		
		while(true) {
			System.out.println("───────────────────────────────────");
			System.out.println("            Crazy Arcade");
			System.out.println("───────────────────────────────────");
			System.out.println("◈ 설치가능 폭탄 개수\t " + bombMaxCount + "EA");
			System.out.println("◈ 남아있는 폭탄 개수\t " + bombCount + "EA");
			System.out.println("◈ 남아있는 벽돌 개수\t " + wallCount + "EA");
			System.out.println("◈ 획득할 아이템 개수\t " + itemCount + "EA");
			// 폭탄 출력
			System.out.println("───────────────────────────────────");
			System.out.println("◈ 설치된 폭탄의 위치");
			for (int i = 0; i < bombCount; i++) {
				System.out.println("[" + (i + 1) + "] " + bombY[i] + " : " + bombX[i]);
			}
			System.out.println("───────────────────────────────────");
			wallCount = 0;
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE; j++) {
					if(map[i][j] == WALL) {
						wallCount++;
						System.out.print("벽 ");
					} else if(map[i][j] == PLAYER) {
						System.out.print("옷 ");
					} else if(map[i][j] == BOMB) {
						System.out.print("폭 ");
					} else if(map[i][j] == ITEM) {
						System.out.print("아 ");
					} else {
						System.out.print(map[i][j] + " ");
					}
				}
				System.out.println();
			}
			
			if(playerDead) {
				System.out.println("[메세지]캐릭터가 폭탄에 맞아 죽었습니다. 게임을 종료합니다.");
				break;
			}
			
			System.out.print("상(1)하(2)좌(3)우(4)폭탄설치(5)폭파(6) 입력 : ");
			int move = sc.nextInt();
			
			if(move == 1 || move == 2 || move == 3 || move == 4) {
				int tempX = pX;
				int tempY = pY;
				
				if(move == 1) {
					tempY --;
				} else if(move == 2) {
					tempY ++;
				} else if(move == 3) {
					tempX --;
				} else if(move == 4) {
					tempX ++;
				}
				
				if(SIZE <= tempY || tempY < 0) {
					continue;
				}
				if(SIZE <= tempX || tempX < 0) {
					continue;
				}
				if(map[tempY][tempX] == WALL) {
					continue;
				}
				if(map[tempY][tempX] == BOMB) {
					continue;
				}
				
				if(map[tempY][tempX] == ITEM) {
					map[pY][pX] = 0;
					itemCount --;
					
					int[] x = bombX;
					int[] y = bombY;
					
					bombX = new int[bombMaxCount + 1];
					bombY = new int[bombMaxCount + 1];
					
					for(int i=0; i<bombMaxCount; i++) {
						bombX[i] = x[i];
						bombY[i] = y[i];
					}
					
					x = null;
					y = null;
					
					bombMaxCount ++;
				}
				
				if(map[pY][pX] == 2) {
					map[pY][pX] = 0;
				}
				
				pY = tempY;
				pX = tempX;
				map[pY][pX] = PLAYER;
			} else if(move == 5) {
				if(bombMaxCount <= bombCount) {
					System.out.println("[메세지] 더이상 폭탄을 설치할 수 없습니다.");
					continue;
				}
				if(map[pY][pX] != 2 && map[pY][pX] != 0) {
					System.out.println("[메세지] 해당 위치에는 폭탄을 설치할 수 없습니다.");
					continue;
				}
				
				bombX[bombCount] = pX;
				bombY[bombCount] = pY;
				map[bombY[bombCount]][bombX[bombCount]] = BOMB;
				bombCount ++;
			} else if(move == 6) {
				if(bombCount <= 0) {
					System.out.println("[메세지] 폭파할 폭탄이 없습니다.");
					continue;
				}
				int xx = bombX[0];
				int yy = bombY[0];
				for(int i = -1; i<=1; i++) {
					if(0<= xx + i && xx + i < SIZE) {
						playerDead = true;
						
						if(map[yy][xx + i] == WALL) {
							if(ran.nextInt(2) == 0) {
								map[yy][xx + i] = 0;
							} else {
								map[yy][xx + i] = ITEM;
								itemCount ++;
							}
						}
					}
				}
				
				map[yy][xx] = 0;
				for(int i=0; i<bombMaxCount - 1; i++) {
					bombX[i] = bombX[i+1];
					bombY[i] = bombY[i+1];
				}
				bombCount --;
			}
		}
	}
}
