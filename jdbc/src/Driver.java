import java.sql.*;

public class Driver {

    public static void main(String[] args) {

        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306");
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
