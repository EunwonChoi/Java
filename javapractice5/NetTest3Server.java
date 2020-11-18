import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//서버환경임(일회용임)
//서버환경에서 실행시키고 클라이언트에서 들어가면 나옴
public class NetTest3Server {
	public static void main(String[] args) {
		// echo server
		ServerSocket ss =null;   //서버생성
		/*
		for (int i = 0; i < 65335; i++) {
			try {
				ss = new ServerSocket(i);
				ss.close();
			} catch (Exception e) {
				System.out.println(i + "번 포트 사용 중");
			}
		}
		System.out.println("확인 종료");
		*/
		
		

		Socket socket = null;  //통신할려고 socket을 하나 더 만듦
		try {
			ss = new ServerSocket(9999);
			System.out.println("서버 서비스 중...");
			socket = ss.accept();
			System.out.println("접속자 정보: " + socket.toString());
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String msg = reader.readLine();
			System.out.println("수신자료: " + msg);

			reader.close();
			socket.close();
			ss.close();
			System.out.println("서버 종료");
		} catch (Exception e) {
		System.out.println("server err: " + e);
		}

	}
}
