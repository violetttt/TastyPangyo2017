package tp.service.impl;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import tp.dao.RestaurantImageDao;
import tp.dao.impl.RestaurantImageDaoImpl;
import tp.service.RestaurantImageService;
import tp.util.SqlSessionFactoryManager;
import tp.vo.RestaurantImage;

public class RestaurantImageServiceImpl implements RestaurantImageService {
	
	private static SqlSessionFactory factory;
	private static RestaurantImageService instance;
	
	private RestaurantImageServiceImpl() throws IOException{
		SqlSessionFactoryManager ssfm = SqlSessionFactoryManager.getInstance();
		factory = ssfm.getSqlSessionFactory();
	}
	
	public static RestaurantImageService getInstance() throws IOException{
		if(instance==null) instance = new RestaurantImageServiceImpl();
		return instance;
	}
	
	SqlSessionFactoryManager ssfm = SqlSessionFactoryManager.getInstance();
	RestaurantImageDao dao = RestaurantImageDaoImpl.getInstance();
	
	RestaurantImage restaurantImage = null;
	int count = 0;
	
	@Override
	public void insertRestaurantImage(RestaurantImage restaurantImage) {
		SqlSession session = null;
		try{
			session = factory.openSession();
			count = dao.insertRestaurantImage(session, restaurantImage);
			System.out.println("추가된 이미지 수 :"+count);
			session.commit();
			
		}finally{
			session.close();
		}
	}

	@Override
	public void deleteRestaurantImage(int restaurantImageId) {
		SqlSession session = null;
		try{
			session = factory.openSession();
			count = dao.deleteRestaurantImage(session, restaurantImageId);
			System.out.println("삭제된 이미지 수: "+count);
			session.commit();
		}finally{
			session.close();
		}
		
	}


}
