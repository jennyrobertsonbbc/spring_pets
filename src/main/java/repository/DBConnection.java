package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost/";
    static final String EXISTING_DATABASE_NAME = "roberj78";

    //  Database credentials
    // Your database username and password
    static final String USER = "roberj78";
    static final String PASS = "roberj78";

    public Connection connect() {
        Connection databaseConnection = null;
        Statement stmt = null;
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            //System.out.println("Connecting to database...");
            databaseConnection = DriverManager.getConnection(DB_URL + EXISTING_DATABASE_NAME, USER, PASS);


        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();

        }//end try

        return databaseConnection;


    }

    public void disconnect() {
        Connection databaseConnection = null;
        Statement stmt = null;

        try {
            if (stmt != null)
                stmt.close();
        } catch (SQLException se2) {
            System.out.println("Its broken");
        }// nothing we can do
        try {
            if (databaseConnection != null)
                databaseConnection.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }//end finally try


        //System.out.println("disconnect finished");
    }

}//end JDBCExample
