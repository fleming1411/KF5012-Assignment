import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddStaff extends JFrame {
	
	/*
	 * Declare variables
	 */
	
	private JLabel id, position, surname, forename, dob, address, strength, weakness, username, password, security, notes;
	private JTextField newId, newPos, newSur, newFor, newDob, newAddr, newStr, newWea, newUser, newPass, newSec;
	private JTextArea newNote;
	private JButton confirm;
	
	private JPanel idPan, posPan, surPan, forPan, dobPan, addPan, strPan, weaPan, userPan, passPan, secPan, notesPan, btnPan;
	
	private String driver = "jdbc:sqlite:";
	private String db = "C:\\Users\\flemi\\Documents\\folder\\capytec.db";
	private String url = driver + db;
	protected Connection conn = null;
	
	/*
	 * Constructor
	 */
	
	public AddStaff() {
		Container pane = this.getContentPane();
		pane.setLayout(new GridLayout(13, 2, 2, 2));
		
		idPan = new JPanel();
		idPan.setLayout(new GridLayout(1, 1));
		
		id = new JLabel("ID", SwingConstants.CENTER);
		idPan.add(id);
		
		newId = new JTextField(15);
		idPan.add(newId);
		
		pane.add(idPan);
		
		posPan = new JPanel();
		posPan.setLayout(new GridLayout(1, 1));
		
		position = new JLabel("Position", SwingConstants.CENTER);
		posPan.add(position);
		
		newPos = new JTextField(15);
		posPan.add(newPos);
		
		pane.add(posPan);
		
		surPan = new JPanel();
		surPan.setLayout(new GridLayout(1, 1));
		
		surname = new JLabel("Surname", SwingConstants.CENTER);
		surPan.add(surname);
		
		newSur = new JTextField(15);
		surPan.add(newSur);
		
		pane.add(surPan);
		
		forPan = new JPanel();
		forPan.setLayout(new GridLayout(1, 1));
		
		forename = new JLabel("Forename", SwingConstants.CENTER);
		forPan.add(forename);
		
		newFor = new JTextField(15);
		forPan.add(newFor);
		
		pane.add(forPan);
		
		dobPan = new JPanel();
		dobPan.setLayout(new GridLayout(1, 1));
		
		dob = new JLabel("DoB", SwingConstants.CENTER);
		dobPan.add(dob);
		
		newDob = new JTextField(15);
		dobPan.add(newDob);
		
		pane.add(dobPan);
		
		addPan = new JPanel();
		addPan.setLayout(new GridLayout(1, 1));
		
		address = new JLabel("Address", SwingConstants.CENTER);
		addPan.add(address);
		
		newAddr = new JTextField(15);
		addPan.add(newAddr);
		
		pane.add(addPan);
		
		strPan = new JPanel();
		strPan.setLayout(new GridLayout(1, 1));
		
		strength = new JLabel("Strength", SwingConstants.CENTER);
		strPan.add(strength);
		
		newStr = new JTextField(15);
		strPan.add(newStr);
		
		pane.add(strPan);
		
		weaPan = new JPanel();
		weaPan.setLayout(new GridLayout(1, 1));
		
		weakness = new JLabel("Weakness", SwingConstants.CENTER);
		weaPan.add(weakness);
		
		newWea = new JTextField(15);
		weaPan.add(newWea);
		
		pane.add(weaPan);
		
		userPan = new JPanel();
		userPan.setLayout(new GridLayout(1, 1));
		
		username = new JLabel("Username", SwingConstants.CENTER);
		userPan.add(username);
		
		newUser = new JTextField(15);
		userPan.add(newUser);
		
		pane.add(userPan);
		
		passPan = new JPanel();
		passPan.setLayout(new GridLayout(1, 1));
		
		password = new JLabel("Password", SwingConstants.CENTER);
		passPan.add(password);
		
		newPass = new JTextField(15);
		passPan.add(newPass);
		
		pane.add(passPan);
		
		secPan = new JPanel();
		secPan.setLayout(new GridLayout(1, 1));
		
		security = new JLabel("Security Level", SwingConstants.CENTER);
		secPan.add(security);
		
		newSec = new JTextField(15);
		secPan.add(newSec);
		
		pane.add(secPan);
		
		notesPan = new JPanel();
		notesPan.setLayout(new GridLayout(1, 1));
		
		notes = new JLabel("Notes", SwingConstants.CENTER);
		notesPan.add(notes);
		
		newNote = new JTextArea(15, 2);
		notesPan.add(newNote);
		
		pane.add(notesPan);
		
		btnPan = new JPanel();
		btnPan.setLayout(new GridLayout(1, 1));
		
		confirm = new JButton("Confirm");
		btnPan.add(confirm);
		
		ConfirmButtonClass cbc = new ConfirmButtonClass();
		confirm.addActionListener(cbc);
		
		pane.add(btnPan);
		
	}
		/*
		 * Action listener on add button
		 */
		
	public class ConfirmButtonClass implements ActionListener {
		public void actionPerformed(ActionEvent abc) {
			int newIdentification = Integer.parseInt(newId.getText());
			String newPosition = newPos.getText();
			String newSurname = newSur.getText();
			String newForename = newFor.getText();
			String newDofb = newDob.getText();
			String newAddress = newAddr.getText();
			String newStrength = newStr.getText();
			String newWeakness = newWea.getText();
			String newSecurity = newSec.getText();
			String newNotes = newNote.getText();
			String username = null;
			String password = null;
			
			String sql = "INSERT INTO Staff VALUES ("
					+ "'" + newIdentification + "',"
					+ "'" + newPosition + "',"
					+ "'" + newSurname + "',"
					+ "'" + newForename + "',"
					+ "'" + newDofb + "',"
					+ "'" + newAddress + "',"
					+ "'" + newStrength + "'," 
					+ "'" + newWeakness + "'," 
					+ "'" + username + "',"
					+ "'" + password + "',"
					+ "'" + newSecurity + "',"  
					+ "'" + newNotes + "'" 
					+ ")";
			try {
				conn = DriverManager.getConnection(url);
				Statement st = conn.createStatement();
				st.executeUpdate(sql);
				conn.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
			
			dispose();
			Staff gui = new Staff();
			gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			gui.pack();
			gui.setLocationRelativeTo(null);
			gui.setTitle("Capytec Staff");
			gui.setVisible(true);
		}
	}
	
}

