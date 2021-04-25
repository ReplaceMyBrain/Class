package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JPanel;

public class Main {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_3_1;
	private JLabel lblNewLabel_4;
	private JPanel loginPanel;
	private JPanel idSearchPanel;
	private JPanel pwSearchPanel;
	private JPanel userPanel;
	private JPanel adminPanel;
	private JTextField tfidSearchName;
	private JTextField tfIdSearchEmail;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getIdSearchPanel());
		frame.getContentPane().add(getLoginPanel());
		frame.getContentPane().add(getPwSearchPanel());
		frame.getContentPane().add(getUserPanel());
		frame.getContentPane().add(getAdminPanel());
		
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("제목(미정)");
			lblNewLabel.setBounds(138, 23, 124, 75);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Tj");
			lblNewLabel_1.setBounds(138, 118, 111, 119);
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		}
		return lblNewLabel_1;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(60, 260, 280, 43);
			textField.setForeground(Color.LIGHT_GRAY);
			textField.setText("  아이디");
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(60, 315, 280, 43);
			textField_1.setForeground(Color.LIGHT_GRAY);
			textField_1.setText("  비밀번호");
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(60, 408, 280, 43);
			textField_2.setForeground(Color.WHITE);
			textField_2.setText("로그인");
			textField_2.setBackground(UIManager.getColor("Desktop.background"));
			textField_2.setHorizontalAlignment(JTextField.CENTER);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("계정이 없으신가요?");
			lblNewLabel_2.setBounds(60, 370, 110, 16);
			lblNewLabel_2.setForeground(Color.GRAY);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("여기를 클릭하세요!");
			lblNewLabel_2_1.setBounds(171, 370, 110, 16);
			lblNewLabel_2_1.setForeground(SystemColor.controlHighlight);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("아이디 찾기");
			lblNewLabel_3.setBounds(128, 463, 61, 16);
			lblNewLabel_3.setForeground(Color.GRAY);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("비밀번호 찾기");
			lblNewLabel_3_1.setBounds(210, 463, 71, 16);
			lblNewLabel_3_1.setForeground(Color.GRAY);
		}
		return lblNewLabel_3_1;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("|");
			lblNewLabel_4.setBounds(195, 463, 15, 16);
			lblNewLabel_4.setForeground(Color.GRAY);
		}
		return lblNewLabel_4;
	}
	
	private JPanel getLoginPanel() { //
		if (loginPanel == null) {
			loginPanel = new JPanel();
			loginPanel.setBounds(0, 0, 400, 572);
			loginPanel.setLayout(null);
			loginPanel.add(getLblNewLabel());
			loginPanel.add(getLblNewLabel_4());
			loginPanel.add(getLblNewLabel_1());
			loginPanel.add(getTextField());
			loginPanel.add(getTextField_1());
			loginPanel.add(getTextField_2());
			loginPanel.add(getLblNewLabel_2());
			loginPanel.add(getLblNewLabel_2_1());
			loginPanel.add(getLblNewLabel_3());
			loginPanel.add(getLblNewLabel_3_1());
		}
		return loginPanel;
	}
	private JPanel getIdSearchPanel() {
		if (idSearchPanel == null) {
			idSearchPanel = new JPanel();
			idSearchPanel.setBounds(0, 0, 400, 572);
			idSearchPanel.setLayout(null);
			
			JLabel lblNewLabel_5 = new JLabel("제목(미정)");
			lblNewLabel_5.setBounds(134, 10, 124, 75);
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 30));
			idSearchPanel.add(lblNewLabel_5);
			
			tfidSearchName = new JTextField();
			tfidSearchName.setBounds(56, 275, 280, 43);
			tfidSearchName.setText("이름");
			tfidSearchName.setForeground(Color.LIGHT_GRAY);
			tfidSearchName.setColumns(10);
			idSearchPanel.add(tfidSearchName);
			
			tfIdSearchEmail = new JTextField();
			tfIdSearchEmail.setBounds(56, 371, 280, 43);
			tfIdSearchEmail.setText("이메일");
			tfIdSearchEmail.setForeground(Color.LIGHT_GRAY);
			tfIdSearchEmail.setColumns(10);
			idSearchPanel.add(tfIdSearchEmail);
			
			JLabel lblNewLabel_1_1_1 = new JLabel("ID 찾기");
			lblNewLabel_1_1_1.setBounds(134, 108, 111, 62);
			lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 30));
			idSearchPanel.add(lblNewLabel_1_1_1);
			
			JLabel lblNewLabel_6 = new JLabel("이름을 입력하세요");
			lblNewLabel_6.setFont(new Font("굴림", Font.PLAIN, 15));
			lblNewLabel_6.setBounds(54, 219, 142, 33);
			idSearchPanel.add(lblNewLabel_6);
			
			JLabel lblNewLabel_6_1 = new JLabel("이메일을 입력하세요");
			lblNewLabel_6_1.setFont(new Font("굴림", Font.PLAIN, 15));
			lblNewLabel_6_1.setBounds(54, 328, 142, 33);
			idSearchPanel.add(lblNewLabel_6_1);
			
			JButton btnidSearch = new JButton("아이디 찾기");
			btnidSearch.setBounds(134, 504, 111, 33);
			idSearchPanel.add(btnidSearch);
		}
		return idSearchPanel;
	}
	private JPanel getPwSearchPanel() {
		if (pwSearchPanel == null) {
			pwSearchPanel = new JPanel();
			pwSearchPanel.setBounds(0, 0, 400, 572);
			pwSearchPanel.setLayout(null);
		}
		return pwSearchPanel;
	}
	private JPanel getUserPanel() {
		if (userPanel == null) {
			userPanel = new JPanel();
			userPanel.setBounds(0, 0, 400, 572);
			userPanel.setLayout(null);
		}
		return userPanel;
	}
	private JPanel getAdminPanel() {
		if (adminPanel == null) {
			adminPanel = new JPanel();
			adminPanel.setBounds(0, 0, 400, 572);
			adminPanel.setLayout(null);
		}
		return adminPanel;
	}
}
