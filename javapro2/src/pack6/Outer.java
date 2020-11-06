package pack6;

//내부 클래스 : 클래스의 내에 클래스를 선언
public class Outer {
	private int a;
	private Inner inner;  //이 클래스 안에서 inner클래스 호출(main에서는 부르지 않음)
	
	public Outer() {
		System.out.println("Outer 생성자 ");
		a = 10;
		inner = new Inner();  //inner 클래스 호출
	}
	
	public void aa() {
		System.out.println("Outer:aa 메소드");
		bb();
		inner.cc();
		System.out.println("Outer의 a는 " + a + "Inner의 b는 " + inner.b);
	}
	
	private void bb() {
		System.out.println("Outer:bb 메소드");
	}
	
	
	//내부 클래스
	class Inner {
		private int b;
		
		public Inner() {
			System.out.println("Inner 생성자");
			b = 20;
		}
		
		public void cc() {
			System.out.println("Inner - cc method");
			System.out.println("Inner: " + b + ", Outer: " + a);  //a는 outer의 a
			bb();   //outer의 bb
		}
		
		//내부클래스 내에 내부 클래스 선언(이렇게는 잘 안함)
		class InnerInner{
			
		}
	}
	//--------------------------------
	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.aa();
		System.out.println();
		
		//여기서 호출하는 것은 권장하지 않음
		//Inner inner = new Inner();  //x
		//Outer.Inner inner = outer.new Inner();  //클래스 안에 있는 클래스는 그 클래스 안에서만 가능 o
		//inner.cc();
	}
}
