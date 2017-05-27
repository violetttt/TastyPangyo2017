package tp.service;

import java.util.Date;
import java.util.List;

import tp.exception.DuplicatedIdException;
import tp.exception.LoginFailException;
import tp.exception.MemberNotFoundException;
import tp.vo.Member;
/**
 * 회원관리 
 * @author violet
 *
 */
public interface MemberService {
	
	/**
	 * 로그인 체크 메소드
	 * @param id
	 */
	Member login(String id, String password) throws LoginFailException, MemberNotFoundException;
	
	/**
	 * 회원정보 등록 메소드
	 * @param member
	 * @throws DuplicatedIdException
	 */
	void insertMember(Member member) throws DuplicatedIdException;
	
	/**
	 * 회원정보 수정 메소드
	 * @param member
	 */
	void updateMember(Member member);
	
	/**
	 * 비밀번호와 일치하는 회원정보 삭제 메소드
	 * @param memberPw
	 */
	void deleteMember(String memberPw);
	
	/**
	 * 접속일로 회원정보 삭제하는 메소드
	 * @param visitDate
	 */
	int deleteMemberByVisitDate(Date visitDate);
	
	/**
	 * 모든 회원정보 조회하는 메소드
	 * @return
	 */
	List<Member> selectAllMember();
	
	/**
	 * 총 회원의 수 조회하는 메소드
	 * @return
	 */
	int selectMemberCount();
	
	/**
	 * id로 회원정보 조회하는 메소드
	 * @param memberId
	 * @return Member
	 */
	Member selectMemberById(String memberId);
	
	/**
	 * 지정한 접속일 이전에 접속한 회원정보 조회하는 메소드
	 * @param visitDate
	 * @return
	 */
	List<Member> selectMemberByVisitDate(Date visitDate);
}
