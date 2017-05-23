package tp.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import tp.exception.DuplicatedIdException;
import tp.exception.MemberNotFoundException;
import tp.vo.Member;
/**
 * 회원관리 
 * @author violet
 *
 */
public interface MemberService {
	/**
	 * 회원정보 등록 메소드
	 * @param member
	 * @throws DuplicatedIdException
	 * @throws SQLException
	 */
	void insertMember(Member member) throws DuplicatedIdException, SQLException;
	
	/**
	 * 회원정보 수정 메소드
	 * @param member
	 * @throws MemberNotFoundException
	 * @throws SQLException
	 */
	void updateMember(Member member) throws MemberNotFoundException, SQLException;
	
	/**
	 * id와 일치하는 회원정보 삭제 메소드
	 * @param memberId
	 * @throws MemberNotFoundException
	 * @throws SQLException
	 */
	void deleteMember(String memberId) throws MemberNotFoundException, SQLException;
	
	/**
	 * 접속일로 회원정보 삭제하는 메소드
	 * @param visitDate
	 * @throws MemberNotFoundException
	 * @throws SQLException
	 */
	void deleteMemberByVisitDate(Date visitDate) throws MemberNotFoundException, SQLException;
	
	/**
	 * 모든 회원정보 조회하는 메소드
	 * @return
	 * @throws SQLException
	 */
	List<Member> selectAllMember() throws SQLException;
	
	/**
	 * 총 회원의 수 조회하는 메소드
	 * @return
	 * @throws SQLException
	 */
	int selectMemberCount() throws SQLException;
	
	/**
	 * id로 회원정보 조회하는 메소드
	 * @param memberId
	 * @return
	 * @throws SQLException
	 */
	Member selectMemberById(String memberId) throws SQLException;
	
	/**
	 * 지정한 접속일 이전에 접속한 회원정보 조회하는 메소드
	 * @param visitDate
	 * @return
	 * @throws SQLException
	 */
	List<Member> selectMemberByVisitDate(Date visitDate) throws SQLException;
}
