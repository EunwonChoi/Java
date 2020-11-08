package pack5;

public class Salesman extends Regular {
	private int sales = 0;
	private double commission = 0;
	
	public Salesman() {
		
	}
	
	public Salesman(String irum, int nai, int salary, int sales, double commission) {
		super(irum, nai, salary);
		this.sales = sales;
		this.commission = commission;
	}
	
	@Override
	double pay() {
		return getSalary() + sales*commission;
	}
	
	@Override
	void print() {
		super.display();
		System.out.println(", 수령액: " + pay());
	}
}
