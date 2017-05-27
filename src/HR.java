/**
 * Created by ManDark on 19-May-17.
 */
public class HR extends User
{

    public HR(String firstName, String lastName, String password, String email)
    {
        super(firstName, lastName, password, email);
    }

    @Override
    public String toString()
    {
        return "HR{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
