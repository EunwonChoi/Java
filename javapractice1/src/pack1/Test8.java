package pack1;

import java.util.Scanner;

public class Test8 {
	public static void main(String[] args) {
		//조건 판단문 switch
		int nai = 23;
		nai = nai/10 * 10;
		System.out.println(nai);
		
		
		switch(nai) {
		case 20:
			System.out.println("이십대");
			System.out.println("인생의 황금기");
			break; //여기서 멈춰라(기억!)
		case 30:
			System.out.println("삼십대");
			break;
		default:
			System.out.println("기타"); //default = else
			break; //마지막에는 break를 넣어줘도 되고 안넣어줘도 됨
		}
		
		
		System.out.println();
		
		String jik = "과장";
		switch(jik) {
		case "대리":
			System.out.println("난 대리");
			break;
		case "과장":
			System.out.println("난 과장");
			break;
		default:
			System.out.println("기타");
			break;
		}
		
		
		//해당 년 월의 날 수 출력
		//키보드로 년과 월을 입력받아 해당 년 월의 날 수 출력. 윤년 체크
		//윤년은 해당 년이 4의 배수이고 100의 배수가 아니거나 400의 배수이면 된다.
		
		System.out.println();
		int year, month, nalsu = 28;
		Scanner sc = new Scanner(System.in);
		System.out.println("년도 입력:");
		year = sc.nextInt();
		System.out.println("월 입력:");
		month = sc.nextInt();
		
		if(month < 1 || month > 12) {
			System.out.println("월은 1~12 사이만 허용");
			System.exit(1);  //1은 비정상적으로 끝낸다
		}
		
		if(year %4 == 0 && year %100 !=0 || year %400 == 0) {
			nalsu = 29;
		}
		
		switch(month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			nalsu = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			nalsu = 30;
			break;
		}
		
		System.out.println(year + "년" + month + "월" + "날수:" + nalsu);
		
	}
}
