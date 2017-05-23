package tp.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

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
	public int deleteReviewSelected(SqlSession session, int reviewNo) {
		return session.delete(MapperPath("deleteReviewSelected"), reviewNo);
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
	public List<Review> selectReviewByRegisteredDate(SqlSession session, Date registeredDate) {
		return session.selectList(MapperPath("selectReviewByRegisteredDate"), registeredDate);
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
	
	

}
