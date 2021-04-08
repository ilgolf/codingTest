package programmers_step3;

public class Solution02 {

	public int solution(int n, int[] stations, int w) {
		int answer = 0;

		int[] apt = new int[n];

		for (int i = 0; i < stations.length; i++) {
			if (stations[i] != 1 && stations[i] != apt.length) {
				apt[(stations[i]-1) - w] = 1;
				apt[(stations[i]-1)] = 1;
				apt[(stations[i]-1) + w] = 1;
			} else if (stations[i] == 0) {
				apt[(stations[i]-1)] = 1;
				apt[(stations[i]-1) + w] = 1;
			} else if (stations[i] == apt.length) {
				apt[(stations[i]-1) - w] = 1;
				apt[(stations[i]-1)] = 1;
			}
		}

		int count = 0;
		for (int i = 0; i < apt.length; i++) {
			if (apt[i] == 0) {
				count++;
			}
		}

		answer = count / (w*2);

		return answer;
	}

	public static void main(String[] args) {
		Solution02 s = new Solution02();

		int n = 11;
		int[] stations = { 4, 11 };
		int w = 1;

		int answer = s.solution(n, stations, w);

		System.out.println(answer);
	}
}
