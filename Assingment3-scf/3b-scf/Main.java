import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
	public static void main(String srgs[])
	{	
		int noOfStudents = 0;
		Marksheet result = new Marksheet();
		System.out.println("enter the no of student");
		Scanner sc = new Scanner(System.in);
		int flag=0;
		while (flag == 0)
		{
			try
			{
				noOfStudents = sc.nextInt();
				flag=1;

			}

			catch(InputMismatchException e )
			{
				System.out.println("enter valid input");
				System.exit(0);
			}
		}
		System.out.println("enter the grades of student");
		double grades[] = new double[noOfStudents];
		
		for(int i=0;i<noOfStudents;i++)
			
		{
			grades[i] = sc.nextDouble();
		}
		System.out.println("average of all students is "+result.average(grades));
		System.out.println("maximum grdade is "+result.maxGrade(grades));
		System.out.println("minimum grade is "+result.minGrade(grades));
		System.out.println("percentage of students passed "+result.percentPass(grades));
		
		
	}

}
