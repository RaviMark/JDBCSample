import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSample {

	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		String connectionUrl = "jdbc:sqlserver://ggku2ser6;databaseName=Training_EmpSample;"
				+ "user=Rocky;password=zaqwsx@123";
        try 
        {
        	Connection con = DriverManager.getConnection(connectionUrl); 
        	Statement stmt = con.createStatement();
        	String sql ="";
//        	Scanner scan = new Scanner(System.in);
        	/*
        	*	Creation of Table in Training_EmpSample Database;
        	*/
//        	sql = "CREATE TABLE  tblUserDetails (" + 
//        			"    id INT PRIMARY KEY IDENTITY (1, 1)," + 
//        			"    first_name VARCHAR (50) NOT NULL," + 
//        			"    last_name VARCHAR (50) NOT NULL," +
//        			"    salary real," + 
//        			")";
//        	stmt.execute(sql);
        	
        	
        	/*
        	 * Insert Statement
        	 */
        	
        	sql="INSERT INTO tblUserDetails(first_name,last_name,salary)values('John','Bailey',20000),('Sunny','Margus',25000)";
        	stmt.execute(sql);
        	System.out.println("Inserted into the table tblUserDetails");
        	/*
        	 * Select Statement
        	 */
        	sql = "select * from tblUserDetails";
        	ResultSet rs = stmt.executeQuery(sql);
        	
        	System.out.println("Select Statement for table tblUserDetails");
        	while(rs.next()) {
        		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+ " "+rs.getFloat(4));  
        	}
        	/*
        	 * Update Statement
        	 */
        	sql="UPDATE tblUserDetails SET last_name = 'Mandy' where id = 1";

        	stmt.executeUpdate(sql);
        	System.out.println("Updated table tblUserDetails ");
        	
        	
        	/*
        	 * Delete Statement
        	 */
        	sql="DELETE FROM tblUserDetails where id = 1";
        	stmt.executeUpdate(sql);
        	System.out.println("Deleted table data from tblUserDetails");
        	
        	/*
        	 * 
        	 *  Prepared Statement
        	 * 
        	 * 
        	 */
        	System.out.println("\n\nPrepared Statement \n\n");
        	PreparedStatement ps=null;  
        	/*
        	 * Insert Prepare Statement  
        	 */
    		ps=con.prepareStatement("insert into tblUserDetails(first_name,last_name,salary) values(?,?,?)");

        	ps.setString(1,"Bob");  
        	ps.setString(2,"Sandy");  
        	ps.setFloat(3,20000);  
        	ps.executeUpdate();   
        	
        	System.out.println("Inserted into the table tblUserDetails");
        	/*
        	 * Select Prepare Statement 
        	 */
        	
        	ps=con.prepareStatement("SELECT * FROM tblUserDetails");
        	rs=ps.executeQuery();

        	System.out.println("Select Statement for table tblUserDetails");
        	while(rs.next()) {
        		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+ " "+rs.getFloat(4));  
        	}
        	 
            /*
             * Update Prepare Statement
             */
            
            ps=con.prepareStatement("UPDATE tblUserDetails SET last_name = ? where id = ?");
            ps.setInt(2, 2);
            ps.setString(1, "Mary");
            ps.execute();
            System.out.println("Updated table tblUserDetails ");
            
            /*
             * Delete Prepare Statement
             */
            
            ps=con.prepareStatement("DELETE FROM tblUserDetails where id = ?");
            ps.setInt(1, 2);
            ps.execute();
            System.out.println("Deleted table data from tblUserDetails");
            
            con.close();
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
	}

}