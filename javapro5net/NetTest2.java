import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

//서로간 데이터를 주고받을 수 있다.
//웹 페이지의 도메인 네임을 읽어옴

public class NetTest2 {
	public static void main(String[] args) {
		try {
			InetAddress ia = InetAddress.getByName("www.daum.net");
			Socket socket = new Socket(ia, 80);
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
			out.println("GET https://www.daum.net");
			out.flush();
			
			//web server로부터 전송된 문서 출력
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while(true) {
				String ss = reader.readLine();
				if(ss == null) break;
				System.out.println(ss);
			}
			
			reader.close();
			out.close();
			socket.close();
			
		} catch (Exception e) {
			System.out.println("err: " + e);
		}
	}
}
