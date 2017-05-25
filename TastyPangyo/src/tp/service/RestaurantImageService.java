package tp.service;

import org.apache.ibatis.session.SqlSession;

import tp.vo.Restaurant;


public interface RestaurantImageService {
	
	// 이미지 추가 기능 메소드
	void insertRestaurantImage(Restaurant restaurant);
	
	void deleteRestaurantImage(int restaurantImageId);

}
