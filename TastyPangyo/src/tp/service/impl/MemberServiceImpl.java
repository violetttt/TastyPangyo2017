package tp.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import tp.dao.MemberDao;
import tp.dao.impl.MemberDaoImpl;
import tp.exception.DuplicatedIdException;
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
	public void updateMember(Member member) throws MemberNotFoundException {
		SqlSession session = null;
		try{
			session = factory.getSqlSessionFactory().openSession();
			dao.updateMember(session, member);
			session.commit();
		}finally{
			if(session != null) session.close();
		}
	}
	@Override
	public void deleteMember(String memberId) throws MemberNotFoundException {
		SqlSession session = null;
		try{
			session = factory.getSqlSessionFactory().openSession();
			if(dao.selectMemberById(session, memberId) == null){
				throw new MemberNotFoundException(String.format("ID가 %s인 회원이 없습니다.", memberId));
			}
			dao.deleteMember(session, memberId);
			session.commit();
		}finally{
			if(session != null) session.close();
		}
	}
	@Override
	public void deleteMemberByVisitDate(Date visitDate) throws MemberNotFoundException {
		SqlSession session = null;
		try{
			session = factory.getSqlSessionFactory().openSession();
			if(dao.selectMemberByVisitDate(session, visitDate)==null){
				throw new MemberNotFoundException("해당하는 회원이 없습니다.");
			}
			dao.deleteMemberByVisitDate(session, visitDate);
			session.commit();
		}finally{
			if(session != null) session.close();
		}
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
