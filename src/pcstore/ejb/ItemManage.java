package pcstore.ejb;

import java.util.List;
import pcstore.ejb.Item;

public interface ItemManage {
	public int addItem(String name, int price, int stock, String description);
	public List<Item> getAllItems();
}
