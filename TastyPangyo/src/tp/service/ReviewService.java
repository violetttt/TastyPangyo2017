package tp.service;

import java.util.Date;
import java.util.List;

import tp.vo.Review;

/**
 * 관리자 리뷰관리 서비스
 * @author Chloe
 *
 */
public interface ReviewService {
	/**
	 * 리뷰 등록하는 메서드
	 * @param review
	 */
	int addReview(Review review);
	

	/**
	 * 선택한 리뷰 수정 메서드 (reviewNo, memberId로 )
	 * @param review
	 */
	int updateReview(Review review);

	/**
	 * 회원의 모든 리뷰 삭제 메서드
	 * @param memberId
	 */
	int deleteReviewByMemberId(String memberId);
	
	/**
	 * 선택한 리뷰 삭제 메서드
	 * @param memberId
	 */
	int deleteReviewSelected(String[] arr);
	
	/**
	 * 등록한 날자로 삭제
	 * @param registeredDate
	 */
	int deleteReviewByRegisteredDate(Date registeredDate);
	
	/**
	 * 가게 이름으로 delete
	 * @param restaurantName
	 */
	int deleteReviewByRestaurantName(String restaurantName);
	
	/**
	 * 가게 번호로 deletes
	 * @param restaurantId
	 */
	int deleteReviewByRestaurantId(int restaurantId);
	/**
	 * 제목으로 delete
	 * @param title
	 */
	int deleteReviewByTitle(String title);
	
	/**
	 * 내용으로 delete
	 * @param comments
	 */
	int deleteReviewByComments(String comments);
	
	
	
	
	
	/**
	 * 모든 리뷰 조회 (정렬 조건, 널이면 리뷰번호순)
	 * @param orderBy
	 * @return
	 */
	List<Review> selectAllReview(String orderBy);

	/**
	 * 특정 등록일 조회
	 * @param registeredDate
	 */
	List<Review> selectReviewByRegisteredDate(Date registeredDate);
	
	/**
	 * 날짜 범위로 리뷰 조회
	 * @param fromDate
	 * @param toDate
	 */
	List<Review> selectReviewByRegisteredDateRange(Date fromDate, Date toDate);
	
	/**
	 * 제목으로 조회
	 * @param title
	 */
	List<Review> selectReviewByTitle(String title);
	
	/**
	 * 내용으로 조회
	 * @param comments
	 */
	List<Review> selectReviewByComments(String comments);
	
	
	/**
	 * 등록번호로 리뷰 조회
	 * @param reviewNo
	 * @return
	 */
	Review selectReviewByNo(int reviewNo);
	
	/**
	 *멤버 아이디로 리뷰 조회
	 * @param memberId
	 * @return
	 */
	List<Review> selectReviewByMemberId(String memberId);
	
	/**
	 *  평균별점 순으로 맛집조회
	 * @return
	 */
	List<Review> selectAvgKostarByRestaurantId();

	double selectAverageOfKostarByRestaurantId(int restaurantId);
	
}
