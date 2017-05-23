package tp.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import tp.vo.Restaurant;

public interface RestaurantService {
	public void addRestaurant(Restaurant restaurant) throws SQLException;
	
	public void modRestaurant(Restaurant restaurant) throws SQLException;
	
	public void deleteRestaurant(int restaurantId) throws SQLException;
	
	Restaurant selectRestaurantByID(int restaurantId) throws SQLException;
	
	List<Restaurant> selectRestaurantByName(String restaurantName) throws SQLException; 
	
	List<Restaurant> selectRestaurantBySort(String foodCategory) throws SQLException;	
	
	List<Restaurant> selectRestaurantByLocation(String location)throws SQLException;	
	
}
