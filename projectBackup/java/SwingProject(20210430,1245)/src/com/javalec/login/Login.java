package com.javalec.login; // 0428_현준 회원가입 기능 수정 

import java.awt.EventQueue;
import java.awt.Font;

import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Cursor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import javax.swing.SwingConstants;

import com.javalec.Datadefine.data_Enviroment_define;
import com.javalec.adminMain.AdminMain;
import com.javalec.login.SearchId;
import com.javalec.login.SearchPW;
import com.javalec.userMain.UserMain;


import javax.swing.JTextField;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	
	private JFrame frame;
	private JPanel loginPanel;
	private JLabel loginLabelTitle;
	private JLabel loginLabelDiv;
	private JLabel loginLabelFindId;
	private JLabel loginLabelFindPw;
	private JLabel loginLabelNoId;
	private JLabel loginLabelClick;	
	private JTextField tfLoginId;

	private JTextField loginTextLogin;	
	BufferedImage img = null;
	
	// 생성자 띄우기
	data_Enviroment_define dataDefine = new data_Enviroment_define();
	SearchId searchID = new SearchId();
	SearchPW searchPW = new SearchPW();
	SignUp signUp = new SignUp();


	private JPasswordField pfLoginPw;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
		frame.setLocationRelativeTo(null);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 430, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLoginPanel());

	}
	
	private JPanel getLoginPanel() { // frame 위에 올라간 LoginMain의 loginPanel
		if (loginPanel == null) {
			loginPanel = new JPanel();
			loginPanel.setBounds(0, 0, 412, 500);
			loginPanel.add(getLoginLabelDiv());
			loginPanel.add(getLoginLabelFindId());
			loginPanel.add(getLoginLabelFindPw());
			loginPanel.add(getLoginLabelTitle());
			loginPanel.add(getLoginTextClick());
			loginPanel.add(getTfLoginId());
			loginPanel.add(getLoginTextLogin());
			loginPanel.add(getLoginTextNoId());
			loginPanel.add(getTfLoginPw());
			loginPanel.setLayout(null);
			
			JLabel lblMBT = new JLabel("M    B   T    I");
			lblMBT.setHorizontalAlignment(SwingConstants.CENTER);
			lblMBT.setForeground(new Color(0, 0, 51));
			lblMBT.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 19));
			lblMBT.setBounds(125, 90, 151, 57);
			loginPanel.add(lblMBT);
			
			setResizable(false); // 창 크기 변경 불가 
			setLocationRelativeTo(null); // 창 크기를 변경하지 못하게 함 
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 정상적으로 JFrame이 종료되게 함.
		}
		return loginPanel;
	}
	
	//----------- Loginpanel
		private JLabel getLoginLabelTitle() {
			if (loginLabelTitle == null) {
				loginLabelTitle = new JLabel("서로를 알아가는");
				loginLabelTitle.setForeground(new Color(0, 0, 0));
				loginLabelTitle.setBounds(70, 20, 280, 85);
				loginLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
				loginLabelTitle.setFont(new Font("LiSong Pro", Font.BOLD, 28));
			}
			return loginLabelTitle;
		}
		private JTextField getTfLoginId() {
			if (tfLoginId == null) {
				tfLoginId = new JTextField();
				tfLoginId.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						tfLoginId.setText("");
					}
				});
			
				tfLoginId.setBounds(70, 190, 280, 43);
				tfLoginId.setForeground(new Color(153, 153, 153));
				tfLoginId.setText("  아이디를 입력해 주세요");
				tfLoginId.setColumns(10);
			}
			return tfLoginId;
		}
		
		private JPasswordField getTfLoginPw() {
			if (pfLoginPw == null) {
			pfLoginPw = new JPasswordField();
			pfLoginPw.setBounds(70, 240, 280, 43);
			pfLoginPw.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					pfLoginPw.setText("");
				}
			});
			pfLoginPw.setForeground(new Color(153, 153, 153));
			pfLoginPw.setColumns(10);
			}
			return pfLoginPw;
		}
		
		private JTextField getLoginTextLogin() {
			if (loginTextLogin == null) {
				loginTextLogin = new JTextField();
				loginTextLogin.setEditable(false);
				loginTextLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				loginTextLogin.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						loginTextLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
						loginTextLogin.setForeground(Color.black);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						loginTextLogin.setForeground(Color.white);
					}
					@Override
					public void mouseClicked(MouseEvent e) { // ------------------ 로그인 클릭 이벤트 
						PreparedStatement ps = null;
						String searchedUserId = "";
						int searchedUserNum = 0;
						String searchedAdminId = "";
						
						String id = tfLoginId.getText();
						char[] pw = pfLoginPw.getPassword();
						String pwString = new String(pw); // 패스워드 char -> string

						
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection conn_mysql = DriverManager.getConnection(dataDefine.url_mysql, dataDefine.id_mysql, dataDefine.pw_mysql);
							Statement stmt_mysql = conn_mysql.createStatement();
							
							if(id.equals("admin")) { // 아이디가 관리자일 때 (관리자는 계정 admin을 사용한다.)
								String query = "SELECT adminId FROM admin where adminId = '" + id + "' and adminPw = '" + pwString + "';"; // ' 사용에 유의!!
								ResultSet rs = stmt_mysql.executeQuery(query); // 쿼리문장을 실행해서 ResultSet타입으로 변환.
								
								while(rs.next()) {
									searchedAdminId = (rs.getString(1));
								}
								if(searchedAdminId.equals(id)) { // 아이디가 유저일 때 
									JOptionPane.showMessageDialog(null, id + " 님 관리자로 로그인 하셨습니다.");
									AdminMain loginAdminMain = new AdminMain();

								}else {
									JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 올바르지 않습니다.");
									tfLoginId.setText("");
									pfLoginPw.setText("");
								}
							} else { // 아이디가 유저일 때 
								String query = "SELECT userId, userNum FROM user where userId = '" + id + "' and userPw = '" + pwString + "';"; // ' 사용에 유의!!
								ResultSet rs = stmt_mysql.executeQuery(query); // 쿼리문장을 실행해서 ResultSet타입으로 변환.
								
								while(rs.next()) {
									searchedUserId = (rs.getString(1));
									searchedUserNum = Integer.parseInt(rs.getString(2));
								}
								if(searchedUserId.equals(id)) { // UserNum이 0이 아닐 때 
									JOptionPane.showMessageDialog(null, "유저 " + id + " 님 로그인 하셨습니다.");
									UserMain loginuserMain = new UserMain(searchedUserNum);
								}else {
									JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 올바르지 않습니다.");
									tfLoginId.setText("");
									pfLoginPw.setText("");
								}
							}
							conn_mysql.close(); // DB 연결 끊기
						} catch (Exception e1) {
							// TODO: handle exception
							e1.printStackTrace(); // 화면에 에러코드 보여주기
						}		
					}
				});
				loginTextLogin.setBounds(70, 338, 280, 45);
				loginTextLogin.setForeground(Color.WHITE);
				loginTextLogin.setText("로그인");
				loginTextLogin.setBackground(new Color(0, 153, 255));
				loginTextLogin.setHorizontalAlignment(JTextField.CENTER);
				loginTextLogin.setColumns(10);
			}
			return loginTextLogin;
		}
		
	
		private JLabel getLoginTextNoId() {
			if (loginLabelNoId == null) {
				loginLabelNoId = new JLabel("계정이 없으신가요?");
				loginLabelNoId.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
				loginLabelNoId.setBounds(72, 290, 126, 16);
				loginLabelNoId.setForeground(new Color(153, 153, 153));
			}
			return loginLabelNoId;
		}
		private JLabel getLoginTextClick() {  // --------------- 회원가입 하기
			if (loginLabelClick == null) {
				loginLabelClick = new JLabel("여기를 클릭하세요!");
				loginLabelClick.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
				loginLabelClick.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						signUp.setVisible(true);// -----------회원가입 하기 클릭 이벤트 
					}
					@Override // 마우스 가져다 댈 때 이벤트 
					public void mouseEntered(MouseEvent e) {
						loginLabelClick.setCursor(new Cursor(Cursor.HAND_CURSOR));
						loginLabelClick.setForeground(Color.blue);
						loginLabelClick.setFont(new Font("Lucida Grande",Font.BOLD, 14));
					}
					@Override // 마우스 땔 때 이벤트 
					public void mouseExited(MouseEvent e) {
						loginLabelClick.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
					}
				});
				loginLabelClick.setBounds(190, 291, 126, 16);
				loginLabelClick.setForeground(new Color(0, 51, 255));
			}
			return loginLabelClick;
		}
		private JLabel getLoginLabelFindId() { // --------------- 아이디 찾기 
			if (loginLabelFindId == null) {
				loginLabelFindId = new JLabel("아이디 찾기");
				loginLabelFindId.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
				loginLabelFindId.addMouseListener(new MouseAdapter() {
					@Override 
					public void mouseClicked(MouseEvent e) { // ------------------ 아이디 찾기 클릭 이벤트 
						searchID.setVisible(true);
					}
					@Override // 마우스 가져다 댈 때 이벤트 
					public void mouseEntered(MouseEvent e) {
						loginLabelFindId.setCursor(new Cursor(Cursor.HAND_CURSOR));
						loginLabelFindId.setForeground(Color.DARK_GRAY);
						loginLabelFindId.setFont(new Font("Lucida Grande",Font.BOLD, 13));
					}
					@Override // 마우스 땔 때 이벤트 
					public void mouseExited(MouseEvent e) {
						loginLabelFindId.setForeground(Color.GRAY);
					}
				});
				loginLabelFindId.setBounds(107, 393, 96, 16);
				loginLabelFindId.setForeground(new Color(102, 102, 102));
			}
			return loginLabelFindId;
		}
		private JLabel getLoginLabelFindPw() { // --------------- 패스워드 찾기 
			if (loginLabelFindPw == null) {
				loginLabelFindPw = new JLabel("비밀번호 찾기");
				loginLabelFindPw.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
				loginLabelFindPw.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) { // ------------------ 패스워드 찾기 클릭 이벤트 
						searchPW.setVisible(true);
					}
					@Override // 마우스 가져다 댈 때 이벤트 
					public void mouseEntered(MouseEvent e) {
						loginLabelFindPw.setCursor(new Cursor(Cursor.HAND_CURSOR));
						loginLabelFindPw.setForeground(Color.DARK_GRAY);
						loginLabelFindPw.setFont(new Font("Lucida Grande",Font.BOLD, 13));
					}
					@Override // 마우스 땔 때 이벤트 
					public void mouseExited(MouseEvent e) {
						loginLabelFindPw.setForeground(Color.GRAY);
					}
				});
				
				loginLabelFindPw.setBounds(231, 393, 119, 16);
				loginLabelFindPw.setForeground(new Color(102, 102, 102));
			}
			return loginLabelFindPw;
		}
		private JLabel getLoginLabelDiv() {
			if (loginLabelDiv == null) {
				loginLabelDiv = new JLabel("|");
				loginLabelDiv.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				loginLabelDiv.setBounds(200, 393, 15, 16);
				loginLabelDiv.setForeground(new Color(153, 153, 153));
			}
			return loginLabelDiv;
		}
}

