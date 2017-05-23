package tp.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import tp.dao.impl.RestaurantDaoImpl;
import tp.service.RestaurantService;
import tp.util.SqlSessionFactoryManager;
import tp.vo.Restaurant;

/**
 * 작성자 : 이병문
 * 작성일 : 2017.05.22
 * 변경일
 */
public class RestaurantServiceImpl implements RestaurantService {
	
	private static RestaurantServiceImpl instance;
	private static SqlSessionFactory factory;
	
	public static RestaurantServiceImpl getInstance() throws IOException{
		if(instance==null){
			instance= new RestaurantServiceImpl();
		}
		return instance;
	}
	
	int count =0;
	ArrayList<Restaurant> list = null;// 테스트용 삭제요망
	
	
	/**
	 * 생성자 => SqlSessionfactory를 하나만사용
	 * @throws IOException
	 */
	private RestaurantServiceImpl()throws IOException{		
		factory = SqlSessionFactoryManager.getInstance().getSqlSessionFactory();
	}
	
	RestaurantDaoImpl dao = RestaurantDaoImpl.getInstance();
	
	@Override
	public void addRestaurant(Restaurant restaurant) throws SQLException {
		SqlSession session =null;
		try{
			session = factory.openSession();
			count = dao.addRestaurant(restaurant, session);
			//System.out.println(count + "행 증가");
			session.commit();
		}finally{
			session.close();
		}		
	}

	@Override
	public void modRestaurant(Restaurant restaurant) throws SQLException {
		SqlSession session=null;
		try{
			session = factory.openSession();
			count = dao.modRestaurant(restaurant, session);
			//System.out.println(count + "행 변경");
			session.commit();
		}finally{
			session.close();
		}
		
	}

	@Override
	public void deleteRestaurant(int restaurantId) throws SQLException {
		SqlSession session = null;
		try {
			session = factory.openSession();
			count = dao.deleteRestaurant(restaurantId, session);
			//System.out.println(count+"행 삭제");
			session.commit();
		} finally {
			session.close();
		}
		
	}

	@Override
	public Restaurant selectRestaurantByID(int restaurantId) throws SQLException {
		SqlSession session = null;
		try {
			session = factory.openSession();
			return dao.selectRestaurantByID(restaurantId, session);
		} finally {
			session.commit();
			session.close();
		}
	}

	@Override
	public List<Restaurant> selectRestaurantByName(String restaurantName) throws SQLException {
			SqlSession session = null;
		try {
			session = factory.openSession();
			return dao.selectRestaurantByName(restaurantName, session);
		} finally {
			session.commit();
			session.close();
		}
	}

	@Override
	public List<Restaurant> selectRestaurantBySort(String foodCategory) throws SQLException {
		SqlSession session = null;
		try {
			session = factory.openSession();
			return dao.selectRestaurantBySort(foodCategory, session);
		} finally {
			session.commit();
			session.close();
		}
	}

	@Override
	public List<Restaurant> selectRestaurantByLocation(String location) throws SQLException {
		SqlSession session = null;
		try {
			session = factory.openSession();
			return dao.selectRestaurantByLocation(location, session);
			
		} finally {
			session.commit();
			session.close();
		}
		
		
	}
	public void printList(List<Restaurant> list, String label){
	      System.out.printf("-----------%s-----------%n", label);
	     for(Restaurant r : list){
	         System.out.println(r);
	     }
	      System.out.println("-----------------------------------");
	      
	   }


}