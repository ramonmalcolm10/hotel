package com.hotel;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.hotel.model.Employee;
import com.hotel.service.EmployeeService;

import javassist.tools.framedump;

import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Optional;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

@SpringBootApplication
public class SignIn {

	JFrame frame;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	
	@Autowired
	private EmployeeService empService;
	private JCheckBox chckbxShowPassword;

	/**
	 * Launch the application.
	 */
	
	 

	public static void main(String[] args) {

		final ConfigurableApplicationContext ctx = new SpringApplicationBuilder(SignIn.class).headless(false).run(args);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn ex = ctx.getBean(SignIn.class);
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
	public SignIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 256, 158);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblUsername = new JLabel("Username");
		frame.getContentPane().add(lblUsername);
		
		txtUsername = new JTextField();
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		frame.getContentPane().add(lblPassword);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setColumns(10);
		frame.getContentPane().add(pwdPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = txtUsername.getText();
				String password = String.valueOf(pwdPassword.getPassword());
				Optional<Employee> emp  = empService.login(username, password);
				if(emp.isPresent()) {
					SignIn login = new SignIn();
					login.frame.setVisible(false);
					
					if(emp.get().getRole() == 1)  {
					  Staff staff = new Staff();
					  staff.frame.setVisible(true);
					}
					else {
						Admin admin = new Admin();
						admin.frame.setVisible(true);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Invalid Credentials");
				}
			}
		});
		
		chckbxShowPassword = new JCheckBox("Show Password");
		chckbxShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxShowPassword.isSelected())	
					pwdPassword.setEchoChar((char)0);
				else
					pwdPassword.setEchoChar('•');
				
			}
		});
	
		frame.getContentPane().add(chckbxShowPassword);
		frame.getContentPane().add(btnLogin);
	}

}
