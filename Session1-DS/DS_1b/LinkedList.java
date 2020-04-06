

/**
 * 
 * @author Ashish
 * Class LinkedList to create Linked List
 */
public class LinkedList {

	Node head;
	static class Node{
		int data;
		Node next;
		Node(int d){
			data=d;
			next = null;
		}
	}
	
	/**
	 * insert Method to insert a new Node Inside the Linked lIst
	 * @param list
	 * @param data
	 * @return
	 */
	
	public static LinkedList insert(LinkedList list,int data)
	{
		Node newNode = new Node(data);
		newNode.next = null;
		if(list.head ==null)
		{
			list.head = newNode;
		}
		else
		{
			Node last = list.head;
			while(last.next!=null)
			{
				last = last.next;
			}
			last.next = newNode;
		}
		return list;
	}
	
	/**
	 * printList Method to print all The Nodes Data present in the Linked List 
	 * @param list
	 */
	
	public static void printList(LinkedList list)
	{
		Node currentNode = list.head;
		System.out.println();
		System.out.println("The List is ===>> ");
		while(currentNode!=null)
		{
			System.out.print(currentNode.data+" -> ");
			currentNode = currentNode.next;
		}
	}
	
	/**
	 * rotateSubList Method rotates the Sublist clockwise.
	 * @param head -->> Here head is the Head of the linked list passed as parameter.
	 * @param l -->> Here l is the left position of the sublist in the linked List.
	 * @param r -->> Here r is the right position of the sublist in the linked list.
	 * @param n -->> Here n is the No. of Rotation we have to perform.
	 */
	
	static void rotateSubList(Node head,int l,int r,int n)
	{
		int size = r-l+1;
		if(n>size)
		{
			n=n%size;
		}
		if(n==0 || n==size)
		{
			Node temp = head;                
			while(temp!=null)
			{
				System.out.println(temp.data);
				temp = temp.next;
				
			}
			return;
		}
		Node link = null;
		if(l==1)
		{
			link =head;
		}
		Node c = head;
		int count = 0;
		Node end = null;
		Node previous = null;
		while(c!=null)
		{
			count++;
			if(count==l-1)
			{
				previous = c;
				link=c.next;
			}
			if(count==r-n)
			{
				if(l==1)
				{
					end = c;
					head = c.next;
				}
				else
				{
					end = c;
					previous.next=c.next;
				}
			}
			if(count==r)
			{
				Node d = c.next;
				c.next = link;
				end.next = d;
				Node temp = head;
				while(temp!=null)
				{
					System.out.print(temp.data +" -> ");
					temp = temp.next;
				}
				return;
			}
			c = c.next;
		}
	}

	/**
	 * This is the Main Method
	 * @param args
	 */
	
	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
		list = insert(list,2);
		list = insert(list,3);
		list = insert(list,4);
		list = insert(list,5);
		list = insert(list,6);
		list = insert(list,7);
		printList(list);
		System.out.println();
		int l=2,r=5,n=2;
		System.out.println("After Rotation of Sublist ===>>");
		rotateSubList(list.head,l,r,n);
	}
}
