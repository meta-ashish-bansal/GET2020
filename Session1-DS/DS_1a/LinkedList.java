import java.util.HashSet;

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
	 * detectLoop Method is used to detect the loop inside a linked list.
	 * @param head
	 * @return
	 */
	static boolean detectLoop(Node head) 
    { 
        HashSet<Node> set = new HashSet<Node>(); 
        while (head!= null) { 
            if (set.contains(head)) 
                return true; 
            set.add(head); 
            head = head.next; 
        } 
  
        return false; 
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
		list.head.next.next.next.next = list.head;
		if(detectLoop(list.head))
		{
			System.out.println("\nLoop Found !!!");
		}
		else
		{
			System.out.println("\nNo Loop Found !!!");
		}	
		
	}
}
