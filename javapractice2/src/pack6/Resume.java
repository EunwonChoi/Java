package pack6;

public interface Resume {
	String SIZE = "A4";  //public final static SIZE
	
	void setIrum(String irum);
	void setPhone(String phone);
	void print();
	
	default void playJava(boolean b) {
		if(b) {
			System.out.println("자바 프로그래밍 기능");
		}else {
			System.out.println("자바 불가능");
		}
	}
	
	static void changeData() {
		System.out.println("스테틱 메소드 처리 가능");
	}
}
