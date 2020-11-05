package pack1;

import java.util.Scanner;

public class Test7 {

	public static void main(String[] args) {
		// 조건판단문if
		int num = 2;
		if (num >= 3) {
			System.out.println("크군요");	
			System.out.println("참일 때"); 
		}
		
		num = 5;
		if(num < 3) {
			System.out.println("작군요");	
			System.out.println("참일 때"); 
		}else {
			System.out.println("크지 않아요");
		}
		
		System.out.println("------다중if------");
		int jumsu = 80;
		if(jumsu >= 70) {
			if(jumsu >= 90) {
				System.out.println("우수");
			}else {
				System.out.println("보통");
			}
		}else {
			if(jumsu >= 50) {
				System.out.println("조금 부족");
			}else {
				System.out.println("저조");
			}
		}
		
		
		System.out.println();
		int jum = 75;
		String re = "평가 결과: ";
		if(jum >= 90) {
			re += "수";
		}else if(jum >= 80) {
			re += "우";
		}else if(jum >= 70) {
			re += "미";
		}else if(jum >= 60) {
			re += "양";
		}else{
			re += "가";
		}
		System.out.println(re);
		
		
		System.out.println();
		System.out.println("문제풀이");
		System.out.println();
		//문) 키보드로 부터 상품명, 수량, 단가를 입력받아 각각 입력받아 금액(수량*단가)을 출력
		//조건: 금액이 5만원 이상이면 금액에 10%를 그 외는 금액에 5%를 세금으로 출력
		//출력 ==> 상품명:***   금액:***   세금:***
	
		
		Scanner sc = new Scanner(System.in);
		System.out.print("상품명: ");
		String product = sc.next();
		System.out.print("수량: ");
		int su = sc.nextInt();
		System.out.print("단가: ");
		int dan = sc.nextInt();
		
 		int price;
 		price = su*dan;
		
		if(price >= 50000) {
			System.out.println("상품명: " + product + " 금액: " + price + " 세금: " + price*0.1);
		}else {
			System.out.println("상품명: " + product + " 금액: " + price + " 세금: " + price*0.05);
		}
		
		
		
		System.out.println("종료");

	}
}
