import java.util.*;
/*
 *Cart class is for storing information of cart
 *products in cart and their quantity and total bill
 */

class Cart {
	Map<Integer,Integer> map= new HashMap();

	Item pencil,pen;
	/*
	 * function to add item
	 */
	void addItem(int id)
	{
		if(!map.containsKey(id))
		{
			map.put(id,1);

			System.out.println("inserted sucessfully\n\n");
		}
		else
		{	
			System.out.println("item already exists\n\n");
		}
	}
	
	/*
	 * function to remove item
	 */

	void removeItem(int id)
	{
		if(map.containsKey(id))
		{
			map.remove(id);
			System.out.println("removed sucessfully\n\n");
		}
		else
		{
			System.out.println("item not exists\n\n");
		}

	}

	/*
	 *function to increase quantity
	 */
	void increaseItem(int id)
	{
		if(map.containsKey(id))
		{
			map.put(id,map.get(id)+1);
			System.out.println("updated sucessfully\n\n");
		}
		else
		{
			System.out.println("please add a item first\n\n");
		}
	}

	/*
	 * function to display the items in cart
	 */
	void displayCart(ArrayList<Item> allItems)
	{	
		System.out.println("Your cart contain");
		System.out.println("Item\t name\tQuantity\n");
		for(Map.Entry m:map.entrySet())
		{  
			System.out.println(m.getKey()+" \t "+allItems.get((int)m.getKey()-1).getName()+"\t"+m.getValue()+"\n\n"); 

		}  
		System.out.println("-------------------------------------------------------------------------------------------------------");

	}
	/*
	 * this function decreases item from cart if it exists
	 * if its quantity reaches 0, it removes item from the cart
	 */

	void decreaseItem(int id)
	{	
		if(map.containsKey(id)&&map.get(id)-1!=0)
		{
			map.put(id,map.get(id)-1);
			System.out.println("updated sucessfully");
		}
		else if(map.get(id)-1==0)
		{
			map.remove(id);
		}

		else
		{
			System.out.println("please add a item first");
		}
	}

	double generateBill(ArrayList<Item> allItems)
	{
		double totalBill=0;
		for(Map.Entry m:map.entrySet())
		{  
			totalBill+= (int)m.getValue() * allItems.get((int)m.getKey()-1).getPrice();  
		}  

		return totalBill;
	}

}
