package com.javalec.adminMain;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

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
	private JButton btnAdUserCreate;
	private JButton btnAdUserEdit;
	private JButton btnAdUserRemove;
	private JLabel lblAdUserEmail;
	private JTextField tfAdUserEmail;

	/**
	 * Create the panel.
	 */
	public PanelManageUser() {
		setBackground(Color.YELLOW);
		setBounds(new Rectangle(180, 10, 500, 420));
		setLayout(null);
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
		add(getBtnAdUserCreate());
		add(getBtnAdUserEdit());
		add(getBtnAdUserRemove());
		add(getLblAdUserEmail());
		add(getTfAdUserEmail());
		tableInit();
	}


	private JScrollPane getScrollPane_AdUser() {
		if (scrollPane_AdUser == null) {
			scrollPane_AdUser = new JScrollPane();
			scrollPane_AdUser.setBounds(20, 17, 496, 156);
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

	//화면 Table 초기화
		private void tableInit() {
			Outer_Table_AdManagerUser.addColumn("번호");
			Outer_Table_AdManagerUser.addColumn("이름");
			Outer_Table_AdManagerUser.addColumn("ID");
			Outer_Table_AdManagerUser.addColumn("Password");
			Outer_Table_AdManagerUser.addColumn("E-mail");
			Outer_Table_AdManagerUser.setColumnCount(5); // Column이 4개
			
			int i = Outer_Table_AdManagerUser.getRowCount();
			for(int j=0; j<i; j++) {
				Outer_Table_AdManagerUser.removeRow(0);
			}
			
//			inner_table_AdUser.setAutoResizeMode(inner_table_AdUser.AUTO_RESIZE_OFF); // 마음대로 리사이징 x
			
			int vColIndex = 0; // 첫번째 행
			TableColumn col = inner_table_AdUser.getColumnModel().getColumn(vColIndex);
			int width = 30; // 첫번째 행 가로
			col.setPreferredWidth(width);; // 첫번째 행 가로크기 설정
			
			vColIndex = 1; // 2번째 행
			col = inner_table_AdUser.getColumnModel().getColumn(vColIndex);
			width = 100; // 2번째 행 가로
			col.setPreferredWidth(width);; // 2번째 행 가로크기 설정
			
			vColIndex = 2; // 3번째 행
			col = inner_table_AdUser.getColumnModel().getColumn(vColIndex);
			width = 150; // 3번째 행 가로
			col.setPreferredWidth(width);; // 3번째 행 가로크기 설정
			
			vColIndex = 3; // 4번째 행
			col = inner_table_AdUser.getColumnModel().getColumn(vColIndex);
			width = 100; // 4번째 행 가로
			col.setPreferredWidth(width);; // 4번째 행 가로크기 설정
			
			vColIndex = 4; // 5번째 행
			col = inner_table_AdUser.getColumnModel().getColumn(vColIndex);
			width = 100; // 5번째 행 가로
			col.setPreferredWidth(width);; // 5번째 행 가로크기 설정
			
		}
	private JLabel getLblAdUserNum() {
		if (lblAdUserNum == null) {
			lblAdUserNum = new JLabel("번호");
			lblAdUserNum.setBounds(20, 194, 61, 16);
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
			tfAdUserNum.setBounds(93, 189, 423, 26);
			tfAdUserNum.setColumns(10);
		}
		return tfAdUserNum;
	}
	private JTextField getTfAdUserName() {
		if (tfAdUserName == null) {
			tfAdUserName = new JTextField();
			tfAdUserName.setColumns(10);
			tfAdUserName.setBounds(93, 225, 423, 26);
		}
		return tfAdUserName;
	}
	private JTextField getTfAdUserId() {
		if (tfAdUserId == null) {
			tfAdUserId = new JTextField();
			tfAdUserId.setColumns(10);
			tfAdUserId.setBounds(93, 258, 423, 26);
		}
		return tfAdUserId;
	}
	private JTextField getTfAdUserPw() {
		if (tfAdUserPw == null) {
			tfAdUserPw = new JTextField();
			tfAdUserPw.setColumns(10);
			tfAdUserPw.setBounds(93, 292, 423, 26);
		}
		return tfAdUserPw;
	}
	private JButton getBtnAdUserCreate() {
		if (btnAdUserCreate == null) {
			btnAdUserCreate = new JButton("생성");
			btnAdUserCreate.setBounds(20, 361, 117, 29);
		}
		return btnAdUserCreate;
	}
	private JButton getBtnAdUserEdit() {
		if (btnAdUserEdit == null) {
			btnAdUserEdit = new JButton("수정");
			btnAdUserEdit.setBounds(209, 361, 117, 29);
		}
		return btnAdUserEdit;
	}
	private JButton getBtnAdUserRemove() {
		if (btnAdUserRemove == null) {
			btnAdUserRemove = new JButton("삭제");
			btnAdUserRemove.setBounds(399, 361, 117, 29);
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
			tfAdUserEmail.setBounds(93, 323, 423, 26);
		}
		return tfAdUserEmail;
	}
}//----------------------
