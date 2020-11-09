import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class NetTest4Client {

	Socket socket;
	PrintWriter out;
	BufferedReader reader;

	public NetTest4Client() {
		try {
			socket = new Socket("192.168.0.63", 7777);
			
			out = new PrintWriter(socket.getOutputStream(), true);  //buffer가 자동적으로 깨끗해짐
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "euc-kr"));
		} catch (Exception e) {
			System.out.println("NetTest4Cient err: " + e);
		}
	}
	
	public void sendMsg() {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("서버로 전송할 메세지: ");
			String ss = scanner.nextLine();
			out.println(ss);   //서버로 데이터 전송
			
			String re_data = reader.readLine();
			System.out.println("수신자료: " + re_data);
		} catch (Exception e) {
			System.out.println("sdenMsg err: " + e);
		} finally {
			try {
				reader.close();
				out.close();
				socket.close();
			} catch (Exception e2) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		NetTest4Client client = new NetTest4Client();
		client.sendMsg();
	}

}
