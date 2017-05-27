/**
 * Created by ManDark on 19-May-17.
 */
public class Employee extends User
{
    int vacantionDays;

    public Employee(String firstName, String lastName, String password, String email, int vacantionDays)
    {
        super(firstName, lastName, password, email);
        this.vacantionDays = vacantionDays;
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
}
