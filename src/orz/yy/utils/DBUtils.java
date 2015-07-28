package orz.yy.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBUtils {

	private static String url = "";
	private static String user = "";
	private static String password = "";
	private static BasicDataSource ds = null;
	
	static{
		ds = new  BasicDataSource();
		Properties prop = new Properties();
		try {
			//从properties文件中读取jdbc连接的参数
			//将来要连接其它的数据库，之需要更改properties文件的相应属性就可以了
			prop.load(DBUtils.class.
					getClassLoader().
					getResourceAsStream("db.properties"));
			//读取属性并存入预先声明的变量中
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
			//构建连接池
			ds.setDriverClassName("com.mysql.jdbc.Driver");
			//初始化连接
			ds.setInitialSize(Integer.parseInt(prop.getProperty("InitialSize")));
			//最大空闲连接
			ds.setMaxIdle(Integer.parseInt(prop.getProperty("maxIdle")));
			//最小空闲连接
			ds.setMinIdle(Integer.parseInt(prop.getProperty("minIdle")));
			//最大连接数量
			ds.setMaxTotal(Integer.parseInt(prop.getProperty("maxTotal")));
			//超时等待时间
			ds.setMaxWaitMillis(Integer.parseInt(prop.getProperty("maxWaitMillis")));
			
			//给连接池附上参数
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(password);
			
		} catch (IOException e) {
			System.out.println("初始化数据库失败。。。");
			e.printStackTrace();
			throw new RuntimeException(e.getMessage(),e);
		}
	}
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection () throws SQLException{
		return ds.getConnection();
	}
	
	/**
	 * 释放数据库连接
	 */
	public static void freeConnection(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("资源释放失败。。。");
				e.printStackTrace();
				throw new RuntimeException(e.getMessage(),e);
			}
		}
	}
}







