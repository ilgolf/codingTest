package solution;

class Solution01 {
	
	int[] count;
	int[][] Needs;
	
	void find(int x, int y) {

		if(x == Needs.length) {
			return;
		}
		
		for(int i=0; i<y; i++) {
			if(Needs[x][y] == 1) {
				count[x] ++;
			}
		}
		
		find(x + 1, y);
	}
	
    public int solution(int[][] needs, int r) {
    	Needs = needs;
    	count = new int[needs.length];
    	
    	for(int i=0; i<needs.length; i++) {
    		for(int j=i; j<r; j++) {
    			find(i, j+1);
    		}
    	}
    	
    	int answer = 0;
    	for(int val : count) {
    		answer = Math.max(answer, val);
    	}
        return answer - 1;
    }
    
    public static void main(String[] args) {
		int[][] needs = { 
				{1, 0, 0}, 
				{1, 1, 0}, 
				{1, 1, 0}, 
				{1, 0, 1}, 
				{1, 1, 0}, 
				{0, 1, 1} 
		};
		int r = 2;
		
		Solution01 s = new Solution01();
		int answer =  s.solution(needs, r);
		System.out.println(answer);
	}
}