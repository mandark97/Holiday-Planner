import javax.swing.*;

/**
 * Created by ManDark on 17-May-17.
 */
public class RegisterForm
{
    private JTextField username;
    private JTextField email;
    private JPasswordField password;
    private JPanel mainPanel;

    public RegisterForm()
    {
    }

    public static void main(String[] args)
    {
        JFrame mainFrame = new JFrame();
        RegisterForm registerForm = new RegisterForm();
        mainFrame.setContentPane(registerForm.mainPanel);
        mainFrame.setVisible(true);
    }
}
