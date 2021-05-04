package com.javalec.login; // 04_30 양현준 최

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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import com.javalec.Datadefine.data_Enviroment_define;
import com.javalec.adminMain.AdminMain;
import com.javalec.userMain.UserMain;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Login extends JFrame { 
	
	// Field
	private JFrame frame;
	private JPanel loginPanel;
	private JLabel loginLabelDiv;
	private JLabel loginLabelFindId;
	private JLabel loginLabelFindPw;
	private JLabel loginLabelNoId;
	private JLabel loginLabelClick;	
	private JTextField tfLoginId;
	private JTextField loginTextLogin;	
	private JPasswordField pfLoginPw;
	private int searchedUserNum = 0;
	private String searchedUserId = "";
	private String searchedAdminId = "";
	private String searchedUserState = "";
	private String searchedUserName = "";
	
	BufferedImage img = null;
	ImageIcon backgrund =new ImageIcon("login.png");
	// Constructor
	data_Enviroment_define dataDefine = new data_Enviroment_define(); // DB 환경 정의 
	SearchId searchID = new SearchId();
	SearchPW searchPW = new SearchPW();
	SignUp signUp = new SignUp();
	private JLabel lblImage;


	// Method
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
					window.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE); // 종료 버튼 기능 구현 위해 X 버튼 원래 기능을 막아놓는다. 
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
		frame.setLocationRelativeTo(null); // 화면이 가운데에서 출력
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { // 새롭게 만든 윈도우 종료버튼 클릭 이벤트 
				panelClean();
				e.getWindow().dispose();
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
	
		frame = new JFrame();
		frame.setTitle("로그인 화면");
		frame.setBounds(100, 100, 430, 530);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLoginPanel());
		frame.setVisible(true);
	}
	
	private JPanel getLoginPanel() { // frame 위에 올라간 LoginMain의 loginPanel
		if (loginPanel == null) {
			loginPanel = new JPanel();
			loginPanel.setBounds(0, 0, 412, 500);
			loginPanel.add(getLoginLabelDiv());
			loginPanel.add(getLoginLabelFindId());
			loginPanel.add(getLoginLabelFindPw());
			loginPanel.add(getLoginTextClick());
			loginPanel.add(getTfLoginId());
			loginPanel.add(getLoginTextLogin());
			loginPanel.add(getLoginTextNoId());
			loginPanel.add(getTfLoginPw());
			loginPanel.setLayout(null);
			loginPanel.add(getLblImage());
			
			setResizable(false); // 창 크기 변경 불가 
			setLocationRelativeTo(null); // 창 크기를 변경하지 못하게 함 
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 정상적으로 JFrame이 종료되게 함.
		}
		return loginPanel;
	}
		private JTextField getTfLoginId() {
			if (tfLoginId == null) {
				tfLoginId = new JTextField();
				tfLoginId.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						tfLoginId.setText("");
						tfLoginId.setForeground(Color.black);
					}
				});
			
				tfLoginId.setBounds(70, 200, 280, 43);
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
					tfLoginId.setForeground(Color.black);
				}
			});
			pfLoginPw.setForeground(new Color(153, 153, 153));
			pfLoginPw.setColumns(10);
			}
			return pfLoginPw;
		}
		
		private JTextField getLoginTextLogin() { // 로그인 기능
			if (loginTextLogin == null) {
				loginTextLogin = new JTextField();
				loginTextLogin.setEditable(false);
				loginTextLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				loginTextLogin.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) { // 마우스 가져다 댈 때 효과
						loginTextLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
						loginTextLogin.setForeground(Color.black);
					}
					@Override
					public void mouseExited(MouseEvent e) { // 마우스 뗄 때 효과
						loginTextLogin.setForeground(Color.white);
					}
					@Override
					public void mouseClicked(MouseEvent e) { // 마우스 클릭 할 때
						PreparedStatement ps = null;
						
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
									frame.setVisible(false);
								}else {
									JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 올바르지 않습니다.");
									tfLoginId.setText("");
									pfLoginPw.setText("");
								}
							} else { // 아이디가 유저일 때 
								String query = "SELECT userId, userNum, userState, userName FROM user where userId = '" + id + "' and userPw = '" + pwString + "';"; // ' 사용에 유의!!
								ResultSet rs = stmt_mysql.executeQuery(query); // 쿼리문장을 실행해서 ResultSet타입으로 변환.
								
								while(rs.next()) {
									searchedUserId = (rs.getString(1));
									searchedUserNum = Integer.parseInt(rs.getString(2));
									searchedUserState = (rs.getString(3));
									searchedUserName= (rs.getString(4));
								}
								if(searchedUserId.equals(id)) { // UserNum이 0이 아닐 때 
									if(searchedUserState.equals("회원")) {
										JOptionPane.showMessageDialog(null, "유저 " + id + " 님 로그인 하셨습니다.");
										data_Enviroment_define.userNum = searchedUserNum;
										data_Enviroment_define.userName= searchedUserName;
				                        UserMain loginuserMain = new UserMain();
										frame.setVisible(false);
									} else {
										JOptionPane.showMessageDialog(null, "유저 " + id + " 님은 현재 [탈퇴] 상태입니다. 새로 가입해 주세요! ", "에러 메세지", JOptionPane.ERROR_MESSAGE);
									} 
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
				loginTextLogin.setBounds(70, 350, 280, 45);
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
				loginLabelClick.setBounds(210, 291, 126, 16);
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
				loginLabelFindId.setBounds(105, 405, 96, 16);
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
				
				loginLabelFindPw.setBounds(235, 405, 119, 16);
				loginLabelFindPw.setForeground(new Color(102, 102, 102));
			}
			return loginLabelFindPw;
		}
		private JLabel getLoginLabelDiv() {
			if (loginLabelDiv == null) {
				loginLabelDiv = new JLabel("|");
				loginLabelDiv.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				loginLabelDiv.setBounds(200, 405, 15, 16);
				loginLabelDiv.setForeground(new Color(153, 153, 153));
			}
			return loginLabelDiv;
		}
		public void panelClean() {
			tfLoginId.setText("");
			pfLoginPw.setText("");
		}
	
		
		
		
		private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setIcon(new ImageIcon(Login.class.getResource("/com/javalec/resources/login.png")));
			lblImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblImage.setBounds(0, 0, 412, 490);
		}
		return lblImage;
	}
}

