package com.javalec.login;  // 0430_현준 기능 최종
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import com.javalec.Datadefine.data_Enviroment_define;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JSeparator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SignUp extends JDialog {
	private JPanel panel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_2;
	private JLabel lblNewLabel_2_3;
	private JLabel labelPWcheck;
	private JLabel lblNewLabel;
	private JTextField tfSignName;
	private JTextField tfSignId;
	private JTextField tfSignEmail;
	private JButton btnOverlap;
	private JPasswordField pwSignPw;
	private JSeparator separator_1;
	private JLabel loginLabelTitle;
	private JTextField tfSignUp;
	private JSeparator separator_1_1;
	private JSeparator separator_1_2;

	private String checkID = "";
	private JLabel label_IDcheck;
	private JPasswordField pwSignPw_2;
	private String Email[] = {"직접입력", "naver.com", "gmail.com", "hanmail.net", "nate.com"}; // 콤보 박스 내용
	private JComboBox<String> cBEmail = new JComboBox(Email);
	private String memberStr = "회원";
	private String userResultM = "-";
	private String userResultA = "-"; 
	private data_Enviroment_define dataDefine = new data_Enviroment_define();
	private JSeparator separator;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SignUp dialog = new SignUp();
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE); // 종료 버튼 기능 구현 위해 X 버튼 원래 기능을 막아놓는다. 
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SignUp() {
		initialize();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { // 새롭게 만든 윈도우 종료버튼 클릭 이벤트 
				panelClean();
				e.getWindow().dispose();
			}
		});
		
	}

	private void initialize() {
		setBounds(100, 100, 430, 530);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().add(getLoginLabelTitle());
		getContentPane().add(getPanel());
			// 로그인 버튼
				tfSignUp = new JTextField();
			
				tfSignUp.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						tfSignUp.setCursor(new Cursor(Cursor.HAND_CURSOR));
						tfSignUp.setForeground(Color.black);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						tfSignUp.setForeground(Color.white);
					}
					@Override
					public void mouseClicked(MouseEvent e) {
						signUpAction();
					}
				});
				tfSignUp.setText("가입하기");
				tfSignUp.setHorizontalAlignment(SwingConstants.CENTER);
				tfSignUp.setForeground(Color.WHITE);
				tfSignUp.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				tfSignUp.setEditable(false);
				tfSignUp.setColumns(10);
				tfSignUp.setBackground(new Color(0, 153, 255));
				tfSignUp.setBounds(79, 440, 280, 45);
				
				getContentPane().add(tfSignUp);		
				getContentPane().add(getSeparator());
	}
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(20, 91, 390, 330);
			panel.setLayout(null);
			panel.add(getLblNewLabel_2());
			panel.add(getLblNewLabel_2_1());
			panel.add(getLblNewLabel_2_2());
			panel.add(getLblNewLabel_2_3());
			panel.add(getTfSignName());
			panel.add(getTfSignId());
			panel.add(getTfSignEmail());
			panel.add(getBtnOverlap());
			panel.add(getPwSignPw());
			panel.add(getSeparator_1());
			panel.add(getSeparator_1_1());
			panel.add(getSeparator_1_2());
			panel.add(getLabelPWcheck());
			cBEmail.setBounds(250, 230, 110, 30);
			panel.add(getCBEmail());
			panel.add(getLblNewLabel());
			panel.add(getLabel_IDcheck());
			
			
			pwSignPw_2 = new JPasswordField();
			pwSignPw_2.addKeyListener(new KeyAdapter() { // Pw 필드 2
			
				@Override
				public void keyReleased(KeyEvent e) { // 비밀번호 체크하는 부분 
					char[] pw = pwSignPw.getPassword();
					String pwString = new String(pw); // 패스워드 char -> string
					char[] pw2 = pwSignPw_2.getPassword();
					String pwString2 = new String(pw2); // 패스워드 char -> string
					
					if(pwString.equals("") || pwString2.equals("")) {
					
					}else {
						if(pwString2.equals(pwString)) {
							labelPWcheck.setText("비밀번호가 일치합니다.");
							labelPWcheck.setForeground(Color.green);
						}else {
							labelPWcheck.setText("비밀번호가 일치하지 않습니다.");
							labelPWcheck.setForeground(Color.red);
						}
					}
				}
			});
			pwSignPw_2.setBounds(18, 145, 210, 30);
			panel.add(pwSignPw_2);
			
			JLabel lblNewLabel_2_2_1 = new JLabel("비밀번호 재 확인 :");
			lblNewLabel_2_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			lblNewLabel_2_2_1.setBounds(18, 125, 114, 20);
			panel.add(lblNewLabel_2_2_1);
				
		}
		return panel;
	}
	
	
	private JPasswordField getPwSignPw() {
		if (pwSignPw == null) {
			pwSignPw = new JPasswordField();
			pwSignPw.addKeyListener(new KeyAdapter() { 
				@Override
				public void keyReleased(KeyEvent e) { // 비밀번호 체크하는 부분 
					char[] pw = pwSignPw.getPassword();
					String pwString = new String(pw); // 패스워드 char -> string
					char[] pw2 = pwSignPw_2.getPassword();
					String pwString2 = new String(pw2); // 패스워드 char -> string
					
					if(pwString.equals("") || pwString2.equals("")) {
					
					}else {
						if(pwString.equals(pwString2)) {
							labelPWcheck.setText("비밀번호가 일치합니다.");
							labelPWcheck.setForeground(Color.green);
						}else {
							labelPWcheck.setText("비밀번호가 일치하지 않습니다.");
							labelPWcheck.setForeground(Color.red);
						}
					}
				}
			});
			pwSignPw.setBounds(18, 90, 210, 30);
		} 
		return pwSignPw;
	}
	
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("이름 :");
			lblNewLabel_2.setBounds(18, 280, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("ID :");
			lblNewLabel_2_1.setBounds(18, 6, 57, 15);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_2_2() {
		if (lblNewLabel_2_2 == null) {
			lblNewLabel_2_2 = new JLabel("PW :");
			lblNewLabel_2_2.setBounds(18, 75, 57, 15);
		}
		return lblNewLabel_2_2;
	}
	private JLabel getLblNewLabel_2_3() {
		if (lblNewLabel_2_3 == null) {
			lblNewLabel_2_3 = new JLabel("Email :");
			lblNewLabel_2_3.setBounds(18, 210, 57, 15);
		}
		return lblNewLabel_2_3;
	}
	private JTextField getTfSignName() {
		if (tfSignName == null) {
			tfSignName = new JTextField();
			tfSignName.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					int key = e.getKeyCode();
					if(key == KeyEvent.VK_ENTER) {
						signUpAction();
					}
				}
			});
			tfSignName.setBounds(18, 300, 210, 30);
			tfSignName.setColumns(10);
		}
		return tfSignName;
	}
	private JTextField getTfSignId() {
		if (tfSignId == null) {
			tfSignId = new JTextField(); 
			tfSignId.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) { 
					if(tfSignId.getText().equals(checkID) == false) { // tSignID에 있는 글자와 checkID가 다를 때
						label_IDcheck.setText("X");
						label_IDcheck.setForeground(Color.red);
					}
				}
			});
			tfSignId.setColumns(10);
			tfSignId.setBounds(18, 25, 210, 30);
		}
		return tfSignId;
	}
	private JTextField getTfSignEmail() {
		if (tfSignEmail == null) {
			tfSignEmail = new JTextField();
			tfSignEmail.setColumns(10);
			tfSignEmail.setBounds(18, 230, 210, 30);
		}
		return tfSignEmail;
	}
	private JButton getBtnOverlap() {
		if (btnOverlap == null) {
			btnOverlap = new JButton("중복검사");
			btnOverlap.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(tfSignId.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "아이디를 입력해 주세요!");
					}else {
						checkAction();
					}
				}
			});
			btnOverlap.setBounds(263, 30, 97, 23);
		}
		return btnOverlap;
	}
	
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setBounds(6, 60, 384, 12);
		}
		return separator_1;
	}
	private JLabel getLoginLabelTitle() {
		if (loginLabelTitle == null) {
			loginLabelTitle = new JLabel("✓ 회원 가입");
			loginLabelTitle.setHorizontalAlignment(SwingConstants.LEFT);
			loginLabelTitle.setForeground(Color.BLACK);
			loginLabelTitle.setFont(new Font("Kefa", Font.PLAIN, 20));
			loginLabelTitle.setBounds(20, 25, 280, 57);
		}
		return loginLabelTitle;
	}
	private JSeparator getSeparator_1_1() {
		if (separator_1_1 == null) {
			separator_1_1 = new JSeparator();
			separator_1_1.setBounds(6, 195, 384, 12);
		}
		return separator_1_1;
	}
	private JSeparator getSeparator_1_2() {
		if (separator_1_2 == null) {
			separator_1_2 = new JSeparator();
			separator_1_2.setBounds(6, 265, 384, 12);
		}
		return separator_1_2;
	}
	private JLabel getLabelPWcheck() {
		if (labelPWcheck == null) {
			labelPWcheck = new JLabel("");
			labelPWcheck.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			labelPWcheck.setForeground(new Color(255, 0, 0));
			labelPWcheck.setBounds(20, 180, 157, 16);
		}
		return labelPWcheck;
	}
	private JComboBox<String> getCBEmail(){
		if (cBEmail == null) {
			cBEmail = new JComboBox(Email);

		}
		return cBEmail;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("@");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel.setBounds(234, 230, 17, 26);
		}
		return lblNewLabel;
	}
	
	
	
	public void signUpAction() { // 가입 하기 버튼 기능 
		PreparedStatement ps = null; 
		
		// tf에 빈칸이 하나라도 있으면 오류 메세지 
		if(tfSignId.getText().equals("") || pwSignPw.getPassword().toString().equals("") || pwSignPw_2.getPassword().toString().equals("") || tfSignEmail.getText().equals("") || tfSignName.getText().equals("")) { 
			JOptionPane.showMessageDialog(null,  "빈 칸 없이 다 채워주세요!", "오류 메세지", JOptionPane.ERROR_MESSAGE);
		} else if(label_IDcheck.getText().equals("O") && labelPWcheck.getText().equals("비밀번호가 일치합니다.") && checkID.equals(tfSignId.getText()) && (tfSignEmail.getText().contains("@") && tfSignEmail.getText().contains("@")) || cBEmail.getSelectedIndex()>0 ) { // 라벨 체크, 비밀번호 체크, 이메일(@) 포함할 때 	
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
							
				String query = "insert into user (userName, userId, userPw, userEmail, userState, userResultM, userResultA)\n"
						+ "values (?,?,?,?,?,?,?);";

				ps = conn_mysql.prepareStatement(query); // 쿼리를 실행하여 ps 형태로 ?값에 가져오기 
				ps.setString(1, tfSignName.getText().trim());
				ps.setString(2, tfSignId.getText().trim());
				
				char[] pw = pwSignPw.getPassword();
				String pwString = new String(pw); // 패스워드 char -> string
				ps.setString(3, pwString.trim());
				
				ps.setString(4, tfSignEmail.getText().trim()+ cbEmailStr);
				ps.setString(5, memberStr);
				ps.setString(6, userResultM);
				ps.setString(7, userResultA);
				ps.executeUpdate();
				
				JOptionPane.showMessageDialog(null,  tfSignName.getText() + " 님의 아이디가 저장되었습니다.");
				panelClean();
				dispose();
				conn_mysql.close(); // DB 연결 끊기
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace(); // 화면에 에러코드 보여주기
			}
		} else if(label_IDcheck.getText().equals("X")) { // 다 채웠지만 아이디 체크가 안되어 있으면 오류 메세지 
			JOptionPane.showMessageDialog(null,  "아이디 체크를 해 주세요! ", "오류 메세지", JOptionPane.ERROR_MESSAGE);
			
		}
		else if(labelPWcheck.getText().equals("비밀번호가 일치하지 않습니다.")){ // 다 채웠지만 비밀번호 체크가 불일치 일 때 
			JOptionPane.showMessageDialog(null,  "비밀번호 체크를 해 주세요! ", "오류 메세지", JOptionPane.ERROR_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, "이메일을 확인해 주세요 ", "오류 메세지", JOptionPane.ERROR_MESSAGE);
		}
	}


	public void checkAction(){ // 아이디 중복 체크 기능 
		PreparedStatement ps = null;
		String searchedId = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(dataDefine.url_mysql, dataDefine.id_mysql, dataDefine.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			String query = "select userId from user where userId = '" + tfSignId.getText() +"';";
			ResultSet rs = stmt_mysql.executeQuery(query); // 쿼리문장을 실행해서 ResultSet타입으로 변환.
			
			while(rs.next()) {
				searchedId = (rs.getString(1));
			}
			
			System.out.println(searchedId);
			if(searchedId.equals(tfSignId.getText())){
				checkID = "";
				JOptionPane.showMessageDialog(null, searchedId + " 는 이미 있는 계정입니다. 아이디를 확인하세요. "  , "오류 메세지", JOptionPane.ERROR_MESSAGE); 
				tfSignId.setText("");
				label_IDcheck.setText("X");
				label_IDcheck.setForeground(Color.red);
			}else {
				JOptionPane.showMessageDialog(null,  "중복 체크 되었습니다. 다음으로 진행하세요! ");
				checkID = tfSignId.getText().trim();
				label_IDcheck.setText("O");
				label_IDcheck.setForeground(Color.green);
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private JLabel getLabel_IDcheck() {
		if (label_IDcheck == null) {
			label_IDcheck = new JLabel("");
			
			label_IDcheck.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
			label_IDcheck.setBounds(234, 30, 34, 23);
		}
		return label_IDcheck;
	}
	
	public void panelClean() {
		tfSignId.setText("");
		tfSignName.setText("");
		pwSignPw.setText("");
		pwSignPw_2.setText("");
		tfSignEmail.setText("");
		label_IDcheck.setText("");
		labelPWcheck.setText("");
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setForeground(new Color(153, 153, 153));
			separator.setBounds(23, 75, 385, 12);
		}
		return separator;
	}
}
