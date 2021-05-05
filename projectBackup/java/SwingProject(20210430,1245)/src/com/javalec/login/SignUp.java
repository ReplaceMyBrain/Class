package com.javalec.login;  // 0428 현준 회원가입 기능 수정

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.Datadefine.data_Enviroment_define;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class SignUp extends JDialog {
	private JPanel panel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_2;
	private JLabel lblNewLabel_2_3;
	private JTextField tfSignName;
	private JTextField tfSignId;
	private JTextField tfSignEmail;
	private JButton btnOverlap;
	private JPasswordField pwSignPw;
	
	private JSeparator separator_1;
	private JLabel lblMBT;
	private JLabel loginLabelTitle;
	private JTextField tfSignUp;
	private JSeparator separator_1_1;
	private JSeparator separator_1_2;
	private JLabel labelPw;
	private String Email[] = {"직접입력", "naver.com", "gmail.com", "hanmail.net", "nate.com"}; // 콤보 박스 내용
	JComboBox<String> cBEmail = new JComboBox(Email);
	data_Enviroment_define dataDefine = new data_Enviroment_define();
	private JLabel lblNewLabel;
	private String checkID = "";
	private JLabel label_check;
	private JPasswordField pwSignPw_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SignUp dialog = new SignUp();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SignUp() {
		setBounds(100, 100, 430, 530);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().add(getPanel());
		getContentPane().add(getLblMBT());
		getContentPane().add(getLoginLabelTitle());
		
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
	}

	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(20, 98, 390, 330);
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
			panel.add(getLabelPw());
			panel.add(getCBEmail());
			panel.add(getLblNewLabel());
			panel.add(getLabel_check());
			
			pwSignPw_2 = new JPasswordField();
			pwSignPw_2.setBounds(18, 145, 210, 30);
			panel.add(pwSignPw_2);
			
			JLabel lblNewLabel_2_2_1 = new JLabel("비밀번호 재 확인 :");
			lblNewLabel_2_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			lblNewLabel_2_2_1.setBounds(18, 125, 114, 20);
			panel.add(lblNewLabel_2_2_1);
		}
		return panel;
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
			tfSignName.setBounds(18, 300, 210, 30);
			tfSignName.setColumns(10);
		}
		return tfSignName;
	}
	private JTextField getTfSignId() {
		if (tfSignId == null) {
			tfSignId = new JTextField();
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
	private JPasswordField getPwSignPw() {
		if (pwSignPw == null) {
			pwSignPw = new JPasswordField();
			pwSignPw.setBounds(18, 90, 210, 30);
		} 
		return pwSignPw;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setBounds(6, 60, 384, 12);
		}
		return separator_1;
	}
	private JLabel getLblMBT() {
		if (lblMBT == null) {
			lblMBT = new JLabel("M    B   T    I");
			lblMBT.setHorizontalAlignment(SwingConstants.CENTER);
			lblMBT.setForeground(new Color(0, 0, 51));
			lblMBT.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 19));
			lblMBT.setBounds(130, 50, 151, 57);
		}
		return lblMBT;
	}
	private JLabel getLoginLabelTitle() {
		if (loginLabelTitle == null) {
			loginLabelTitle = new JLabel("서로를 알아가는");
			loginLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
			loginLabelTitle.setForeground(Color.BLACK);
			loginLabelTitle.setFont(new Font("LiSong Pro", Font.BOLD, 28));
			loginLabelTitle.setBounds(75, 6, 280, 57);
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
	private JLabel getLabelPw() {
		if (labelPw == null) {
			labelPw = new JLabel("");
			labelPw.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseMoved(MouseEvent e) {
				}
			});
			labelPw.addContainerListener(new ContainerAdapter() { // 비밀번호 중복 체크 아직 미완성 @@@@@@@@@@@@@
				@Override
				public void componentAdded(ContainerEvent e) {
					if(pwSignPw.getPassword().toString().equals("") || pwSignPw_2.getPassword().toString().equals("") ) {
					}else {
						if(pwSignPw.getPassword().toString().equals(pwSignPw_2.getPassword().toString())) {
							labelPw.setText("비밀번호가 일치합니다. ");
							labelPw.setForeground(Color.green);
						}else {
							labelPw.setText("비밀번호가 일치하지 않습니다. ");
							labelPw.setForeground(Color.red);
						}
					}
				}
			});
		
			labelPw.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			labelPw.setForeground(new Color(255, 0, 0));
			labelPw.setBounds(20, 180, 157, 16);
		}
		return labelPw;
	}
	private JComboBox getCBEmail() {
		if (cBEmail == null) {
			cBEmail = new JComboBox(Email);
			cBEmail.setBounds(250, 230, 100, 30);
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
		
		if(tfSignId.getText().equals("") || pwSignPw.getPassword().toString().equals("") || pwSignPw_2.getPassword().toString().equals("") || tfSignEmail.getText().equals("") || tfSignName.getText().equals("")) { // 중복체크 완료한 아이디와 가입하는 아이디 비교	
			JOptionPane.showMessageDialog(null,  "빈 칸 없이 다 채워주세요!");
		}else if(checkID.equals(tfSignId.getText().trim()) ) {			
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
				
				String query = "insert into user (userName, userId, userPw, userEmail)\n"
						+ "values (?,?,?,?);";

				ps = conn_mysql.prepareStatement(query); // 쿼리를 실행하여 ps 형태로 ?값에 가져오기 
				ps.setString(1, tfSignName.getText().trim());
				ps.setString(2, tfSignId.getText().trim());
				
				char[] pw = pwSignPw.getPassword();
				String pwString = new String(pw); // 패스워드 char -> string
				ps.setString(3, pwString.trim()+cbEmailStr);
				
				ps.setString(4, tfSignEmail.getText().trim());
				ps.executeUpdate();
				
				JOptionPane.showMessageDialog(null,  tfSignName.getText() + " 님의 아이디가 저장되었습니다.");
				
				conn_mysql.close(); // DB 연결 끊기
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace(); // 화면에 에러코드 보여주기
			}
			
		} else {
			JOptionPane.showMessageDialog(null,  "아이디 중복 체크를 해주세요!");	
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
				JOptionPane.showMessageDialog(null, searchedId + " 는 이미 있는 계정입니다. 아이디를 확인하세요. "); 
				tfSignId.setText("");
				label_check.setText("X");
				label_check.setForeground(Color.red);
			}else {
				JOptionPane.showMessageDialog(null,  "중복 체크 되었습니다. 다음으로 진행하세요! ");
				checkID = tfSignId.getText().trim();
				label_check.setText("O");
				label_check.setForeground(Color.green);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private JLabel getLabel_check() {
		if (label_check == null) {
			label_check = new JLabel("");
			
			label_check.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
			label_check.setBounds(234, 30, 34, 23);
		}
		return label_check;
	}
}
