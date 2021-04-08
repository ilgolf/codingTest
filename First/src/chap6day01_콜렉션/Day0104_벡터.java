package chap6day01_Äİ·º¼Ç;

import java.util.Vector;

public class Day0104_º¤ÅÍ {
	public static void main(String[] args) {
		Vector<Integer> list = new Vector<>();
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		System.out.println(list);
		
		list.remove(3);
		System.out.println(list);
		
		int count = list.size();
		System.out.println("count = " + count);
		
		System.out.print("[");
		for(int i=0; i<count; i++) {
			System.out.print(list.get(i));
			if(i != count - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
		
		list.add(0, 9);
		System.out.println(list);
		
		list.set(3, 5);
		System.out.println(list);
		
		list.clear();
		System.out.println(list.size());
	}
}
