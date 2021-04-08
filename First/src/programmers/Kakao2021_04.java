package programmers;

public class Kakao2021_04 {

	public static final int INF = 40000000;  // ���Ѵ��� �� 
	public static int[][] d = new int[200][200]; // �ִ� �Ÿ� ���̺�
	
	// �� ����� ���� ����� ã������ Ž��
	void floyd(int n) {
		for(int k=0; k<n; ++k) { // ���
			for(int i=0; i<n; i++) { // �����
				for(int j=0; j<n; j++) {  // ������
					if(d[i][k] + d[k][j] < d[i][j]) {
						d[i][j] = d[i][k] + d[k][j];
					}
				}
			}
		}
	}
	
	public int solution(int n, int s, int a, int b, int[][] fares) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i == j) { // ���������� ���� ��ġ�� �ʴ´�.
					d[i][j] = 0;
				} else {
					d[i][j] = INF;
				}
			}
		}
		
		// ������, ������, ��� ���̺��� ����(1���� idex ���)
		for(int[] endge : fares) {
			d[endge[0] - 1][endge[1] - 1] = endge[2];
			d[endge[1] - 1][endge[0] - 1] = endge[2];
		}
		
		floyd(n);
		
		--s; // 1���� idx�� ����
		--a;
		--b;
		
		int answer = INF;
		for(int k=0; k<n; k++) {
			answer = Math.min(answer, d[s][k] + d[k][a] + d[k][b]);
		}
        return answer;
    }
	
	public static void main(String[] args) {
		int n = 6;  // ��������
		int s = 4;  // �����
		int a = 6;  // a�� �����
		int b = 2;  // b�� �����
		
		int[][] fares = {
				{4, 1, 10}, 
				{3, 5, 24}, 
				{5, 6, 2}, 
				{3, 1, 41}, 
				{5, 1, 24}, 
				{4, 6, 50}, 
				{2, 4, 66}, 
				{2, 3, 22},
				{1, 6, 25}	
		};
		
		Kakao2021_04 k = new Kakao2021_04();
		int answer = k.solution(n, s, a, b, fares);
		System.out.println(answer);
	}
}