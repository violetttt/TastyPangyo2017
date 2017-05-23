package tp.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import tp.exception.DuplicatedIdException;
import tp.exception.MemberNotFoundException;
import tp.vo.Member;

public interface MemberService {
	void insertMember(Member member) throws DuplicatedIdException, SQLException;
	void updateMember(Member member) throws MemberNotFoundException, SQLException;
	void deleteMember(String memberId) throws MemberNotFoundException, SQLException;
	void deleteMemberByVisitDate(Date visitDate) throws MemberNotFoundException, SQLException;
	List<Member> selectAllMember() throws SQLException;
	int selectMemberCount() throws SQLException;
	Member selectMemberById(String memberId) throws SQLException;
	List<Member> selectMemberByVisitDate(Date visitDate) throws SQLException;
}
