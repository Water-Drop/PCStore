package pcstore.ejb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ejb.Stateless;

@Stateless
public class RegisterBean implements Register {
	public int UserRegister(String username, String password) {
		int userid = 0;
		String drive = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/PCStore";
		Connection conn = null;
		try {
			Class.forName(drive);
			conn = DriverManager.getConnection(url, "root", null);
			PreparedStatement ps1 = conn.prepareStatement("SELECT * FROM User");
			ResultSet rs = ps1.executeQuery();
			rs.last();
			int count = rs.getRow();
			PreparedStatement ps2 = conn
					.prepareStatement("INSERT INTO User VALUES (?, ?, ?)");
			userid = count++;
			ps2.setInt(1, userid);
			ps2.setString(2, username);
			ps2.setString(3, password);
			ps2.execute();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return userid;
	};

	public int CheckUsername(String username) {
		int isValid = 0;
		if (username.contains(" ")) {
			return -1;// include whitespace
		} else if (username.contains("<") || username.contains(">")
				|| username.contains("\\")) {
			return -2;// include illegal character
		} else {
			return isValid;
		}
	};
}
