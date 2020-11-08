package pack5;

public class Temporary extends Employee{
	private int ilsu = 0;
	private int ildang = 0;
	
	//생성자
	public Temporary(String irum, int nai, int ilsu, int ildang) {
		super(irum, nai);
		this.ilsu = ilsu;
		this.ildang = ildang;
	}

	@Override
	double pay() {
		return ilsu*ildang;
	}
	
	
	@Override
	void print() {
		super.display();
		System.out.println(", 월급: " + pay());
	}
}
