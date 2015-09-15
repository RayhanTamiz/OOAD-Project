import javax.swing.border.EmptyBorder;

import java.sql.*;
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class AddReservation extends JFrame {

	private JPanel contentPane;
	private JTextField addResCname;
	private JTextField addResAge;
	private JTextField addResNid;

	Connection connection = null ;
	private JButton AddResReturn;
	
	
	
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
					AddReservation frame = new AddReservation();
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
	public AddReservation() {
		
		connection = sqliteConnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setBounds(50, 47, 129, 31);
		contentPane.add(lblCustomerName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(50, 102, 77, 31);
		contentPane.add(lblAge);
		
		JLabel lblNationalId = new JLabel("National ID");
		lblNationalId.setBounds(50, 157, 77, 31);
		contentPane.add(lblNationalId);
		
		addResCname = new JTextField();
		addResCname.setBounds(157, 49, 119, 26);
		contentPane.add(addResCname);
		addResCname.setColumns(10);
		
		addResAge = new JTextField();
		addResAge.setBounds(157, 107, 86, 26);
		contentPane.add(addResAge);
		addResAge.setColumns(10);
		
		addResNid = new JTextField();
		addResNid.setBounds(157, 157, 119, 25);
		contentPane.add(addResNid);
		addResNid.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD Reservation");
		btnNewButton.setBackground(new Color(51, 204, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String query = "insert into customerInfo (cName,age,NID) values(?,?,?) ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, addResCname.getText() );
					pst.setString(2, addResAge.getText() );
					pst.setString(3, addResNid.getText() );
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "      Data   Saved ");
					
					//ResultSet rs = pst.executeQuery();
					
					pst.close();
					
					
					//rs.close();
					
				}catch(Exception es){
					es.printStackTrace();
				}
				
				close();
				Hotel ht = new Hotel();
				ht.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(50, 238, 226, 45);
		contentPane.add(btnNewButton);
		
		AddResReturn = new JButton("Return");
		AddResReturn.setBackground(new Color(51, 204, 255));
		AddResReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				Hotel ht = new Hotel();
				ht.setVisible(true);
			}
		});
		AddResReturn.setBounds(315, 238, 109, 45);
		contentPane.add(AddResReturn);
	}

}
