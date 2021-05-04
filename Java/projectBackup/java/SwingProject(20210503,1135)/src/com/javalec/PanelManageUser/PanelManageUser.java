package com.javalec.PanelManageUser;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.Datadefine.data_Enviroment_define;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelManageUser extends JPanel {
	private JScrollPane scrollPane_AdUser;
	private JTable inner_table_AdUser;
	private final DefaultTableModel Outer_Table_AdManagerUser = new DefaultTableModel(); // ################
	private JLabel lblAdUserNum;
	private JLabel lblAdUserName;
	private JLabel lblAdUserId;
	private JTextField tfAdUserNum;
	private JTextField tfAdUserName;
	private JTextField tfAdUserId;
	private JButton btnAdUserWithdrawal;
	private JButton btnAdUserEdit;
	private JLabel lblAdUserEmail;
	private JTextField tfAdUserEmail;
	private JLabel lblAdUserState;
	private JButton btnAdUserSearch;
	private JTextField tfAdUserSearch;
	private JComboBox cbadUserSearch;
	private JTextField tfAdUserState;

	/**
	 * Create the panel.
	 */
	public PanelManageUser() {
		setBackground(new Color(238, 238, 238));
		setBounds(new Rectangle(180, 10, 512, 420));
		setLayout(null);
		setVisible(false);
		add(getScrollPane_AdUser());
		add(getScrollPane_AdUser());
		add(getLblAdUserNum());
		add(getLblAdUserName());
		add(getLblAdUserId());
		add(getTfAdUserNum());
		add(getTfAdUserName());
		add(getTfAdUserId());
		add(getBtnAdUserWithdrawal());
		add(getBtnAdUserEdit());
		add(getLblAdUserEmail());
		add(getTfAdUserEmail());
		add(getLblAdUserState());
		add(getBtnAdUserSearch());
		add(getTfAdUserSearch());
		add(getCbadUserSearch());
		add(getTfAdUserState());
		tableInit();
		tableInputAction();
	}


	private JScrollPane getScrollPane_AdUser() {
		if (scrollPane_AdUser == null) {
			scrollPane_AdUser = new JScrollPane();
			scrollPane_AdUser.setBounds(12, 17, 488, 135);
			scrollPane_AdUser.setViewportView(getInner_table_AdUser());
		}
		return scrollPane_AdUser;
	}
	private JTable getInner_table_AdUser() {
		if (inner_table_AdUser == null) {
			inner_table_AdUser = new JTable();
			inner_table_AdUser.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					TableClick();
				}
			});
			inner_table_AdUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			inner_table_AdUser.setModel(Outer_Table_AdManagerUser); // 테이블을 불러오기 위해 ******꼭 써야할 것*****
		}
		return inner_table_AdUser;
	}
	private JLabel getLblAdUserNum() {
		if (lblAdUserNum == null) {
			lblAdUserNum = new JLabel("번호");
			lblAdUserNum.setBounds(23, 206, 61, 16);
		}
		return lblAdUserNum;
	}
	private JLabel getLblAdUserName() {
		if (lblAdUserName == null) {
			lblAdUserName = new JLabel("이름");
			lblAdUserName.setBounds(23, 243, 61, 16);
		}
		return lblAdUserName;
	}
	private JLabel getLblAdUserId() {
		if (lblAdUserId == null) {
			lblAdUserId = new JLabel("Id");
			lblAdUserId.setBounds(23, 276, 61, 16);
		}
		return lblAdUserId;
	}
	private JTextField getTfAdUserNum() {
		if (tfAdUserNum == null) {
			tfAdUserNum = new JTextField();
			tfAdUserNum.setEditable(false);
			tfAdUserNum.setBounds(96, 202, 86, 26);
			tfAdUserNum.setColumns(10);
		}
		return tfAdUserNum;
	}
	private JTextField getTfAdUserName() {
		if (tfAdUserName == null) {
			tfAdUserName = new JTextField();
			tfAdUserName.setColumns(10);
			tfAdUserName.setBounds(96, 238, 411, 26);
		}
		return tfAdUserName;
	}
	private JTextField getTfAdUserId() {
		if (tfAdUserId == null) {
			tfAdUserId = new JTextField();
			tfAdUserId.setColumns(10);
			tfAdUserId.setBounds(96, 271, 411, 26);
		}
		return tfAdUserId;
	}
	private JButton getBtnAdUserWithdrawal() {
		if (btnAdUserWithdrawal == null) {
			btnAdUserWithdrawal = new JButton("탈퇴/복원");
			btnAdUserWithdrawal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					WithdrawalAction();
				}

			});
			btnAdUserWithdrawal.setBounds(49, 361, 105, 29);
		}
		return btnAdUserWithdrawal;
	}
	private JButton getBtnAdUserEdit() {
		if (btnAdUserEdit == null) {
			btnAdUserEdit = new JButton("수정");
			btnAdUserEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ActionPartition_editAction();
				}
			});
			btnAdUserEdit.setBounds(342, 361, 105, 29);
		}
		return btnAdUserEdit;
	}
	private JLabel getLblAdUserEmail() {
		if (lblAdUserEmail == null) {
			lblAdUserEmail = new JLabel("E-mail");
			lblAdUserEmail.setBounds(23, 314, 61, 16);
		}
		return lblAdUserEmail;
	}
	private JTextField getTfAdUserEmail() {
		if (tfAdUserEmail == null) {
			tfAdUserEmail = new JTextField();
			tfAdUserEmail.setColumns(10);
			tfAdUserEmail.setBounds(96, 309, 411, 26);
		}
		return tfAdUserEmail;
	}
	private JLabel getLblAdUserState() {
		if (lblAdUserState == null) {
			lblAdUserState = new JLabel("상태");
			lblAdUserState.setBounds(235, 207, 61, 16);
		}
		return lblAdUserState;
	}
	
	private JButton getBtnAdUserSearch() {
		if (btnAdUserSearch == null) {
			btnAdUserSearch = new JButton("검색");
			btnAdUserSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ConditionQuery();
				}
			});
			btnAdUserSearch.setBounds(402, 160, 98, 29);
		}
		return btnAdUserSearch;
	}
	private JTextField getTfAdUserSearch() {
		if (tfAdUserSearch == null) {
			tfAdUserSearch = new JTextField();
			tfAdUserSearch.setColumns(10);
			tfAdUserSearch.setBounds(96, 162, 294, 26);
		}
		return tfAdUserSearch;
	}
	private JComboBox getCbadUserSearch() {
		if (cbadUserSearch == null) {
			cbadUserSearch = new JComboBox();
			cbadUserSearch.setModel(new DefaultComboBoxModel(new String[] {"상태", "이름", "Id", "E-mail"}));
			cbadUserSearch.setBounds(10, 167, 90, 23);
		}
		return cbadUserSearch;
	}
	
	private JTextField getTfAdUserState() {
		if (tfAdUserState == null) {
			tfAdUserState = new JTextField();
			tfAdUserState.setEditable(false);
			tfAdUserState.setBounds(274, 204, 49, 21);
			tfAdUserState.setColumns(10);
		}
		return tfAdUserState;
	}
	//-------------------------------
	//메소드정리 
	//-------------------------------
	
	//화면 Table 초기화 
	//Dowoo 2021.04.28 비밀번호 삭제, 상태추가
	private void tableInit() {
		Outer_Table_AdManagerUser.addColumn("번호");
		Outer_Table_AdManagerUser.addColumn("상태");
		Outer_Table_AdManagerUser.addColumn("이름");
		Outer_Table_AdManagerUser.addColumn("ID");
		Outer_Table_AdManagerUser.addColumn("E-mail");
		Outer_Table_AdManagerUser.addColumn("MBTI");
		Outer_Table_AdManagerUser.addColumn("적성검사");
		Outer_Table_AdManagerUser.setColumnCount(7); // 
		
		int i = Outer_Table_AdManagerUser.getRowCount();
		for(int j=0; j<i; j++) {
			Outer_Table_AdManagerUser.removeRow(0);
		}
		
		inner_table_AdUser.setAutoResizeMode(inner_table_AdUser.AUTO_RESIZE_OFF); // 마음대로 리사이징 x
		
		int vColIndex = 0; // 첫번째 행
		TableColumn col = inner_table_AdUser.getColumnModel().getColumn(vColIndex);
		int width = 30; // 첫번째 행 가로
		col.setPreferredWidth(width);; // 첫번째 행 가로크기 설정
		
		vColIndex = 1; // 2번째 행
		col = inner_table_AdUser.getColumnModel().getColumn(vColIndex);
		width = 50; // 2번째 행 가로
		col.setPreferredWidth(width);; // 2번째 행 가로크기 설정
		
		vColIndex = 2; // 3번째 행
		col = inner_table_AdUser.getColumnModel().getColumn(vColIndex);
		width = 50; // 3번째 행 가로
		col.setPreferredWidth(width);; // 3번째 행 가로크기 설정
		
		vColIndex = 3; // 4번째 행
		col = inner_table_AdUser.getColumnModel().getColumn(vColIndex);
		width = 50; // 4번째 행 가로
		col.setPreferredWidth(width);; // 4번째 행 가로크기 설정
		
		vColIndex = 4; // 5번째 행
		col = inner_table_AdUser.getColumnModel().getColumn(vColIndex);
		width = 100; // 5번째 행 가로
		col.setPreferredWidth(width);; // 5번째 행 가로크기 설정
		
		vColIndex = 5; // 6번째 행
		col = inner_table_AdUser.getColumnModel().getColumn(vColIndex);
		width = 95; // 6번째 행 가로
		col.setPreferredWidth(width);; // 6번째 행 가로크기 설정
		
		vColIndex = 6; // 7번째 행
		col = inner_table_AdUser.getColumnModel().getColumn(vColIndex);
		width = 95; // 7번째 행 가로
		col.setPreferredWidth(width);; // 7번째 행 가로크기 설정
	}
	//Dowoo 2021.04.28  탈퇴 복원
	
	//table에 DB 정보 입력
	//SungAh 2021.04.29
	private void tableInputAction() {
		String query = "select userNum, userState, userName, userId, userEmail, userResultM, userResultA from user";
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(data_Enviroment_define.url_mysql, data_Enviroment_define.id_mysql, data_Enviroment_define.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query); // 쿼리문장을 실행하여 ResultSet타입으로 변환 ->결과값 저장
			
			while(rs.next()) { //ResultSet에서 
				String[] qTxt = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)};
				Outer_Table_AdManagerUser.addRow(qTxt);
				}			
			conn_mysql.close(); //DB 연결 끊기
			
			
		}catch(Exception e) {//java.lang
			e.printStackTrace();// 화면에 에러코드 보여주기
		}
	
	}
		
	//Table clicked / table 내의 각 행을 클릭했을 때
	private void TableClick() {
		int i = inner_table_AdUser.getSelectedRow(); // i행을 불러옴, Seqno의 숫자 1~n까지
		String wkSeq = (String) inner_table_AdUser.getValueAt(i, 0); // String값으로 차례로 i행을 불러와 넣어줌
		String query = "select userNum, userState, userName, userId, userEmail from swing_project_team3.user where userNum="+wkSeq;
		// 열값을 차례로 불러오기 위함	
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc 드라이버를 로딩
			Connection conn_mysql = DriverManager.getConnection(data_Enviroment_define.url_mysql, data_Enviroment_define.id_mysql, data_Enviroment_define.pw_mysql); //DB환경 연결&로그인
			Statement stmt_mysql = conn_mysql.createStatement(); // DB에서 데이터를 불러옴
			
			ResultSet rs = stmt_mysql.executeQuery(query); // 쿼리문장을 실행하여 ResultSet타입으로 변환 ->객체 rs에 결과값 저장
			
			while(rs.next()) {
				tfAdUserNum.setText(rs.getString(1)); // 열값을 차례로 불러오기 위함
				tfAdUserState.setText(rs.getString(2));
				tfAdUserName.setText(rs.getString(3));
				tfAdUserId.setText(rs.getString(4));
				tfAdUserEmail.setText(rs.getString(5));
				}
					
		conn_mysql.close(); //DB 연결 끊기
				
				
		}catch(Exception e) {
			e.printStackTrace();// 화면에 에러코드 보여주기
			}
	}
	
	// DataField 초기화(텍스트필드+콤보박스)
	//SungAh 2021.04.29
	private void ClearColumn() {
		tfAdUserNum.setText("");
		tfAdUserState.setText("");
		tfAdUserName.setText("");
		tfAdUserId.setText("");
		tfAdUserEmail.setText("");
	}
	
	//선택한 콤보박스의 내용을 검색
	private void ConditionQuery() {
		int i = cbadUserSearch.getSelectedIndex(); // 전환한 문자열을 받을 변수 선언
		String conditionQueryColumn = ""; // ""값으로 초기화
		switch(i) {
		case 0:
			conditionQueryColumn = "userState";
			break;
		case 1:
			conditionQueryColumn = "userName";
			break;
		case 2 : 
			conditionQueryColumn = "userId";
			break;
		case 3 : 
			conditionQueryColumn = "userEmail";
			break;
		default:
			break;
		}
		
		tableInit(); // table을 재구성함
		ClearColumn(); // 화면 지우는 메소드
		ConditionQueryAction(conditionQueryColumn); // 검색메소드 실행
//		System.out.println(conditionQueryColumn);
	}
	
	//검색 메소드
	//SungAh 2021.04.29
	private void ConditionQueryAction(String columnName) { // conditionQueryColumn를 columnName으로 받아옴
		String query = "select userNum, userName, userId, userEmail from user where "+columnName;
		String query2 = " like '%" + tfAdUserSearch.getText() + "%'"; // 검색용 필터
//		System.out.println(query+query2); // sql 문장 확인용
		PreparedStatement ps = null;
		int dataCount = 0; // while문이 몇번돌았는지 확인용
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc 드라이버를 로딩
			Connection conn_mysql = DriverManager.getConnection(data_Enviroment_define.url_mysql, data_Enviroment_define.id_mysql, data_Enviroment_define.pw_mysql); //DB환경 연결&로그인
			Statement stmt_mysql = conn_mysql.createStatement(); // DB에서 데이터를 불러옴
			
			ResultSet rs = stmt_mysql.executeQuery(query+query2); // 쿼리문장을 실행하여 ResultSet타입으로 변환 ->객체 rs에 결과값 저장
			
			while(rs.next()) {
			 String[] qTxt = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
			 Outer_Table_AdManagerUser.addRow(qTxt); // 열값을 차례대로 불러오기 (순서, 이름, 전화번호, 관계)
			 dataCount++;
			}
				
			conn_mysql.close(); //DB 연결 끊기
			}catch(Exception e) {
				e.printStackTrace();// 화면에 에러코드 보여주기
			}
	}
	
	
	
	//공백 체크
	// SungAh 2021.04.28
	private int FieldCheck() {
		int i = 0;
		String message = "";
		if(tfAdUserName.getText().length() == 0) {
			i++;
			message = "이름을 ";
			tfAdUserName.requestFocus();
		}
		if(tfAdUserId.getText().length() == 0) {
			i++;
			message = "Id를 ";
			tfAdUserId.requestFocus();
		}
		if(tfAdUserEmail.getText().length() == 0) {
			message = "E-mail을 ";
			i++;
			tfAdUserEmail.requestFocus();
		}
		
					
		if(i>0) {
			JOptionPane.showMessageDialog(null, message + "입력하세요");
		}
		
		return i;
	}
	
	
	//회원 탈퇴/복원 액션
	private void WithdrawalAction() { // if문 동작이 안되어 switch문으로 수정
		switch(tfAdUserState.getText()) {
		case "회원" : 
			tfAdUserState.setText("탈퇴");
			break;
		case "탈퇴" : 
			tfAdUserState.setText("회원");
			break;
		default : 
			break;
		}
		
		String userState = tfAdUserState.getText().trim(); // 변경 후 회원상태 저장
		int userNum = Integer.parseInt(tfAdUserNum.getText().trim());
		
		MU_DbAction mu_DbAction = new MU_DbAction(userState, userNum);
		boolean msg =  mu_DbAction.WithdrawalAction();
		
		
		
		if(msg=true) {
			switch(tfAdUserState.getText()) {
				case "탈퇴" :
					JOptionPane.showMessageDialog(this, tfAdUserName.getText()+" 님의 정보가 탈퇴 되었습니다.!",
				        	"탈퇴 완료!",JOptionPane.INFORMATION_MESSAGE);
					break;
				case "회원" : 
					JOptionPane.showMessageDialog(this,tfAdUserName.getText()+" 님의 정보가 복원 되었습니다.!",
				        	"복원 완료!",JOptionPane.INFORMATION_MESSAGE); 
					break;
				default : 
					break;
			}			
			
		}else if(msg=false){
			JOptionPane.showMessageDialog(this, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!",
				 "Critical Error!", 
				 JOptionPane.ERROR_MESSAGE);  
		}
		
		tableInit();
		tableInputAction();
		ClearColumn();
		
	}
	
	//공백체크 + 수정버튼 동작 실행
	//SungAh 2021.04.29
	private void ActionPartition_editAction() {
		int i_chk = FieldCheck();
		if(i_chk == 0) {
			MU_editAction();
			tableInit();
			tableInputAction();
			ClearColumn();
		}
	}


	private void MU_editAction() {
		String userName = tfAdUserName.getText().trim();
		String userId = tfAdUserId.getText().trim();
		String userEmail = tfAdUserEmail.getText().trim();
		int userNum = Integer.parseInt(tfAdUserNum.getText());
		
		MU_DbAction mu_dbAction = new MU_DbAction(userName, userId, userEmail, userNum);
		boolean msg = mu_dbAction.MU_editAction_boolean();
		if(msg == true) {
			JOptionPane.showMessageDialog(this, "유저 정보가 수정되었습니다", "수정완료",JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "DB에 자료 입력 중 에러가 발생했습니다", "Critical Error!", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
	
	
}//----------------------
