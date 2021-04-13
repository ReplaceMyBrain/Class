package com.javalec.ex;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ex_01 {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblPassword;
	private JTextField tfId;
	private JPasswordField pfPass;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex_01 window = new Ex_01();
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
	public Ex_01() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 359, 199);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblPassword());
		frame.getContentPane().add(getTfId());
		frame.getContentPane().add(getPfPass());
		frame.getContentPane().add(getBtnLogin());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("UserId");
			lblNewLabel.setBounds(27, 55, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setBounds(27, 95, 57, 15);
		}
		return lblPassword;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(96, 52, 116, 21);
			tfId.setColumns(10);
		}
		return tfId;
	}
	private JPasswordField getPfPass() {
		if (pfPass == null) {
			pfPass = new JPasswordField();
			pfPass.setBounds(96, 92, 116, 21);
		}
		return pfPass;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Login");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					checkPassword();
				}
			});
			btnLogin.setBounds(224, 51, 86, 59);
		}
		return btnLogin;
	}
	
	private void checkPassword() {
		loginTure loginTure = new loginTure();
		
		String id = tfId.getText(); // 아이디 받기.
		
		char[] str = pfPass.getPassword(); // 패스워드 받기
		String passString = new String(str);
		
		
		if (id.equals("abc") && passString.equals("1234")) {
				loginTure.setVisible(true);
		} else {
				JOptionPane.showMessageDialog(null, "다시로그인해주세요.");
		}
		
	
	}
}
