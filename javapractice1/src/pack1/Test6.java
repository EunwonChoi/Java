package pack1;

import java.lang.Exception;  //생략가능
import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) throws Exception {
		// 프로그램 진행 도중 외부에서 값을 얻기
		//System.out.println(args.length); //배열의 크기 : length
		if(args.length == 0) {
			System.out.println("외부에서 값 얻기 실패");
			System.exit(0);
		}
		System.out.println("외부에서 넘어온 값: "+ args[0] + " " + args[1]); //응용프로그램(cmd)에서 받아옴 + 이클립스에서 run as로 들어가도 똑같음
		
		System.out.println();
		
		System.out.println("키보드로 값 받기");
		
		/*
		System.out.print("문자 입력:");
		int mun = System.in.read(); //표준 입력장치로 문자(값) 얻기
		System.out.println("mun: " + mun + " " + (char)mun);
		*/
		
		//문자열 받기(값을 바꾸고 싶으면 scanner를 쓰세요)
		Scanner sc = new Scanner(System.in);  
		
		System.out.println("상품명 입력: ");  
		String product = sc.next(); //문자열 받을 때
		System.out.println("상품명은 " + product);
		
		System.out.println("가격 입력: ");
		int price = sc.nextInt(); //숫자 받을 때
		System.out.println("상품명은 " + price);
		
		System.out.println("프로그램 정상 종료");

	}

}
