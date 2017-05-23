package tp.service;

import org.apache.ibatis.session.SqlSession;

import tp.vo.RestaurantImage;

public interface RestaurantImageService {
	
	// 이미지 추가 기능 메소드
	void insertRestaurantImage(RestaurantImage restaurantImage);
	
	void deleteRestaurantImage(int restaurantImageId);

}
