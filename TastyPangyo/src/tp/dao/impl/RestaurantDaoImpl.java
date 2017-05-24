package tp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import tp.dao.RestaurantDao;
import tp.exception.NotFoundRestaurantIdException;
import tp.vo.Restaurant;

public class RestaurantDaoImpl implements RestaurantDao{
	private static RestaurantDaoImpl instance;
	   private RestaurantDaoImpl(){}
	   public static RestaurantDaoImpl getInstance(){
	      if(instance==null){
	         instance=new RestaurantDaoImpl();
	      }return instance;
	   }
	   
	   @Override
	   public int addRestaurant(Restaurant restaurant, SqlSession session) {
	      return session.insert(makeSql("insertRestaurantInfo"),restaurant);
	   }

	   @Override
	   public int modRestaurant(Restaurant restaurant, SqlSession session) {
	      return session.update(makeSql("modRestaurantInfo"),restaurant);
	   }

	   @Override
	   public int deleteRestaurant(int restaurantId, SqlSession session){
	      return session.delete(makeSql("deleteRestaurantInfo"),restaurantId);
	   }

	   @Override
	   public Restaurant selectRestaurantByID(int restaurantId, SqlSession session){
	      return session.selectOne(makeSql("selectRestaurantInfoByRestaurantId"),restaurantId);
	   }

	   @Override
	   public List<Restaurant> selectRestaurantByName(String restaurantName, SqlSession session) {
	      return session.selectList(makeSql("selectRestaurantInfoByRestaurantName"),restaurantName);
	   }

	   @Override
	   public List<Restaurant> selectRestaurantBySort(String foodCategory, SqlSession session) {
	      return session.selectList(makeSql("selectRestaurantInfoByRestaurantSort"),foodCategory);
	   }

	   @Override
	   public List<Restaurant> selectRestaurantByLocation(String location, SqlSession session) {
	      return session.selectList(makeSql("selectRestaurantInfoByRestaurantLocation"),location);
	   }
	   
	   private String makeSql(String id){
	      return "tp.config.mapper.restaurantMapper."+id;
	   }

}
