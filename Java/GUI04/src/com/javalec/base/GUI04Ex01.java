package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI04Ex01 {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField tfUserid;
	private JPasswordField pfInput;
	private JButton btnLogin;
	private JTextField tfResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI04Ex01 window = new GUI04Ex01();
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
	public GUI04Ex01() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getTfUserid());
		frame.getContentPane().add(getPfInput());
		frame.getContentPane().add(getBtnLogin());
		frame.getContentPane().add(getTfResult());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("userid");
			lblNewLabel.setBounds(31, 26, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("password");
			lblNewLabel_1.setBounds(31, 66, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JTextField getTfUserid() {
		if (tfUserid == null) {
			tfUserid = new JTextField();
			tfUserid.setBounds(100, 23, 116, 21);
			tfUserid.setColumns(10);
		}
		return tfUserid;
	}
	private JPasswordField getPfInput() {
		if (pfInput == null) {
			pfInput = new JPasswordField();
			pfInput.setBounds(100, 63, 116, 21);
		}
		return pfInput;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Login");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkPassword();
				}
			});
			btnLogin.setBounds(267, 22, 97, 23);
		}
		return btnLogin;
	}
	private JTextField getTfResult() {
		if (tfResult == null) {
			tfResult = new JTextField();
			tfResult.setEditable(false);
			tfResult.setBounds(98, 118, 195, 21);
			tfResult.setColumns(10);
		}
		return tfResult;
	}
	private void checkPassword() {
		String id = tfUserid.getText(); // 아이디 받기.
		
		char[] str = pfInput.getPassword(); // 패스워드 받기
		String passString = new String(str);
		
		
		if (id.equals("abc") && passString.equals("1234")) {
			tfResult.setText("로그인되었습니다.");
		} else {
			tfResult.setText("Id 또는 비밀번호가 틀립니다.");
		}
		
	
	}
	
}////////
