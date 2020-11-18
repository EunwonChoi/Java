package pack6;

//public interface InterVol2 {
public interface InterVol2 extends InterVol{  //추상 메소드가 총 4개가 됨(인터페이스는 인터페이스끼리 상속받을 수 있음)
	void volOff();
	void volResume();
}
