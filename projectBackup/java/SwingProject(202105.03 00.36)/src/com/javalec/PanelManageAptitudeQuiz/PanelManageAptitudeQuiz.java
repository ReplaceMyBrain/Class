package com.javalec.PanelManageAptitudeQuiz;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.Datadefine.data_Enviroment_define;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelManageAptitudeQuiz extends JPanel {
	private JScrollPane scrollPane_AdAptitideQA;
	private JTable inner_table_AdMBTIQA;
	private final DefaultTableModel Outer_Table_AdMBTIQA= new DefaultTableModel(); // ################
	private JLabel lblAdAptitideNum;
	private JLabel lblAdAptitideQA;
	private JLabel lblAdAptitideAnswer1;
	private JLabel lblAdAptitideAnswer2;
	private JButton btnAdAptitideQACreate;
	private JButton btnAdAptitideQAEdit;
	private JButton btnAdAptitideQARemove;
	private JTextField tfAdAptitideQANum;
	private JTextField tfAdAptitideQA;
	private JTextField tfAdAptitideAnswer1;
	private JTextField tfAdAptitideAnswer2;
	private JScrollPane scrollPane_AdUser;
	private JLabel lblAdAptitideAnswer1Score;
	private JLabel lblAdAptitideAnswer2Score;
	private JComboBox cbAptitideAnswer1Score;
	private JComboBox cbAptitideAnswer2Score;

	/**
	 * Create the panel.
	 */
	public PanelManageAptitudeQuiz() {
		setBackground(new Color(238, 238, 238));
		setBounds(new Rectangle(0, 57, 500, 350));
		setLayout(null);
		setVisible(false);
		add(getScrollPane_AdAptitideQA());
		add(getLblAdAptitideNum());
		add(getLblAdAptitideQA());
		add(getLblAdAptitideAnswer1());
		add(getLblAdAptitideAnswer2());
		add(getBtnAdAptitideQACreate());
		add(getBtnAdAptitideQAEdit());
		add(getBtnAdAptitideQARemove());
		add(getTfAdAptitideQANum());
		add(getTfAdAptitideQA());
		add(getTfAdAptitideAnswer1());
		add(getTfAdAptitideAnswer2());
		add(getLblAdAptitideAnswer1Score());
		add(getLblAdAptitideAnswer2Score());
		add(getCbAptitideAnswer1Score());
		add(getCbAptitideAnswer2Score());

	}

	private JScrollPane getScrollPane_AdAptitideQA() {
		if (scrollPane_AdAptitideQA == null) {
			scrollPane_AdAptitideQA = new JScrollPane();
			scrollPane_AdAptitideQA.setBounds(12, 17, 476, 156);
			scrollPane_AdAptitideQA.setViewportView(getInner_table_AdMBTIQA());
			
		}
		return scrollPane_AdAptitideQA;
	}
	private JTable getInner_table_AdMBTIQA() {
		if (inner_table_AdMBTIQA == null) {
			inner_table_AdMBTIQA = new JTable();
			inner_table_AdMBTIQA.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					TableClick();
				}
			});
			inner_table_AdMBTIQA.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			inner_table_AdMBTIQA.setModel(Outer_Table_AdMBTIQA); // 테이블을 불러오기 위해 ******꼭 써야할 것*****
			
			MAQ_TableInit();
			MAQ_tableInputAction();
			
		}
		return inner_table_AdMBTIQA;
	}
	
	private JLabel getLblAdAptitideNum() {
		if (lblAdAptitideNum == null) {
			lblAdAptitideNum = new JLabel("번호");
			lblAdAptitideNum.setBounds(12, 191, 27, 16);
		}
		return lblAdAptitideNum;
	}
	private JLabel getLblAdAptitideQA() {
		if (lblAdAptitideQA == null) {
			lblAdAptitideQA = new JLabel("질문");
			lblAdAptitideQA.setBounds(12, 227, 27, 16);
		}
		return lblAdAptitideQA;
	}
	private JLabel getLblAdAptitideAnswer1() {
		if (lblAdAptitideAnswer1 == null) {
			lblAdAptitideAnswer1 = new JLabel("답1");
			lblAdAptitideAnswer1.setBounds(12, 260, 27, 16);
		}
		return lblAdAptitideAnswer1;
	}
	private JLabel getLblAdAptitideAnswer2() {
		if (lblAdAptitideAnswer2 == null) {
			lblAdAptitideAnswer2 = new JLabel("답2");
			lblAdAptitideAnswer2.setBounds(12, 294, 27, 16);
		}
		return lblAdAptitideAnswer2;
	}
	private JTextField getTfAdAptitideQANum() {
		if (tfAdAptitideQANum == null) {
			tfAdAptitideQANum = new JTextField();
			tfAdAptitideQANum.setEditable(false);
			tfAdAptitideQANum.setBounds(51, 187, 60, 26);
			tfAdAptitideQANum.setColumns(10);
		}
		return tfAdAptitideQANum;
	}
	private JTextField getTfAdAptitideQA() {
		if (tfAdAptitideQA == null) {
			tfAdAptitideQA = new JTextField();
			tfAdAptitideQA.setColumns(10);
			tfAdAptitideQA.setBounds(51, 223, 437, 26);
		}
		return tfAdAptitideQA;
	}
	private JTextField getTfAdAptitideAnswer1() {
		if (tfAdAptitideAnswer1 == null) {
			tfAdAptitideAnswer1 = new JTextField();
			tfAdAptitideAnswer1.setColumns(10);
			tfAdAptitideAnswer1.setBounds(51, 256, 285, 26);
		}
		return tfAdAptitideAnswer1;
	}
	private JTextField getTfAdAptitideAnswer2() {
		if (tfAdAptitideAnswer2 == null) {
			tfAdAptitideAnswer2 = new JTextField();
			tfAdAptitideAnswer2.setColumns(10);
			tfAdAptitideAnswer2.setBounds(51, 290, 285, 26);
		}
		return tfAdAptitideAnswer2;
	}
	private JButton getBtnAdAptitideQACreate() {
		if (btnAdAptitideQACreate == null) {
			btnAdAptitideQACreate = new JButton("생성");
			btnAdAptitideQACreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ActionPartition_insertAction();
				}
			});
			btnAdAptitideQACreate.setBounds(52, 320, 60, 29);
		}
		return btnAdAptitideQACreate;
	}
	private JButton getBtnAdAptitideQAEdit() {
		if (btnAdAptitideQAEdit == null) {
			btnAdAptitideQAEdit = new JButton("수정");
			btnAdAptitideQAEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ActionPartition_editAction();
				}
			});
			btnAdAptitideQAEdit.setBounds(164, 320, 60, 29);
		}
		return btnAdAptitideQAEdit;
	}
	private JButton getBtnAdAptitideQARemove() {
		if (btnAdAptitideQARemove == null) {
			btnAdAptitideQARemove = new JButton("삭제");
			btnAdAptitideQARemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ActionPartition_delectAction();
				}
			});
			btnAdAptitideQARemove.setBounds(276, 320, 60, 29);
		}
		return btnAdAptitideQARemove;
	}
	private JLabel getLblAdAptitideAnswer1Score() {
		if (lblAdAptitideAnswer1Score == null) {
			lblAdAptitideAnswer1Score = new JLabel("답1 점수");
			lblAdAptitideAnswer1Score.setBounds(368, 258, 46, 16);
		}
		return lblAdAptitideAnswer1Score;
	}
	private JLabel getLblAdAptitideAnswer2Score() {
		if (lblAdAptitideAnswer2Score == null) {
			lblAdAptitideAnswer2Score = new JLabel("답2 점수");
			lblAdAptitideAnswer2Score.setBounds(368, 294, 46, 16);
		}
		return lblAdAptitideAnswer2Score;
	}
	private JComboBox getCbAptitideAnswer1Score() {
		if (cbAptitideAnswer1Score == null) {
			cbAptitideAnswer1Score = new JComboBox();
			cbAptitideAnswer1Score.setModel(new DefaultComboBoxModel(new String[] {"선택", "0", "1"}));
			cbAptitideAnswer1Score.setBounds(426, 256, 62, 26);
		}
		return cbAptitideAnswer1Score;
	}
	private JComboBox getCbAptitideAnswer2Score() {
		if (cbAptitideAnswer2Score == null) {
			cbAptitideAnswer2Score = new JComboBox();
			cbAptitideAnswer2Score.setModel(new DefaultComboBoxModel(new String[] {"선택", "0", "1"}));
			cbAptitideAnswer2Score.setBounds(427, 290, 61, 26);
		}
		return cbAptitideAnswer2Score;
	}
	//-----------------------------------------------------------
	
	//Method
	
	//-----------------------------------------------------------
	//table 초기화
	@SuppressWarnings("static-access")
	public void MAQ_TableInit(){
      	Outer_Table_AdMBTIQA.addColumn("번호");
		Outer_Table_AdMBTIQA.addColumn("MBTI질문");
		Outer_Table_AdMBTIQA.addColumn("답1");
		Outer_Table_AdMBTIQA.addColumn("답2");
		Outer_Table_AdMBTIQA.setColumnCount(4); // Column이 4개
		
		int i = Outer_Table_AdMBTIQA.getRowCount();
		for(int j=0; j<i; j++) {
			Outer_Table_AdMBTIQA.removeRow(0);
		}
		
//		inner_table_AdMBTIQA.setAutoResizeMode(inner_table_AdMBTIQA.AUTO_RESIZE_OFF); // 마음대로 리사이징 x
		
		int vColIndex = 0; // 첫번째 행
		TableColumn col = inner_table_AdMBTIQA.getColumnModel().getColumn(vColIndex);
		int width = 10; // 첫번째 행 가로
		col.setPreferredWidth(width);; // 첫번째 행 가로크기 설정
		
		vColIndex = 1; // 2번째 행
		col = inner_table_AdMBTIQA.getColumnModel().getColumn(vColIndex);
		width = 110; // 2번째 행 가로
		col.setPreferredWidth(width);; // 2번째 행 가로크기 설정
		
		vColIndex = 2; // 3번째 행
		col = inner_table_AdMBTIQA.getColumnModel().getColumn(vColIndex);
		width = 150; // 2번째 행 가로
		col.setPreferredWidth(width);; // 3번째 행 가로크기 설정
		
		vColIndex = 3; // 4번째 행
		col = inner_table_AdMBTIQA.getColumnModel().getColumn(vColIndex);
		width = 100; // 3번째 행 가로
		col.setPreferredWidth(width);; // 4번째 행 가로크기 설정

	}
	
	//table에 DB 정보 입력
	public void MAQ_tableInputAction() {
		String query = "select aqNum, aqQuestion, aqAnswer1, aqAnswer2 from swing_project_team3.aptitudequestion";
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(data_Enviroment_define.url_mysql, data_Enviroment_define.id_mysql, data_Enviroment_define.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query); // 쿼리문장을 실행하여 ResultSet타입으로 변환 ->결과값 저장
			
			while(rs.next()) { //ResultSet에서 
				String[] qTxt = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
				Outer_Table_AdMBTIQA.addRow(qTxt);
				}			
			conn_mysql.close(); //DB 연결 끊기
			
			
		}catch(Exception e) {//java.lang
			e.printStackTrace();// 화면에 에러코드 보여주기
		}
	
	}
	
	
	// DataField 초기화(텍스트필드+콤보박스)
	public void MAQ_ClearColumn() {
		tfAdAptitideQANum.setText("");
		tfAdAptitideQA.setText("");
		tfAdAptitideAnswer1.setText("");
		tfAdAptitideAnswer2.setText("");
		cbAptitideAnswer1Score.setSelectedIndex(0);
		cbAptitideAnswer2Score.setSelectedIndex(0);
	}
	
	//Table clicked / table 내의 각 행을 클릭했을 때
	private void TableClick() {
		int i = inner_table_AdMBTIQA.getSelectedRow(); // i행을 불러옴, Seqno의 숫자 1~n까지
		String wkSeq = (String) inner_table_AdMBTIQA.getValueAt(i, 0); // String값으로 차례로 i행을 불러와 넣어줌
		String query = "select aqNum, aqQuestion, aqAnswer1, aqAnswer2, aqScore1, aqScore2 from swing_project_team3.aptitudequestion where aqNum="+wkSeq;
		// 열값을 차례로 불러오기 위함	
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc 드라이버를 로딩
			Connection conn_mysql = DriverManager.getConnection(data_Enviroment_define.url_mysql, data_Enviroment_define.id_mysql, data_Enviroment_define.pw_mysql); //DB환경 연결&로그인
			Statement stmt_mysql = conn_mysql.createStatement(); // DB에서 데이터를 불러옴
			
			ResultSet rs = stmt_mysql.executeQuery(query); // 쿼리문장을 실행하여 ResultSet타입으로 변환 ->객체 rs에 결과값 저장
			
			while(rs.next()) {
				tfAdAptitideQANum.setText(rs.getString(1)); // 열값을 차례로 불러오기 위함(순서, 이름, 전화번호, 이메일, 관계)
				tfAdAptitideQA.setText(rs.getString(2));
				tfAdAptitideAnswer1.setText(rs.getString(3));
				tfAdAptitideAnswer2.setText(rs.getString(4));
				cbAptitideAnswer1Score.setSelectedItem(rs.getString(5));
				cbAptitideAnswer2Score.setSelectedItem(rs.getString(6));
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
		if(tfAdAptitideQA.getText().length() == 0) {
			i++;
			message = "질문을 ";
			tfAdAptitideQA.requestFocus(); // 커서 띄우기
		}
		if(tfAdAptitideAnswer1.getText().length() == 0) {
			i++;
			message = "답1을 ";
			tfAdAptitideAnswer1.requestFocus();
		}
		if(tfAdAptitideAnswer2.getText().length() == 0) {
			i++;
			message = "답2을 ";
			tfAdAptitideAnswer2.requestFocus();
		}
		if(cbAptitideAnswer1Score.getSelectedItem() == "선택") {
			message = "점수1을 ";
			i++;
			cbAptitideAnswer1Score.requestFocus();
		}
		if(cbAptitideAnswer2Score.getSelectedItem() == "선택") {
			message = "점수2를 ";
			cbAptitideAnswer2Score.requestFocus();
			i++;
		}
					
		if(i>0) {
			JOptionPane.showMessageDialog(null, message + "입력하세요");
		}
		
		return i;
	}
	
	//점수1, 점수2이 같은 값일 경우 오류 출력
	//SungAh 2021.04.28
	private int ScoreFieldCheck(){
		int i = 0;			
		if(cbAptitideAnswer1Score.getSelectedItem() == "0" && cbAptitideAnswer2Score.getSelectedItem() == "0") {
			i++; // 점수1과 점수2의 값 = 0이면
		}			
		if(cbAptitideAnswer1Score.getSelectedItem() == "1" && cbAptitideAnswer2Score.getSelectedItem() == "1") {
			i++; // 점수1과 점수2의 값 = 1이면
		}			
		
		if(i>0) {
			JOptionPane.showMessageDialog(null, "점수1과 점수2의 값이 동일합니다");
		}
		return i;
		
	}
	
	//공백체크 + 점수1&점수2값 오류 체크 + 생성버튼 동작 실행
	//SungAh 2021.04.28
	private void ActionPartition_insertAction() {
		int i_chk = FieldCheck();
		int i_scorechk = ScoreFieldCheck();
		if(i_chk == 0 && i_scorechk == 0) { // 빈공란과 점수1&2가 같지않을 때
			MAQ_insertAction();
			MAQ_TableInit();
			MAQ_tableInputAction();
			MAQ_ClearColumn();
		}else {
			
		}
	}
	
	//공백체크 + 점수1&점수2값 오류 체크 + 수정버튼 동작 실행
	//SungAh 2021.04.28
	private void ActionPartition_editAction() {
		int i_chk = FieldCheck();
		int i_scorechk = ScoreFieldCheck();
		if(i_chk == 0 && i_scorechk == 0) { // 빈공란과 점수1&2가 같지않을 때
			MAQ_editAction();
			MAQ_TableInit();
			MAQ_tableInputAction();
			MAQ_ClearColumn();
		}else {
			
		}
	}
	
	//공백체크 + 점수1&점수2값 오류 체크 + 삭제버튼 동작 실행
	//SungAh 2021.04.28
	private void ActionPartition_delectAction() {
		int i_chk = FieldCheck();
		if(i_chk == 0) { // 빈공란과 점수1&2가 같지않을 때
			MAQ_delectAction();
			MAQ_TableInit();
			MAQ_tableInputAction();
			MAQ_ClearColumn();
		}else {
			
		}
	}
	
	
	// 생성 액션
	// SungAh 2021.04.28
	private void MAQ_insertAction() {		
		String aqQuestion = tfAdAptitideQA.getText().trim();
		String aqAnswer1 = tfAdAptitideAnswer1.getText().trim();
		String aqAnswer2 = tfAdAptitideAnswer2.getText().trim();
		String aqScore1 = cbAptitideAnswer1Score.getSelectedItem().toString();
		String aqScore2 = cbAptitideAnswer2Score.getSelectedItem().toString();
		
		MAQ_DbAction maq_dbAction = new MAQ_DbAction(aqQuestion, aqAnswer1, aqAnswer2, aqScore1, aqScore2);
		boolean msg = maq_dbAction.insertAction_boolean(); // dbAction 실행이 잘되는 지 확인
		if(msg == true) {
			JOptionPane.showMessageDialog(this, "적성검사 질문 정보가 입력되었습니다", "입력완료", 
			JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "DB에 자료 입력 중 에러가 발생했습니다", "Critical Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	// 수정 액션
	// SungAh 2021.04.28
	private void MAQ_editAction() {	
		String aqQuestion = tfAdAptitideQA.getText().trim();
		String aqAnswer1 = tfAdAptitideAnswer1.getText().trim();
		String aqAnswer2 = tfAdAptitideAnswer2.getText().trim();
		String aqScore1 = cbAptitideAnswer1Score.getSelectedItem().toString();
		String aqScore2 = cbAptitideAnswer2Score.getSelectedItem().toString();
		int aqNum = Integer.parseInt(tfAdAptitideQANum.getText());
		
		MAQ_DbAction maq_dbAction = new MAQ_DbAction(aqQuestion, aqAnswer1, aqAnswer2, aqScore1, aqScore2, aqNum);
		boolean msg = maq_dbAction.MAQ_editAction_boolean();
		if(msg == true) {
			JOptionPane.showMessageDialog(this, "적성검사 질문 정보가 수정되었습니다", "수정완료", 
			JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "DB에 자료 입력 중 에러가 발생했습니다", "Critical Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	// 삭제 액션
	// SungAh 2021.04.28
	private void MAQ_delectAction() {	
		int aqNum = Integer.parseInt(tfAdAptitideQANum.getText());
		
		MAQ_DbAction maq_dbAction = new MAQ_DbAction(aqNum);
		boolean msg = maq_dbAction.MAQ_deleteAction_boolean();
		if(msg == true) {
			JOptionPane.showMessageDialog(this, "적성검사 질문 정보가 삭제되었습니다", "삭제완료", 
			JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "DB에 자료 입력 중 에러가 발생했습니다", "Critical Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
}//-----------------------------------
