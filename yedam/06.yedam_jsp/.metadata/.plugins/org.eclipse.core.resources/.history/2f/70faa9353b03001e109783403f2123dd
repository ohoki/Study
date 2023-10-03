package co.micol.notice;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.notice.command.NoticeList;
import co.micol.notice.common.Command;
import co.micol.notice.main.command.MainCommand;
import co.micol.notice.member.command.MemberList;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Command> map = new HashMap<String, Command>();   
	
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		// 처음 시작될때 동작하는 메소드, 요청한 것을 담아 두는 곳 (한번만 실행)
		map.put("/main.do", new MainCommand()); //처음 들어오는 페이지를 돌려준다.
		map.put("/noticeList.do", new NoticeList()); //게시글 목록보기
		map.put("/memberList.do", new MemberList());  //멤버 목록 보기
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청을 분석하고, 수행할 Command를 찾아서 수행하고, 결과를 돌려준다.
		request.setCharacterEncoding("utf-8"); // 한글 깨짐 방지
		String uri = request.getRequestURI();  // 호출한 URI를 가져옴 ("/notice/main.do")
		String contextPath = request.getContextPath(); //root를 구함 ("/notice")
		String page = uri.substring(contextPath.length()); //실제 요청한 페이지 ("/main.do")
		
		Command command = map.get(page); // 수행할 command를 가져온다.
		String viewPage = command.exec(request, response);
		
		if(!viewPage.endsWith(".do")) {
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
		}else {
			response.sendRedirect(viewPage); // 결과가 *.do이면 위임해버린다. 
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
