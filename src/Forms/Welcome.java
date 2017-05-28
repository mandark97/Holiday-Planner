package Forms;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Welcome extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Welcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHolidayPlanner = new JLabel("Holiday Planner");
		lblHolidayPlanner.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblHolidayPlanner.setBounds(151, 11, 144, 32);
		contentPane.add(lblHolidayPlanner);
		
		JButton loginEmployee = new JButton("Login as employee");
		loginEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			/*	dispose();
				Login_employee.start();
				*/
			}
		});
		loginEmployee.setBounds(151, 125, 144, 23);
		contentPane.add(loginEmployee);
		
		JButton register = new JButton("Register");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Register.start();
			}
		});
		register.setBounds(174, 65, 89, 23);
		contentPane.add(register);
		
		JButton loginHR = new JButton("Login as HR");
		loginHR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*dispose();
				Login_HR.start();
				*/
			}
		});
		loginHR.setBounds(151, 175, 144, 23);
		contentPane.add(loginHR);
	}
}
