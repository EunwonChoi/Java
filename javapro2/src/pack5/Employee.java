package pack5;

public abstract class Employee {
	private String irum = "";
	private int nai = 0;
	
	abstract double pay();
	abstract void print(); 
	
	public Employee() {
		
	}
	
	public Employee(String irum, int nai) {
		this.irum = irum;
		this.nai = nai;
	}
	
	public String getIrum() {
		return irum;
	}
	
	public int getNai() {
		return nai;
	}
	
	public void display() {
		System.out.print("이름: " + getIrum() + ", 나이: " + getNai());
	}
	
}
