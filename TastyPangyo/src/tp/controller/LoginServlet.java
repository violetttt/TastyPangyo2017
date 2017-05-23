package tp.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tp.exception.LoginFailException;
import tp.vo.Member;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청파라미터 조회
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		// 처리- Model 호출
		try {
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
		
		// 응답 - View 호출
	}
	
	// 인증처리 메소드 - Model대용
		public Member authenticate(String id, String pw) throws LoginFailException{
	
			// id, pw비교 - member service, dao 관련 mybatis복사해와서 쓰면 됨
			String dbid = "qms1109", dbpw = "violet0814";
			
			Member m =// null; 
					new Member("qms1109", "password", "서현화", new Date());
			if(m != null){ // id check
				if(pw.equals(m.getMemberPw())){ // +pw check = 인증성공 
					return m;
				}else{// id는 맞고 pw는 틀린 경우 = 인증실패
					throw new LoginFailException("비밀번호가 일치하지 않습니다.");
				}
			}else{// id가 틀린 경우 = 인증실패
				throw new LoginFailException("해당 ID가 존재하지 않습니다.");
			}
		}
}
