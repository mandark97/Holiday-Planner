import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class HR extends User
{

    public HR(String firstName, String lastName, String password, String email)
    {
        super(firstName, lastName, password, email);
    }

    static
    {
        dbSchema = "holidayplanner";
        dbTable = "hrs";
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

    @Override
    protected PreparedStatement getInsertStatement() throws SQLException {
        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO "  + dbSchema + "." + dbTable
                        + "(firstName,lastName,email,password) "
                        + "VALUES(?,?,?,?)");
        statement.setString(1, this.firstName);
        statement.setString(2, this.lastName);
        statement.setString(3, this.email);
        statement.setString(4, this.password);

        return statement;
    }

    protected static User createUser(ResultSet rs) {
        try {
            return new HR(rs.getString("firstName"), rs.getString("lastName"),
                    rs.getString("password"), rs.getString("email"));
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static User login(String email, String password) {
        try {
            return loginUser(email, password, HR::createUser);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
