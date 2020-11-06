package pack5;

public class WolfDog extends Dog{
	private String where = "산";
	
	public WolfDog(String name) {
		super(name);
	}
	
	public WolfDog(String name, String where) {
		super(name);
		this.where = where;
	}
	
	public void show() {
		System.out.println("거주(wolf): " + where + "속");
	}
	
	@Override  //부모가 가진 것을 자기도 가지고 있음
	public void print() {
		System.out.println(getName() + "는(은) " + where + "에 살고 있다?");
	}
	
	public void display() {
		print();  //현재 클래스!
		this.print();  //현재 클래스에 있을지 없을지..
		super.print();  //무조건 부모 클래스에 있어...
	}
}
