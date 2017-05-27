package tp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import tp.dao.RestaurantImageDao;
import tp.vo.Restaurant;

public class RestaurantImageDaoImpl implements RestaurantImageDao {

	private static RestaurantImageDao instance = new RestaurantImageDaoImpl();
	private RestaurantImageDaoImpl(){}
	public static RestaurantImageDao getInstance(){
		if(instance == null) instance = new RestaurantImageDaoImpl();
		return instance;
	}
	
	@Override
	public int insertRestaurantImage(SqlSession session, Restaurant restaurant) {
		return session.insert("tp.config.mapper.restaurantImageMapper.insertRestaurantImage",restaurant);
	}

	@Override
	public int deleteRestaurantImage(SqlSession session, int restaurantId) {
		return session.delete("tp.config.mapper.restaurantImageMapper.deleteRestaurantImage",restaurantId);
	}
	
	
	@Override	
	public int deleteRestaurantImageByFile(SqlSession session, String image) {
		return session.delete("tp.config.mapper.restaurantImageMapper.deleteRestaurantImageByFile",image);
	}
	@Override
	public List<String> selectRestaurantImageById(SqlSession session, int restaurantId) {
		return session.selectList("tp.config.mapper.restaurantImageMapper.selectRestaurantImageById", restaurantId);
		}
	
}
