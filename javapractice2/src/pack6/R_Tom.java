package pack6;

public class R_Tom implements Resume{
	private String irum, phone, juso;
	
	public R_Tom() {
		
	}
	
	@Override
	public void setIrum(String irum) {
		this.irum = irum;
	}
	
	@Override
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setJuso(String juso) {
		this.juso = juso;
	}
	
	public void print() {
		//Resume.SIZE = "b5";   //final
		System.out.println("이력서 용지 규격은 " + Resume.SIZE);
		System.out.println("이름: " + irum + ", 전화:" + phone + ", 주소: " + juso);
		playJava(true);
		Resume.changeData();
	}
	
	void abc() {
		System.out.println("톰의 고유 메소드");
		//Resume.changeData();
		//playJava(true);
	}
}
