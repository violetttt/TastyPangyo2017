package tp.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import tp.dao.impl.ReviewDaoImpl;
import tp.service.ReviewService;
import tp.util.SqlSessionFactoryManager;
import tp.vo.Review;


public class ReviewServiceImpl implements ReviewService {
	private static SqlSessionFactory factory;
	private static ReviewServiceImpl instance;
	private ReviewServiceImpl() throws IOException{
		SqlSessionFactoryManager ssfm = SqlSessionFactoryManager.getInstance();
		factory = ssfm.getSqlSessionFactory();
	}
	public static ReviewServiceImpl getInstance() throws IOException{
		if(instance == null){
			instance = new ReviewServiceImpl();
		}
		return instance;
	}
	
	
	ReviewDaoImpl dao = ReviewDaoImpl.getInstance();
	
	
	List<Review> list = null;
	Review review = null;
	int count = 0;
	
	
	
	@Override
	public int addReview(Review review) {
		SqlSession session = null;
		try{
			session = factory.openSession();
			return dao.insertReview(session, review);
			
		}finally{
			session.commit();
			session.close();
		}
	}

	@Override
	public int updateReview(Review review) {
		SqlSession session = null;
		try{
			session = factory.openSession();
			return dao.updateReview(session, review);

		}finally{
			session.commit();
			session.close();
		}
	}

	@Override
	public int deleteReviewByMemberId(String memberId) {
		SqlSession session = null;
		try{
			session = factory.openSession();
			return dao.deleteReviewByMemberId(session, memberId);
	
		}finally{
			session.commit();
			session.close();
		}
	}

	@Override
	public int deleteReviewSelected(String[] noArr){
		SqlSession session = null;
		try{
			session = factory.openSession();
			return  dao.deleteReviewSelected(session, noArr);
			
		}finally{
			session.commit();
			session.close();
		}
	}

	@Override
	public int deleteReviewByRegisteredDate(Date registeredDate) {
		SqlSession session = null;
		try{
			session = factory.openSession();
			return dao.deleteReviewByRegisteredDate(session, registeredDate);
			
		}finally{
			session.commit();
			session.close();
		}
	}
	
	
	@Override
	public int deleteReviewByRestaurantName(String restaurantName) {
		SqlSession session = null;
		try{
			session = factory.openSession();
			return dao.deleteReviewByRestaurantName(session, restaurantName);
			
		}finally{
			session.commit();
			session.close();
		}
		
	}
	
	
	@Override
	public int deleteReviewByRestaurantId(int restaurantId) {
		SqlSession session = null;
		try{
			session = factory.openSession();
			return dao.deleteReviewByRestaurantId(session, restaurantId);
		
		}finally{
			session.commit();
			session.close();
		}
	}
	
	@Override
	public int deleteReviewByTitle(String title) {
		SqlSession session = null;
		try{
			session = factory.openSession();
			return dao.deleteReviewByTitle(session, title);
			
		}finally{
			session.commit();
			session.close();
		}
	}	
	
	@Override
	public int deleteReviewByComments(String comments) {
		SqlSession session = null;
		try{
			session = factory.openSession();
			return dao.deleteReviewByComments(session, comments);
			
		}finally{
			session.commit();
			session.close();
		}
	}
	
	
	
	
	
	
	
//	--select------------------------------------------------------------
	
	@Override
	public List<Review> selectAllReview(String orderBy) {
		SqlSession session = null;
		try{
			session = factory.openSession();
			return dao.selectAllReview(session, orderBy);

		}finally{
			session.commit();
			session.close();
		}
	}
	
	
	
	
	@Override
	public List<Review> selectReviewByRegisteredDate(Date registeredDate) {
		SqlSession session = null;
		try{
			session = factory.openSession();
			return dao.selectReviewByRegisteredDate(session, registeredDate);
			
//			printList(list, String.format("등록일[%s]으로 조회", new SimpleDateFormat("yyyy-MM-dd").format(registeredDate)));
			
		}finally{
			session.commit();
			session.close();
		}
	}
	
	
	@Override
	public List<Review> selectReviewByRegisteredDateRange(Date fromDate, Date toDate) {
		SqlSession session = null;
		try{
			session = factory.openSession();
			return dao.selectReviewByRegisteredDateRange(session, fromDate, toDate);
			
		}finally{
			session.commit();
			session.close();
		}
	}
	
	@Override
	public List<Review> selectReviewByTitle(String title) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			return dao.selectReviewByTitle(session, title);
		}finally{
			session.commit();
			session.close();
		}
		
	}
	
	
	@Override
	public List<Review> selectReviewByComments(String comments) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			return dao.selectReviewByComments(session, comments);
			
			
		}finally{
			session.commit();
			session.close();
		}
	}
	
	@Override
	public Review selectReviewByNo(int reviewNo) {
		SqlSession session = null;
		try{
			session = factory.openSession();
			review = dao.selectReviewByNo(session, reviewNo);
			
//			System.out.printf("----------리뷰번호[%s]로 조회----------%n", reviewNo);
			System.out.println(review);
			return review;
			
		}finally{
			session.commit();
			session.close();
		}
	}
	
	
	
	@Override
	public List<Review> selectReviewByMemberId(String memberId) {
		SqlSession session = null;
		try{
			session = factory.openSession();
			return dao.selectReviewByMemberId(session, memberId);
		
		}finally{
			session.commit();
			session.close();
		}
	}
	

	
	@Override
	public List<Review> selectAvgKostarByRestaurantId() {
		SqlSession session = null;
		try{
			session = factory.openSession();
			return dao.selectAvgKostarByRestaurantId(session);
		
		}finally{
			session.commit();
			session.close();
		}
	}
	
	@Override
	public double selectAverageOfKostarByRestaurantId(int restaurantId) {
		SqlSession session = null;
		try{
			session = factory.openSession();
			return dao.selectAverageOfKostarByRestaurantId(session, restaurantId);
		
		}finally{
			session.commit();
			session.close();
		}
	}
	
	
	
	
	
//	--print(로그확인용)--------------------------------------------------------------------------
	public void printList(List<Review> list, String label){
		System.out.printf("-----------%s-----------%n", label);
		for(Review r : list){
			System.out.println(r);
		}
		System.out.println("-----------------------------------");
		
	}
	
	
}
