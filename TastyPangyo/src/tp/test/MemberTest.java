package tp.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import tp.dao.impl.MemberDaoImpl;
import tp.exception.DuplicatedIdException;
import tp.exception.LoginFailException;
import tp.exception.MemberNotFoundException;
import tp.service.impl.MemberServiceImpl;
import tp.vo.Member;

public class MemberTest {

	public static void main(String[] args) throws IOException, DuplicatedIdException, SQLException, MemberNotFoundException, LoginFailException {
		
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		MemberDaoImpl dao = MemberDaoImpl.getInstance();
		SqlSession ss = null;
		List<Member> list = null;
		
		Member m = new Member("id", "pw", "사람", new Date());
		Member m2 = new Member("id-2", "pw-2", "동물", new Date());
		Member m3 = new Member("id-3", "pw-3", "짐승", new Date());
		Member m4 = new Member("id-4", "pw-4", "곤충", new Date());
		Member m5 = new Member("id", "pw-5", "식물", new Date());
		Member m6 = new Member("new", "flower", "꽃", new Date());
		
// 로그인
		//System.out.println(service.login("shh"));
		
		// 등록 - O
		//service.insertMember(m6);
	
		// 수정 - O
		//service.updateMember(m5);
		
		// 삭제 - O
		//service.deleteMember("000");
		
// 조회
		// 회원수 조회 - O
		System.out.println("---회원수----");
		System.out.println(service.selectMemberCount());
		
		// id로 회원조회 - O
		System.out.println("--- id로 회원 조회----");
		System.out.println(service.selectMemberById("sey"));
		
		// 접속일로 회원리스트 조회 - O
		System.out.println("--- 접속일로 회원 조회----");
		list = service.selectMemberByVisitDate(new Date(117,04,25));
		for(Member mem : list){
			System.out.println(mem);
		}
		// 모든 회원조회 - O
		System.out.println("--- 모든 회원 조회----");
		list = service.selectAllMember();
		for(Member mem : list){
			System.out.println(mem);
		}

		
	}

}
