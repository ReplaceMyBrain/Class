package com.javalec.login;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class SearchPW extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblProjectName;
	private JTextField tfUserId;
	private JTextField tfUserEmail;
	private JLabel lblSearchPW;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SearchPW dialog = new SearchPW();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SearchPW() {
		setBounds(100, 100, 400, 480);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblProjectName());
		{
			JLabel lblProjectSimbol = new JLabel("로고");
			lblProjectSimbol.setBounds(157, 99, 61, 16);
			contentPanel.add(lblProjectSimbol);
		}
		{
			JLabel lblUserID = new JLabel("ID");
			lblUserID.setBounds(20, 233, 61, 16);
			contentPanel.add(lblUserID);
		}
		{
			JLabel lblUserEmail = new JLabel("E-mail");
			lblUserEmail.setBounds(20, 294, 61, 16);
			contentPanel.add(lblUserEmail);
		}
		contentPanel.add(getTfUserId());
		contentPanel.add(getTfUserEmail());
		contentPanel.add(getLabel_1());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnOK = new JButton("확인");
				btnOK.setActionCommand("OK");
				buttonPane.add(btnOK);
				getRootPane().setDefaultButton(btnOK);
			}
			{
				JButton btnCancel = new JButton("취소");
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}
	private JLabel getLblProjectName() {
		if (lblProjectName == null) {
			lblProjectName = new JLabel("프로젝트이름");
			lblProjectName.setBounds(157, 35, 61, 16);
		}
		return lblProjectName;
	}
	private JTextField getTfUserId() {
		if (tfUserId == null) {
			tfUserId = new JTextField();
			tfUserId.setBounds(93, 228, 273, 26);
			tfUserId.setColumns(10);
		}
		return tfUserId;
	}
	private JTextField getTfUserEmail() {
		if (tfUserEmail == null) {
			tfUserEmail = new JTextField();
			tfUserEmail.setColumns(10);
			tfUserEmail.setBounds(93, 289, 273, 26);
		}
		return tfUserEmail;
	}
	private JLabel getLabel_1() {
		if (lblSearchPW == null) {
			lblSearchPW = new JLabel("비밀번호 찾기");
			lblSearchPW.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblSearchPW.setBounds(139, 159, 147, 36);
		}
		return lblSearchPW;
	}
}
