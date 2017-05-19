/**
 * Created by ManDark on 19-May-17.
 */
public class Employee
{
    protected String firstName;
    protected String lastName;
    protected String password;
    protected String email;

    protected Employee(String firstName, String lastName, String password, String email)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }
}
