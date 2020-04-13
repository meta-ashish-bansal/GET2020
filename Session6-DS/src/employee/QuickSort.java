package employee;

/**
 * For sorting the employee list
 * @author Ashish
 *
 */
public class QuickSort {

	/**
	 * To partition list on basis of pivot point
	 * @param start header of list
	 * @param end last node of list
	 * @return pivot
	 */
	private static Employee partitionLast(Employee start, Employee end) 
	{ 
		if(start == end ||  
				start == null || end == null) 
			return start; 

		Employee pivot_prev = start; 
		Employee curr = start;  
		Employee pivot = end;  

		while(start != end ) 
		{ 
			if(start.getSalary() > pivot.getSalary()) 
			{  
				pivot_prev = curr;  
				long tempSal = curr.getSalary();  
				curr.setSalary(start.getSalary());  
				start.setSalary(tempSal);

				String tempName = curr.getName();
				curr.setName(start.getName());
				start.setName(tempName);

				int tempAge = curr.getAge();
				curr.setAge(start.getAge());
				start.setAge(tempAge);
				curr = curr.getNext();  
			} 
			else if(start.getSalary() == pivot.getSalary() && start.getAge() < pivot.getAge()) 
			{    
				long tempSal = pivot.getSalary();  
				pivot.setSalary(start.getSalary());  
				start.setSalary(tempSal);

				String tempName = pivot.getName();
				pivot.setName(start.getName());
				start.setName(tempName);

				int tempAge = pivot.getAge();
				pivot.setAge(start.getAge());
				start.setAge(tempAge);  
			}
			start = start.getNext();  
		} 
		long tempSal = curr.getSalary();  
		curr.setSalary(pivot.getSalary());  
		end.setSalary(tempSal); 

		String tempName = curr.getName();
		curr.setName(end.getName());
		end.setName(tempName);

		int tempAge = curr.getAge();
		curr.setAge(end.getAge());
		end.setAge(tempAge);

		curr = curr.getNext();

		return pivot_prev; 
	} 

	/**
	 * To sort the employee list in descending order
	 * @param start header of list
	 * @param end last index of list
	 */
	static void sort(Employee start, Employee end) 
	{ 
		if(start == end ) 
			return; 

		Employee pivot_prev = partitionLast(start, end); 
		sort(start, pivot_prev); 

		if( pivot_prev != null && pivot_prev == start ) 
			sort(pivot_prev.getNext(), end); 
		else if(pivot_prev != null && pivot_prev.getNext() != null) 
			sort(pivot_prev.getNext().getNext(), end); 
	}

}