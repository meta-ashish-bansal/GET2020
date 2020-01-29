import java.util.*;

class Main {
	public static void main(String args[])
	{	 
		Cart mycart = new Cart();
		Item pencil = new Item("pencil",15);
		Item pen    = new Item("pen",10);
		Item eraser = new Item("eraser",5);
		ArrayList<Item> allItems=new ArrayList<Item>(3);
		allItems.add(pencil);
		allItems.add(pen);
		allItems.add(eraser);


		int choice = 0;
		Scanner sc = new Scanner(System.in);

		do
		{	
			System.out.println("id\tname\tprice");
			System.out.println(pencil.toString());
			System.out.println(pen.toString());
			System.out.println(eraser.toString());
			System.out.println("\n1 to add a item \n2 to remove an item \n3 to see cart \n4 to increase quantity \n5 to decrease quantity \n6 for generate bill");
			
			try
			{
				choice = sc.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("Invalid Input");

			}
			if(choice == 3)
			{
				mycart.displayCart(allItems);

			}
			else if(choice == 6)
			{
				double totalAmount = mycart.generateBill(allItems);
				System.out.println(totalAmount);
				System.exit(0);
			}
			else {	
				int next_choice = 0;
				System.out.println("1 for pencil\n2 for pen\n3 for eraser");

				try
				{
					next_choice = sc.nextInt();
				}
				catch(Exception e)
				{
					System.out.println("Invalid input");
				}

				switch(choice)
				{
				case 1:
					if(next_choice == 1)
						mycart.addItem(pencil.id);
					
					else if(next_choice == 2)
						mycart.addItem(pen.id);
					
					else if(next_choice == 3)
						mycart.addItem(eraser.id);
					
					else
					{
						System.out.println("Please enter valid input");
					}
					break;

				case 2:
					System.out.println(choice);
					if(next_choice == 1)
						mycart.removeItem(pencil.id);
					
					else if(next_choice == 2)
						mycart.removeItem(pen.id);
					
					else if(next_choice == 3)
						mycart.removeItem(eraser.id);
					
					else
					{
						System.out.println("Please enter valid input");
						break;
					}

					break;

				case 4:
					if(next_choice == 1)
						mycart.increaseItem(pencil.id);

					else if(next_choice == 2)
						mycart.increaseItem(pen.id);

					else if(next_choice == 3)
						mycart.increaseItem(eraser.id);
					
					else
					{
						System.out.println("Please enter valid input");
						break;
					}
					break;

				case 5:
					if(next_choice == 1)
						mycart.decreaseItem(pencil.id);
					
					else if(next_choice == 2)
						mycart.decreaseItem(pen.id);
					
					else if(next_choice == 2)
						mycart.decreaseItem(pen.id);
					
					else
					{
						System.out.println("Please enter valid input");
						break;
					}
					break;

				default:
					System.out.println("invalid input");
				}

			}
		}
		while(choice != 0);
		sc.close();

	}
}
