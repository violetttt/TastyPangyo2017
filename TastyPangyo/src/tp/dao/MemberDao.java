package tp.dao;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import tp.exception.DuplicatedIdException;
import tp.exception.MemberNotFoundException;
import tp.vo.Member;
/**
 * 회원관리 DAO
 * @author violet
 *
 */
public interface MemberDao  {  
	/**
	 * 회원정보 등록
	 * @param member
	 * @throws DuplicatedIdException
	 * @throws SQLException
	 */
	int insertMember(SqlSession session, Member member);			
	
	
	/**
	 * 회원정보 수정
	 * @param member
	 * @throws MemberNotFoundException
	 * @throws SQLException
	 */
	int updateMember(SqlSession session, Member member);			
	
	
	/**
	 * id와 일치하는 회원정보 삭제 - 사용자
	 * @param memberId
	 * @throws MemberNotFoundException
	 * @throws SQLException
	 */
	int deleteMember(SqlSession session, String memberId);			
	
	
	/**
	 * 접속일로 회원정보 삭제 - 관리자
	 * @param visitDate
	 * @throws MemberNotFoundException
	 * @throws SQLException
	 */
	int deleteMemberByVisitDate(SqlSession session, Date visitDate);	
	
	
	
	/**
	 * 모든 회원정보 조회
	 * @return
	 * @throws SQLException
	 */
	List<Member> selectAllMember(SqlSession session);			
	
	
	/**
	 * 총 회원의 수 조회
	 * @return
	 * @throws SQLException
	 */
	int selectMemberCount(SqlSession session);		
	
	
	/**
	 * id로 회원정보 조회
	 * @param memberId
	 * @return
	 * @throws SQLException
	 */
	Member selectMemberById(SqlSession session, String memberId);	
	
	
	/**
	 * 지정한 접속일 이전에 접속한 회원정보 조회
	 * @param visitDate
	 * @return
	 * @throws SQLException
	 */
	List<Member> selectMemberByVisitDate(SqlSession session, Date visitDate);		// 접속일로 회원List 조회
	
	
	
}
