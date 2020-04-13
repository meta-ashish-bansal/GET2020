
import java.util.Comparator;

public class SortByName implements Comparator<EmployeeDetail> {
	
	public int compare(EmployeeDetail a, EmployeeDetail b) {
		return a.name.compareTo(b.name); 
	}

}
