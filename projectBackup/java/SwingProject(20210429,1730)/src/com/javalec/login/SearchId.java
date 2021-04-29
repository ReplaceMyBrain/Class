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

public class SearchId extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblProjectName;
	private JTextField tfUserName;
	private JTextField tfUserEmail;
	private JLabel lblSearchId;
	private String Email[] = {"naver", "gmail", "hanmail", "nate", "직접입력"}; // 콤보 박스 내용
//	JComboBox<E> // 04_28 현준 제작 중 :(
	
	data_Enviroment_define dataDefine = new data_Enviroment_define();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SearchId dialog = new SearchId();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
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
		contentPanel.add(getLblProjectName());
		{
			JLabel lblProjectSimbol = new JLabel("로고");
			lblProjectSimbol.setBounds(157, 99, 61, 16);
			contentPanel.add(lblProjectSimbol);
		}
		{
			JLabel lblUserName = new JLabel("이름");
			lblUserName.setBounds(20, 233, 61, 16);
			contentPanel.add(lblUserName);
		}
		{
			JLabel lblUserEmail = new JLabel("E-mail");
			lblUserEmail.setBounds(20, 294, 61, 16);
			contentPanel.add(lblUserEmail);
		}
		contentPanel.add(getTfUserName());
		contentPanel.add(getTfUserEmail());
		contentPanel.add(getLabel_1());
		
		JComboBox cBEmail = new JComboBox();
		cBEmail.setBounds(273, 290, 97, 27);
		contentPanel.add(cBEmail);
		
		JLabel lblNewLabel = new JLabel("@");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel.setBounds(258, 288, 17, 26);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnOK = new JButton("찾기");
				btnOK.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						findIdAction();  
					}
				});
				btnOK.setBackground(new Color(102, 153, 255));
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
	private JTextField getTfUserName() {
		if (tfUserName == null) {
			tfUserName = new JTextField();
			tfUserName.setBounds(93, 228, 273, 26);
			tfUserName.setColumns(10);
		}
		return tfUserName;
	}
	private JTextField getTfUserEmail() {
		if (tfUserEmail == null) {
			tfUserEmail = new JTextField();
			tfUserEmail.setColumns(10);
			tfUserEmail.setBounds(93, 289, 164, 26);
		}
		return tfUserEmail;
	}
	private JLabel getLabel_1() {
		if (lblSearchId == null) {
			lblSearchId = new JLabel("아이디 찾기");
			lblSearchId.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblSearchId.setBounds(139, 159, 147, 36);
		}
		return lblSearchId;
	}
	
	
	public void findIdAction() {
		PreparedStatement ps = null;
		String searchedId = "";

 		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(dataDefine.url_mysql, dataDefine.id_mysql, dataDefine.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			String query = "SELECT userId FROM user where userName = '" + tfUserName.getText().trim() + "' and userEmail = '" + tfUserEmail.getText().trim() + "';"; // ' 사용에 유의!!
			
			ResultSet rs = stmt_mysql.executeQuery(query); // 쿼리문장을 실행해서 ResultSet타입으로 변환.
			
			while(rs.next()) {
				searchedId = (rs.getString(1));
			}
			
			if(searchedId == "") { // 가져온 searchedId가 없을 경우 (Null
				JOptionPane.showMessageDialog(null, "일치하는 아이디가 없습니다. 이름과 메일을 확인하세요! ");
				
			}else {
				JOptionPane.showMessageDialog(null,  tfUserName.getText() + " 님의 아이디는 " + searchedId + " 입니다.");
			}
			conn_mysql.close(); // DB 연결 끊기
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); // 화면에 에러코드 보여주기
		}
	}
}
