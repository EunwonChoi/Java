package pack2;

public class Mylamdba {
	static class Inner implements HelloIInter{
		@Override
		public int addData(int a, int b) {
			// TODO Auto-generated method stub
			return a + b;
		}
	}
	
	public static void main(String[] args) {
		Inner inner = new Inner();    //전통적 방법
		System.out.println(inner.addData(3, 4));

		//인터페이스 변수 ==> 람다식(익명 메소드)
		HelloIInter hinter = (x, y) -> x + y;    //오버라이딩 한것임
		System.out.println(hinter.addData(3, 4));
		
		HelloIInter hinter2 = (x, y) -> x * y;   //오버라이딩 한것임
		System.out.println(hinter2.addData(3, 4));
	}

}
