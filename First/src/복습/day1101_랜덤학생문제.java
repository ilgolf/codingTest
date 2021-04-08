package 복습;

import java.util.Random;

public class day1101_랜덤학생문제 {
	
	/*
	 * # 랜덤학생
	 * 1. 10회 반복을 한다.
	 * 2. 1~100 사이의 랜덤 숫자를 저장한다.(학생의 성적)
	 * 3. 성적이 60점 이상이면 합격생이다.
	 * ---------------------------------------
	 * . 전교생(10명)의 총점과 평균을 출력한다.
	 * . 합격자 수를 출력한다.
	 * . 1등 학생의 번호와 성적을 출력한다.
	 */

	public static void main(String[] args) {
		Random ran = new Random();
		
		int i=0; 
		double sum = 0;
		double avg = 0;
		int cnt = 0;
		int max = 0;
		int max_score = 0;
		while(i<10) {
			int r = ran.nextInt(100) + 1;
			
			sum += r;
			avg = sum/10;
			
			if(r >= 60) {
				cnt ++;
			}
			
			if(max < r) {
				max = i;
				max_score = r;
			}
			i++;
		}
		System.out.println(sum + " : " + avg);
		System.out.println("합격자 = " + cnt + "명");
		System.out.println("1등 " + max + " : " + max_score);
	}
}
