package com.javalec.base;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.cj.xdevapi.PreparableStatement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddressInsert {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JTextField tfName;
	private JButton btnOK;
//	private String nameError = "";
//	private String telnoError = "";
//	private String addressError = "";
//	private String emailError = "";
//	private String relationError = "";
	
	//Database 환경 정의
	private final String url_mysql = "jdbc:mysql://127.0.0.1/useraddress?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	private final String id_mysql = "root";
	private final String pw_mysql = "qwer1234";
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_3;
	private JTextField tfTelno;
	private JTextField tfAddress;
	private JTextField tfEmail;
	private JTextField tfRelation;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressInsert window = new AddressInsert();
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
	public AddressInsert() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("주소록등록");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getBtnOK());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_1_1());
		frame.getContentPane().add(getLblNewLabel_1_2());
		frame.getContentPane().add(getLblNewLabel_1_3());
		frame.getContentPane().add(getTfTelno());
		frame.getContentPane().add(getTfAddress());
		frame.getContentPane().add(getTfEmail());
		frame.getContentPane().add(getTfRelation());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("성명 :");
			lblNewLabel.setBounds(6, 6, 61, 16);
		}
		return lblNewLabel;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(76, 1, 178, 26);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("입력");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = check();
					if (i ==0) {
						inserAction();
					}
					
				}
			});
			btnOK.setBounds(327, 237, 117, 29);
		}
		return btnOK;
	}

	
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("전화번호 :");
			lblNewLabel_1.setBounds(6, 44, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("주소 :");
			lblNewLabel_1_1.setBounds(6, 82, 61, 16);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("전자우편");
			lblNewLabel_1_2.setBounds(6, 121, 61, 16);
		}
		return lblNewLabel_1_2;
	}
	private JLabel getLblNewLabel_1_3() {
		if (lblNewLabel_1_3 == null) {
			lblNewLabel_1_3 = new JLabel(" 관계 :");
			lblNewLabel_1_3.setBounds(6, 158, 61, 16);
		}
		return lblNewLabel_1_3;
	}
	private JTextField getTfTelno() {
		if (tfTelno == null) {
			tfTelno = new JTextField();
			tfTelno.setColumns(10);
			tfTelno.setBounds(76, 39, 178, 26);
		}
		return tfTelno;
	}
	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setColumns(10);
			tfAddress.setBounds(76, 77, 178, 26);
		}
		return tfAddress;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setColumns(10);
			tfEmail.setBounds(76, 116, 178, 26);
		}
		return tfEmail;
	}
	private JTextField getTfRelation() {
		if (tfRelation == null) {
			tfRelation = new JTextField();
			tfRelation.setColumns(10);
			tfRelation.setBounds(76, 153, 178, 26);
		}
		return tfRelation;
	}
	
	
	private void inserAction() { // 사용자 정보 입력
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
		
				String query = "insert into userinfo(name,telno,address,email,relation) values (?,?,?,?,?)";			
				ps = conn_mysql.prepareStatement(query);
				ps.setString(1, tfName.getText().trim());
				ps.setString(2, tfTelno.getText().trim());
				ps.setString(3, tfAddress.getText().trim());
				ps.setString(4, tfEmail.getText().trim());
				ps.setString(5, tfRelation.getText().trim());
				ps.executeUpdate();
				
				conn_mysql.close();
				
				JOptionPane.showMessageDialog(null, tfName.getText() + "님의 정보가 입력 되었습니다");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

//	private void check() {
//		nameError = "";
//		telnoError = "";
//		addressError = "";
//		emailError = "";
//		relationError = "";
//		
//		
//		if (tfName.getText().trim().equals("")){
//			nameError = "이름 ";
//			tfName.requestFocus();
//		} 
//		if(tfTelno.getText().trim().equals("")) {
//			telnoError = "전화번호 ";
//			tfTelno.requestFocus();
//		}
//		if(tfAddress.getText().trim().equals("")) {
//			addressError = "주소 ";
//			tfAddress.requestFocus();
//		}
//		if(tfEmail.getText().trim().equals("")) {
//			emailError = "전자우편 ";
//			tfEmail.requestFocus();
//		}
//		if(tfRelation.getText().trim().equals("")) {
//			relationError ="관계 ";
//			tfRelation.requestFocus();
//		}
//	}
//		
//	private void error() {	
//		
//		if(tfName.getText().trim().equals("") || tfTelno.getText().trim().equals("") || tfAddress.getText().trim().equals("") || tfEmail.getText().trim().equals("") || tfRelation.getText().trim().equals("")) {
//			JOptionPane.showMessageDialog(null, nameError+telnoError+addressError+emailError+relationError+ "입력해주세요");	
//		} else { 
//			inserAction();
//	
//	 }
//	}
	private int check() {
		int i = 0;
		String message = "";
		
		if (tfName.getText().trim().equals("")){
			message += "이름 ";
			tfName.requestFocus();
			i++;
		} 
		if(tfTelno.getText().trim().equals("")) {
			message += "전화번호 ";
			tfTelno.requestFocus();
			i++;
		}
		if(tfAddress.getText().trim().equals("")) {
			message += "주소 ";
			tfAddress.requestFocus();
			i++;
		}
		if(tfEmail.getText().trim().equals("")) {
			message += "전자우편 ";
			tfEmail.requestFocus();
			i++;
		}
		if(tfRelation.getText().trim().equals("")) {
			message +="관계 ";
			tfRelation.requestFocus();
			i++;
		}
		
		if(i>0) {
			JOptionPane.showMessageDialog(null, message + "을(를) 입력해주세요");		
		}
		return i;
	}
 
	
}/////
