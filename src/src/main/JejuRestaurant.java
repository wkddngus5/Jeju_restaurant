package src.main;

import src.main.daos.RestaurantDao;
import src.main.jdbc.JdbcConnector;

public class JejuRestaurant {
	public static void main(String[] args) {
		JdbcConnector jdbcConnector = new JdbcConnector();
		jdbcConnector.connect();
		
		RestaurantDao restaurantDao = new RestaurantDao(jdbcConnector.connection);
		restaurantDao.searchBy업소명();
	}
}
