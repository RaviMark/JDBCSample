import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String connectionUrl = "jdbc:sqlserver://ggku2ser6;databaseName=Training_EmpSample;"
				+ "user=Rocky;password=zaqwsx@123";
        try 
        {
        	Connection con = DriverManager.getConnection(connectionUrl); 
        	Statement stmt = con.createStatement();
        	
            con.close();
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
	}

}
