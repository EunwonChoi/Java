package pack5;

public class GrandFa {
	private int nai = 80;
	public String gabo = "상감청자";
	//자식을 쓰겠다는 의사 표시(GrandFa는 자식을 가지겠다는 의미)
	//상속관계임
	//자기 자식에게만 public임 , 그 이외는 private임
	protected String gahun = "객체를 이해하자";   
	
	//생성자
	public GrandFa() {
		System.out.println("할아버지 생성자");
	}
	
	//오버로딩
	public GrandFa(int nai) {
		this();  //현재 클래스의 생성자를 부름(argument(인자)가 일치하는 GrandFa()를 부름) = 생성자 오버로딩하는 것이랑 비슷
		this.nai = nai;  //멤버를 부를 때 씀
		//this();  <- 여기 위치에는 적으면 안됨, 다른 생성자보다 먼저 호출해야 함
	}
	
	public String say() {
		return "할아버지 말씀 : 데이터 사이언티스트가 되거라";
	}
	
	public void eat() {
		System.out.println("밥은 맛있게");
	}
	
	public int getNai() {
		return nai;
	}
}
