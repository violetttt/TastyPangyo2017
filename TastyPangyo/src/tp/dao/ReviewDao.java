package tp.dao;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import tp.vo.Review;

public interface ReviewDao {
	

	/**
	 * 리뷰를 insert하는 메서드
	 * @param session
	 * @param review
	 * @return
	 */
	int insertReview(SqlSession session, Review review);

	/**
	 * 리뷰를 update하는 메서드
	 * @param session
	 * @param review
	 * @return
	 */
	int updateReview(SqlSession session, Review review);
	
	/**
	 * 선택된 리스트 리뷰 delete
	 * @param session
	 * @param list
	 * @return
	 */
	int deleteReviewSelected(SqlSession session, String[] noArr);
	
	/**
	 * 특정 회원이 등록한 리뷰 delete
	 * @param session
	 * @param member
	 * @return
	 */
	int deleteReviewByMemberId(SqlSession session, String memberId);
	
	/**
	 * 등록일자의 리뷰들 delete
	 * @param session
	 * @param registerDate
	 * @return
	 */
	int deleteReviewByRegisteredDate(SqlSession session, Date registeredDate);
	
	/**
	 * 식당명으로 찾은 리뷰들 delete
	 * @param session
	 * @param restautantName
	 * @return
	 */
	int deleteReviewByRestaurantName(SqlSession session, String restaurantName);
	

	/**
	 * 음식점번호로 찾은 리뷰들 delete
	 * @param session
	 * @param restautantName
	 * @return
	 */
	int deleteReviewByRestaurantId(SqlSession session, int restaurantId);
	
	/**
	 * 제목으로 검색한 리뷰들 delete
	 * @param session
	 * @param title
	 * @return
	 */
	int deleteReviewByTitle(SqlSession session, String title);
	
	/**
	 * 내용으로 검색한 리뷰들 delete
	 * @param session
	 * @param comments
	 * @return
	 */
	int deleteReviewByComments(SqlSession session, String comments);

	
	
	
	/**
	 * 모든 리뷰 조회 (정렬조건을 매개변수로 받음)
	 * @param session
	 * @param orderBy
	 * @return
	 */
	List<Review> selectAllReview(SqlSession session, String orderBy);
	
	
	/**
	 * 등록번호로 리뷰 select
	 * @param reviewNo
	 * @return
	 */
	Review selectReviewByNo(SqlSession session, int reviewNo);
	
	/**
	 * 모든 리뷰 조회(번호 오름차순)
	 * @param session
	 * @return
	 */
	List<Review> selectAllReviewOrderByNo(SqlSession session);	//필요없음
	
	/**
	 * 모든 리뷰 조회(아이디 오름차순)
	 * @param session
	 * @return
	 */
	List<Review> selectAllReviewOrderByMemberId(SqlSession session); //필요없음
	
	/**
	 * 모든 리뷰 조회(날짜 내림차순,최신순)
	 * @param session
	 * @return
	 */
	List<Review> selectAllReviewOrderByNewestRegistered(SqlSession session); //필요없음
	
	/**
	 * 작성자로 등록된 리뷰 select
	 * @param session
	 * @param memberId
	 * @return
	 */
	List<Review> selectReviewByMemberId(SqlSession session, String memberId);
	/**
	 * 특정 날짜에 등록된 리뷰 select
	 * @param session
	 * @param RegisteredDate
	 * @return
	 */
	List<Review> selectReviewByRegisteredDate(SqlSession session, Date RegisteredDate);
	
	/**
	 * 현재 날짜 기준 등록된 기간으로 리뷰 select
	 * (최근 일주일, 한 달, 일 년 등) 
	 * @param session
	 * @param toDate
	 * @return
	 */
	List<Review> selectReviewByRegisteredDateRange(SqlSession session, Date fromDate, Date toDate);
	
	/**
	 * 특정 단어가 포함된 제목의 리뷰 select
	 * @param session
	 * @param title
	 * @return
	 */
	List<Review> selectReviewByTitle(SqlSession session, String title);
	
	/**
	 * 특정 단어가 포함된 내용의 리뷰 select
	 * @param session
	 * @param comments
	 * @return
	 */
	List<Review> selectReviewByComments(SqlSession session, String comments);
	
	/**
	 * 음식점 명으로 select
	 * @param session
	 * @param restaurantName
	 * @return
	 */
	List<Review> selectReviewByRestaurantName(SqlSession session, String restaurantName);
	
	/**
	 * 음식점번호로 select
	 * @param session
	 * @param restaurantName
	 * @return
	 */
	List<Review> selectReviewByRestaurantId(SqlSession session, int restaurantId);
	
	/**
	 * 특정 음식점의 평균별점 select
	 * @param session
	 * @param kostar
	 * @return
	 */
	double selectAverageOfKostarByRestaurantId(SqlSession session, int restaurantId);
	
	/**
	 * 특정 음식점의 리뷰개수 select
	 * @param session
	 * @param restaurantId
	 * @return
	 */
	int selectCountReviewByRestaurantId(SqlSession session, int restaurantId);
	
	/**
	 * 특정 회원의 리뷰개수 select
	 * @param session
	 * @param memberId
	 * @return
	 */
	int selectCountReviewByMemberId(SqlSession session, String memberId);

	/**
	 * 평점순으로 
	 * @param session
	 * @return
	 */
	List<Review> selectAvgKostarByRestaurantId(SqlSession session);
}
