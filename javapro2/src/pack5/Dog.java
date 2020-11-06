package pack5;

public class Dog {  //개과의 동물들이 가져야할 기본 멤버
	private String name = "개";
	
	public Dog() {
		// TODO Auto-generated constructor stub
	}
	
	public Dog(String name) { 
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String callName() {
		return "종류: " + name;
	}
	
	public void print() {
		System.out.println(name + " : 한국에 살고 있다");
	}

}
