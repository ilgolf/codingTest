package chap6day01_�ݷ���;

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

public class Day0105_��̸���Ʈ�ǽ�2 {

	public static void main(String[] args) {
		ArrayList<Tv> list = new ArrayList<>();
		
		Tv temp = new Tv("TV", "�Ｚ", 1000);
		list.add(temp);
		
		temp = new Tv("�ñ״�óTV", "����", 2000);
		list.add(temp);

		temp = new Tv("����ƮTV", "����", 3000);
		list.add(temp);

		for(int i=0; i<list.size(); i++) {
			temp = list.get(i);
			System.out.println(temp.name + " : " + temp.brand + " : " + temp.price);
		}
	}
}
