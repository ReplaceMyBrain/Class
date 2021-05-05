package com.javalec.login; // 04/28 양현준 아이디 찾기 기능 

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.javalec.Datadefine.data_Enviroment_define;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchId extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfUserName;
	private JTextField tfUserEmail;
	private String Email[] = {"직접입력", "naver.com", "gmail.com", "hanmail.net", "nate.com"}; // 콤보 박스 내용
	JComboBox<String> cBEmail = new JComboBox(Email);
	data_Enviroment_define dataDefine = new data_Enviroment_define();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SearchId dialog = new SearchId();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setTitle("아이디 찾기");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SearchId() {
		setBounds(100, 100, 400, 480);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(34, 351, 335, 12);
		contentPanel.add(separator_2);
		{
			JLabel lblUserName = new JLabel("이름");
			lblUserName.setForeground(new Color(51, 51, 51));
			lblUserName.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
			lblUserName.setBounds(31, 212, 61, 16);
			contentPanel.add(lblUserName);
		}
		{
			JLabel lblUserEmail = new JLabel("E-mail");
			lblUserEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
			lblUserEmail.setBounds(31, 275, 61, 16);
			contentPanel.add(lblUserEmail);
		}
		contentPanel.add(getTfUserName());
		contentPanel.add(getTfUserEmail());
		
		cBEmail.setBounds(270, 262, 100, 45);
		contentPanel.add(cBEmail);
		{
		JLabel lblNewLabel = new JLabel("@");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel.setBounds(257, 268, 17, 26);
		contentPanel.add(lblNewLabel);
		}
		JLabel Label_Title = new JLabel("✓ 아이디 찾기");
		Label_Title.setFont(new Font("Kefa", Font.PLAIN, 20));
		Label_Title.setBounds(34, 54, 199, 26);
		contentPanel.add(Label_Title);
		{
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(35, 90, 335, 37);
		contentPanel.add(separator);
		}
		{
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(31, 240, 335, 12);
			contentPanel.add(separator_1);
		}
		{
			JButton btnOK = new JButton("아이디 찾기");
			btnOK.setFont(new Font("Lucida Grande", Font.BOLD, 14));
			btnOK.setBounds(135, 375, 114, 44);
			contentPanel.add(btnOK);
			btnOK.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String tfUserNamestr = tfUserName.getText().trim();
					String tfUserEmailstr = tfUserEmail.getText().trim();
					
					if (tfUserNamestr.equals("") || tfUserEmailstr.equals("")) {
						JOptionPane.showMessageDialog(null, "이름과 이메일에 빈칸이 없는지 확인해주세요!");
					} else {
						findIdAction(); 
					}
				}
			});
			btnOK.setBackground(new Color(102, 102, 102));
			btnOK.setActionCommand("OK");
			getRootPane().setDefaultButton(btnOK);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("이름과 이메일을 입력해 주세요.");
			lblNewLabel_1.setForeground(new Color(102, 102, 102));
			lblNewLabel_1.setBounds(45, 111, 297, 16);
			contentPanel.add(lblNewLabel_1);
		}
		
	}
	private JTextField getTfUserName() {
		if (tfUserName == null) {
			tfUserName = new JTextField();
			tfUserName.setBounds(93, 205, 114, 30);
			tfUserName.setColumns(10);
		}
		return tfUserName;
	}
	private JTextField getTfUserEmail() {
		if (tfUserEmail == null) {
			tfUserEmail = new JTextField();
			tfUserEmail.setColumns(10);
			tfUserEmail.setBounds(94, 268, 164, 30);
		}
		return tfUserEmail;
	}
	
	
	public void findIdAction() {
		PreparedStatement ps = null;
		String searchedId = "";

 		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(dataDefine.url_mysql, dataDefine.id_mysql, dataDefine.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			String cbEmailStr = cBEmail.getSelectedItem().toString(); // combobox에서 받아온 글자
			if(cbEmailStr.equals("직접입력")) {
				cbEmailStr = "";
			} else {
				cbEmailStr = "@" + cBEmail.getSelectedItem().toString();
			}
			
			String query = "SELECT userId FROM user where userName = '" + tfUserName.getText().trim() + "' and userEmail = '" + tfUserEmail.getText().trim() + cbEmailStr + "';"; // ' 사용에 유의!!
			ResultSet rs = stmt_mysql.executeQuery(query); // 쿼리문장을 실행해서 ResultSet타입으로 변환.
			
			while(rs.next()) {
				searchedId = (rs.getString(1));
			}
			
			if(searchedId == "") { // 가져온 searchedId가 없을 경우 (Null
				JOptionPane.showMessageDialog(null, "일치하는 아이디가 없습니다. 이름과 메일을 확인하세요!" , "오류 메세지", JOptionPane.ERROR_MESSAGE);
				
			}else {
				JOptionPane.showMessageDialog(null,  tfUserName.getText() + " 님의 아이디는 " + searchedId + " 입니다!");
				panelClean();
			}
			conn_mysql.close(); // DB 연결 끊기
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); // 화면에 에러코드 보여주기
		}
	}
	
	public void panelClean() {
		tfUserName.setText("");
		tfUserEmail.setText("");
	}
}
