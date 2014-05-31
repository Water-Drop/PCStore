package pcstore.ejb;

import javax.ejb.Stateless;

import java.sql.*;

@Stateless
public class LoginBean implements Login {
	public int UserLogin(String username, String password) {
		int id = 0;
		String drive = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/PCStore";
		Connection conn = null;
		try {
			Class.forName(drive);
			conn = DriverManager.getConnection(url, "root", null);
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM User WHERE username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			rs.last();
			int count = rs.getRow();
			if (count == 0){
				id = -1;
			} else {
				rs.first();
				id = rs.getInt("Id");
			}	
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println(id);
		return id;
	}
}
