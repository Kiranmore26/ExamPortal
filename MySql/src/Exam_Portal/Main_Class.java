package Exam_Portal;

import java.util.Scanner;

public class Main_Class {

	public static void main(String[] args) throws Exception
	{
		Scanner sc  = new Scanner(System.in);
		Students s = new Students();
		Teachers t = new Teachers();
		System.out.println("Choose From Below to enter into :");
		System.out.println("1) Students portal");
		System.out.println("2) Teachers portal");
		System.out.println("3) Exit");
		int choice=sc.nextInt();
		
		while(true)
		{
			switch (choice) 
			{
			case 1:
				System.out.println("This is an Portal of Student's Information");
				s.Operation();
				break;
			case 2:
				System.out.println("This is an Portal of Teacher's Information");
				t.operations();
				break;
			default:
				break;
			}
		}
		

	}

}
