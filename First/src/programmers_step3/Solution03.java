package programmers_step3;

public class Solution03 {
	public int solution(int[] A, int[] B) {
		int answer = 0;

		int[] count = new int[A.length];
		for(int i=0; i<B.length; i++) {
			for(int j=0; j<B.length; j++) {
				if(B[i] < B[j]) {
					int tmp = B[i];
					B[i] = B[j];
					B[j] = tmp;
				}
				
				if(A[j] < B[j]) {
					count[i] += 1;
				}
			}
		}
		
		int max = 0;
		for(int i=0; i<count.length; i++) {
			if(max < count[i]) {
				max = count[i];
			}
		}
		answer = max;
        return answer;
    }
	public static void main(String[] args) {
		Solution03 s = new Solution03();
		
		int[] A = {5,1,3,7};
		int[] B = {2,2,6,8};
		
		int answer = s.solution(A, B);
		System.out.println(answer);
	}
}
