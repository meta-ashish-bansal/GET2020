
import java.util.Comparator;

public class SortById implements Comparator<EmployeeDetail> { 
		public int compare(EmployeeDetail a, EmployeeDetail b){ 	            
			return a.employeeId - b.employeeId; 
		}
}
