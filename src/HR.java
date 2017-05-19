/**
 * Created by ManDark on 19-May-17.
 */
public class HR extends Employee
{
    public HR(String firstName, String lastName, String password, String email)
    {
        super(firstName, lastName, password, email);
    }
    Employee createEmployee(String firstName, String lastName, String password, String email)
    {
        return new Employee(firstName,lastName,password,email);
    }
}
