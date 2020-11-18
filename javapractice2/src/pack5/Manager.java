package pack5;

public class Manager extends Regular{
	private int incentive = 0;
	
	//생성자
	public Manager() {
			
	}

	public Manager(String irum, int nai, int salary) {
		super(irum, nai, salary);
	}
	
	@Override
	double pay() {
		incentive = getSalary();
		
		if(incentive >= 2500000) {
			return getSalary() + (incentive * 0.6);
		}else if(incentive >= 2000000 && incentive < 2500000) {
			return getSalary() + (incentive * 0.5);
		}else
			return getSalary() + (incentive * 0.4);
	}

	@Override
	void print() {
		super.display();
		System.out.println(", 수령액: " + pay());
	}
	
}
