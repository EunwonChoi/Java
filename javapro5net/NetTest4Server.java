import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class NetTest4Server {

	ServerSocket ss;
	Socket socket;
	PrintWriter out;
	BufferedReader reader;
	
	public NetTest4Server() {
		try {
			ss = new ServerSocket(7777);
		} catch (Exception e) {
			System.out.println("NetTest4Server err: " + e);
			return;
		}
		System.out.println("EcoServer start..");
		
		try {
			socket = ss.accept();   //통신을 받아들임
			
			out = new PrintWriter(socket.getOutputStream(), true);  //buffer가 자동적으로 깨끗해짐
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "euc-kr"));
		} catch (Exception e) {
			System.out.println("server err: " + e);
		}
	}
	
	public void receiveMsg() {
		try {
			String msg = reader.readLine();  //클라이언트로부터 넘어온 것을 받아둠
			System.out.println("receiveMsg: " + msg);
			
			out.println("from server: " + msg);
			reader.close();
			out.close();
			socket.close();
			ss.close();
		} catch (Exception e) {
			System.out.println("receiveMag err: " + e);
		}
	}
	
	public static void main(String[] args) {
		//무한루프로 서버가 계속 실행되게 함
		while(true) {
			NetTest4Server server = new NetTest4Server();
			server.receiveMsg();
		}
	}

}
