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
//        initComponents();
    }

//    void initComponents()
//    {
//        mainFrame = new JFrame();
//        mainFrame.setSize(1000,1000);
//        username = new JTextField();
//        email = new JTextField();
//        password = new JPasswordField();
//        mainFrame.add(username);
//        mainFrame.add(email);
//        mainFrame.add(password);
//        mainFrame.setVisible(true);
//    }
    public static void main(String[] args)
    {
        JFrame mainFrame = new JFrame();
        RegisterForm registerForm = new RegisterForm();
        mainFrame.setContentPane(registerForm.mainPanel);
        mainFrame.setVisible(true);
    }
}
