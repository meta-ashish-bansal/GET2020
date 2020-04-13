package employee;

/**
 * Driver class for employee list
 * @author Ashish
 *
 */
public class EmployeeOperation {

	public static void main(String[] args){
		EmployeeList.addEmployee("Akshay", 20000, 22);
		EmployeeList.addEmployee("Avinash", 23000, 25);
		EmployeeList.addEmployee("Rahul", 98000, 25);
		EmployeeList.addEmployee("Yogendra", 120000, 21);
		EmployeeList.addEmployee("Sunil", 19000, 27);
		EmployeeList.addEmployee("Piyush", 10000, 29);
		EmployeeList.addEmployee("Man Mohan", 23000, 20);
		EmployeeList.addEmployee("Pawan", 25000, 26);
		EmployeeList.displayList();
		System.out.println("----------------");
		EmployeeList.sortList();
		EmployeeList.displayList();
	}
}
