package lk.crabproject.vidurabookshop.db;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection connection;
    
    public static Connection getConnection() throws Exception{
        if(connection==null){
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ViduraBookShop", "root", "everything");
        }
        return connection;
    }
}
