package pack1;

public class Test1 {
	public static void main(String ar[]) {
		System.out.println("성공");
		System.out.println(10 + 20); // 한 줄 주석
		/*
		 * 여러 줄 주석
		 */
		System.out.println("a");  
		System.out.print("b");
		System.out.println("c");
		
		//변수 : 기억장소의 이름 - 기본형
		//**첫글자가 대문자면 무조건 class임
		//byte var1;  // 타입 선언
		//var1 = 10;  // 변수 선언
		
		byte var1 = 10;  // 1byte 정수 기억 -128 ~ 127의 정수를 기억
		var1 = 20;  // 10이 없어지고 20이 덮어 씀 + 만약에 127초과의 수를 쓰면 에러남
		System.out.println(var1);
		System.out.println(Byte.MAX_VALUE); // byte의 가장 큰 값
		System.out.println(Byte.MIN_VALUE); // byte의 가장 작은 값
		
		short var2 = 20;  //2byte 정수 기억 -32768 ~ 32767의 정수를 기억
		System.out.println("var2 : " + var2);  //문자열로 출력됨(숫자가 문자열로 됨)
		
		//무조건 java에서 int만 쓰셔요(기본임!!)
		int var3 = 20;  //4byte 정수 기억 -2147483648 ~ 2147483647
		System.out.println("var3 : " + var3);
		
		long var4 = 3147483647L;  //8byte 정수 기억(뒤에 L붙임)
		System.out.println(Long.MAX_VALUE);
		System.out.println("var4 : " + var4);
		
		//**(기억해두세요)promotion: 자동 형변환, cast: 강제 형변환
		//byte b1 = 12; // promotion
		byte b1 = (byte)128;  // cast 
		System.out.println("b1 : " + b1);
		
		int b2 = 10;
		byte b3 = (byte)b2;  // cast(int가 byte형으로 바뀜)
		System.out.println("b3 : " + b3);
		
		short s1 = 10;
		int i1 = s1;  // promotion(short가 int형으로 바뀜)
		System.out.println("i1 : " + i1);
		
		//System.out.println();
		System.out.println("\n실수처리 -------");  // \n 이스케이프 문자 문 하나
		//double이 가장 기본!
		double d1 = 10.5;  //8byte
		d1 = 5; // 정수가 실수로 바뀜(promotion)
		System.out.println("d1 : " + d1);
		
		float f1 = (float)4.5; //4byte(cast)
		f1 = 5.1F; // F를 붙임
		System.out.println("f1 : "+ f1);
		
		int i2 = (int)3.5; // 소수 이하는 버림
		System.out.println("i2 : " + i2); 
		
		double d2 = 4.5 + 10; // 연산 시 큰 타입으로 자동 형변환됨
		System.out.println("d2 : "+ d2);
		
		int i3 = (int)4.5 + 10; 
		System.out.println("i3 : "+ i3);
		
		System.out.println();
		boolean bu1 = true;
		bu1 = false;
		System.out.println("bu1 : " + bu1);
		
		System.out.println();
		char c1 = 'a'; // 무조건 작은따옴표(큰 따옴표는  string)
		char c2 = 'A';
		//char c2 ='ab'; //이건 안됨
		System.out.println("c1 : " + c1 + " " + (int)c1 + " " + (char)97);  //ascii 코드표 확인(코드표 외우세요...)
		System.out.println(c2);
		// ***(외우세요)A=65 ~ Z 와 0~9 와 LF=10, CR=13은 자동으로 enter임
		
		System.out.println("안녕" + "\n" + "반가워");
		System.out.println("안녕" + (char)10 + "반가워"); //char가 enter가 됨
		System.out.println("안녕" + (char)13 + "반가워"); //char가 enter가 됨
		
		System.out.println(0xa); // 16진수임(10)
		System.out.println(0xf); // 16진수임(15)
		System.out.println(05);  // 8진수임(5)
		System.out.println(052); // 8진수임(42)
		
		
		
		
		
		//참조형(string은 기본형이 아님)
		String irum = "홍길동";  //String은 class임(직접 들어가지 않고 주소를 가지고 참조를 하여 들어가짐)
		System.out.println(irum);
	}
}
