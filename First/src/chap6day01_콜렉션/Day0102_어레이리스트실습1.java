package chap6day01_콜렉션;

import java.util.ArrayList;
import java.util.Scanner;

public class Day0102_어레이리스트실습1 {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println(list);
			System.out.println("1.add 2.delete 3.insert 4.exit");
			int sel = sc.nextInt();
			if(sel == 1) {
				System.out.println("추가할 숫자를 입력하세요 >>> ");
				int num = sc.nextInt();
				list.add(num);
			} else if(sel == 2) {
				System.out.println(list);
				System.out.println("삭제할 인덱스를 입력하세요 >>> ");
				int index = sc.nextInt();
				if(list.size() <= 0) {
					continue;
				}
				if(index < 0) {
					continue;
				}
				if(index >= list.size()) {
					continue;
				}
				list.remove(index);
			} else if(sel == 3) {
				System.out.println(list);
				System.out.println("삽입할 위치를 입력하세요 >>> ");
				int pos = sc.nextInt();
				System.out.println("삽입할 값을 입력하세요 >>> ");
				int value = sc.nextInt();
				list.add(pos, value);
			} else if(sel == 4) {
				System.out.println("종료");
				break;
			}
		}
	}
}
