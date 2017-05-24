package tp.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import tp.dao.impl.RestaurantDaoImpl;
import tp.service.impl.RestaurantServiceImpl;
import tp.util.SqlSessionFactoryManager;
import tp.vo.Restaurant;

/**
 * 작성자 : 이병문
 * 작성일 : 2017.05.22
 * 변경일
 */
public class RestaurantTest {
	private SqlSessionFactory sessionFactory;
	public RestaurantTest()throws IOException{
		sessionFactory = SqlSessionFactoryManager.getInstance().getSqlSessionFactory();
	}
	
	public void RestaurantDaoTest()throws SQLException, IOException{
		
		SqlSession session =null;
		RestaurantDaoImpl dao = RestaurantDaoImpl.getInstance();
		Restaurant restaurant = null;
		try{
			session = sessionFactory.openSession();
			int cnt = 0;
			
			ArrayList<Restaurant> list = null;
//			변경 , 삽입, 삭제 테스트
			//cnt=dao.addRestaurant(new Restaurant(1, "즁식", "못생김", "김밥천국3",12, "03319723898", "소개글","이것저것"), session);	
			//cnt=dao.addRestaurant(new Restaurant(1, "한식", "못생김", "김밥천국3",12, "03319723898", "소개글","이것저것"), session);
			
			
//		cnt = dao.modRestaurant(new Restaurant(1,"양식","못생김", "김밥천국3",12, "03319723898", "소개글","이것저것"), session);
//		System.out.println("변경된 행의 수:"+ cnt);
				
			
			//서비스 테스트
			RestaurantServiceImpl service = RestaurantServiceImpl.getInstance();
			service.addRestaurant(new Restaurant(0, "양식", "삼환하이펙스A", "스파게티집",1345, "01041953615", "맛난다", "메뉴다"));
//			service.modRestaurant(new Restaurant(1, "중식", "유스페이스1", "밥집",15, "01041953615", "맛난다", "메뉴다"));
			
			
			//조회 테스트
//			System.out.println(dao.selectRestaurantByID(1, session));
//			System.out.println(dao.selectRestaurantByName("김밥천국3", session));
//			System.out.println(dao.selectRestaurantBySort("기타", session));
//			System.out.println(dao.selectRestaurantByLocation("삼환하이펙스A", session));
//			
//			//서비스 조회테스트
//			
			list = (ArrayList<Restaurant>) service.selectRestaurantByLocation("삼환하이펙스");
			for(Restaurant r : list){
				System.out.println(r);
			}
			
			session.commit();
		}finally{
			session.close();
		}
	}
	public static void main(String[] args) throws IOException, SQLException {
		RestaurantTest t = new RestaurantTest();
		t.RestaurantDaoTest();
	}
}
