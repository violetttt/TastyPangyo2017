package tp.dao.impl;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import tp.dao.MemberDao;
import tp.vo.Member;

public class MemberDaoImpl implements MemberDao{

	private static MemberDaoImpl instance;
	private MemberDaoImpl(){}
	public static MemberDaoImpl getInstance(){
		if(instance == null) instance = new MemberDaoImpl();
		return instance;
	}
	
	String sql = "tp.config.mapper.memberMapper.";
	
	
	@Override
	public String selectMemberPw(SqlSession session, String id) {
		return session.selectOne(sql+"selectMemberPw", id);
	}
	@Override
	public int insertMember(SqlSession session, Member member) {
		return session.insert(sql+"insertMember", member);
	}

	@Override
	public int updateMember(SqlSession session, Member member) {
		return session.update(sql+"updateMember", member);
	}

	@Override
	public int deleteMember(SqlSession session, String memberPw) {
		return session.delete(sql+"deleteMember", memberPw);
	}

	@Override
	public int deleteMemberByVisitDate(SqlSession session, Date visitDate) {
		return session.delete(sql+"deleteMemberByVisitDate", visitDate);
	}

	@Override
	public List<Member> selectAllMember(SqlSession session) {
		return session.selectList(sql+"selectAllMember");
	}

	@Override
	public int selectMemberCount(SqlSession session) {
		// 회원목록 보여줄 때 필요
		return session.selectOne(sql+"selectMemberCount");
	}
	@Override
	public Member selectMemberById(SqlSession session, String memberId) {
		return session.selectOne(sql+"selectMemberById", memberId);
	}

	@Override
	public List<Member> selectMemberByVisitDate(SqlSession session, Date visitDate) {
		return session.selectList(sql+"selectMemberByVisitDate", visitDate);
	}

	
}
