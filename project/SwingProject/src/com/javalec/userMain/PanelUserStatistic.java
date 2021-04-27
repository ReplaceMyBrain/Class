package com.javalec.userMain;

import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PanelUserStatistic extends JPanel {
	private JLabel lblNewLabel_5;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public PanelUserStatistic() {
		setBounds(new Rectangle(180, 10, 500, 420));
		setLayout(null);
		add(getLblNewLabel_5());
		add(getTextField());
		add(getTextField_1());
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("나의 MBTI");
			lblNewLabel_5.setBounds(40, 58, 68, 24);
		}
		return lblNewLabel_5;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(40, 85, 200, 21);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(40, 128, 200, 21);
		}
		return textField_1;
	}
}
