import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

import java.sql.*;
import javax.swing.*;
import java.awt.Color;

public class CheckInGuest extends JFrame {

	private JPanel contentPane;
	private JTextField AssignRoom;
	private JLabel lblCustomerId;
	private JTextField CheckID;
	
	Connection connection = null ;
	private JButton btnNewButton;
	
	public void close(){

		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckInGuest frame = new CheckInGuest();
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
	public CheckInGuest() {
		
		connection = sqliteConnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAssignRoomNumber = new JLabel("Assign Room Number");
		lblAssignRoomNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAssignRoomNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblAssignRoomNumber.setBounds(10, 72, 181, 35);
		contentPane.add(lblAssignRoomNumber);
		
		AssignRoom = new JTextField();
		AssignRoom.setBounds(271, 81, 118, 26);
		contentPane.add(AssignRoom);
		AssignRoom.setColumns(10);
		
		JButton btnMakeAssignment = new JButton("Make Assignment");
		btnMakeAssignment.setBackground(new Color(51, 204, 255));
		btnMakeAssignment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "Update customerInfo set   roomNum=' "+AssignRoom.getText()+ " ' where c_id=' "+CheckID.getText()+" '   ";
					PreparedStatement pst = connection.prepareStatement(query);
					
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "     Room Assignment  Confirmed  ");
					
					//ResultSet rs = pst.executeQuery();
					
					pst.close();
					
					
					//rs.close();
					
				}catch(Exception es){
					es.printStackTrace();
				}
				
				
			}
		});
		btnMakeAssignment.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMakeAssignment.setBounds(112, 150, 221, 46);
		contentPane.add(btnMakeAssignment);
		
		lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCustomerId.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerId.setBounds(37, 28, 154, 46);
		contentPane.add(lblCustomerId);
		
		CheckID = new JTextField();
		CheckID.setBounds(269, 43, 103, 27);
		contentPane.add(CheckID);
		CheckID.setColumns(10);
		
		btnNewButton = new JButton("Return");
		btnNewButton.setBackground(new Color(51, 204, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				Hotel hff= new Hotel();
				hff.setVisible(true);
			}
		});
		btnNewButton.setBounds(176, 209, 89, 23);
		contentPane.add(btnNewButton);
	}
}
