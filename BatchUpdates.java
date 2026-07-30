package banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BatchUpdates {
	Connection con;
	PreparedStatement psmt;
	public void createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking_db","root","svecw@123");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void batchInsert() {
		try {
			String query = "INSERT INTO account VALUES(?,?,?,?)";
			psmt=con.prepareStatement(query);
			ArrayList <String> accounts =new ArrayList<String>();
			accounts.add("10,ravi,ongole,7000");
			accounts.add("11,sita,ongole,5000");
			accounts.add("17,subbareddy,ongole,9000");
			for(String account:accounts) {
				String columns[]=account.split(",");
				psmt.setString(1, columns[0]);
				psmt.setString(2, columns[1]);
				psmt.setString(3, columns[2]);
				psmt.setString(4, columns[3]);
				System.out.println("Account number : "+columns[0]);
				System.out.println("Holder Name: "+columns[1]);
				System.out.println("Branch: "+columns[2]);
				System.out.println("Amount: "+columns[3]);
				psmt.addBatch();
			}
			int rows[]=psmt.executeBatch();
			System.out.println(rows.length+" number of updates done in Database");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void viewDetails() {
		try {
			String query="select*from account";
			psmt=con.prepareStatement(query);
			ResultSet rs=psmt.executeQuery();
			while(rs.next()) {
				System.out.println("account number:"+rs.getInt(1));
				System.out.println("holder name:"+rs.getString(2));
				System.out.println("branch:"+rs.getString(3));
				System.out.println("balance:"+rs.getInt(4));
		} 
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
	public void updateDetails() {
		try {
			int account_number=1201;
			String holder_name="nani";
			String query = "UPDATE account SET holder_name='" + holder_name
			        + "' WHERE account_number=" + account_number;
			Statement stmt=con.createStatement();
			int row=stmt.executeUpdate(query);
			System.out.println(row+"update recorded");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}
