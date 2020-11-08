package pack5;

//단일 상속임
//여기서 따로 메소드를 지정해 주지 않으면 자동적으로 부모의 내용이 나옴
public class Father extends GrandFa{   //부모와 자식 형성 - super/parent/조상/자식/sub/chlid
	private int nai = 55;
	private int house = 1;   //현재 클래스의 고유 멤버(부모와 상관없음)
	public String gabo = "꽃병";   //은닉화(자식이 나타내면 부모의 내용은 안보이게 됨)
	protected String gahun = "다형성을 이해하자";   
	
	
	public Father() {
		//argument에 의해 선택적으로 호출
		//안에 숫자만큼 argument 갯수랑 맞는거 부름
		super();   //부모 생성자 호출(지금 굳이 여기서 안써도 됨)
		System.out.println("아버지 생성자랍니다");
	}
	
	@Override   //annotation : 부모 메소드와 동일해야 함을 강요
	public final int getNai() {  //부모 메소드와 동일한 메소드를 선언 : 메소드 오버라이드(method override)
		//return nai;    //위 아래는 같음  //final 때문에 하위 클래스에서는 오버라이딩 불가
		return this.nai;
	}
	
	@Override
	public String say() {
		//return super.say();  //할아버지의 say를 찾아가서 바꾸게됨
		return "자바 프로그래머 전문가가 되자";
	}
	
	public void showData() {
		//나에게 내용이 있으면 내것을 출력하고 만약 없으면 부모의 내용을 출력함
		String gabo = "컴퓨터";  //지역변수
		System.out.println("gabo: " + gabo);   
		System.out.println("gabo: " + this.gabo);   
		System.out.println("gabo: " + super.gabo);  
		System.out.println("nai: " + getNai());  
		System.out.println("nai: " + this.getNai());  
		System.out.println("nai: " + super.getNai()); 
		eat();
		this.eat();
		super.eat();
	}
}
