package pack5;

public class PolyProduct {  //가전제품의 부모(원형) 클래스
	private int volume = 0;
	
	public void volumeControl() {  //라디오와 tv의 소리 조절은 여기서 할 수 있지만 두 개가 똑같이 조절할 수는 없음
		//오버라이드를 기대		
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	
}
