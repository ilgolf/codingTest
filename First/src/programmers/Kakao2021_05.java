package programmers;

public class Kakao2021_05 {
		int convert(String time) {
			String[] nums = time.split(":");
			return Integer.parseInt(nums[0]) * 60 * 60 + Integer.parseInt(nums[1]) * 60 + Integer.parseInt(nums[2]);
		}
	
	public String solution(String play_time, String adv_time, String[] logs) {
		int playSec = convert(play_time);
		int advSec = convert(adv_time);
		
		int[] totalSec = new int[100 * 3600];
		for(String log : logs) {
			int start = convert(log.substring(0, 8));
			int end = convert(log.substring(9, 17));
			
			for(int i=start; i<end; i++) {
				totalSec[i] += 1;
			}
		}
		
		long currSum = 0;
		for(int i=0; i<advSec; i++) {
			currSum += totalSec[i];
		}
		
		long maxSum = currSum;
		int maxIdx = 0;
		for(int i= advSec; i<playSec; i++) {
			currSum = currSum + totalSec[i] - totalSec[i - advSec];
			if(currSum > maxSum) {
				maxSum = currSum;
				maxIdx = i - advSec + 1;
			}
		}
		
		return String.format("%02d:%02d:%02d", maxIdx/3600, maxIdx/60 % 60, maxIdx % 60);
    }
	
	public static void main(String[] args) {
		String play_time = "02:03:55";
		String adv_time = "00:14:15";
		String[] logs = {
				"01:20:15-01:45:14", 
				"00:40:31-01:00:00", 
				"00:25:50-00:48:29", 
				"01:30:59-01:53:29", 
				"01:37:44-02:02:30"
			};
		
		Kakao2021_05 k = new Kakao2021_05();
		String answer = k.solution(play_time, adv_time, logs);
		System.out.println(answer);
	}
}
