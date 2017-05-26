import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by ManDark on 25-May-17.
 */
public class DBConnection
{
    private static DBConnection ourInstance = new DBConnection();

    public static DBConnection getInstance()
    {
        return ourInstance;
    }

    private Connection connection;

    private DBConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/holidayplanner", "root", "root");

        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void createHR(HR hr)
    {
        try
        {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO hrs(firstName,lastName,email,password) VALUES(?,?,?,?)");
            statement.setString(1,hr.firstName);
            statement.setString(2,hr.lastName);
            statement.setString(3,hr.email);
            statement.setString(4,hr.password);
            statement.execute();
            statement.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        DBConnection db = DBConnection.getInstance();
        HR hr = new HR("matei","eSmecher","123","matei@wow.com");
        db.createHR(hr);
    }
}
