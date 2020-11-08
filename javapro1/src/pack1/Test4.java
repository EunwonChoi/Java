package pack1;

public class Test4 {

	public static void main(String[] args) {
		//논리연산자 처리 시 주의사항
		
		boolean a = false, b = true, c;
		
		c = a || b;
		System.out.println(c);
		c = a && b;
		System.out.println(c);
		
		System.out.println("-------------------");
		//System.out.println(aa()); //aa를 불러옴
		boolean b1, b2;
		b1 = aa();
		System.out.println(b1);
		System.out.println(bb());
		
		System.out.println("주의할 점 -------------");
		//b2 = aa() || bb();  //aa를 수행하고 bb가 출력이 안됨
		b2 = bb() || aa(); //
		System.out.println(b2);
		
		System.out.println();
		b2 = aa() && bb(); //출력이 됨
		b2 = bb() && aa(); //bb만 출력이 됨
		System.out.println(b2);
		
		
		//여기서부터 기억해 주세요!!!
		System.out.println("~~~~~~");
		
		b2 = aa() | bb(); //모두 출력이 됨
		System.out.println("종료");
		
		System.out.println();
		b2 = bb() & aa(); //모두 수행이 됨(가장 중요)
		System.out.println(b2);
	}
	
	//void가 있으면 호출할 때 빈손으로 돌아간다는 뜻이고 void가 없으면 호출할 때 값을 가지고 돌아가라는 뜻임!!
	public static boolean aa() {
		System.out.println("aa 출력");
		return true;
	}
	
	public static boolean bb() {
		System.out.println("bb 수행");
		return false;
	}
}
