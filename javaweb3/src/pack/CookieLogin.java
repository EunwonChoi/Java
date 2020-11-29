package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CookieLogin")
public class CookieLogin extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8 ");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		//쿠키 읽기(쿠키가 있을 때)
		String id = null;
		String pwd = null;
		try {
			Cookie[] cookies = request.getCookies();    //클라이언트의 모든 쿠키 읽음
			for (int i = 0; i < cookies.length; i++) {
				String name = cookies[i].getName();
				System.out.println("name: " + name);
				//encoder 한것을 decoder로 읽음(id와 pwd를 채움)
				if(name.equals("id")) {
					id = URLDecoder.decode(cookies[i].getValue(), "utf-8");
				}
				if(name.equals("pwd")) {
					pwd = URLDecoder.decode(cookies[i].getValue(), "utf-8");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(id != null && pwd != null) {
			out.println(id + "님 쿠키를 통해 로그인한 상태입니다." );
			out.println("</html></body>");
			out.close();
			return; 
		}
		
		
		
		//쿠키가 없으면 로그인 화면 출력
		out.println("** 로그인 **");
		out.println("<form method='post'>");   //자기 자신에게 post방식으로 불러옴
		out.println("id: <input type = 'text' name='id'><br>");
		out.println("pwd: <input type = 'text' name='pwd'><br>");
		out.println("<input type = 'submit' value='전송'><br>");
		out.println("</form>");
		out.println("</html></body>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		//System.out.println(id + " " + pwd);
	
		response.setContentType("text/html;charset=utf-8 ");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		if(id.equals("aa") && pwd.equals("11")){
			try {
				//쿠키를 만들어줌
				id = URLEncoder.encode(id, "utf-8");  //암호화
				Cookie idCookie = new Cookie("id", id);    //cookie에 id를 담아둠
				idCookie.setMaxAge(60 * 60 * 24 * 365);    //쿠기가 1년간 유효함
				
				pwd = URLEncoder.encode(pwd, "utf-8");  //암호화
				Cookie pwdCookie = new Cookie("pwd", pwd);    //cookie에 id를 담아둠
				pwdCookie.setMaxAge(60 * 60 * 24 * 365);    //쿠기가 1년간 유효함
				
				//클라이언트에 전송 후 저장
				response.addCookie(idCookie);    
				response.addCookie(pwdCookie);    
			}catch(Exception e){
				
			}
			out.println("로그인 성공으로 쿠키 생성됨");
		}else {
			out.println("로그인 실패");
		}
		
		out.println("</html></body>");
		out.close();
	}

}
