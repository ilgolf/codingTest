package programmers;

class Kakao2020_03 {
	
	// 90도 회전 하면서 key 복사본에 key 값 저장
	void match(int[][] arr, int[][] key, int rot, int r, int c) {
		int n = key.length;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(rot == 0) {
					arr[r + i][c + j] += key[i][j]; 
				} else if(rot == 1) {
					arr[r + i][c + j] += key[j][n - 1 - i];
				} else if(rot == 2) {
					arr[r + i][c + j] += key[n - 1 - i][n - 1 - j];
				} else {
					arr[r + i][c + j] += key[n - 1 - j][i];
				}
			}
		}
	}
	
	// 매칭 시켰을때 2는 겹치는 부분 0 은 채워지지 않은 부분이므로 1이 아닐때 false 리턴 
	boolean check(int[][] arr,  int offset, int n) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[offset + i][offset + j] != 1) {
					return false;
				}
			}
		}
		
		// 전부다 매칭이 됬으므로 true 리턴
		return true;
	}
	
    public boolean solution(int[][] key, int[][] lock) {
    	int offset = key.length - 1; // 가상의 키를 매칭하기위한 변수
    	
    	for(int r=0; r<offset + lock.length; ++r) { // 각각 매칭 시키기위해 lock + @ 길이로 탐색
    		for(int c=0; c<offset + lock.length; ++c) {
    			for(int rot = 0; rot < 4; ++rot) { // 회전
    				int[][] arr = new int[58][58]; // 넓은 배열에서 각각의 키와 자물쇠를 매칭 시키기위함
    				for(int i=0; i<lock.length; i++) {
    					for(int j=0; j<lock.length; j++) {
    						arr[offset + i][offset + j] = lock[i][j]; // 가운데에 자물쇠를 복사하여 탐색이 쉽게 해줌
    					}
    				}
    				
    				// 탐색
    				match(arr, key, rot, r, c);
    				if(check(arr, offset, lock.length)) {
    					return true;
    				}
    			}
    		}
    	}
    	
    	// 위에서 매칭했을때  실패한것이므로 false 리턴
    	return false;
    }
    
    public static void main(String[] args) {
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		
		Kakao2020_03 k = new Kakao2020_03();
		
		boolean answer = k.solution(key, lock);
		System.out.println(answer);
	}
}