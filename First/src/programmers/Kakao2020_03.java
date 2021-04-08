package programmers;

class Kakao2020_03 {
	
	// 90�� ȸ�� �ϸ鼭 key ���纻�� key �� ����
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
	
	// ��Ī �������� 2�� ��ġ�� �κ� 0 �� ä������ ���� �κ��̹Ƿ� 1�� �ƴҶ� false ���� 
	boolean check(int[][] arr,  int offset, int n) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[offset + i][offset + j] != 1) {
					return false;
				}
			}
		}
		
		// ���δ� ��Ī�� �����Ƿ� true ����
		return true;
	}
	
    public boolean solution(int[][] key, int[][] lock) {
    	int offset = key.length - 1; // ������ Ű�� ��Ī�ϱ����� ����
    	
    	for(int r=0; r<offset + lock.length; ++r) { // ���� ��Ī ��Ű������ lock + @ ���̷� Ž��
    		for(int c=0; c<offset + lock.length; ++c) {
    			for(int rot = 0; rot < 4; ++rot) { // ȸ��
    				int[][] arr = new int[58][58]; // ���� �迭���� ������ Ű�� �ڹ��踦 ��Ī ��Ű������
    				for(int i=0; i<lock.length; i++) {
    					for(int j=0; j<lock.length; j++) {
    						arr[offset + i][offset + j] = lock[i][j]; // ����� �ڹ��踦 �����Ͽ� Ž���� ���� ����
    					}
    				}
    				
    				// Ž��
    				match(arr, key, rot, r, c);
    				if(check(arr, offset, lock.length)) {
    					return true;
    				}
    			}
    		}
    	}
    	
    	// ������ ��Ī������  �����Ѱ��̹Ƿ� false ����
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