package 복습;

import java.util.Random;

public class day0602_경마게임 {

	public static void main(String[] args) {
		int[][] horse = new int[5][20];
		Random ran = new Random();
		int max = 20;
		int[] rank = new int[5];
		int[] total = new int[5];
		boolean run = true;
		int count = 1;
		for(int i=0; i<20; i++) {
			int check = 0;
			for(int n=0; n<5; n++) {
				if(total[n] >= 19) {
					horse[n][i] = 0;
				} else {
					int r = ran.nextInt(4) + 1;
					horse[n][r] = r;
					total[n] = total[n] + horse[n][i];
					if(total[n] >=19) {
						horse[n][i] = 0;
						check += 1;
						if(check >= 2) {
							i = -1;
							horse = new int[5][20];
							total = new int[5];
							rank = new int[5];
							count = 1;
							break;
						}
					} 
				}
			}
		}
		for(int i=0; i<5; i++) {
			System.out.println(rank[i]);
		}
		for(int i=0; i<5; i++) {
			for(int n=0; n<20; n++) {
				System.out.println(horse[i][n]);
			}
			System.out.println();
		}
		
		int[][] show = new int[5][20];
		int[] index = new int[5];
		run = true;
		count = 0;
		while(run) {
			for(int i=0; i<5; i++) {
				for(int n=0; n<20; n++) {
					if(show[i][n] == 0) {
						System.out.print("[ ]");
					} else {
						System.out.print("[읏]");
					}
				}
				System.out.println("");
			}
			System.out.println("=================");
			for(int n=0; n<5; n++) {
				show[n][index[n]] = 0;
				index[n] += horse[n][count];
				if(index[n] >= 20) {
					index[n] = 19;
				}
				show[n][index[n]] = 1;
			}
			try {
				Thread.sleep(100);
			} catch(Exception e) {
				
			}
			count ++;
			if(count == 20) {
				break;
			}
		}
	}
}
