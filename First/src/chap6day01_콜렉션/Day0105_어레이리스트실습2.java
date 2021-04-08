package chap6day01_콜렉션;

import java.util.ArrayList;

class Tv {
	String name;
	String brand;
	int price;
	
	Tv(String name, String brand, int price) {
		this.name = name;
		this.brand = brand;
		this.price = price;
	}
}

public class Day0105_어레이리스트실습2 {

	public static void main(String[] args) {
		ArrayList<Tv> list = new ArrayList<>();
		
		Tv temp = new Tv("TV", "삼성", 1000);
		list.add(temp);
		
		temp = new Tv("시그니처TV", "엘지", 2000);
		list.add(temp);

		temp = new Tv("스마트TV", "애플", 3000);
		list.add(temp);

		for(int i=0; i<list.size(); i++) {
			temp = list.get(i);
			System.out.println(temp.name + " : " + temp.brand + " : " + temp.price);
		}
	}
}
