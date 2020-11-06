package pack3;

public class MySingleton {
	int kor = 10;
	//...
	
	private static MySingleton singleton = new MySingleton();  //자기 스스로가 new로 생성
	
	//static 멤버를 불러와야 하므로 static을 씀
	public static MySingleton getInstance() {
		return singleton;
	}
}
