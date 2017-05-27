package tp.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tp.exception.LoginFailException;
import tp.exception.MemberNotFoundException;
import tp.service.impl.MemberServiceImpl;
import tp.vo.Member;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		// 1. 요청파라미터 조회
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		
		// 2. 처리- Model 호출
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		Member m = service.selectMemberById(id);

			if(m != null){
				if(pw.equals(m.getMemberPw())){ // 로그인 성공
					session.setAttribute("login", m);
					m.setVisitDate(new Date());
					service.updateMember(m);
					session.setAttribute("id", id);
				}else{
				session.setAttribute("fail", "비밀번호가 틀렸습니다");
				}
			}else{
			session.setAttribute("fail", "아이디가 틀렸습니다");
			}

		// 3. 응답 - View 호출
		req.getRequestDispatcher("/jsp/intro.jsp").forward(req, resp);
	}

}
