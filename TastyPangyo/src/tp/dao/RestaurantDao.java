package tp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import tp.vo.Restaurant;

public interface RestaurantDao {

	int addRestaurant(Restaurant restaurant, SqlSession session) throws SQLException; // 맛집 등록
	
	int modRestaurant(Restaurant restaurant, SqlSession session) throws SQLException; // 맛집 수정
	
	int deleteRestaurant(int restaurantId, SqlSession session)   throws SQLException; // 맛집 삭제
	
	Restaurant selectRestaurantByID(int restaurantId, SqlSession session) throws SQLException; // id로 맛집 조회
	
	List<Restaurant> selectRestaurantByName(String restaurantName, SqlSession session) throws SQLException; // 이름으로 맛집 조회
	
	List<Restaurant> selectRestaurantBySort(String foodCategory, SqlSession session) throws SQLException;	// 음식종류로 맛집List 조회
	
	List<Restaurant> selectRestaurantByLocation(String location, SqlSession session)throws SQLException;	// 위치로 맛집List 조회
	
}
