import java.awt.EventQueue;

import java.sql.*;
import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null ;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;
	

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		
		connection = sqliteConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.setBounds(100, 100, 473, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name  : ");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setBounds(62, 110, 130, 24);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password  :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(62, 181, 130, 24);
		frame.getContentPane().add(lblPassword);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(190, 110, 161, 24);
		frame.getContentPane().add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(190, 181, 161, 24);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(51, 204, 255));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "select * from admin where username=? and password=? ";
					PreparedStatement pst = connection.prepareStatement(query);
					
					pst.setString(1, textFieldUsername.getText() );
					pst.setString(2, passwordField.getText() );
					
					ResultSet rs = pst.executeQuery();
					
					int count = 0;
					while(rs.next() ){
						count++;
					}
					
					if( count == 1 ){
						JOptionPane.showMessageDialog(null, "Username and Password is Correct ");
						
						frame.dispose();
						//EmployeeInfo empInfo = new EmployeeInfo();
						//empInfo.setVisible(true);
						
						Hotel hotel = new Hotel();
						hotel.setVisible(true);
						
					}else if( count > 1 ){
						JOptionPane.showMessageDialog(null, "Duplicate Username and Password ");
					}else{
						JOptionPane.showMessageDialog(null, "Wrong information . Try again.... ");
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception e){
					
					JOptionPane.showMessageDialog(null, e);
					
				}
				
				
				
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnLogin.setBounds(155, 265, 196, 45);
		frame.getContentPane().add(btnLogin);
	}
}
