package HolidayPlanner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;


public abstract class User
{
    protected String firstName;
    protected String lastName;
    protected String password;
    protected String email;
    protected static String dbSchema;
    protected static String dbTable;


    public User(String firstName, String lastName, String password, String email)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    protected abstract PreparedStatement getInsertStatement() throws SQLException;

    public boolean register()
    {
        try
        {
            PreparedStatement statement = getInsertStatement();
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e)
        {
            return false;
        }

        return true;
    }

    protected static User loginUser(String email, String password, Function<ResultSet, User> s) throws  SQLException
    {

        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM " + dbSchema + "." + dbTable + " WHERE email = ? AND password = ?");
        statement.setString(1, email);
        statement.setString(2, password);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            return s.apply(rs);
        }

        return null;
    }
    
    public String getName() {
    	return this.firstName + " " + this.lastName;
    }
}
