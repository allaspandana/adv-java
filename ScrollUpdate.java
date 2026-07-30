package banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollUpdate {
	Connection con;
	Statement stmt;
	public void createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking_db","root","svecw@123");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void ScrollableUpdateRs() {
		try {
			String query="select*from account";
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=stmt.executeQuery(query);
			rs.afterLast();
			while(rs.previous()) {
				if(rs.getString(1).equals("1")) {
					rs.updateString("holder_name","Ram" );
					rs.updateRow();
				}
				System.out.println("Acoount number: "+rs.getInt(1));
				System.out.println("holder name: "+rs.getString(2));
				System.out.println("branch: "+rs.getString(3));
				System.out.println("amount: "+rs.getInt(4));
			}
			rs.absolute(4);
			rs.relative(1);
			rs.moveToInsertRow();
			rs.updateInt(1, 101);
			rs.updateString(2, "Siri");
			rs.updateString(3, "bhimavaram");
			rs.updateString(4, "1000");
			rs.insertRow();
			rs.first();
			rs.deleteRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
