/**
 * This class is immutable class to represent sets and perform various set operations
 */

final class IntSet
{	
	private final int[] set; 
	private final int[] univarsal_set = new int[1001];

	/**
	 * getter method to see value of set
	 */
	int[] getSet()
	{
		return set;
	}
	
	/**
	 * constructor to initialize set variable of IntSet class
	 * and check if elements in set are not repeated
	 */

	IntSet(int []array)
	{	

		int count;
		for(int i:array)
		{	count = 0;
		for(int j:array)
		{
			if(i==j)
				count++;
		}
		if(count!=1)
		{	// throwing assertion error if there are duplicate elements in set 
			throw new AssertionError("invalid set input");
		}

		}

		set=array.clone();

		for(int i=0;i<=1000;i++)	
			univarsal_set[i]=i;
	}

	/**
	 * this function returns true if the number passed in argument is member of the set
	 */
	public	boolean isMember(int no_to_searched)
	{
		for(int i:set)
		{	if(i==no_to_searched)
			return true;
		}
		return false;
	}

	/**
	 * this function returns the size of the set
	 */

	public int size()
	{
		return set.length;
	}

	/**
	 * this function checks if one set is subset of other
	 */
	public boolean isSubSet(IntSet intset)
	{
		for(int i:intset.set)
		{	
			int flag = 0;
			for(int j:this.set)
			{	
				if(i==j)
				{
					flag=1;
					break;
				}
			}
			if(flag==0)
			{
				return false;
			}
		}
		return true;
	}
	/**
	 * this functions returns the compliment of the set 
	 */

	public int[] getCompliment()
	{	
		int []compliment = new int[1001-size()];
		int index = 0;

		for(int i:univarsal_set)
		{
			int flag  = 0;
			for(int j:set)
			{
				if(i==j)
				{
					flag=1;
				}


			}
			if(flag == 0)
			{compliment[index] = i;
			index++;
			}
		}

		return compliment;
	}

	/**
	 * this function returns the union of 2 sets
	 */

	public static IntSet getUnion(IntSet s1,IntSet s2)
	{	
		int no_of_common = 0;

		for(int i:s1.set)
		{  
			for(int j:s2.set)
			{
				if(i==j)
				{
					no_of_common++;
					break;
				}

			}
		}

		int union[] = new int[s1.size()+s2.size()-no_of_common] ; ;
		int index = 0;
		for(int i:s1.set)
		{  
			int flag=0;
			for(int j:s2.set)
			{
				if(i==j)
				{
					flag=1;
					break;
				}

			}
			if(flag == 0)
			{
				union[index]=i;
				index++;
			}


		}
		for(int i:s2.set)
		{
			union[index]=i;
			index++;
		}



		return new IntSet(union);
	}



}