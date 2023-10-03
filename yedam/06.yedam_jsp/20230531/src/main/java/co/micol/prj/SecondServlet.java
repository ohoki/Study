package co.micol.prj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "aaa", urlPatterns = { "/aaa" })
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SecondServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>행복한 JSP 수업시간2 </h1>");
		out.print("<h1>이름 : 홍길동 </h1>");
		out.print("<h1>직업 : 의적 </h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
