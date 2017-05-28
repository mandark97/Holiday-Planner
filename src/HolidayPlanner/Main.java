package HolidayPlanner;

import Forms.Welcome;

public class Main {

	  public static void main(String[] args)
	    {
		  	/*
	        Employee em = new Employee("Test","Test","123456", "test@gmail.com",10);

	        if(em.register()) {
	            System.out.println("User registered successfully");
	        } else {
	            System.out.println("User registration failed");
	        }

	        ArrayList<Employee> employees = Employee.getAllEmployees();
	        employees.forEach(System.out::println);

	        DBConnection.close();
	        */
		  
			Welcome.start();
	    }
}
