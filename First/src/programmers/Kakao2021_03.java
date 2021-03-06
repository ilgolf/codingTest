package programmers;

import java.util.*;

public class Kakao2021_03 {
	
	Map<String, Integer> wmap = new HashMap<>();
	List<List<Integer>> list = new ArrayList<>();
	
	public int[] solution(String[] info, String[] query) {
		// 키워드 맵 정렬에 저장
		wmap.put("-", 0);
		wmap.put("cpp", 1);
		wmap.put("java", 2);
		wmap.put("python", 3);
		wmap.put("backend", 1);
		wmap.put("frontend", 2);
		wmap.put("junior", 1);
		wmap.put("senior", 2);
		wmap.put("chicken", 1);
		wmap.put("pizza", 2);
		for(int i=0; i<4*3*3*3; i++) {
			list.add(new ArrayList<>());
		}
		
		// 검색할 테이블 작성
		for(String str : info) {
			String[] word = str.split(" ");
			int[] arr = {
						wmap.get(word[0]) *3*3*3, // 각 칸마다 데이터 저장
						wmap.get(word[1]) *3*3,
						wmap.get(word[2]) *3,
						wmap.get(word[3])
				};
			int score = Integer.parseInt(word[4]); // 점수는 따로 인티저형으로 저장
			
			for(int i=0; i<(1 << 4); i++) {
				int idx = 0;
				for(int j=0; j<4; j++) {
					if((i & (1<<j)) != 0) {
						idx += arr[j];
					}
				}
				list.get(idx).add(score); // 각 위치에 점수 저장
			}
		}
		
		// 이분탐색을 위해 정렬
		for(int i=0; i<4*3*3*3; i++) {
			Collections.sort(list.get(i));
		}
		
		
		int[] answer = new int[query.length];
		
		for(int i=0; i<query.length; i++) {
			String[] word = query[i].split(" ");
			
			int idx = wmap.get(word[0]) *3*3*3 + 
					wmap.get(word[2]) *3*3 + 
					wmap.get(word[4]) *3 + wmap.get(word[6]); // and를 제외한 나머지 값을 파싱하여 테이블에 대입
			int score = Integer.parseInt(word[7]);
			
			// 각 값들과 점수를 비교하며 이분탐색 <- 시간 초과 방지
			int ret = Collections.binarySearch(list.get(idx), score);
			if(ret < 0) {
				ret = -(ret + 1);  // 음수일경우에는 값을 찾지 못한경우 양수로 바꿔주어 오류 방지
			} else {
				for(int j=ret - 1; j>=0; j--) {
					if(list.get(idx).get(j) == score) {  // 점수가 넘는값을 찾았지만 그게 우리가 찾는 정답이 아닐지도 모른다.
						ret = j;  // 가장 작은값을 탐색 하여 있을경우 가장 작은값을 계속해서 넣어준다(sort로 정렬을 하였기때문에 가능)
					} else {
						break;
					}
				}
			}
			answer[i] = list.get(idx).size() - ret; // 사이즈는 총 개수, ret은 가장 작은값의 위치
		}
        return answer;
    }
	
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		
		Kakao2021_03 k = new Kakao2021_03();
		int[] answer = k.solution(info, query);
		System.out.println(Arrays.toString(answer));
	}
}
