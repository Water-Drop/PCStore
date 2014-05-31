package pcstore.ejb;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import javax.ejb.Stateless;

@Stateless
public class ItemManageBean implements ItemManage {
	public int addItem(String name, int price, int stock, String description) {
		int itemId = -1;
		Connection conn = null;
		try {
			String drive = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://127.0.0.1:3306/PCStore";
			Class.forName(drive);
			conn = DriverManager.getConnection(url, "root", null);
			PreparedStatement ps1 = conn.prepareStatement("SELECT * FROM Item");
			ResultSet rs = ps1.executeQuery();
			rs.last();
			int count = rs.getRow();
			PreparedStatement ps2 = conn
					.prepareStatement("INSERT INTO Item VALUES (?, ?, ?, ?, ?)");
			count++;
			itemId = count;
			ps2.setInt(1, itemId);
			ps2.setString(2, name);
			ps2.setInt(3, price);
			ps2.setInt(4, stock);
			ps2.setString(5, description);
			ps2.execute();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return itemId;
	}

	public List<Item> getAllItems() {
		List<Item> items = new ArrayList<Item>();
		Connection conn = null;
		try {
			String drive = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://127.0.0.1:3306/PCStore";
			Class.forName(drive);
			conn = DriverManager.getConnection(url, "root", null);
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Item");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Item tmpItem = new Item(rs.getInt("Id"), rs.getString("Name"),
						rs.getInt("Price"), rs.getInt("Stock"),
						rs.getString("Description"));
				items.add(tmpItem);
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return items;
	}

}
