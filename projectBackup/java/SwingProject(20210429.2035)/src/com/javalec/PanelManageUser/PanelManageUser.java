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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PanelManageUser extends JPanel {
	private JScrollPane scrollPane_AdUser;
	private JTable inner_table_AdUser;
	private final DefaultTableModel Outer_Table_AdManagerUser = new DefaultTableModel(); // ################
	private JLabel lblAdUserNum;
	private JLabel lblAdUserName;
	private JLabel lblAdUserId;
	private JLabel lblAdUserPw;
	private JTextField tfAdUserNum;
	private JTextField tfAdUserName;
	private JTextField tfAdUserId;
	private JTextField tfAdUserPw;
	private JButton btnAdUserWithdrawal;
	private JButton btnAdUserEdit;
	private JButton btnAdUserRemove;
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
		setBackground(Color.YELLOW);
		setBounds(new Rectangle(180, 10, 512, 420));
		setLayout(null);
		setVisible(false);
		add(getScrollPane_AdUser());
		add(getScrollPane_AdUser());
		add(getLblAdUserNum());
		add(getLblAdUserName());
		add(getLblAdUserId());
		add(getLblAdUserPw());
		add(getTfAdUserNum());
		add(getTfAdUserName());
		add(getTfAdUserId());
		add(getTfAdUserPw());
		add(getBtnAdUserWithdrawal());
		add(getBtnAdUserEdit());
		add(getBtnAdUserRemove());
		add(getLblAdUserEmail());
		add(getTfAdUserEmail());
		add(getLblAdUserState());
		add(getBtnAdUserSearch());
		add(getTfAdUserSearch());
		add(getCbadUserSearch());
		add(getTfAdUserState());
		tableInit();
	}


	private JScrollPane getScrollPane_AdUser() {
		if (scrollPane_AdUser == null) {
			scrollPane_AdUser = new JScrollPane();
			scrollPane_AdUser.setBounds(20, 17, 484, 122);
			scrollPane_AdUser.setViewportView(getInner_table_AdUser());
		}
		return scrollPane_AdUser;
	}
	private JTable getInner_table_AdUser() {
		if (inner_table_AdUser == null) {
			inner_table_AdUser = new JTable();
			inner_table_AdUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			inner_table_AdUser.setModel(Outer_Table_AdManagerUser); // 테이블을 불러오기 위해 ******꼭 써야할 것*****
		}
		return inner_table_AdUser;
	}
	private JLabel getLblAdUserNum() {
		if (lblAdUserNum == null) {
			lblAdUserNum = new JLabel("번호");
			lblAdUserNum.setBounds(20, 193, 61, 16);
		}
		return lblAdUserNum;
	}
	private JLabel getLblAdUserName() {
		if (lblAdUserName == null) {
			lblAdUserName = new JLabel("이름");
			lblAdUserName.setBounds(20, 230, 61, 16);
		}
		return lblAdUserName;
	}
	private JLabel getLblAdUserId() {
		if (lblAdUserId == null) {
			lblAdUserId = new JLabel("Id");
			lblAdUserId.setBounds(20, 263, 61, 16);
		}
		return lblAdUserId;
	}
	private JLabel getLblAdUserPw() {
		if (lblAdUserPw == null) {
			lblAdUserPw = new JLabel("Password");
			lblAdUserPw.setBounds(20, 297, 61, 16);
		}
		return lblAdUserPw;
	}
	private JTextField getTfAdUserNum() {
		if (tfAdUserNum == null) {
			tfAdUserNum = new JTextField();
			tfAdUserNum.setBounds(93, 189, 86, 26);
			tfAdUserNum.setColumns(10);
		}
		return tfAdUserNum;
	}
	private JTextField getTfAdUserName() {
		if (tfAdUserName == null) {
			tfAdUserName = new JTextField();
			tfAdUserName.setColumns(10);
			tfAdUserName.setBounds(93, 225, 411, 26);
		}
		return tfAdUserName;
	}
	private JTextField getTfAdUserId() {
		if (tfAdUserId == null) {
			tfAdUserId = new JTextField();
			tfAdUserId.setColumns(10);
			tfAdUserId.setBounds(93, 258, 411, 26);
		}
		return tfAdUserId;
	}
	private JTextField getTfAdUserPw() {
		if (tfAdUserPw == null) {
			tfAdUserPw = new JTextField();
			tfAdUserPw.setColumns(10);
			tfAdUserPw.setBounds(93, 292, 411, 26);
		}
		return tfAdUserPw;
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
			btnAdUserEdit.setBounds(212, 361, 105, 29);
		}
		return btnAdUserEdit;
	}
	private JButton getBtnAdUserRemove() {
		if (btnAdUserRemove == null) {
			btnAdUserRemove = new JButton("삭제");
			btnAdUserRemove.setBounds(357, 361, 105, 29);
		}
		return btnAdUserRemove;
	}
	private JLabel getLblAdUserEmail() {
		if (lblAdUserEmail == null) {
			lblAdUserEmail = new JLabel("E-mail");
			lblAdUserEmail.setBounds(20, 328, 61, 16);
		}
		return lblAdUserEmail;
	}
	private JTextField getTfAdUserEmail() {
		if (tfAdUserEmail == null) {
			tfAdUserEmail = new JTextField();
			tfAdUserEmail.setColumns(10);
			tfAdUserEmail.setBounds(93, 323, 411, 26);
		}
		return tfAdUserEmail;
	}
	private JLabel getLblAdUserState() {
		if (lblAdUserState == null) {
			lblAdUserState = new JLabel("상태");
			lblAdUserState.setBounds(232, 194, 61, 16);
		}
		return lblAdUserState;
	}
	
	private JButton getBtnAdUserSearch() {
		if (btnAdUserSearch == null) {
			btnAdUserSearch = new JButton("검색");
			btnAdUserSearch.setBounds(399, 147, 105, 29);
		}
		return btnAdUserSearch;
	}
	private JTextField getTfAdUserSearch() {
		if (tfAdUserSearch == null) {
			tfAdUserSearch = new JTextField();
			tfAdUserSearch.setColumns(10);
			tfAdUserSearch.setBounds(93, 149, 294, 26);
		}
		return tfAdUserSearch;
	}
	private JComboBox getCbadUserSearch() {
		if (cbadUserSearch == null) {
			cbadUserSearch = new JComboBox();
			cbadUserSearch.setBounds(17, 149, 64, 23);
		}
		return cbadUserSearch;
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
		Outer_Table_AdManagerUser.setColumnCount(5); // 
		
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
		width = 30; // 2번째 행 가로
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
		
	}
	//Dowoo 2021.04.28  탈퇴 복원

	private void WithdrawalAction() {
		
		if(tfAdUserState.equals("회원")) {
			  tfAdUserState.setText("탈퇴");
		}else if(tfAdUserState.equals("탈퇴")) {
			 tfAdUserState.setText("회원");
		}
		
		int userNum = Integer.parseInt(tfAdUserNum.getText());
		
		MU_DbAction mu_DbAction = new MU_DbAction(userNum);
		boolean msg =  mu_DbAction.WithdrawalAction();
		
		if(msg=true) {
			if(tfAdUserState.equals("탈퇴")) {
				  JOptionPane.showMessageDialog(this,tfAdUserName.getText()+" 님의 정보가 탈퇴 되었습니다.!",
			        	"탈퇴 완료!",JOptionPane.INFORMATION_MESSAGE);

			}else if(tfAdUserState.equals("회원")) {
				  JOptionPane.showMessageDialog(this,tfAdUserName.getText()+" 님의 정보가 복원 되었습니다.!",
			        	"복원 완료!",JOptionPane.INFORMATION_MESSAGE); 
				 
			}
		}else if(msg=false){
			JOptionPane.showMessageDialog(this, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!",
				 "Critical Error!", 
				 JOptionPane.ERROR_MESSAGE);  
			}
		
		}


	private JTextField getTfAdUserState() {
		if (tfAdUserState == null) {
			tfAdUserState = new JTextField();
			tfAdUserState.setBounds(271, 191, 49, 21);
			tfAdUserState.setColumns(10);
		}
		return tfAdUserState;
	}
}//----------------------
