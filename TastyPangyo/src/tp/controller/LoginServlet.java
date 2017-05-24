package tp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tp.exception.LoginFailException;
import tp.service.impl.MemberServiceImpl;
import tp.vo.Member;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		// 1. 요청파라미터 조회
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		
		// 2. 처리- Model 호출
		String login = null;
		Member m = null;
		
			// selectMemberById의 결과(A)가 존재하고 A의 비밀번호와 입력받은 비밀번호가 일치하면 - 로그인 성공		
			// selectMemberById의 결과(A)가 존재하나 A의 비밀번호와 입력받은 비밀번호가 틀리면 LoginFailException
			// selectMemberById의 결과(A)가 없으면 MemberNotFoundException - 아이디 불일치
			MemberServiceImpl service = MemberServiceImpl.getInstance();
			m = service.selectMemberById(id);
			if(service.selectMemberById(id) != null){
				if(pw.equals(m.getMemberPw())){
					login = "로그인 성공";
				}
				login = "비밀번호가 일치하지 않습니다";
			}
			login = "해당 ID가 존재하지 않습니다";
		
		session.setAttribute("login", login);
		
/*		try {
			Member m = authenticate(id, pw);
			// 로그인 성공 (session 생성 - success.jsp로 이동)
			HttpSession ss = req.getSession();
			// 로그인 여부 체크할 값 session에 추가
			ss.setAttribute("logininfo", m); // 얘는 로그아웃할때까지 필요한 data니까(사용자단위) session scope에 저장.
			req.getRequestDispatcher("/login/login_success.jsp").forward(req, resp);
		} catch (LoginFailException e) {
			// 로그인 실패 - login_form.jsp로 이동
			req.setAttribute("Error", e.getMessage()); // 응답한 이후에는 필요없는 data니까 request scope에 저장.
			req.getRequestDispatcher("/login/login_form.jsp").forward(req, resp);
		}
*/
		
		// 3. 응답 - View 호출
		req.getRequestDispatcher("/member/login_success.jsp").forward(req, resp);	
	}
	
}
