package com.javalec.login; // 04_28 현준 저녁에 할 예정 ㅎㅎ;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import com.javalec.Datadefine.data_Enviroment_define;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SearchPW extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfUserId;
	private JTextField tfUserEmail;
	private String Email[] = {"직접입력", "naver.com", "gmail.com", "hanmail.net", "nate.com"}; // 콤보 박스 내용
	JComboBox<String> cBEmail = new JComboBox(Email);
	data_Enviroment_define dataDefine = new data_Enviroment_define();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SearchPW dialog = new SearchPW();
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE); // 종료 버튼 기능 구현 위해 X 버튼 원래 기능을 막아놓는다. 
			dialog.setVisible(true);
			dialog.setTitle("비밀번호 찾기");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SearchPW() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { // 새롭게 만든 윈도우 종료버튼 클릭 이벤트 
				panelClean();
				e.getWindow().dispose();
			}
		});
		
		setBounds(100, 100, 400, 480);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		
		{
			JLabel Label_Title = new JLabel("✓ 비밀번호 찾기");
			Label_Title.setFont(new Font("Kefa", Font.PLAIN, 20));
			Label_Title.setBounds(34, 54, 199, 26);
			contentPanel.add(Label_Title);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("아이디와 이메일을 입력해 주세요.");
			lblNewLabel_1.setForeground(new Color(102, 102, 102));
			lblNewLabel_1.setBounds(45, 111, 297, 16);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setForeground(Color.BLACK);
			separator.setBounds(35, 90, 335, 37);
			contentPanel.add(separator);
		}
		{
			JLabel lblUserID = new JLabel("ID");
			lblUserID.setForeground(new Color(51, 51, 51));
			lblUserID.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
			lblUserID.setBounds(34, 212, 61, 16);
			contentPanel.add(lblUserID);
		}
		{
			JLabel lblUserEmail = new JLabel("E-mail");
			lblUserEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
			lblUserEmail.setBounds(34, 274, 61, 16);
			contentPanel.add(lblUserEmail);
		}
		{
			JLabel lblNewLabel = new JLabel("@");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel.setBounds(261, 269, 17, 26);
			contentPanel.add(lblNewLabel);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setForeground(Color.BLACK);
			separator.setBounds(35, 90, 335, 37);
			contentPanel.add(separator);
		}
		{
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(34, 240, 335, 12);
			contentPanel.add(separator_1);
		}
		contentPanel.add(getTfUserId());
		contentPanel.add(getTfUserEmail());
		cBEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		cBEmail.setBounds(273, 262, 100, 45);
		contentPanel.add(cBEmail);
		
		
		{
			JButton btnOK = new JButton("비밀번호 찾기");
			btnOK.setFont(new Font("Lucida Grande", Font.BOLD, 14));
			btnOK.setBounds(134, 371, 114, 44);
			contentPanel.add(btnOK);
			btnOK.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String tfUserIdstr = tfUserId.getText().trim();
					String tfUserEmailstr = tfUserEmail.getText().trim();
					
					if (tfUserIdstr.equals("") || tfUserEmailstr.equals("")) {
						JOptionPane.showMessageDialog(null, "아이디와 이메일에 빈칸이 없는지 확인해주세요!", "오류 메세지", JOptionPane.ERROR_MESSAGE);
					} else {
						findPwAction(); 
					}
				}
			});
			btnOK.setBackground(new Color(102, 102, 102));
			btnOK.setActionCommand("OK");
			getRootPane().setDefaultButton(btnOK);
		}
		{
			JSeparator separator_2 = new JSeparator();
			separator_2.setBounds(34, 353, 330, 6);
			contentPanel.add(separator_2);
		}
		
	}
	private JTextField getTfUserId() {
		if (tfUserId== null) {
			tfUserId = new JTextField();
			tfUserId.setBounds(96, 205, 114, 30);
			tfUserId.setColumns(10);
		}
		return tfUserId;
	}
	private JTextField getTfUserEmail() {
		if (tfUserEmail == null) {
			tfUserEmail = new JTextField();
			tfUserEmail.setColumns(10);
			tfUserEmail.setBounds(97, 268, 164, 30);
		}
		return tfUserEmail;
	}
	
	public void findPwAction() {
		PreparedStatement ps = null;
		String searchedPw = "";

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
			
			String query = "SELECT userPw FROM user where userId = '" + tfUserId.getText().trim() + "' and userEmail = '" + tfUserEmail.getText().trim() + cbEmailStr + "';"; // ' 사용에 유의!!
			ResultSet rs = stmt_mysql.executeQuery(query); // 쿼리문장을 실행해서 ResultSet타입으로 변환.
			
			while(rs.next()) {
				searchedPw = (rs.getString(1));
			}
		
			if(searchedPw == "") { // 가져온 searchedId가 없을 경우 (Null
				JOptionPane.showMessageDialog(null, "정보가 없습니다. 아이디와 이메일을 확인해 주세요!" , "오류 메세지", JOptionPane.ERROR_MESSAGE);
	
			}else {
				JOptionPane.showMessageDialog(null,  "아이디 " +tfUserId.getText() + " 의 비밀번호는 " +  searchedPw + " 입니다!");
				panelClean();
			}
			conn_mysql.close(); // DB 연결 끊기
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); // 화면에 에러코드 보여주기
		}
	}
	public void panelClean() {
		tfUserId.setText("");
		tfUserEmail.setText("");
		cBEmail.setSelectedIndex(0);
	}
	
}
