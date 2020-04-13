
import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author Ashish
 *
 */

public class EmployeeOperation {
	private static ArrayList<EmployeeDetail> employeeList = new ArrayList<>();
	
	private static String addEmployee(int id, String EmployeeName, String address) {
		for (int i=0; i<employeeList.size(); i++)
			if (employeeList.get(i).employeeId == id)
				return "Employee Exist";
		EmployeeDetail newEmployee = new EmployeeDetail(id, EmployeeName, address);
		employeeList.add(newEmployee);
		return "Added Successfully";
	}
	
	private static void display() {			
		for (EmployeeDetail employee : employeeList)
			System.out.println("Id: " + employee.employeeId + ", Employee Name: "+employee.name + ", Address: "+ employee.address);
	}
	
	private static void sortEmployeeById() {
		 Collections.sort(employeeList, new SortById());
		 display();
	}
	
	private static void sortEmployeeByName() {
		Collections.sort(employeeList, new SortByName());
		display();
	}
	
	public static void main(String[] args){
		System.out.println(addEmployee(2,"Man Mohan","Alwar"));
		System.out.println(addEmployee(6,"Akshay Kumar Sharma","Haryana"));
		System.out.println(addEmployee(1,"Atul Jain","Bhilwara"));
		System.out.println(addEmployee(4,"Ayush Pandey","Gulabpura"));
		System.out.println(addEmployee(3,"Naman","Ganaganagar"));
		System.out.println(addEmployee(3,"Akshay Kumar Sharma","Haryana"));
		System.out.println(addEmployee(1,"Mohit Soni","Ajmer"));
		System.out.println(addEmployee(5,"Tushar Mathur","Bikaner"));
		System.out.println(addEmployee(7,"Abhinav Kanchal","Devli"));
		System.out.println("\n\n\nEmployee List:");
		display();
		System.out.println("\n\n\nSorted by Employee ID:");
		sortEmployeeById();
		System.out.println("\n\n\nSorted by Employee Name:");
		sortEmployeeByName();
	}

}
