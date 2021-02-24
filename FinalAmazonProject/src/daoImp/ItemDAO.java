package daoImp;

import java.util.List;

public abstract class ItemDAO {
	
	public abstract Item findByName(String name);
	public abstract Item getitem(int id);
	public abstract List<Item> getAllItems(Shop shop);
	public abstract Boolean insertItem(Item itemDto);
	public abstract Boolean updateItem(Item itemDto);
	public abstract Boolean deleteItem(Item itemDto);

}
