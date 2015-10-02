package com.demo.devops;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DemoDAO {
	//Connection con;
	private String dbName = "root";
	private String password = "welcome123";
	private String host = "localhost";

	public DemoDAO(String host, String dbName, String password) {
		this.dbName = dbName;
		this.password = password;
		this.host = host;
		//init();
	}
	
	public DemoDAO(){
		
	}


/*	public void init() {
		try {
		// get connection from connetion util
		} catch (Exception e) {
			//log error
		}
	}*/


	public void close(Connection con) {
		ConnectionUtil.closeConnection(con);
	}

	public void createUser(UserVO user) {
		//String sql = "INSERT INTO `demouser` (`name`,`address`,`state`,`country`) VALUES (?,?,?,?)";
	//+ user.getName() + ","+user.getAddress() + ","+user.getState() + ","
	//			+ "" + user.getCountry() +")";
		
		String sql = "INSERT INTO `demouser` (`name`,`address`,`state`,`country`) VALUES ('"
		+ user.getName() + "','"+user.getAddress() + "','"+user.getState() + "','"
					+ "" + user.getCountry() +"')";
		Connection connection = ConnectionUtil.getConnection();
		try {
			connection.createStatement().executeUpdate(sql );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(" User is created succssfully");
	}

	public UserVO findUser(UserVO user) {
		String findSql = "SELECT * FROM  demouser where name='" + user.getName() +"'";
		Connection connection = ConnectionUtil.getConnection();
		try {
			ResultSet rs = connection.createStatement().executeQuery(findSql);
			if(rs.next()){
				UserVO resUser = new UserVO();
				resUser.setName(rs.getString(2));
				resUser.setAddress(rs.getString(3));
				resUser.setState(rs.getString(4));
				resUser.setCountry(rs.getString(5));
				System.out.println(" Found user" + resUser.toString());
				return resUser;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(" No  user found ");
		return null;
	}
	
	public static void main(String[] args) {
		//UserVO user = new UserVO("'Test1'" , "'address1'", "'state1'", "'country1'");
		UserVO user = new UserVO("Test2" , "address2", "state2", "country3");
		//new DemoDAO().createUser(user);
		new DemoDAO().findUser(user);
	}
}
