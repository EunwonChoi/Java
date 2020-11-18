package pack7;

public class A {   //바깥쪽 클래스
	int field1;
	
	public A(){
		System.out.println("A 생성자");
	}
	
	void method1() {
		System.out.println("method1 수행: " + field1);
	}
	
	class B{   //인스턴스 멤버 클래스
		int field2;
		public B() {
			System.out.println("B객체 생성자");
		}
		void method2() {
			System.out.println("method2 수행: " + field2);
		}
	}
	
	static class C{  //정적 멤버 클래스 
		int field3;
		
		public C() {
			System.out.println("c 정적 객체 생성자");
		}
		
		void method3() {
			System.out.println("method3 수행: " + field3);
		}
	}
	
	void a_method4() {  //a클래스의 메소드
		System.out.println("a_method4가 진행");
		class D{   //local method
			int field4;
			
			public D() {
				System.out.println("D 생성자");
			}
			
			void method4() {
				System.out.println("method 수행: " + field4);
			}
		}
		
		D d = new D();
		d.field4 = 4;
		d.method4();
	}
	
	

	
	//허용범위------------
	B b2 = new B();
	C c2 = new C();
	//D d2 = new D();  //메소드 안에 있기 때문에 불가
	
	void test1() {
		B b3 = new B();
		C c3 = new C();
	}
	
	static C c4 = new C(); 
	static void test2(){
		//B b4 = new B();  //불가능함(static 메소드는 static만 처리함)
		C c5 = new C();
	}
	
	public static void main(String[] args) {
		A a = new A();
		a.field1 = 1;
		a.method1();
		
		System.out.println("인스턴트 멤버 클래스----------");
		A.B b = a.new B();
		b.field2 = 2;
		b.method2();
		
		System.out.println("정적 인스턴스 멤버 클래스------------");
		A.C c = new A.C();
		c.field3 = 3;
		c.method3();
		C c2 = new C();
		c2.field3 =4;
		c2.method3();
		
		System.out.println("로컬 클래스 멤버---------------");
		a.a_method4();
		
		System.out.println();
		a.test1();
		a.test2();
		A.test2();  //직접 A라고 쓰기를 권장함 (static안에 있어서 굳이 따로 변수를 만들지 않고 그대로 가져다 씀)
	}
	
}
