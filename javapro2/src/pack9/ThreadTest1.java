package pack9;

//동시에 순차척으로 수행
//완전 동시 수행은 아님
//잘못해서 무한 루프 돌리면 안죽을 수도 있음

public class ThreadTest1 extends Thread{  //extends Thread
	public ThreadTest1() {

	}
	
	public ThreadTest1(String name) {
		//super(name);
	}
	
	@Override
	public void run() {
		for(int i = 0; i <= 50; i++) {
			//System.out.println(i + " ");
			System.out.println(i  + "(" + super.getName() + ")");
			try {
				//Thread.sleep(100);				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public static void main(String[] args) {
		//메인(demon) 스레드에 의해 main() 수행
		try {
			//process 단위 수행
			//Process p1 = Runtime.getRuntime().exec("calc.exe");
			//Process p2 = Runtime.getRuntime().exec("notepad.exe");

			//thread로 메인 메소드 단위 수행
			/*
			ThreadTest1 t1 = new ThreadTest1();
			ThreadTest1 t2 = new ThreadTest1();
			t1.run();
			System.out.println();
			t2.run();
			*/
			
			//ThreadTest1 t1 = new ThreadTest1();
			//ThreadTest1 t2 = new ThreadTest1();
			ThreadTest1 t1 = new ThreadTest1("일");
			ThreadTest1 t2 = new ThreadTest1("둘");
			t1.start();
			t2.start();
			t2.setPriority(MAX_PRIORITY);   //t2에게 우선순위 요청(확률적임)
			t1.join();   //사용자 스레드가 종료될때까지 메인 스레드를 대기
			t2.join();
			
			System.out.println("프로그램 종료");
		} catch (Exception e) {
			System.out.println("err: " + e);
		}
	}

}
