package chap6day01_콜렉션;

import java.util.Scanner;

class MyList {
	int[] arr;
	int count;
	
	void print() {
		System.out.print("[");
		for(int i=0; i<count; i++) {
			System.out.print(arr[i]);
			if(i != count - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
	
	void add(int value) {
		if(count == 0) {
			arr = new int[count + 1];
		} else if(count > 0) {
			int[] temp = arr;
			arr = new int[count + 1];
			
			for(int i=0; i<count; i++) {
				arr[i] = temp[i];
			}
			temp = null;
		}
		
		arr[count] = value;
		count++;
	}
	
	void add(int index, int value) {
		if(count == 0) {
			arr = new int[count + 1];
		} else if(count > 0) {
			int[] temp = arr;
			arr = new int[count + 1];
			
			int j = 0;
			for(int i=0; i<count + 1; i++) {
				if(i != index) {
					arr[i] = temp[j];
					j++;
				}
			}
			temp = null;
		}
		
		arr[index] = value;
		count ++;
	}
	
	void remove(int index) {
		if(count == 1) {
			arr = null;
		} else if(count > 1) {
			int[] temp = arr;
			arr = new int[count - 1];
			
			int j = 0;
			for(int i=0; i<count; i++) {
				if(i != index) {
					arr[j] = temp[i];
					j ++;
				}
			}
			temp = null;
		}
		count --;
	}
	
	int size() {
		return count;
	}
	
	int get(int index) {
		return arr[index];
	}
	
	void set(int index, int value) {
		arr[index] = value;
	}
	
	void clear() {
		arr = null;
		count = 0;
	}
}

public class Day0103_어레이리스트직접만들기 {
	
	public static void main(String[] args) {
		MyList list = new MyList();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			list.print();
			
			System.out.println("1.add 2.delete 3.insert 4.exit");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				System.out.println("enter add number >>> ");
				int num = sc.nextInt();
				list.add(num);
			} else if(sel == 2) {
				list.print();
				System.out.println("enter delete index >>> ");
				int index = sc.nextInt();
				if(list.size() <= 0) {
					continue;
				}
				if(index < 0 ) {
					continue;
				}
				if(index >= list.size()) {
					continue;
				}
				list.remove(index);
			} else if(sel == 3) {
				list.print();
				System.out.println("enter insert index >>> ");
				int pos = sc.nextInt();
				System.out.println("enter insert number >>> ");
				int value = sc.nextInt();
				list.add(pos, value);
			} else if(sel == 4) {
				System.out.println("exit");
				break;
			}
		}
		sc.close();
	}
}
