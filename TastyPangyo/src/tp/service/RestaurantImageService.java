package tp.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import tp.vo.Restaurant;


public interface RestaurantImageService {
	
	// 이미지 추가 기능 메소드
	void insertRestaurantImage(Restaurant restaurant);
	
	void deleteRestaurantImage(int restaurantImageId);
	
	int deleteRestaurantImageByFile(String image);
	
	List<Restaurant> selectRestaurantImageById(int restaurantId);
	
}
