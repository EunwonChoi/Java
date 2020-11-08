package pack5;

public class Regular extends Employee{
	private int salary = 0;
	
	//생성자
	public Regular() {
		
	}
	
	public Regular(String irum, int nai, int salary) {
		super(irum, nai);
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}
	
	@Override
	double pay() {
		return salary;
	}
	
	
	@Override
	void print() {
		super.display();
		System.out.println(", 급여: " + pay());
	}
}
