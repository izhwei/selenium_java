package selenium_test;

import java.sql.*;
public class MysqlJdbc {
  public static void main(String args[]) {
    try {
      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
      //Class.forName("org.gjt.mm.mysql.Driver");
     System.out.println("Success loading Mysql Driver!");
    }
    catch (Exception e) {
      System.out.print("Error loading Mysql Driver!");
      e.printStackTrace();
    }
    try {
      Connection connect = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/test","root","123");
           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码

      System.out.println("Success connect Mysql server!");
      Statement stmt = connect.createStatement();
      //可以跨数据库进行join连接
      ResultSet rs = stmt.executeQuery("SELECT * FROM dmreport.dm_product AS p LEFT JOIN dmreport2.dm_product_description AS p1 ON p.product_id=p1.product_id WHERE p1.language_id=2");
                                                              //user 为你表的名称
while (rs.next()) {
        System.out.println(rs.getString("product_id")+"---"+rs.getString("name"));
      }
    }
    catch (Exception e) {
      System.out.print("get data error!");
      e.printStackTrace();
    }
  }
}
