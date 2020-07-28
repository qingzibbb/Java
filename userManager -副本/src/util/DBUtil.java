package util;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//连接数据库
public class DBUtil {
    private static String url = "jdbc:mysql://127.0.0.1:3306/usermanger?useSSL=false";
    private static String password = "123456";
    private static String username = "root";

    private static volatile DataSource DATASOURCE;

    private static DataSource getDatasource(){
        if(DATASOURCE == null){
            synchronized (DBUtil.class){
                if(DATASOURCE == null){
                    DATASOURCE = new MysqlDataSource();
                    ((MysqlDataSource) DATASOURCE).setUrl(url);
                    ((MysqlDataSource) DATASOURCE).setUser(username);
                    ((MysqlDataSource) DATASOURCE).setPassword(password);
                }
            }
        }
        return DATASOURCE;
    }

    public static Connection getConnection(){
        try {
            Connection connection = getDatasource().getConnection();
            return connection;
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException("获取数据库连接失败");
        }
    }
    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
