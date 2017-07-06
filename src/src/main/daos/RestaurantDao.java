package src.main.daos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.main.domain.Restaurant;

public class RestaurantDao {
	private java.sql.PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	private Connection connection;
	BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
	
	public RestaurantDao(Connection connection) {
		this.connection = connection;
	}
	
	public List<Restaurant> selectAll() {
		String sql = "SELECT * FROM restaurant.restaurant";
		List<Restaurant> restaurantList = new ArrayList<>();
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Restaurant resultRestaurant = new Restaurant(
						resultSet.getString(1), 
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4), 
						resultSet.getString(5), 
						resultSet.getString(6), 
						resultSet.getString(7)
						);
				
				System.out.println(resultRestaurant);
				restaurantList.add(resultRestaurant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return restaurantList;
	}
	
	public Restaurant insert() {
		Restaurant restaurant = null;
		try {
			System.out.print("새로운 식당을 추가합니다.");
			System.out.print("업종명: ");
			String 업종명 = in.readLine();
			
			System.out.print("인허가일자(0000-00-00): ");
			String 인허가일자 = in.readLine();
			
			System.out.print("업소명: ");
			String 업소명 = in.readLine();
			
			System.out.print("소재지(도로명): ");
			String 소재지_도로명 = in.readLine();
			
			System.out.print("소재지(지번): ");
			String 소재지_지번 = in.readLine();
			
			System.out.print("소재지전화: ");
			String 소재지전화 = in.readLine();
			
			System.out.print("업태명: ");
			String 업태명 = in.readLine();
			
			restaurant = new Restaurant(업종명, 인허가일자, 업소명, 소재지_도로명, 소재지_지번, 소재지전화, 업태명);
			String sql = "INSERT INTO restaurant.restaurant VALUES(?, ?, ?, ?, ?, ?, ?)";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, 업종명);
				preparedStatement.setString(2, 인허가일자);
				preparedStatement.setString(3, 업소명);
				preparedStatement.setString(4, 소재지_도로명);
				preparedStatement.setString(5, 소재지_지번);
				preparedStatement.setString(6, 소재지전화);
				preparedStatement.setString(7, 업태명);
				int n = preparedStatement.executeUpdate();
				
				if (n > 0) {
					System.out.println("식당 추가 성공");
				} else {
					System.out.println("식당 추가 실패");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return restaurant;
	}
	
	public void searchBy업소명() {
		System.out.print("입력: ");
		try {
			String input = in.readLine();
			String sql = "SELECT * FROM restaurant.restaurant WHERE 업소명 like '%" + input + "%'";
			try {
				preparedStatement = connection.prepareStatement(sql);
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					Restaurant resultRestaurant = new Restaurant(
							resultSet.getString(1), 
							resultSet.getString(2),
							resultSet.getString(3),
							resultSet.getString(4), 
							resultSet.getString(5), 
							resultSet.getString(6), 
							resultSet.getString(7)
							);
					
					System.out.println(resultRestaurant);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
		}
	}
	
	public void searchBy업태명() {
		System.out.print("입력: ");
		try {
			String input = in.readLine();
			String sql = "SELECT * FROM restaurant.restaurant WHERE 업태명 like '%" + input + "%'";
			try {
				preparedStatement = connection.prepareStatement(sql);
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					Restaurant resultRestaurant = new Restaurant(
							resultSet.getString(1), 
							resultSet.getString(2),
							resultSet.getString(3),
							resultSet.getString(4), 
							resultSet.getString(5), 
							resultSet.getString(6), 
							resultSet.getString(7)
							);
					
					System.out.println(resultRestaurant);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
		}
	}
}
