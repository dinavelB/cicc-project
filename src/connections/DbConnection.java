package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;
import java.io.*;


public class DbConnection {
    private static String url;
    private  static String username;
    private static String driver;

    DbConnection() throws Exception{
        FileReader readFile =  new FileReader("src/connections/database.properties");
        Properties properties = new Properties();

        properties.load(readFile);

        url = properties.getProperty("db.url");
        username =  properties.getProperty("db.username");
        driver = properties.getProperty("db.driver");
    }

    // throw an exception if the file is not found
    public static void main(String[] args) throws Exception{

        Connection connection;

        Class.forName(driver);
        connection = DriverManager.getConnection(url, username, "");
    }


}
