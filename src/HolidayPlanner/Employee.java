package HolidayPlanner;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.model.core.ID;


public class Employee extends User
{
    protected int vacantionDays;

    public Employee(String firstName, String lastName, String password, String email, int vacantionDays)
    {
        super(firstName, lastName, password, email);
        this.vacantionDays = vacantionDays;
    }

    static
    {
        dbSchema = "holidayplanner";
        dbTable = "employees";
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", vacantionDays=" + vacantionDays +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    protected PreparedStatement getInsertStatement() throws SQLException {
        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO " + dbSchema + "." + dbTable
                        +"(firstName,lastName,email,password,vacantionDays) "
                        + "VALUES(?,?,?,?,?)");
        statement.setString(1, this.firstName);
        statement.setString(2, this.lastName);
        statement.setString(3, this.email);
        statement.setString(4, this.password);
        statement.setString(5, String.valueOf(this.vacantionDays));

        return statement;
    }

    protected static User createUser(ResultSet rs) {
        try {
            return new Employee(rs.getString("firstName"), rs.getString("lastName"),
                    rs.getString("password"), rs.getString("email"), rs.getInt("vacantionDays"));
        } catch(SQLException e) {
            return null;
        }
    }

    public static User login(String email, String password) {
        try {
            return loginUser(email, password, Employee::createUser);
        } catch (SQLException e) {
            return null;
        }
    }

    public static String[][] getAllEmployees()
    {
        try
        {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM " + dbSchema + "." + dbTable);
            ArrayList<String[]> employees = new ArrayList<>();

            while (rs.next())
            {	
                employees.add(new String[]{rs.getString("firstName"), 
                		rs.getString("lastName"), rs.getString("password"), 
                		rs.getString("email"), rs.getString("vacantionDays")});
            }
            
            
            String[][] employeesData = new String[employees.size()][];
            
            for(int i = 0; i < employees.size(); i++) {
            	employeesData[i] = employees.get(i);
            }
            
            return employeesData;
        } catch (SQLException e)
        {
            return null;
        }

    }
    public int getVacantionDays()
    {
    	return this.vacantionDays;
    }
    public void setVacantionDays(int vacantionDays)
    {
    	this.vacantionDays=vacantionDays;
    }
    public void addVacantionDay(String day)
    {
    	try {
    	Connection connection = DBConnection.getConnection();
    	Statement stm = connection.createStatement();
    	ResultSet rSet = stm.executeQuery("SELECT employee_id FROM employees WHERE email = '"+this.email+"'");
    	int id=0;
    	if(rSet.next())
    		id = rSet.getInt("employee_id");
    	System.out.println(id);
    	PreparedStatement statement = connection.prepareStatement( "INSERT INTO " + dbSchema + "." + "vacantiondays" +"(employee_id,day)"+ "VALUES(?,?)");
    	
			statement.setString(1, String.valueOf(id));
			DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date myDate = formatter.parse(day);
	    	statement.setDate(2, new Date(myDate.getTime()));
	    	statement.executeUpdate();
	    this.vacantionDays--;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public ArrayList<String> VacantionDays(String day1, String day2)
    {
		ArrayList<String> days = new ArrayList<>();
    	try{
    		Connection connection = DBConnection.getConnection();
    		Statement stm = connection.createStatement();
        	ResultSet rSet = stm.executeQuery("SELECT employee_id FROM employees WHERE email = '"+this.email+"'");
        	int id=0;
        	if(rSet.next())
        		id = rSet.getInt("employee_id");
    		Statement statement = connection.createStatement();
    		ResultSet resultSet = statement.executeQuery("SELECT day FROM vacantionDays WHERE employee_id = "+id + " AND day BETWEEN '"+day1 +"' AND '"+day2+"'");
    		while(resultSet.next())
    		{
    			days.add(resultSet.getString("day"));
    		}
    	}
    	catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return days;
    }
    static public Employee getEmployee(String email)
    {
    	try {
    	Connection connection = DBConnection.getConnection();
    	Statement statement = connection.createStatement();
    	ResultSet rs;
			rs = statement.executeQuery("SELECT * FROM employees WHERE email = '"+email+"'")	;
    	if(rs.next())
    	return new Employee(rs.getString("firstName"), rs.getString("lastName"),
                rs.getString("password"), rs.getString("email"), rs.getInt("vacantionDays"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
      
}
