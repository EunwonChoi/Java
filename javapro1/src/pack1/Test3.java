package pack1;

public class Test3 {

	public static void main(String[] args) {
		// 관계, 논리 연산자, 기타
		int a = 5;
		System.out.println(a > 3);
		System.out.println(a <= 3);
		System.out.println(a == 3);
		System.out.println(a != 3);
		
		System.out.println();
		int b = 10;
		System.out.println(a > 3 && b <= 10); //&&(and) : 논리곱(둘중에 하나가 틀리면 false)
		System.out.println(a >= 3 && b == 7); 
		
		System.out.println(a > 6 || b <= 10); //||(or) : 논리합(둘중에 하나가 맞으면 true)
		System.out.println(a > 7 || b < (5 + 10));
		
		System.out.println();
		int ii = 8, ij;
		//System.out.println(ii + " " + ij); //Exception in thread "main" java.lang.Error: Unresolved compilation problem: The local variable ij may not have been initialized
		System.out.println("ii: " + ii + " " + Integer.toBinaryString(ii)); 
		ij = ii << 1; //시프트 연산자(좌측으로 1bit가 옆으로 한칸씩 이동. 남은 우측은 0으로 채움)
		System.out.println("ij: " + ij);
		ij = ii >> 2; //시프트 연산자(우측으로 2bit가 옆으로 한칸씩 이동. 남은 좌측은 부호와 같은 값으로 채움)
		System.out.println("ij: " + ij);
		ij = ii >>> 2; //시프트 연산자(우측으로 2bit가 옆으로 한칸씩 이동. 남은 좌측은 0으로 채움)
		System.out.println("ij: " + ij);
		
		
		//삼항 연산자
		System.out.println();
		int re = (ii > 5)?100 : 50 + 20; //변수 = (조건)?참값:거짓값 <== 외우세요!(조건에 맞는 값이 출력됨)
		System.out.println("re: " + re );
		
		int x,y,z;
		x = y = z = 5;
		System.out.println(x + " " + y + " " + z);
		
		
		aa(); //method call(밑에서 스스로 출력되지 않으므로 부름)
		bb(7);
		
		System.out.println("프로그램 종료");
	}
	
	//기억해 두세요!
	public static void aa() { // 성격이 비슷한 명령문들을 모아놓은 집단 - method
		System.out.println("aa 메소드 수행");
		bb(12); //여기서 bb 부르는 것도 가능 
	}

	public static void bb(int mbc) { //mbc는 현재 기억장소 (argument) + mbc는 bb method 안에서만 유효함(local변수)
		System.out.println("bb 메소드 처리");
		System.out.println("mbc: " + mbc);
	}
}
