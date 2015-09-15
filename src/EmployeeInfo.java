import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.sql.*;
import javax.swing.*;
import java.awt.Color;

public class EmployeeInfo extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeInfo frame = new EmployeeInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void close(){

		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);

	}
	
	
	Connection connection = null ;
	
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtNid;
	private JTextField textC_id;
	
	
	
	public void refreshTable(){
		try{
			String query = "select c_id,cName,age,NID from customerInfo";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs) );
			
			
			
		}catch(Exception e){
			
			JOptionPane.showMessageDialog(null, e);
			
		}
		
	}
	
	/**
	 * Create the frame.
	 */
	public EmployeeInfo() {
		
		connection = sqliteConnection.dbConnector();
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 749, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDisplayData = new JButton("Display Table Data");
		btnDisplayData.setBackground(new Color(51, 204, 255));
		btnDisplayData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "select c_id,cName,age,NID from customerInfo";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs) );
					
					
					
				}catch(Exception e){
					
					JOptionPane.showMessageDialog(null, e);
					
				}
				
			}
		});
		btnDisplayData.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDisplayData.setBounds(145, 23, 480, 56);
		contentPane.add(btnDisplayData);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(256, 134, 428, 315);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setBounds(83, 147, 112, 31);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setHorizontalAlignment(SwingConstants.CENTER);
		txtAge.setBounds(83, 203, 112, 31);
		contentPane.add(txtAge);
		txtAge.setColumns(10);
		
		txtNid = new JTextField();
		txtNid.setHorizontalAlignment(SwingConstants.CENTER);
		txtNid.setBounds(83, 245, 112, 36);
		contentPane.add(txtNid);
		txtNid.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(27, 150, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(27, 206, 46, 14);
		contentPane.add(lblAge);
		
		JLabel lblNationalId = new JLabel("National ID");
		lblNationalId.setBounds(10, 252, 80, 17);
		contentPane.add(lblNationalId);
		
		JButton btnInsert = new JButton("ADD ");
		btnInsert.setBackground(new Color(51, 204, 255));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String query = "insert into customerInfo (cName,age,NID) values(?,?,?) ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, txtName.getText() );
					pst.setString(2, txtAge.getText() );
					pst.setString(3, txtNid.getText() );
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "      Data   Saved ");
					
					//ResultSet rs = pst.executeQuery();
					
					pst.close();
					
					
					//rs.close();
					
				}catch(Exception es){
					es.printStackTrace();
				}
				
				refreshTable();
				
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnInsert.setBounds(55, 321, 117, 31);
		contentPane.add(btnInsert);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(51, 204, 255));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = " Update customerInfo set cName=' "+txtName.getText()+" ' , age=' "+txtAge.getText()+ " ' , NID=' "+txtNid.getText()+ " ' where c_id=' "+textC_id.getText()+" '  ";
					PreparedStatement pst = connection.prepareStatement(query);
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "         Data   Updated   ");
					
					//ResultSet rs = pst.executeQuery();
					
					pst.close();
					
					
					//rs.close();
					
				}catch(Exception es){
					es.printStackTrace();
				}
				
				refreshTable();
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.setBounds(55, 363, 117, 35);
		contentPane.add(btnUpdate);
		
		textC_id = new JTextField();
		textC_id.setHorizontalAlignment(SwingConstants.CENTER);
		textC_id.setBounds(182, 363, 64, 69);
		contentPane.add(textC_id);
		textC_id.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(51, 204, 255));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int action = JOptionPane.showConfirmDialog(null, "Do you really want to DELETE !!! " , "Delete Confirmation", JOptionPane.YES_NO_OPTION );
				
				if(action == 0 ){
					
					try{
						String query = "delete from customerInfo where c_id=' "+textC_id.getText()+" '";
						PreparedStatement pst = connection.prepareStatement(query);
						
						
						pst.execute();
						
						JOptionPane.showMessageDialog(null, "         Data   Deleted  ");
						
						//ResultSet rs = pst.executeQuery();
						
						pst.close();
						
						
						//rs.close();
						
					}catch(Exception es){
						es.printStackTrace();
					}
					
					refreshTable();
					
				}
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDelete.setBounds(55, 409, 117, 23);
		contentPane.add(btnDelete);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.setBackground(new Color(51, 204, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Hotel httv = new Hotel();
				httv.setVisible(true);
				close();
			}
		});
		btnNewButton.setBounds(55, 443, 89, 23);
		contentPane.add(btnNewButton);
		
		refreshTable();
		
	}
}
