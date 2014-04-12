package pcstore.ejb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;


@Stateful
public class CartBean implements Cart, Serializable {
	private static final long serialVersionUID = 2L;
	List<String> contents;
    String userId;
    //String userName;

    @Override
    public int initialize(String id){
        if (id.equals("0")) {
            return -1;
        } else {
        	userId = id;
        }
        contents = new ArrayList<>();
        return 0;
    }

    @Override
    public int addItem(String itemname) {
    	if(itemname != null){
        contents.add(itemname);
    	}else{
    		return -1;
    	}
        return 0;
    }

    @Override
    public int removeItem(String itemname){
        boolean result = contents.remove(itemname);
        if (result == false) {
            return -1;
        }else{
        	return 0;
        }
    }

    @Override
    public List<String> getContents() {
        return contents;
    }

    @Remove()
    @Override
    public int remove() {
        contents = null;
        return 0;
    }
}
