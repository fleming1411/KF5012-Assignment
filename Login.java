import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.sql.DriverManager;
import java.sql.*;

public class Login extends JFrame {
	
	/*
	 * Declare variables
	 */
	
	private String driver = "jdbc:sqlite:";
	private String db = "C:\\Users\\flemi\\Documents\\folder\\capytec.db";
	private String url = driver + db;
	protected Connection conn = null;
	
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	private JPanel usernamePanel, passwordPanel, buttonPanel;
	
	private JLabel usernamePrompt, passwordPrompt;
	private JTextField username;
	private JPasswordField password;
	private JButton login;
	
	
	/*
	 * Constructor
	 */
	
	public Login() {
		Container pane = this.getContentPane();
		pane.setLayout(new GridLayout(3, 1, 2, 2));
		
		/*
		 * Username panel
		 */
		
		usernamePanel = new JPanel();
		usernamePanel.setLayout(new GridLayout(1, 2));
		
		usernamePrompt = new JLabel("Username:");
		usernamePanel.add(usernamePrompt);
		
		username = new JTextField(10);
		usernamePanel.add(username);
		
		pane.add(usernamePanel);
		
		/*
		 * Password panel
		 */
		
		passwordPanel = new JPanel();
		passwordPanel.setLayout(new GridLayout(1, 2));
		
		passwordPrompt = new JLabel("Password:");
		passwordPanel.add(passwordPrompt);
		
		password = new JPasswordField();
		passwordPanel.add(password);
		
		pane.add(passwordPanel);
		
		/*
		 * Button panel
		 */
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2));
		
		login = new JButton("Login");
		buttonPanel.add(login);
		
		pane.add(buttonPanel);
		
		/*
		 * Action listener on login button
		 */
		
		LoginButtonClass lbc = new LoginButtonClass();
		login.addActionListener(lbc);
	}
	
	/*
	 * Connection to database - Works without, comment out, keep for debug
	 */
	
	//public boolean connect() {
		//try {
			//conn = DriverManager.getConnection(url);
			//System.err.println("Connection Successful \n");;
		//} catch (SQLException sqlex) {
			//System.err.println("Connection Unsuccessful\n" + sqlex.toString());
			//return false;
		//} catch (Exception ex) {
			//System.err.println(ex.toString());
		//}
		//return true;
	//}
	
	/*
	 * Login button class
	 */
	
	public class LoginButtonClass implements ActionListener {
		public void actionPerformed(ActionEvent lbc) {
			String sql = "SELECT * FROM staff WHERE username=? AND password=?";
			try {
				conn = DriverManager.getConnection(url);
				pst = conn.prepareStatement(sql);
				pst.setString(1, username.getText());
				pst.setString(2, password.getText());
				rs = pst.executeQuery();
				if(rs.next()) {
					dispose();
					MainMenu gui = new MainMenu();
					gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					gui.setSize(300, 400);
					gui.setLocationRelativeTo(null);
					gui.setTitle("Capytec Main Menu");
					gui.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Username and Password Incorrect");
				}
				pst.close();
				rs.close();
				conn.close();
			} catch (SQLException sqlex) {
				System.err.println("Connection Unsuccessful\n" + sqlex.toString());
			} catch (Exception ex) {
				System.err.println(ex.toString());
			}
		}
	}
	
	/*
	 * Main Method to run the page
	 */
	
	public static void main(String args[]) {
		Login gui = new Login();
		gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		gui.setTitle("Capytec Login");
		gui.setVisible(true);
		gui.setSize(375, 135);
		gui.setLocationRelativeTo(null);
	}
}
