package pack3;

public class Callby2 {
	public void ex(int a, int b) {  //인자로 기본형 변수 사용
		int imsi = a;
		a = b;
		b = imsi;
		System.out.println("메소드 내의 a: " + a + ",b: " + b);
	}
	
	//메소드 오버로딩
	public void ex(Callby1 data) {  //인자로 참조형 변수 사용
		int imsi = data.a;
		data.a = data.b;
		data.b = imsi;
		System.out.println("메소드 내의 a: " + data.a + ",b: " + data.b);
	}
	
	//메소드 오버로딩
	public void ex(int[] ar) {  //인자로 참조형 변수 사용
		int imsi = ar[0];
		ar[0] = ar[1];
		ar[1] = imsi;
	}
}
