package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿은 무조건 서버를 한번 껏다가 켜줘야함

@WebServlet("/kor.mbc")   //web.xml역할을 해줌
public class ServletGo extends HttpServlet {
	//private OurClass our = new OurClass();
	private OurClass our = null;
	
//	public ServletGo() {
//		System.out.println("ServletGo 생성자");
//	}

	//doGet, dePost, service를 같이 사용하면 안됨
	//service가 우선시됨
	//jsp는 service만 사용(서비스 메소드만 오버라이드함)
	
	//서블릿 라이프 사이클(생성자를 만들 필요 없음)
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");    //초기화 담당. 1회 수행(객체가 만들어짐)
		our = new OurClass();
	}


	public void destroy() {
		System.out.println("destroy 수행");   //마무리 담당.서비스 종료 시 1회 수행
		our = null;
	}

	//get
	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//System.out.println("nice - doGet");
	
			//출력 방향을 바꿈
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();   //클라이언트 브라우저로 출력
			out.println("<html><head>연습</head>");
			out.println("<body><h1>시작</h1>");
			int a = 10, b = 20;
			out.println("a=" + a + ", b=" + b);
			int tot = myCalc(a, b);
			out.println("<br>tot=" + tot);

			//OurClass our = new OurClass();   //객체가 계속 만들어짐
			out.println("<br>이름은 " + our.getIrum());   //이미 만들어져 있는 객체를 계속 가져다가 쓸 수 있음
			
			out.println("</body></html>");
			out.close();
			
	}
	
/*
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
		//get, post 모두 처리
		System.out.println("good - service");   //모든 클라이언트 요청 시 계속 수행(공유가 가능)
	}
*/
	
		private int myCalc(int a, int b) {
			return a+b;
		}
	
}
