package graphicsLib;

import java.util.*;  

/**
 * This class implements comparator to sort objects based on area.
 * @author Ashish
 *
 */
public class AreaComparator implements Comparator<Shape>{
	public int compare(Shape s1,Shape s2){  
		if(s1.getArea()==s2.getArea())  
			return 0;  
		else if(s1.getArea()>s2.getArea())  
			return 1;  
		else  
			return -1;  
	}
}  