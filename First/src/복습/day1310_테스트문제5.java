package 복습;

import java.util.Scanner;

public class day1310_테스트문제5 {

	public static void main(String[] args) {
		int[] data = { 5, 5, 6, 8, 2, 6 };

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int cnt = 0;
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data.length; j++) {
				if(num == data[j]) {
					data[j] = 0;
					cnt ++;
				}
			}
		}
		if(cnt != 0) {
			for(int i=0; i<data.length-1; i++) {
				for(int j=0; j<data.length-1; j++) {
					if(data[j] == 0 && data[j+1] != 0) {
						int temp = data[j];
						data[j] = data[j+1];
						data[j+1] = temp;
					}
				}
			}
			int[] temp = new int[data.length];
			
			for(int i=0; i<temp.length; i++) {
				temp[i] = data[i];
			}
			
			data = new int[temp.length - cnt];
			int k = 0;
			for(int i=0; i<data.length; i++) {
				data[i] = temp[k];
				k++;
				System.out.println(data[i]);
			}
		}
		else if(cnt == 0) {
			data = new int[1];
			for(int i=0; i<data.length; i++) {
				System.out.println(data[i]);
			}
		}
	}
}
