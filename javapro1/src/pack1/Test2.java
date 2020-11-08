package pack1;

public class Test2 {

	public static void main(String[] args) {
		//연산자
		//우선순위 : ( ) > 산술(*,/ > +,-) > 관계 > 논리 > =(치환)
		
		int a = 5; //치환
		int b = 3;
		int c = a + b;
		
		//산술 연산자
		System.out.println(a+b);
		System.out.println(a/b); //몫
		System.out.println(a%b); //나머지
		System.out.println(a/(double)b); //실수로 만들어서 몫과 나머지를 나타냄
		//System.out.println(a/0); //error //강제 종료
		System.out.println(a/0.0); //infinity //프로그램 계속 진행
		System.out.println(a%0.0); //NaN(Not a Number)
		System.out.println(0/0.0); //NaN
		
		System.out.println(3+4*5);
		System.out.println((3+4)*5);
		
		System.out.println();
		String ss1="대한";
		String ss2="민국";
		String ss3=ss1 + ss2;
		System.out.println("ss3 " + ss3);
		System.out.println("ss3 " + ss3 + "2010"); //2010은 문자열
		System.out.println("ss3 " + ss3 + 2010); //2010은 문자열로 자동으로 바꿈
		System.out.println("ss3 " + ss3 + Integer.toString(2010)); //강제로 문자열로
		
		System.out.println(10 + 20);
		System.out.println(10 + "20"); //문자열로
		System.out.println(10 + Integer.parseInt("20")); //강제로 숫자열로
		
		
		//누적
		System.out.println();
		int no = 1;
		no = no + 1;
		no += 1; //이거를 가장 많이 씀(중요!)
		no++; //증감 연산자(1씩 더함)
		++no; //후위증감 연산자(1씩 더함)
		System.out.println("no: " + no);
		
		//증감 연산자(!소스 읽기 힘드므로 다른 연산자랑 쓰지 않고 독단적으로만 사용하도록 하라!)
		int imsi = 5;
		int result = ++imsi + 1;
		System.out.println(imsi + " " + result);
		
		int imsi2 = 5;
		int result2 = imsi2++ + 1;
		System.out.println(imsi2 + " " + result2); //후위증감연산자는 먼저 변수에 값을 주고 후에 더해줌
		
		
		//부호
		int imsi3 = 3;
		System.out.println(imsi3); //양수
		System.out.println(-imsi3); //음수로 바뀜
		System.out.println(-imsi3 * -1); //음수였던게 다시 양수로 바뀜(부호 바뀜)
		
		
		//System.exit(0); //응용 프로그램 강제 종료
		System.out.println("프로그램 종료");
	}

}
