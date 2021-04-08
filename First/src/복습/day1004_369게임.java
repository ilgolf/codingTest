package ∫πΩ¿;

public class day1004_369∞‘¿” {

	public static void main(String[] args) {
		
		int i = 1;
		while(i <= 50) {
			int cnt = 0;
			
			if(i%10 == 3 || i%10 == 6 || i%10 == 9) {
				cnt ++;
			}
			if(i/10 == 3) {
				cnt++;
			}
			
			if(cnt == 0) {
				System.out.println(i);
			}
			else if(cnt == 1) {
				System.out.println("¬¶");
			}
			else if(cnt == 2) {
				System.out.println("¬¶¬¶");
			}
			i++;
		}
	}

}
