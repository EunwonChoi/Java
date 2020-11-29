package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetServlet")    //얘가 실질적인 파일명임
public class GetServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  //html로 변형해서 보내줌
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String addr = request.getParameter("addr");
		System.out.println(name + " " + age + " " + addr);
	
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();   //클라이언트 브라우저로 출력
		out.println("<html><head>연습</head>");
		out.println("<body>");
		out.println("<b style='color:red';>* 결과  출력  *</b>");
		out.println("<br>이름은 " + name + "<br>");
		//out.println("<br>나이는 " + age + "<br>");
		String ss = calcAge(age);
		out.println("<br>나이는 " + ss + "<br>");
		out.println("<br>주소는 " + addr + "<br>");
		out.println("<a href='getex.html'>자료 다시 입력</a>");
		
		out.println("</body></html>");
		out.close();
	}
	
	private String calcAge(String age) { 
		int imsi = Integer.parseInt(age) / 10 * 10;   //   23/10 => 2 * 10 ==> 20대
		String re = "";
		
		switch (imsi) {
		case 20:
			re="20대";
			break;
		case 30:
			re="30대";
			break;
		default:
			re="기타";
			break;
		}
		return re;
	}
}
