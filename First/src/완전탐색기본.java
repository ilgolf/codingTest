import java.util.StringTokenizer;
import java.io.*;

public class 완전탐색기본 {

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

		// 3개를 고르게 때문에 첫번째 카드는 N - 2 까지
		for (int i = 0; i < N - 2; i++) {

			// 두 번째 카드는 첫 번째 카드 다음부터 N - 1 까지만 순회
			for (int j = i + 1; j < N - 1; j++) {

				// 세 번째 카드는 두 번째 카드 다음부터 N까지 순회
				for (int k = j + 1; k < N; k++) {

					// 3카드의 합
					int temp = card[i] + card[j] + card[k];

					// 세 카드의 합이 M과 같으면 temp 리턴해주고 종료
					if (M == temp) {
						return temp;
					}

					// 같지 않다면 M보다 작은 수 중에 가장 큰값을 탐색후 result에 저장
					if (result < temp && temp < M) {
						result = temp;
					}
				}
			}
		}

		// 리턴 해주고 끝
		return result;
	}
}
