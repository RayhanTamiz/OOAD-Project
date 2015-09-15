import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.*;
import java.awt.*;

public class Hotel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hotel frame = new Hotel();
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
	

	/**
	 * Create the frame.
	 */
	public Hotel() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 695, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddReservation = new JButton("Add Reservation");
		btnAddReservation.setBackground(new Color(51, 204, 255));
		btnAddReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddReservation adr = new AddReservation();
				adr.setVisible(true);
				close();
				
			}
			
		});
		btnAddReservation.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddReservation.setBounds(446, 63, 185, 42);
		contentPane.add(btnAddReservation);
		
		JButton btnNewButton = new JButton("Check In Guest");
		btnNewButton.setBackground(new Color(51, 204, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
				CheckInGuest chk = new CheckInGuest();
				chk.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(446, 116, 185, 42);
		contentPane.add(btnNewButton);
		
		JButton btnCheckOutGuest = new JButton("Check Out Guest");
		btnCheckOutGuest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCheckOutGuest.setBackground(new Color(51, 204, 255));
		btnCheckOutGuest.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCheckOutGuest.setBounds(446, 169, 185, 42);
		contentPane.add(btnCheckOutGuest);
		
		JButton btnTransportService = new JButton("Transport Service");
		btnTransportService.setBackground(new Color(51, 204, 255));
		btnTransportService.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTransportService.setBounds(446, 232, 185, 42);
		contentPane.add(btnTransportService);
		
		JButton btnCancelReservation = new JButton("Cancel Reservation");
		btnCancelReservation.setBackground(new Color(51, 204, 255));
		btnCancelReservation.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancelReservation.setBounds(446, 285, 189, 36);
		contentPane.add(btnCancelReservation);
		
		JButton btnFoodCater = new JButton("Food Catering ");
		btnFoodCater.setBackground(new Color(51, 204, 255));
		btnFoodCater.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnFoodCater.setBounds(446, 332, 185, 39);
		contentPane.add(btnFoodCater);
		
		JLabel lblHotelManagementSystem = new JLabel("Hotel Management System");
		lblHotelManagementSystem.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblHotelManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotelManagementSystem.setBounds(10, 11, 363, 48);
		contentPane.add(lblHotelManagementSystem);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/hotels.jpg") ).getImage();
		lblNewLabel.setIcon(new ImageIcon(img) );
		lblNewLabel.setBounds(10, 59, 414, 359);
		contentPane.add(lblNewLabel);
		
		JButton btnShowDatabase = new JButton("Show Database");
		btnShowDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				EmployeeInfo empInfo = new EmployeeInfo();
				empInfo.setVisible(true);
			}
		});
		btnShowDatabase.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnShowDatabase.setBackground(new Color(51, 204, 255));
		btnShowDatabase.setBounds(446, 382, 185, 36);
		contentPane.add(btnShowDatabase);
	}
}
