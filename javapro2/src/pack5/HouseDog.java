package pack5;

public class HouseDog extends Dog {
	private String where = "집";
	
	public HouseDog(String name) {
		super(name);
	}
	
	public void show() {
		System.out.println("거주: " + where + "안");
	}
	
	@Override  //부모가 가진 것을 자기도 가지고 있음
	public void print() {
		System.out.println(getName() + "는(은) " + where + "에 살고 있다");
	}
}

