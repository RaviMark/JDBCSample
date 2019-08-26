import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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
//        	sql = "CREATE TABLE  tblUserDetails1 (" + 
//        			"    id INT PRIMARY KEY IDENTITY (1, 1)," + 
//        			"    first_name VARCHAR (50) NOT NULL," + 
//        			"    last_name VARCHAR (50) NOT NULL," +
//        			"    salary real," + 
//        			")";
//        	stmt.execute(sql);
        	
        	/*
        	 * 
        	 * 
        	 * 
        	 */
        	
//        	sql="";
        	PreparedStatement ps=null;  
        	  
        	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
        	boolean toInsert=true;
        	System.out.println("Do you want to Insert some data in 'tblUserDetails' : y/n");  
    		String s=br.readLine();  
    		if(s.startsWith("n"))
    		{  
    			toInsert=false;
    		}  
    		else {
    			ps=con.prepareStatement("insert into tblUserDetails(first_name,last_name,salary) values(?,?,?)");
    		}
        	while(toInsert){  
        		System.out.println("enter first name:");  
        		String firstname=br.readLine();  
        		System.out.println("enter last name:");  
        		String lastname=br.readLine();  
        		System.out.println("enter salary:");  
        		float salary=Float.parseFloat(br.readLine());  
        	  
        		ps.setString(1,firstname);  
        		ps.setString(2,lastname);  
        		ps.setFloat(3,salary);  
        		int i=ps.executeUpdate();  
        		System.out.println(i+" records affected");  
        	  
        		System.out.println("Do you want to continue: y/n");  
        		s=br.readLine();  
        		if(s.startsWith("n"))
        		{  
        			toInsert=false;
        		}  
        	}
        	  
        	sql = "select * from tblUserDetails";
        	ResultSet rs = stmt.executeQuery(sql);
        	while(rs.next()) {
        		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+ " "+rs.getFloat(4));  
        	}
            con.close();
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
	}

}
