package com.hotel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Checkin {

	private JFrame frame;
	private JTextField txtFname;
	private JTextField txtLname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Checkin window = new Checkin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Checkin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 528, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCheckIn = new JLabel("Customer Check In");
		lblCheckIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckIn.setBounds(169, 26, 189, 56);
		frame.getContentPane().add(lblCheckIn);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(17, 99, 88, 16);
		frame.getContentPane().add(lblFirstName);
		
		txtFname = new JTextField();
		txtFname.setBounds(98, 94, 130, 26);
		frame.getContentPane().add(txtFname);
		txtFname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(269, 99, 72, 16);
		frame.getContentPane().add(lblLastName);
		
		txtLname = new JTextField();
		txtLname.setBounds(353, 94, 130, 26);
		frame.getContentPane().add(txtLname);
		txtLname.setColumns(10);
		
		JButton btnCheckIn = new JButton("Check In");
		btnCheckIn.setBounds(208, 342, 117, 29);
		frame.getContentPane().add(btnCheckIn);
		
		JLabel lblCheckOutDate = new JLabel("Check Out Date");
		lblCheckOutDate.setBounds(17, 149, 130, 16);
		frame.getContentPane().add(lblCheckOutDate);
	}
}
