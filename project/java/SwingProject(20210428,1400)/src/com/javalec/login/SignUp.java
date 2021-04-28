package com.javalec.login;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp extends JDialog {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPanel panel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_2;
	private JLabel lblNewLabel_2_3;
	private JTextField tfSignName;
	private JTextField tfSignId;
	private JTextField tfSignEmail;
	private JButton btnSignUp;
	private JButton btnOverlap;
	private JPasswordField pwSignPw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SignUp dialog = new SignUp();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SignUp() {
		setBounds(100, 100, 430, 530);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getPanel());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("회원가입");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
			lblNewLabel.setBounds(147, 10, 120, 83);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("로고");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 30));
			lblNewLabel_1.setBounds(147, 103, 120, 83);
		}
		return lblNewLabel_1;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(12, 217, 390, 264);
			panel.setLayout(null);
			panel.add(getLblNewLabel_2());
			panel.add(getLblNewLabel_2_1());
			panel.add(getLblNewLabel_2_2());
			panel.add(getLblNewLabel_2_3());
			panel.add(getTfSignName());
			panel.add(getTfSignId());
			panel.add(getTfSignEmail());
			panel.add(getBtnSignUp());
			panel.add(getBtnOverlap());
			panel.add(getPwSignPw());
		}
		return panel;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("이름 :");
			lblNewLabel_2.setBounds(12, 10, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("ID :");
			lblNewLabel_2_1.setBounds(12, 65, 57, 15);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_2_2() {
		if (lblNewLabel_2_2 == null) {
			lblNewLabel_2_2 = new JLabel("PW :");
			lblNewLabel_2_2.setBounds(12, 120, 57, 15);
		}
		return lblNewLabel_2_2;
	}
	private JLabel getLblNewLabel_2_3() {
		if (lblNewLabel_2_3 == null) {
			lblNewLabel_2_3 = new JLabel("Email :");
			lblNewLabel_2_3.setBounds(12, 175, 57, 15);
		}
		return lblNewLabel_2_3;
	}
	private JTextField getTfSignName() {
		if (tfSignName == null) {
			tfSignName = new JTextField();
			tfSignName.setBounds(12, 34, 133, 21);
			tfSignName.setColumns(10);
		}
		return tfSignName;
	}
	private JTextField getTfSignId() {
		if (tfSignId == null) {
			tfSignId = new JTextField();
			tfSignId.setColumns(10);
			tfSignId.setBounds(12, 90, 133, 21);
		}
		return tfSignId;
	}
	private JTextField getTfSignEmail() {
		if (tfSignEmail == null) {
			tfSignEmail = new JTextField();
			tfSignEmail.setColumns(10);
			tfSignEmail.setBounds(12, 200, 250, 21);
		}
		return tfSignEmail;
	}
	private JButton getBtnSignUp() {
		if (btnSignUp == null) {
			btnSignUp = new JButton("가입");
			btnSignUp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertAction();
				}
			});
			btnSignUp.setBounds(281, 231, 97, 23);
		}
		return btnSignUp;
	}
	private JButton getBtnOverlap() {
		if (btnOverlap == null) {
			btnOverlap = new JButton("중복검사");
			btnOverlap.setBounds(157, 89, 97, 23);
		}
		return btnOverlap;
	}
	private JPasswordField getPwSignPw() {
		if (pwSignPw == null) {
			pwSignPw = new JPasswordField();
			pwSignPw.setBounds(12, 145, 250, 21);
		}
		return pwSignPw;
	}
	
	public void insertAction() {
		
	}
	
	
	
	
	
	
	
}//===============
