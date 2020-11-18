package pack5;

public class JepumMain {
	public static void main(String[] args) {
		// 추상 메소드를 가지고 있으므로 new를 쓸 수 없음
		//Jepum jepum = new Jepum();
		Jepum jepum = null;
		
		Jepum_Tv tv = new Jepum_Tv();
		jepum = tv;
		jepum.volumeControl();
		
		System.out.println();
		Jepum_Radio radio = new Jepum_Radio();
		jepum = radio;
		jepum.volumeControl(); 
	}

}
