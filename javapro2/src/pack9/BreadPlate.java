package pack9;

public class BreadPlate {
	private int breadCount = 0;   //공유자원
	
	public BreadPlate() {
		
	}
	
	public synchronized void makeBread() {
		if(breadCount >= 10) {
			try {
				System.out.println("빵 샌산 초과");
				wait();   //Thread를 비활성화
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		breadCount++;   //빵 생산
		System.out.println("빵 생산 후 갯수: " + breadCount + "개");
		notify();   //Thread 활성화(wait가 해제 되도록함)
	}
	
	public synchronized void eatBread() {
		if(breadCount < 1) {
			try {
				System.out.println("빵이 없어 대기");
				wait();   //Thread를 비활성화
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		breadCount--;   //빵 소비
		System.out.println("빵 소비 후: " + breadCount + "개");
		notify();   //Thread 활성화(wait가 해제 되도록함)
	}
}
