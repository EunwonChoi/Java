package pack2;

public class MyInterMain {

	public static void main(String[] args) {
		// 1. 인자가 없는 void 추상메소드 
		MyInterface inter = new MyInterface() {
			
			@Override
			public void abc() {
				System.out.println("일반적인 익명 클래스의 메소드 오버라이딩");
			}
		};
		inter.abc();
	
		// 1을 람다식으로 표현(새로운 문법임 /알아두세요!)
		MyInterface inter2 = () -> {
			System.out.println("일반적인 익명 클래스의 메소드 오버라이딩2");
			System.out.println("일반적인 익명 클래스의 메소드 오버라이딩 여러개");
		};
		inter2.abc();
		
		MyInterface inter3 = () -> System.out.println("일반적인 익명 클래스의 메소드 오버라이딩3");   //한개일 경우엔 중괄호 안해두 됨
		inter3.abc();
		
		System.out.println("----------------------------------------");
		
		// 2. 인자가 있는 void 추상메소드
		MyInterArg interArg = new MyInterArg() {
			
			@Override
			public void def(int a, int b) {
				System.out.println("두 수의 합은" + (a + b));
				
			}
		};
		interArg.def(4, 3);
		
		// 2를 람다식으로 표현
		MyInterArg interArg2 = (a, b) -> System.out.println("두 수의 합은" + (a + b));
		interArg2.def(4, 3);
		MyInterArg interArg3 = (a, b) -> System.out.println("두 수의 곱은" + (a * b));
		interArg3.def(4, 3);
		MyInterArg interArg4 = (a, b) ->{
			int c = a * b;
			System.out.println("두 수의 곱은" + c);
	};
		interArg4.def(4, 2);
		
		System.out.println("----------------------------------------");
		
		// 3. 반환값이 있는 추상메소드
		MyinterArgOther other = new MyinterArgOther() {
			
			@Override
			public int def(int a, int b) {
				return a + b;
			}
		};
		
		int result = other.def(3, 4);
		System.out.println("result: " + result);
		
		
		// 3을 람다식으로 표현
		MyinterArgOther other2 = (m, n) -> {return m + n;};
		int result2 = other2.def(3, 4);
		System.out.println("result2: " + result2);
		
		MyinterArgOther other3 = (m, n) ->  m + n;   //return 생략 가능, 중괄호 생략 가능\
		
		int result3 = other3.def(3, 4);
		System.out.println("result3: " + result3);
	}
	

}
