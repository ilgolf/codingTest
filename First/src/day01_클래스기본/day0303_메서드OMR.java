package day01_Ŭ�����⺻;

import java.util.Random;

class OMR {
	Random ran = new Random();
	
	int[] omr = {1, 4, 3, 2, 2};		// ������
	int[] me = new int[5];				// �л����
	
	int cnt = 0;						// ���� ���� ����
	int score = 0;						// ����
	
	void dataSetting() {
		for(int i=0; i<me.length; i++) {
			int r = ran.nextInt(5) + 1;
			
			me[i] = r;
		}
	}
	
	void printOMR() {
		System.out.print("OMR = { ");
		for(int i=0; i<omr.length; i++) {
			System.out.print(omr[i] + " ");
		}
		System.out.println("}");
	}
	
	void printMe() {
		System.out.print("ME = { ");
		for(int i=0; i<me.length; i++) {
			System.out.print(me[i] + " ");
		}
		System.out.println("}");
	}
	
	void printChart() {
		System.out.print("����ǥ = { ");
		for(int i=0; i<omr.length; i++) {
			if(omr[i] == me[i]) {
				System.out.print("O ");
				cnt ++;
			}
			else if(omr[i] != me[i]) {
				System.out.print("X ");
			}
		}
		System.out.println("}");
		
		score = cnt*20;
		
		System.out.println("���� = " + score);
	}
}

public class day0303_�޼���OMR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OMR o = new OMR();
		
		o.dataSetting();
		o.printOMR();
		o.printMe();
		o.printChart();
	}

}
