import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Preferences extends JFrame {
	
	/*
	 * Declare variables
	 */
	
	private JLabel chgPass;
	private JButton chgPassBtn;
	
	/*
	 * Constructor
	 */
	
	public Preferences() {
		setLayout(new FlowLayout());
		
		chgPass = new JLabel("Change Password");
		add(chgPass);
		
		chgPassBtn = new JButton("Password");
		add(chgPassBtn);
	}
}
