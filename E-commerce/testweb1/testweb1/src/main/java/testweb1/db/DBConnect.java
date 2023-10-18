package testweb1.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
  private final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
  private final String DBURL = "jdbc:mysql://127.0.0.1:3306/javawebdb";
  private final String DBUSER = "root";
  private final String DBPASSWORD = "Yin030623."; //改成你的数据库密码
  private Connection conn = null;
  //构造器
  public DBConnect() {
	  try {
		  Class.forName(DBDRIVER);
		  this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
	  }catch(Exception e) {
		  System.out.println(e.getMessage());
	  }
  }
  //获取数据库连接
  public Connection getConnection() {
	  return this.conn;
  }
  //关闭数据库连接
  public void close() {
	  try {
		  this.conn.close();
	  }catch(Exception e) {

	  }
  }
}
