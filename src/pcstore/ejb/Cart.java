package pcstore.ejb;

import java.util.List;

import javax.ejb.Remote;


@Remote
public interface Cart {
	public int initialize(String id);
	
	public int addItem(String itemname);
	
	public int removeItem(String itemname);
	
	public List<String> getContents();
	
	public int remove();
}
