package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExcuteUpdate {

	public static void main(String[] args) throws SQLException {

		Connection con = null;

		try {

			// Step0: specific driver
			Driver driverRef = new Driver();

			// step1: register driver
			DriverManager.registerDriver(driverRef);

			// step2: get a connection to the driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasa3db", "root", "root");

			// step3: get create statement.
			Statement state = con.createStatement();

			// step4: execute update.
			String q = "insert into candidateinfo values('Vava', 88, 'Kerala');";
			int result = state.executeUpdate(q);

			if (result >= 1) {
				System.err.println("data added");
			}
			ResultSet resul = state.executeQuery("select * from candidateinfo;");

			while (resul.next()) {
				System.out.println(
						resul.getString("name") + " " + resul.getString("id") + " " + resul.getString("address"));
			}
		} finally {
			// step5: close
			con.close();
			System.out.println("Driver is closed");
		}

	}

}
