package com.javalec.userMain;

import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelUserProfile extends JPanel {
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JLabel lblNewLabel_3;
	private JTextField textField_2;
	private JLabel lblNewLabel_4;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNewLabel_2;
	private JButton btnUserProfileEdit;

	/**
	 * Create the panel.
	 */
	public PanelUserProfile() {
		setBounds(new Rectangle(180, 10, 500, 420));
		setLayout(null);
		add(getLblNewLabel());
		add(getTextField());
		add(getLblNewLabel_1());
		add(getTextField_1());
		add(getLblNewLabel_3());
		add(getTextField_2());
		add(getLblNewLabel_4());
		add(getTextField_3());
		add(getTextField_4());
		add(getLblNewLabel_2());
		add(getBtnUserProfileEdit());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("이름       :");
			lblNewLabel.setBounds(37, 44, 57, 15);
		}
		return lblNewLabel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(117, 41, 116, 21);
		}
		return textField;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("ID          :");
			lblNewLabel_1.setBounds(37, 116, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(117, 185, 211, 21);
		}
		return textField_1;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("MBTI      :");
			lblNewLabel_3.setBounds(37, 260, 67, 15);
		}
		return lblNewLabel_3;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setEnabled(false);
			textField_2.setColumns(10);
			textField_2.setBounds(116, 257, 116, 21);
		}
		return textField_2;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("적성검사  :");
			lblNewLabel_4.setBounds(37, 332, 79, 15);
		}
		return lblNewLabel_4;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setEnabled(false);
			textField_3.setColumns(10);
			textField_3.setBounds(117, 329, 116, 21);
		}
		return textField_3;
	}
	private JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setEnabled(false);
			textField_4.setColumns(10);
			textField_4.setBounds(117, 113, 116, 21);
		}
		return textField_4;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Email     :");
			lblNewLabel_2.setBounds(37, 188, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JButton getBtnUserProfileEdit() {
		if (btnUserProfileEdit == null) {
			btnUserProfileEdit = new JButton("수정");
			btnUserProfileEdit.setBounds(355, 328, 97, 23);
		}
		return btnUserProfileEdit;
	}
}
