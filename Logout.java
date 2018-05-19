import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Logout extends JDialog {
	
	/*
	 * Decalare variables
	 */
	
	private JLabel logout;
	private JButton yes, no;
	
	/*
	 * Constructor
	 */
	
	public Logout(JFrame frame) {
		super(frame, "Logout", true);
		setLayout(new FlowLayout());
		
		/*
		 * Are you sure label
		 */
		
		logout = new JLabel("Are you sure?");
		add(logout);
		
		/*
		 * Yes button
		 */
		
		yes = new JButton("Yes");
		add(yes);
		
		/*
		 * No button
		 */
		
		no = new JButton("No");
		add(no);
		
		/*
		 * Action listeners on buttons
		 */
		
		LogoutYes ly = new LogoutYes();
		yes.addActionListener(ly);
		
		LogoutNo ln = new LogoutNo();
		no.addActionListener(ln);
	}
	
	/*
	 * Take use back to login page when they choose to log out
	 */
	
	public class LogoutYes implements ActionListener {
		public void actionPerformed(ActionEvent ly) {
			dispose();
			Login gui = new Login();
			gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			gui.setTitle("Capytec Login");
			gui.setVisible(true);
			gui.setSize(375, 135);
			gui.setLocationRelativeTo(null);
		}
	}
	
	/*
	 * Take user back to main menu when they choose to stay logged in
	 */
	
	public class LogoutNo implements ActionListener {
		public void actionPerformed(ActionEvent ln) {
			dispose();
			MainMenu gui = new MainMenu();
			gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			gui.setSize(300, 400);
			gui.setLocationRelativeTo(null);
			gui.setTitle("Capytec Main Menu");
			gui.setVisible(true);
		}
	}
}
