package tp.dao.impl;

import org.apache.ibatis.session.SqlSession;

import tp.dao.RestaurantImageDao;
import tp.vo.RestaurantImage;

public class RestaurantImageDaoImpl implements RestaurantImageDao {

	private static RestaurantImageDao instance = new RestaurantImageDaoImpl();
	private RestaurantImageDaoImpl(){}
	public static RestaurantImageDao getInstance(){
		if(instance == null) instance = new RestaurantImageDaoImpl();
		return instance;
	}
	
	@Override
	public int insertRestaurantImage(SqlSession session, RestaurantImage restaurantImage) {
		return session.insert("tp.config.mapper.restaurantImageMapper.insertRestaurantImage",restaurantImage);
	}

	@Override
	public int deleteRestaurantImage(SqlSession session, int restaurantImageId) {
		return session.insert("tp.config.mapper.restaurantImageMapper.deleteRestaurantImage",restaurantImageId);
	}
	
}
