package pack1;

import java.math.BigDecimal;

public class Test5 {

	public static void main(String[] args) {
		// BigDecimal
		// 수치를 정밀하게 표현해준다.
		// 가장 큰 double도 소수점의 표현의 한계가 있다.
		
		// double 사용 시
		//double a = 1.5;
		//double b = 1.4;
		double a = 2.0;
		double b = 1.1;
		System.out.println(a+b);
		System.out.println(a-b); //0.9가 나오지 않고 0.899999로 나옴
		
		// BigDecimal 사용 시
		System.out.println();
		BigDecimal d1 = new BigDecimal("2.0"); //class를 만들 때
		BigDecimal d2 = new BigDecimal("1.1"); //class인 bigdecimal을 만들어 해결!
		System.out.println(d1.add(d2));
		System.out.println(d1.subtract(d2));

		System.out.println();
		//long aa = 1234567891234567890L;
		BigDecimal no1 = new BigDecimal("123456789123456789");
		BigDecimal no2 = new BigDecimal("123456789123456789");
		System.out.println(no1.add(no2));
	}

}
