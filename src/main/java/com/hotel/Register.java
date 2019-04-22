package com.hotel;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.hotel.model.Employee;
import com.hotel.service.EmployeeService;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

@SpringBootApplication
public class Register {

	private JFrame frame;
	private JTextField txtFname;
	private JTextField txtLname;
	private JTextField txtUsername;

	@Autowired
	private EmployeeService empService;
	private JPasswordField pwdPassword;
	private JPasswordField pwdConfrimPassword;
	
	@Autowired
	private SignIn login;
	
	@Autowired
	private Register reg;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		
		final ConfigurableApplicationContext ctx = new SpringApplicationBuilder(Register.class).headless(false).run(args);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register ex = ctx.getBean(Register.class);
					ex.frame.setVisible(true);
				} catch (BeansException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	/**
	 * @wbp.parser.entryPoint
	 */
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 412, 438);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 438, 35);
		frame.getContentPane().add(panel);
		
		JLabel lblRegisterStaff = new JLabel("Register Staff");
		panel.add(lblRegisterStaff);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(31, 69, 93, 16);
		frame.getContentPane().add(lblFirstName);
		
		txtFname = new JTextField();
		txtFname.setBounds(31, 98, 130, 26);
		frame.getContentPane().add(txtFname);
		txtFname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(248, 69, 130, 16);
		frame.getContentPane().add(lblLastName);
		
		txtLname = new JTextField();
		txtLname.setBounds(248, 98, 130, 26);
		frame.getContentPane().add(txtLname);
		txtLname.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(31, 136, 130, 16);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblUserRole = new JLabel("User Role");
		lblUserRole.setBounds(248, 136, 61, 16);
		frame.getContentPane().add(lblUserRole);
		
		final JComboBox cmbUserRole = new JComboBox();
		cmbUserRole.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Staff"}));
		cmbUserRole.setBounds(248, 165, 130, 27);
		frame.getContentPane().add(cmbUserRole);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(31, 164, 130, 26);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				Employee emp = new Employee();
				emp.setFname(txtFname.getText());
				emp.setLname(txtLname.getText());
				emp.setUsername(txtUsername.getText());
				emp.setRole(cmbUserRole.getSelectedIndex());
				emp.setPassword(String.valueOf(pwdPassword.getPassword()));
				
				if(empService.register(emp)) {
					
					//Register reg = new Register();
					reg.frame.setVisible(false);
					
					login.frame.setVisible(true);
					
				}
				
				
			}
		});
		btnRegister.setBounds(156, 337, 117, 29);
		frame.getContentPane().add(btnRegister);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(31, 221, 61, 16);
		frame.getContentPane().add(lblPassword);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(31, 263, 130, 26);
		frame.getContentPane().add(pwdPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(248, 221, 117, 16);
		frame.getContentPane().add(lblConfirmPassword);
		
		pwdConfrimPassword = new JPasswordField();
		pwdConfrimPassword.setBounds(248, 263, 117, 26);
		frame.getContentPane().add(pwdConfrimPassword);
	}
}
