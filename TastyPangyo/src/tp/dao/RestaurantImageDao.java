package tp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import tp.vo.Restaurant;
import tp.vo.Review;

public interface RestaurantImageDao {
	
	/**
	 *  이미지 추가
	 * @param session
	 * @param restaurant
	 * @return
	 */
	int insertRestaurantImage(SqlSession session, Restaurant restaurant);
	
	/**
	 *  이미지 전체 삭제
	 * @param session
	 * @param restaurantId
	 * @return
	 */
	int deleteRestaurantImage(SqlSession session, int restaurantId);
	
	/**
	 * 파일이름으로 삭제
	 * @param session
	 * @param image
	 * @return
	 */
	int deleteRestaurantImageByFile(SqlSession session, String image);
		
	/**
	 *  레스토랑 번호로 이미지 조회
	 * @param session
	 * @param restaurantId
	 * @return
	 */
	List<String> selectRestaurantImageById(SqlSession session, int restaurantId);
	
}
