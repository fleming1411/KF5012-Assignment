import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class LogoutButtonClass {
	public class LogoutButtonClass implements ActionListener {
		public void actionPerformed(ActionEvent lbc) {
			dispose();
			Toolkit.getDefaultToolkit().beep();
			Logout gui = new Logout(MainMenu.this);
			gui.setSize(300, 100);
			gui.setVisible(true);
			gui.setTitle("Logout");
			gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			gui.setLocationRelativeTo(null);
		}
	}
}
