package tp.dao;

import org.apache.ibatis.session.SqlSession;

import tp.vo.RestaurantImage;

public interface RestaurantImageDao {
	
	// 이미지 추가
	int insertRestaurantImage(SqlSession session, RestaurantImage restaurantImage);
	
	// 이미지 삭제
	int deleteRestaurantImage(SqlSession session, int restaurantImageId);
}
