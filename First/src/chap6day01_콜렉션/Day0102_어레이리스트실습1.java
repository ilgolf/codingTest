package chap6day01_�ݷ���;

import java.util.ArrayList;
import java.util.Scanner;

public class Day0102_��̸���Ʈ�ǽ�1 {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println(list);
			System.out.println("1.add 2.delete 3.insert 4.exit");
			int sel = sc.nextInt();
			if(sel == 1) {
				System.out.println("�߰��� ���ڸ� �Է��ϼ��� >>> ");
				int num = sc.nextInt();
				list.add(num);
			} else if(sel == 2) {
				System.out.println(list);
				System.out.println("������ �ε����� �Է��ϼ��� >>> ");
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
				System.out.println("������ ��ġ�� �Է��ϼ��� >>> ");
				int pos = sc.nextInt();
				System.out.println("������ ���� �Է��ϼ��� >>> ");
				int value = sc.nextInt();
				list.add(pos, value);
			} else if(sel == 4) {
				System.out.println("����");
				break;
			}
		}
	}
}
