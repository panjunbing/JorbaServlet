package cn.junbing.jorbaServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBmanager {

	private Connection connection;
	private PreparedStatement preparedStatement;
	public DBmanager(){
		connection = null;
		preparedStatement = null;
		//1.加载驱动
        try {
			Class.forName("com.mysql.jdbc.Driver");
			//2.得到连接
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jorba", "root", "pjb3252523114_");
			//3.创建PreparedStatment 用于传送sql查询语句
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public boolean SQL(String sql){
		try {
			preparedStatement = connection.prepareStatement(sql);
			return preparedStatement.execute();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	
	public ResultSet SQLResult(String sql){
		try {
			preparedStatement = connection.prepareStatement(sql);
			return  preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	
}
