package tp.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.omg.PortableServer.POAPackage.NoServant;

import tp.dao.ReviewDao;
import tp.vo.Review;

public class ReviewDaoImpl implements ReviewDao{
	private static ReviewDaoImpl instance;
	public static ReviewDaoImpl getInstance(){
		if(instance==null){
			instance = new ReviewDaoImpl();
		}
		return instance;
	}
	private ReviewDaoImpl(){}
	
	//반복되는 패스 입력
	public String MapperPath(String sqlId){
		return String.format("tp.config.mapper.reviewMapper.%s", sqlId);
	}
	
	
	@Override
	public int insertReview(SqlSession session, Review review) {
		return session.insert(MapperPath("insertReview"), review);
	}

	@Override
	public int updateReview(SqlSession session, Review review) {
		return session.update(MapperPath("updateReview"), review);
	}

	
	
	@Override
	public int deleteReviewSelected(SqlSession session, String[] noArr) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(String noStr : noArr){
			
		list.add(Integer.parseInt(noStr.trim()));
		}
		return session.delete(MapperPath("deleteReviewSelected"), list);
	}
	@Override
	public int deleteReviewByMemberId(SqlSession session, String memberId) {
		return session.delete(MapperPath("deleteReviewByMemberId"), memberId);
	}

	@Override
	public int deleteReviewByRegisteredDate(SqlSession session, Date registeredDate) {
		return session.delete(MapperPath("deleteReviewByRegisteredDate"), registeredDate);
	}

	@Override
	public int deleteReviewByRestaurantName(SqlSession session, String restaurantName) {
		return session.delete(MapperPath("deleteReviewByRestaurantName"), restaurantName);
	}

	@Override
	public int deleteReviewByRestaurantId(SqlSession session, int restaurantId) {
		return session.delete(MapperPath("deleteReviewByRestaurantId"), restaurantId);
	}

	@Override
	public int deleteReviewByTitle(SqlSession session, String title) {
		return session.delete(MapperPath("deleteReviewByTitle"), title);
	}

	@Override
	public int deleteReviewByComments(SqlSession session, String comments) {
		return session.delete(MapperPath("deleteReviewByComments"), comments);
	}

	
	
	@Override
	public List<Review> selectAllReview(SqlSession session, String orderBy) {
		// orderBy로 정렬 조건 column이름을 받아서 정렬문으로 만들어주고 던저 주기  
		// 작성일(registered_date)이 넘어오면 오름
		orderBy = "ORDER BY "+orderBy +(orderBy.equals("registered_date")? " DESC":"");
		System.out.println(orderBy);
		return session.selectList(MapperPath("selectAllReview"), orderBy);
	}
	
	@Override
	public Review selectReviewByNo(SqlSession session, int reviewNo) {
		return session.selectOne(MapperPath("selectReviewByNo"), reviewNo);
	}
	@Override
	public List<Review> selectAllReviewOrderByNo(SqlSession session) {
		return session.selectList(MapperPath("selectAllReviewOrderByNo"));
	}

	@Override
	public List<Review> selectAllReviewOrderByMemberId(SqlSession session) {
		return session.selectList(MapperPath("selectAllReviewOrderByMemberId"));
	}
	@Override
	public List<Review> selectAllReviewOrderByNewestRegistered(SqlSession session) {
		return session.selectList(MapperPath("selectAllReviewOrderByNewestRegistered"));
	}
	
	@Override
	public List<Review> selectReviewByMemberId(SqlSession session, String memberId) {
		return session.selectList(MapperPath("selectReviewByMemberId"), memberId);
	}
	
	
	@Override
	public List<Review> selectReviewByRegisteredDate(SqlSession session, Date registeredDate) {
		//캘린더 객체 생성
		Calendar c = Calendar.getInstance();
		//입력받은 날짜대로 캘린더 객체 시간 설정
		c.setTime(registeredDate);
		//c.add(바꿔줄 단위[연도, 월, 일], 더해줄 값) -> 다음날(DATE)로 시간을 설정
		c.add(Calendar.DATE, 1); // eg.2017-05-24 => 2017-05-25
		//yyyy-MM-dd 00:00:00 부터 yyyy-MM-dd 23:59:59까지 범위  MAP에 저장
		HashMap map = new HashMap();
		map.put("value1", registeredDate);
		map.put("value2", new Date(c.getTimeInMillis()-1));	// yyyy-MM-dd 23:59:59로 만들기 위해 1 밀리초만큼 빼주기
		System.out.println(map);
		return session.selectList(MapperPath("selectReviewByRegisteredDate"), map);
	}

	@Override
	public List<Review> selectReviewByRegisteredDateRange(SqlSession session,  Date fromDate, Date toDate) {
		HashMap<String,Date> map = new HashMap<>();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		return session.selectList(MapperPath("selectReviewByRegisteredDateRange"), map);
	}

	@Override
	public List<Review> selectReviewByTitle(SqlSession session, String title) {
		return session.selectList(MapperPath("selectReviewByTitle"), title);
	}

	@Override
	public List<Review> selectReviewByComments(SqlSession session, String comments) {
		return session.selectList(MapperPath("selectReviewByComments"), comments);
	}

	@Override
	public List<Review> selectReviewByRestaurantName(SqlSession session, String restaurantName) {
		return session.selectList(MapperPath("selectReviewByRestaurantName"), restaurantName);
	}

	@Override
	public List<Review> selectReviewByRestaurantId(SqlSession session, int restaurantId) {
		return session.selectList(MapperPath("selectReviewByRestaurantId"), restaurantId);
	}

	@Override
	public int selectAverageOfKostarByRestaurantId(SqlSession session, int restaurantId) {
		return session.selectOne(MapperPath("selectAverageOfKostarByRestaurantId"), restaurantId);
	}
	
	@Override
	public int selectCountReviewByRestaurantId(SqlSession session, int restaurantId) {
		return session.selectOne(MapperPath("selectCountReviewByRestaurantId"), restaurantId);
	}
	@Override
	public int selectCountReviewByMemberId(SqlSession session, String memberId) {
		return session.selectOne(MapperPath("selectCountReviewByMemberId"), memberId);
	}
	
	
	@Override
	public List<Review> selectRestaurantIdByAvgKostar(SqlSession session) {
		return session.selectList(MapperPath("selectRestaurantIdByAvgKostar"));
	}
	
	
	

}
