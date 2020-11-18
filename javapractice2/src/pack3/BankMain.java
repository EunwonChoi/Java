package pack3;

import java.lang.System;  //이거는 굳이 안해도 됨(생략가능) 대신 이거 이외에는 import 해야함
//bank 타입: tom,,,
//string 타입: ss1,,,

public class BankMain {
	public static void main(String[] args) {
		// 뭔가를 하다가...
		
		System.out.println("-------tom고객-------");
		Bank tom = new Bank();
		tom.dePosit(5000);
		tom.withDraw(3000);
		System.out.println("tom의 잔고: " + tom.getMoney());
		
		System.out.println("------oscar고객-------");
		Bank oscar = new Bank(3000);
		oscar.dePosit(1000);
		oscar.withDraw(7000);
		oscar.withDraw(4000);
		System.out.println("oscar의 잔고: " + oscar.getMoney());
		
		System.out.println("-------------주소 관련 -------------");
		//기억해두세요..!
		System.out.println("tom 주소: " + tom);
		System.out.println("oscar 주소: "+ oscar.toString());    //toString으로 주소 찍어내는건 똑같음 + hex로 보여줌
		System.out.println("oscar 주소: "+ oscar.hashCode());    //decimal로 보여줌
		
		System.out.println("--------james고객--------");
		Bank james = null;  //아무것도 참조하고 있지 않음
		System.out.println("james 주소: " + james);
		//james.dePosit(2000);   // java.lang.NullPointerException
		
		//참조형도 치환할 수 있음!
		james = oscar;  //james 변수에 oscar 변수를 넣음(중요!!)
		System.out.println("james 주소: " + james);  //james의 주소와 oscar의 주소가 같음(하나의 object을 여러 객체가 참조할 수 있음!!)
		james.dePosit(2000);
		System.out.println("oscar의 잔고: " + oscar.getMoney());
		System.out.println("james의 잔고: " + james.getMoney());
		//oscar = null;  //oscar에 null값을 넣어도 인스턴스 값은 살아있음(그리고 james가 이미 oscar를 참조하고 있기 때문에 같음)
		
		System.out.println("------------------");
		if(james == oscar)
			System.out.println("둘은 같은 객체 주소 참조");
		else
			System.out.println("달라요");
		
		if(james == tom)
			System.out.println("둘은 같은 객체 주소 참조2");
		else
			System.out.println("달라요2");
	
		//엄청 중요해요!!!
		//string값을 넣어서 문자열을 쓸 수 있도록 함(참조형)
		//기본형에서 비교는 == 씀
		System.out.println("-------------String 클래스 타입값 비교----------");
		String ss1 = "kor";  //kor은 object임(ss1과 ss2에서 kor자체가 객체임)
		String ss2 = new String();
		ss2 = "kor";
		String ss3 = new String("kor");
		System.out.println(ss1 + " " + ss2 + " " + ss3);
		
		//값 비교X , 주소비교임
		if(ss1 == ss2)
			System.out.println("같음1");
		else
			System.out.println("다름1");
		
		if(ss1 == ss3)
			System.out.println("같음2");
		else
			System.out.println("다름2");
		
		if(ss2 == ss3)
			System.out.println("같음3");
		else
			System.out.println("다름3");
		
		System.out.println(ss1.hashCode() + " " + ss3.hashCode() + " " + ss3.hashCode());
		
		//문자열 비교용 메소드 equals() : String 객체의 값을 비교
		if(ss1.contentEquals(ss2))
			System.out.println("같음1");
		else
			System.out.println("다름1");
		
		if(ss1.equals(ss3))   
			System.out.println("같음2");
		else
			System.out.println("다름2");
		
		if(ss2.equalsIgnoreCase(ss3))   //영문자 대소 구분을 안하고 싶을 때 equalsIgnoreCase를 씀
			System.out.println("같음3");
		else
			System.out.println("다름3");
		
		
		System.out.println("---------------배열 관련-------------");
		//배열도 별도의 주소를 가지고 있음
		int ar1[] = {1,2,3};
		System.out.println(ar1); //주소
		System.out.println(ar1[0] + " " + ar1[1]);  //데이터
		int[][] ar2 = {{1,2,3}, {4,5,6}};
		System.out.println(ar2); //주소를 가짐
		System.out.println(ar2[0]);  //주소를 가짐
		System.out.println(ar2[0][0]);  //데이터를 가짐
		
	}

}
