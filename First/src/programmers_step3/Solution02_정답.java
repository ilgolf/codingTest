package programmers_step3;

public class Solution02_���� {
	public int solution(int n, int[] stations, int w) {
		int answer = 0;
		int left = 0;   // ������ ����
		int right = 0;  // ������ ������
		int baseL = 0;  // ���� �� ����
		int baseR = 0;  // ���� �� ������
		
		for(int i=0; i<stations.length; i++) {
			int base = stations[i]; // ������ ����
			left = baseR; //������ ���� ���� �ٱ� ���� �����̹Ƿ� left�� ����
			
			// ���� ���� w �� 1�ΰ�� �翷 1 
			baseL = base - w;
			baseR = base + w;
			
			// ���� ���� ����
			if(baseL < 0) baseL = 0;
			if(baseR > n) baseR = n;
			
			// 
			right = baseL - 1;
			
			// right�� ������ ���� ���� ����ó��
			if(right < 0) continue; 
			if(left == right) continue;
			if(left > right) continue;
			
			// �������� ��ġ�� �ʴ� ����(right - left)���� �������� ������ �����ְ�
			double temp = (double)(right - left)/((w*2) + 1);
			
			// �� ���� ���������� �״�� answer���� ����ؼ� �����ְ� ���������� �ʴ´ٸ� + 1�� ���ش�.
			if(temp%1 == 0) { answer += (int)temp; }
			else { answer += (int)temp + 1; } 
		}
		
		// ���� ������ �������� ä���� ���ߴٸ� +1�� ���� ���¿��� �ٽ� �Ʊ�� ���� ������� answer�� ����ؼ� �����ش�.
		if(baseR != n) {
			double temp = (double) (n - baseR) / ((w*2) + 1);
			if(temp % 1 == 0) { answer += (int)temp; }
			else { answer += ((int)temp) + 1; }
		}
		return answer;
	}
}