package ����;

public class day1309_�׽�Ʈ����4 {

	public static void main(String[] args) {
		int darr[][] = {
				{10,20,30},
				{40,50,60},
				{70,80,90},
		};
		int b [] = {10,2,54,90,50};
		// b �� arr �� ���� ������ 0���� ���� 
		
		//��) b ==> {0,2,54,0,0};
		
		for(int i=0; i<darr.length; i++) {
			int check = -1;
			for(int j=0; j<darr[i].length; j++) {
				for(int k=0; k<b.length; k++) {
					if(b[k] == darr[i][j]) {
						check = k;
					}
				}
			}
			b[check] = 0;
		}
		
		for(int i=0; i<b.length; i++) {
			System.out.println(b[i]);
		}
	}
}
