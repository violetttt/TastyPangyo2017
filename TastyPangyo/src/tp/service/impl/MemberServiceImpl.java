package tp.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import tp.dao.MemberDao;
import tp.dao.impl.MemberDaoImpl;
import tp.exception.DuplicatedIdException;
import tp.exception.LoginFailException;
import tp.exception.MemberNotFoundException;
import tp.service.MemberService;
import tp.util.SqlSessionFactoryManager;
import tp.vo.Member;

public class MemberServiceImpl implements MemberService{
	
	private MemberDao dao;
	private SqlSessionFactoryManager factory;
	
	private static MemberServiceImpl instance;
	
	private MemberServiceImpl() throws IOException{
		dao = MemberDaoImpl.getInstance();
		factory = SqlSessionFactoryManager.getInstance();
	}
	
	public static MemberServiceImpl getInstance() throws IOException{
		if(instance == null) instance = new MemberServiceImpl();
		return instance;
	}
	
	
	
	@Override
	public Member login(String id, String password) throws LoginFailException, MemberNotFoundException {
		SqlSession session = null;
		try{
			session = factory.getSqlSessionFactory().openSession();
			
			Member m = dao.selectMemberById(session, id);
			if(m == null){ // id 불일치
				throw new MemberNotFoundException("존재하지 않는 아이디입니다");
			}else{ // id 일치
				if(!(password.equals(m.getMemberPw()))){
					// 비밀번호 불일치
					throw new LoginFailException("비밀번호가 일치하지 않습니다");
				}//로그인 성공
				return m;
			}
			
		}finally{
			session.commit();
			if(session != null) session.close();
		}
	}

	@Override
	public void insertMember(Member member) throws DuplicatedIdException {
		
		SqlSession session = null;
		try{
			session = factory.getSqlSessionFactory().openSession();
			dao.insertMember(session, member);
			session.commit();
		}finally{
			if(session != null) session.close();
		}
	}
	@Override
	public void updateMember(Member member) {
		SqlSession session = null;
		
		session = factory.getSqlSessionFactory().openSession();
		dao.updateMember(session, member);
		session.commit();
		
		if(session != null) session.close();
		
	}
	@Override
	public void deleteMember(String memberPw) {
		SqlSession session = null;
		
		session = factory.getSqlSessionFactory().openSession();
			
		dao.deleteMember(session, memberPw);
		session.commit();
		
		if(session != null) session.close();
		
	}
	@Override
	public void deleteMemberByVisitDate(Date visitDate) {
		SqlSession session = null;
		
		session = factory.getSqlSessionFactory().openSession();
			
		dao.deleteMemberByVisitDate(session, visitDate);
		session.commit();
		
		if(session != null) session.close();
		
	}
	@Override
	public List<Member> selectAllMember() {
		SqlSession session = null;
		try{
			session = factory.getSqlSessionFactory().openSession();
			return dao.selectAllMember(session);
			
		}finally{
			session.commit();
			if(session != null) session.close();
		}
	}
	@Override
	public int selectMemberCount() {
		SqlSession session = null;
		try{
			session = factory.getSqlSessionFactory().openSession();
			return dao.selectMemberCount(session);
			
		}finally{
			session.commit();
			if(session != null) session.close();
		}
	}
	@Override
	public Member selectMemberById(String memberId) {
		SqlSession session = null;
		try{
			session = factory.getSqlSessionFactory().openSession();
			return dao.selectMemberById(session, memberId);
			
		}finally{
			session.commit();
			if(session != null) session.close();
		}
	}
	@Override
	public List<Member> selectMemberByVisitDate(Date visitDate) {
		SqlSession session = null;
		try{
			session = factory.getSqlSessionFactory().openSession();
			return dao.selectMemberByVisitDate(session, visitDate);
			
		}finally{
			session.commit();
			if(session != null) session.close();
		}
	}
	
	
	
}
