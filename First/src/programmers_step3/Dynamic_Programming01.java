package programmers_step3;

public class Dynamic_Programming01 {

	public int solution(int[][] triangle) {
		int answer = 0;
		
		for(int i=1; i<triangle.length; i++) {
			for(int j=0; j<triangle[i].length; j++) {
				
				if(j == 0) {
					triangle[i][j] = triangle[i][j] + triangle[i-1][j];
				} else if(i == j) {
					triangle[i][j] = triangle[i][j] + triangle[i-1][j-1];
				} else {
					int left = triangle[i][j] + triangle[i-1][j-1];
					int right = triangle[i][j] + triangle[i-1][j];
					triangle[i][j] = Math.max(left, right);
				}
				
				answer = Math.max(answer, triangle[i][j]);
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		
		Dynamic_Programming01 s = new Dynamic_Programming01();
		int answer = s.solution(triangle);
		System.out.println(answer);
	}
}
