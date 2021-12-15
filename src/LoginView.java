import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class LoginView extends JFrame {

	// as global declaration
	private WishList wishList = new WishList();// access class WishList as global declaration
	private UserProfile userProfile = new UserProfile();
	Container pane = getContentPane();
	
	
	private JLabel loginUsernameL, loginUserPasswordL, invalidCred; // inside the panel of mainP
	private JTextField loginUsernameTF, loginUserPasswordTF;
	private JButton signInB;
	
	private JPanel mainP, loginFormP; // panels for CardLayout
	
	public LoginView() {
		
		// ======= Create main Page==============//
		pane.setLayout(new CardLayout());
		mainP = new JPanel(null);
		mainP.setBackground(Color.darkGray);

		
		pane.add(mainP, "welcomeForm");


		loginFormP = new JPanel(null);
		loginFormP.setBackground(Color.DARK_GRAY);

		loginUsernameL = new JLabel("Username :");
		loginUsernameL.setFont(new Font("Verdana", Font.BOLD, 15));
		loginUsernameL.setForeground(Color.CYAN);
		loginUsernameL.setBounds(50, 1, 250, 100);
		loginFormP.add(loginUsernameL);

		loginUserPasswordL = new JLabel("Password:");
		loginUserPasswordL.setFont(new Font("Verdana", Font.BOLD, 15));
		loginUserPasswordL.setForeground(Color.CYAN);
		loginUserPasswordL.setBounds(50, 50, 250, 100);
		loginFormP.add(loginUserPasswordL);

		loginUsernameTF = new JTextField("Enter Username"); // set as 10 ha
		loginUsernameTF.setHorizontalAlignment(JTextField.CENTER);
		loginUsernameTF.setForeground(Color.GRAY);
		loginUsernameTF.setBounds(300, 40, 250, 30);
		loginFormP.add(loginUsernameTF);

		loginUserPasswordTF = new JTextField("Enter Password"); // set as 10 ha
		loginUserPasswordTF.setHorizontalAlignment(JTextField.CENTER);
		loginUserPasswordTF.setForeground(Color.GRAY);
		loginUserPasswordTF.setBounds(300, 90, 250, 30);
		loginFormP.add(loginUserPasswordTF);
		
		invalidCred = new JLabel("Invalid Username / Password");
		invalidCred.setFont(new Font("Verdana", Font.BOLD, 15));
		invalidCred.setForeground(Color.RED);
		invalidCred.setBounds(50, 100, 250, 100);
		loginFormP.add(invalidCred);
		
		
		ImageIcon loginBackImage = new ImageIcon("images/customer.GIF");
		signInB = new JButton(loginBackImage);
		signInB.setBackground(Color.CYAN);
		signInB.setBounds(350, 200, 100, 50);
		signInB.setRolloverEnabled(true);
		signInB.setRolloverIcon(loginBackImage);
		signInB.setPressedIcon(loginBackImage);
		signInB.addActionListener(new validateLoginButton());
		signInB.setActionCommand("backToLogin");
		loginFormP.add(signInB);
		pane.add(loginFormP, "userLoginForm");
		
		CardLayout cL = (CardLayout) pane.getLayout();
		cL.show(pane, "userLoginForm");

	}
	
	
	private class validateLoginButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();
			pane.getComponents();

			String username = loginUsernameTF.getText();
			String passwrd = loginUserPasswordTF.getText(); 
			
			Boolean valid = DBUtils.validateLogin(username, passwrd);
			if(valid) {
				System.out.println(username+" logged in.. ");
			} else {
				System.out.println(username+" login failed.. ");
			}
			System.out.println(username+" "+ passwrd);
		}
	}


	private void printstack(Exception e) {
		// TODO Auto-generated method stub

	}
}