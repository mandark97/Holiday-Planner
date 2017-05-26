/**
 * Created by ManDark on 26-May-17.
 */
public class User
{
    protected String firstName;
    protected String lastName;
    protected String password;
    protected String email;

    public User()
    {
    }

    public User(String firstName, String lastName, String password, String email)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }
}
