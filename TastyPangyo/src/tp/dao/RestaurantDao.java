package tp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import tp.exception.NotFoundRestaurantIdException;
import tp.exception.NotInputDataException;
import tp.vo.Restaurant;

public interface RestaurantDao {

	int addRestaurant(Restaurant restaurant, SqlSession session); // 맛집 등록
	
	int modRestaurant(Restaurant restaurant, SqlSession session); // 맛집 수정
	
	int deleteRestaurant(int restaurantId, SqlSession session); // 맛집 삭제
	
	Restaurant selectRestaurantByID(int restaurantId, SqlSession session); // id로 맛집 조회
	
	List<Restaurant> selectRestaurantByName(String restaurantName, SqlSession session) ; // 이름으로 맛집 조회
	
	List<Restaurant> selectRestaurantBySort(String foodCategory, SqlSession session);	// 음식종류로 맛집List 조회
	
	List<Restaurant> selectRestaurantByLocation(String location, SqlSession session);	// 위치로 맛집List 조회
	
	List<Restaurant> selectAllRestaurant (SqlSession session);	// 전체 맛집조회
	
}
