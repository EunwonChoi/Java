package pack5;

public final class Me extends Father {   //final 때문에 상속 불가능
	public final int abc = 10;  //수정 불가
	
	
	public Me() {
		System.out.println("내 생성자!");
	}
	
	public void Biking() {
		System.out.println("자전거로 전국일주");
	}
	
//	@Override
//	public int getNai() {   //father에서 final을 걸어서 여기서는 getNai를 가져다 쓸 수 없음
//		return super.getNai();
//	}
//	
	@Override
	public String toString() {
		String ss = "자바 만세";
		return ss ;
	}
	
	//연습해보세요
//	public void showData{
//		// ..........
//	}
}
