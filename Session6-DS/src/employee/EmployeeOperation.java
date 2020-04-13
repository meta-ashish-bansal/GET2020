package employee;

/**
 * Driver class for employee list
 * @author Ashish
 *
 */
public class EmployeeOperation {

	public static void main(String[] args){
		EmployeeList emp = new EmployeeList();
		
		emp.addEmployee("Akshay", 25000, 21);
		emp.addEmployee("Avinash", 28000, 22);
		emp.addEmployee("Rahul", 90000, 25);
		emp.addEmployee("Man Mohan", 60000, 21);
		emp.addEmployee("Pawan", 25000, 27);
		emp.displayList();
		System.out.println("----------------");
		emp.sortList();
		emp.displayList();
	}
}