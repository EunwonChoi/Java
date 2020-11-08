package pack3;

//method overloading : 동일한 이름의 메소드를 여러 개 선언 가능(단, 조건 o)

public class Animal {
	private int leg = 4;
	private int age;
	private String name;
	public final static int MOUTH = 1;
	
	
	//엄청 중요해요!!(생성자 오버로딩이 더 중요)
	public Animal() {
		//생성자는 내용이 없을 경우 생략 가능. (컴파일러 만듦)		
	}
	
	public Animal(int leg) {  //생성자 오버로딩
		this.leg = leg;
	}
	
	public Animal(String irum) {  //생성자 오버로딩	
		name = irum;
	}
	
	//--------------------------------------------------
	
	
	public void display() {
		System.out.println("leg: " + leg + ", age: " + age + ", name: " + name);
	}
	
	public void display(int nai) {   //매소드 오버로딩 : 인자의 갯수 다름
		age = nai;  //age는 전역변수 nai는 지역변수
		System.out.println("leg: " + leg + ", age: " + age + ", name: " + name);
	}
	
//	public void display(int age) {   //매소드 오버로딩 : 인자의 갯수 다름
//		this.age = age;  //age는 전역변수 nai는 지역변수
//		System.out.println("leg: " + leg + ", age: " + age + ", name: " + name);
//	}
	
	public void display(String name) {   //매소드 오버로딩 : 인자의 type 다름
		this.name = name;  
		System.out.println("leg: " + leg + ", age: " + age + ", name: " + name);
	}
	
	public void display(String name, int nai) {   //매소드 오버로딩 : 인자의 갯수 다름
		this.name = name;
		age = nai;
		System.out.println("leg: " + leg + ", age: " + age + ", name: " + name);
	}
	
	public void display(int nai, String name) {   //매소드 오버로딩 : 인자의 갯수와 type 다름
		this.name = name;
		age = nai;
		System.out.println("leg: " + leg + ", age: " + age + ", name: " + name);
	}
}
