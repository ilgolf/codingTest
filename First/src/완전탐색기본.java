import java.util.StringTokenizer;
import java.io.*;

public class ����Ž���⺻ {

	public static void main(String[] args) throws IOException  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(st.nextToken());

		int[] card = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		int result = search(card, N, M);
		System.out.println(result);
	}

	static int search(int[] card, int N, int M) {
		int result = 0;

		// 3���� ���� ������ ù��° ī��� N - 2 ����
		for (int i = 0; i < N - 2; i++) {

			// �� ��° ī��� ù ��° ī�� �������� N - 1 ������ ��ȸ
			for (int j = i + 1; j < N - 1; j++) {

				// �� ��° ī��� �� ��° ī�� �������� N���� ��ȸ
				for (int k = j + 1; k < N; k++) {

					// 3ī���� ��
					int temp = card[i] + card[j] + card[k];

					// �� ī���� ���� M�� ������ temp �������ְ� ����
					if (M == temp) {
						return temp;
					}

					// ���� �ʴٸ� M���� ���� �� �߿� ���� ū���� Ž���� result�� ����
					if (result < temp && temp < M) {
						result = temp;
					}
				}
			}
		}

		// ���� ���ְ� ��
		return result;
	}
}
