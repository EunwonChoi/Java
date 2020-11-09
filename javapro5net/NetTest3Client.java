import java.io.PrintWriter;
import java.net.Socket;

public class NetTest3Client {
	//client
	//서버가 켜지면 클라이언트가 들어가서 실행하게 됨
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("192.168.0.63", 9999);   //내 주소와 소켓번호
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);   //글 작성
			out.println("Hi I'm tom" + "\n");
			
			out.close();
			socket.close();
		} catch (Exception e) {
			System.out.println("client err :" + e);
		}

	}

}
