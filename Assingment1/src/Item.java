/*
 * class is used to store information about product
 */

class Item
{	static int init=0;
	String nameOfItem;
	double price;
int id;

Item(String name, double amount)
{
	nameOfItem=name;
	price=amount;
	init++;
	id+=init;
}

/*
 *return name of item
 */
String getName()
{
	return nameOfItem;

}

/*
 * return price of item
 */
double getPrice()
{
	return price;

}

/*
 * return information about product
 */

public String toString()
{
	return id+ "\t"+nameOfItem+"\t"+price;
}

}