package tp.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import tp.exception.NotInputDataException;
import tp.exception.NotFoundRestaurantIdException;
import tp.vo.Restaurant;

public interface RestaurantService {

	public void addRestaurant(Restaurant restaurant);
	
	public void modRestaurant(Restaurant restaurant) throws NotFoundRestaurantIdException;
	
	public void deleteRestaurant(int restaurantId) throws NotFoundRestaurantIdException;
	
	Restaurant selectRestaurantByID(int restaurantId) throws NotFoundRestaurantIdException;
	
	List<Restaurant> selectRestaurantByName(String restaurantName); 
	
	List<Restaurant> selectRestaurantBySort(String foodCategory);	
	
	List<Restaurant> selectRestaurantByLocation(String location);	
	
	List<Restaurant> selectAllRestaurant();
	
	List<Restaurant> selectAllRestaurantByHit();
	
	List<Restaurant> selectRestaurantIdByAvgKostar();
	
}
