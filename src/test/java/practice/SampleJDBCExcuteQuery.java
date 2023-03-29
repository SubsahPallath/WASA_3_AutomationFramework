package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExcuteQuery {

	public static void main(String[] args) throws SQLException {

		// Driver for mySQL database
		Driver driverRef = new Driver();

		// Step 1: Register the driver
		DriverManager.registerDriver(driverRef);

		// Step 2: get Connection to database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasa3db ", "root", "root");

		// Step 3: issue the Create statement
		Statement state = con.createStatement();

		// Step 4: Execute a Query
		ResultSet result = state.executeQuery(" select * from candidateinfo;");

		while (result.next()) {

			System.err.println(result.getString(1) + " " + result.getInt(2) + " " + result.getString(3));
		}

		// step 5: close
		con.close();
		System.out.println("closed database");
	}

}
