package tp.service;

import java.util.Date;
import java.util.List;

import tp.vo.Review;

/**
 * 관리자 리뷰관리 서비스
 * @author Chloe
 *
 */
public interface ReviewManagementService {
	/**
	 * 리뷰 등록하는 메서드
	 * @param review
	 */
	void addReview(Review review);
	

	/**
	 * 선택한 리뷰 수정 메서드 (reviewNo, memberId로 )
	 * @param review
	 */
	void updateReview(Review review);

	/**
	 * 회원의 모든 리뷰 삭제 메서드
	 * @param memberId
	 */
	void deleteReviewByMemberId(String memberId);
	
	/**
	 * 선택한 리뷰 삭제 메서드
	 * @param memberId
	 */
	void deleteReviewSelected(String[] arr);
	
	/**
	 * 등록한 날자로 삭제
	 * @param registeredDate
	 */
	void deleteReviewByRegisteredDate(Date registeredDate);
	
	/**
	 * 가게 이름으로 delete
	 * @param restaurantName
	 */
	void deleteReviewByRestaurantName(String restaurantName);
	
	/**
	 * 가게 번호로 deletes
	 * @param restaurantId
	 */
	void deleteReviewByRestaurantId(int restaurantId);
	/**
	 * 제목으로 delete
	 * @param title
	 */
	void deleteReviewByTitle(String title);
	
	/**
	 * 내용으로 delete
	 * @param comments
	 */
	void deleteReviewByComments(String comments);
	
	
	
	
	
	/**
	 * 모든 리뷰 조회
	 */
	List<Review> selectAllReview();

	/**
	 * 전체조회 회원 아이디 정렬
	 */
	List<Review> selectAllReviewOrderByMemberId();
	
	/**
	 * 전체조회 최근등록순 정렬
	 */
	List<Review> selectAllReviewOrderByNewestRegistered();
	
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
	
	
}
