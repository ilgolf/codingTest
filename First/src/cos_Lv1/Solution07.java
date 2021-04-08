package cos_Lv1;

public class Solution07 {

	public int solution(int one_day_price, int multi_day, int multi_day_price, int n) {
		int answer = 0;

		int multi_count = n / multi_day;
		int one_day_count = n % multi_day;

		int sum = (multi_count * multi_day_price) + (one_day_count * one_day_price);

		answer = sum;

		return answer;
	}

	public static void main(String[] args) {
		Solution07 s = new Solution07();
		int answer = s.solution(2, 3, 5, 11);
		System.out.println(answer);
	}
}
