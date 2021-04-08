package programmers_step3;

public class Dynamic_Programming01_1 { 

	public int solution(int[][] triangle) {
		for(int i=triangle.length - 2; i>=0; i--) {
			for(int j=0; j<triangle[i].length; j++) {
				int left = triangle[i][j] + triangle[i+1][j];
				int right = triangle[i][j] + triangle[i+1][j+1];
				triangle[i][j] = Math.max(left, right);
			}
		}
		
		return triangle[0][0];
	}
	
	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		
		Dynamic_Programming01_1 s = new Dynamic_Programming01_1();
		int answer = s.solution(triangle);
		System.out.println(answer);
	}
}
