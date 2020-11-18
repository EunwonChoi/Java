package pack3;

public class MySingletonMain {
	public static void main(String[] args) {
		// 객체를 new 하더라도 매번 객체가 만들어지지 않도록 할 경우 싱글톤 패턴을 이용한다.
		
		//이렇게 하면 서버는 과부하...
		MySingleton s1 = new MySingleton();
		MySingleton s2 = new MySingleton();
		System.out.println(s1 + " " + s2);  //주소가 다름
		s1.kor = 80;
		s2.kor = 100;
		System.out.println(s1.kor + " " + s2.kor);  //같은 클래스지만 다른 객체임
		
		
		//new를 사용하지 않고 불러옴
		//서버 과부하가 걸리지 않음
		System.out.println("---------싱글톤 사용시-----------");
		MySingleton s3 = MySingleton.getInstance();
		MySingleton s4 = MySingleton.getInstance();
		System.out.println(s3 + " " + s4);  //주소가 같음(같은 object 참조)
		s3.kor = 88;
		System.out.println(s3.kor + " " + s4.kor);  //같은 클래스의 같은 객체
	}

}
