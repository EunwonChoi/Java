package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/postServlet")
public class postServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");   //post 방식에서는 글씨가 깨져버리므로 인코딩해준다
		
		String name = request.getParameter("name");
		//String addr = request.getParameter("addr");
		//여러개를 받을 시(배열사용)
		String addr[] = request.getParameterValues("addr");
		//System.out.println(name + " " + addr[0] + " " + addr[1]);  
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();   //클라이언트 브라우저로 출력
		out.println("<html><head>연습</head>");
		out.println("<body>");
		out.println("<br><b style='color:red';>* 결과  출력(post)  *</b>");
		out.println("<br>이름은 " + name + "<br>");
		out.println("<br>주소는 " + addr[0] + " " + addr[1] + "<br>");

		//checkbox
		try {
			String lan[] = request.getParameterValues("lan");    //checkbox 선택시에 파라미터 값이 와야함
			out.println("선택한 언어는");
			for(String la:lan) {
				out.println(la + " ");
			}
		} catch (Exception e) {
			out.println("&nbsp하나 이상의 언어를 선택해 보세요");
		}
		
		//radio
		String os = request.getParameter("os");
		out.println("<br>운영체제는 " + os + "<br>");
		
		//select
		String tr = request.getParameter("tr");
		out.println("<br>교통수단 " + tr + "<br>");
		
		//hidden
		String msg = request.getParameter("msg");
		out.println("<br>메세지: " + msg + "<br>");
		
		out.println("<br><a href='postex.html'>자료 다시 입력(post)</a>");
		out.println("</body></html>");
		out.close();
		
	}

}
