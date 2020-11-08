package pack8;

import java.util.ArrayList;
import java.util.Scanner;

//문제연습

public class StudMain {
	ArrayList<StudDto> list = new ArrayList<StudDto>();
	
	public void insertData() {
		StudDto dto = null;
		
		int sum = 0;
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			dto = new StudDto();
			System.out.println("이름입력: ");
			String i = sc.next();
			dto.setIrum(i);
			System.out.println("국어점수: ");
			int k = sc.nextInt();
			dto.setKor(k);
			System.out.println("영어점수: ");
			int e = sc.nextInt();
			dto.setEng(e);
			list.add(dto);
			System.out.println("계속할까요?(y=1/n=2)");
			int a = sc.nextInt();
			if(a == 1) {
				System.out.println();
			}else {
				break;
			}
		}
	}
		
	public void ShowData() {
		System.out.println("이름  " + "국어  " + "영어  " + "총점");
		for (int i = 0; i < list.size(); i++) {
			StudDto dto = new StudDto();   //record타입으로 저장하고 받음
			dto = list.get(i);  
			System.out.println(dto.getIrum() + "  " + dto.getKor() + "  " + dto.getEng() + "  " + (dto.getKor()+dto.getEng()) );
		}
		System.out.println("응시인원: " + list.size() + "명");
	}
	
	
	
	
	public static void main(String[] args) {
		StudMain test = new StudMain();
		test.insertData();
		test.ShowData();
	}

}
