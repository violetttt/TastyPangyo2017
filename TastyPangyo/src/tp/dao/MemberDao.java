package tp.dao;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import tp.vo.Member;

public interface MemberDao  {  
	
	int insertMember(SqlSession session, Member member);				// member객체를 받아 회원정보 추가
	int updateMember(SqlSession session, Member member);				// member객체를 받아 회원정보 수정
	int deleteMember(SqlSession session, String memberId);				// 회원id를 받아 회원정보 삭제 - 사용자
	int deleteMemberByVisitDate(SqlSession session, Date visitDate);		// 접속일로 회원정보삭제 - 관리자
	
	
	List<Member> selectAllMember(SqlSession session);										// 모든 회원 조회
	int selectMemberCount(SqlSession session);												// 총 회원수 조회
	Member selectMemberById(SqlSession session, String memberId);					// 회원id로 회원조회
	List<Member> selectMemberByVisitDate(SqlSession session, Date visitDate);		// 접속일로 회원List 조회
	
	
	
}
