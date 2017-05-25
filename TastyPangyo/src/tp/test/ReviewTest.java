package tp.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tp.service.impl.ReviewManagementServiceImpl;
import tp.vo.Review;

public class ReviewTest {
	public static void main(String[] args) throws IOException{
		ReviewManagementServiceImpl rms = ReviewManagementServiceImpl.getInstance();

		Review review = null;
		Date d = new Date();
		String[] noArr = new String[]{"7", "9", "11", "13"};
		List<Review> list = new ArrayList<Review>();
		/**
		private int reviewNo;
		private String memberId;	// 회원 테이블 외래키
		private int restaurantId;	// 맛집 테이블 외래키
		private String restaurantName;
		private Date registeredDate;
		private String title;
		private String comments;
		private int kostar;
		 */
		
		
		// 등록 : OK
//		review = new Review(0, "chloes", 4, "새마을식당", new Date(117, 3, 15) , "새마을식당 존나 맛있다.", "브루클린 치즈피자에 맥주 캐미가 좋아요. 피자가 메인메뉴인만큼 맛도 좋고 특히 마음에 들었던 것은 맥주 종류가 다양해 고르는 재미가 있다는 것! 브루클린 단골 될 것 같아윸", 7);
//		rms.addReview(review);
//		review = new Review(0, "sirius_012", 3, "브루클린", new Date(117, 3, 15) , "브루클린 맛있습니다.", "염병할 드럽게 맛있다. 피자가 메인메뉴인만큼 맛도 좋고 특히 마음에 들었던 것은 맥주 종류가 다양해 고르는 재미가 있다는 것! 브루클린 단골 될 것 같아윸", 9);
//		rms.addReview(review);
		
		
		// 수정 : OK
//		review = new Review(2, "chloes", 4, "새마을식당", d, "새마을 식당 열탄불고기 존맛탱", "학원있는 건물 2층에 새마을 식당 있어서 갔는데 진짜 맛있음. 3명이서 열탄불고기 6인분 먹고 7분 김치찌개도 먹음. 또 먹고 싶다...", 10);
//		rms.updateReview(review);
		
		// 삭제 
		//	(1) 아이디로 : OK
//		rms.deleteReviewByMemberId("sirius_012");
		//	(2) 선택한(조회한) : OK
//		rms.deleteReviewSelected(noArr);
		//	(3) 날짜로 : Ok
//		rms.deleteReviewByRegisteredDate(new Date(117, 3, 15));
		//	(4) 가게이름으로 : OK
//		rms.deleteMyReviewByRestaurantName("없음");
		//	(5) 가게아이디로 : OK
//		rms.deleteReviewByRestaurantId(1);
		//	(6) 제목으로 : OK
//		rms.deleteReviewByTitle("존나");
		//	(7) 내용으로 : Ok
//		rms.deleteReviewByComments("염병");
		
		
		// 조회
		//	(1) 전체 리뷰 : OK
//		rms.selectAllReview();
		//	(2) 리뷰 번호로 조회 : Ok
//		rms.selectReviewByNo(35);
		//	(3) 전체 리뷰 (아이디순) : OK
//		rms.selectAllReviewOrderByMemberId();
		//	(4) 전체 리뷰 (최근등록순) : 
//		rms.selectAllReviewOrderByNewestRegistered();
		//	(5) 등록일로 조회
//		rms.selectReviewByRegisteredDate(new Date(117, 3, 15));
		//	(6) 등록기간으로 조회
//		rms.selectReviewByRegisteredDateRange(new Date(117, 3, 17), new Date(117, 4, 17));
		//	(7) 제목으로 조회
//		rms.selectReviewByTitle("불고기");
		//	(8) 내용으로
//		rms.selectReviewByComments("맥주");
		list = rms.selectAllReview("member_id");
		rms.printList(list, "label");
		
	}

}
