package com.javalec.adminMain;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PanelManageMbtiQuiz extends JPanel {
	private JScrollPane scrollPane_AdMBTIQA;
	private JTable inner_table_AdMBTIQA;
	private final DefaultTableModel Outer_Table_AdMBTIQA= new DefaultTableModel(); // ################
	private JLabel lblAdMBTIQANum;
	private JLabel lblAdMBTIQA;
	private JLabel lblAdMBTIAnswer1;
	private JLabel lblAdMBTIAnswer2;
	private JButton btnAdMBTIQACreate;
	private JButton btnAdMBTIQAEdit;
	private JButton btnAdMBTIQARemove;
	private JTextField tfAdMBTIQANum;
	private JTextField tfAdMBTIQA;
	private JTextField tfAdMBTIAnswer1;
	private JTextField tfAdMBTIAnswer2;
	private JScrollPane scrollPane_AdUser;
	private JLabel lblAdMBTIGroup;
	private JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	public PanelManageMbtiQuiz() {
		setBackground(Color.BLUE);
		setBounds(new Rectangle(180, 70, 370, 350));
		setLayout(null);
		add(getScrollPane_AdMBTIQA());
		add(getLblAdMBTIQANum());
		add(getLblAdMBTIQA());
		add(getLblAdMBTIAnswer1());
		add(getLblAdMBTIAnswer2());
		add(getBtnAdMBTIQACreate());
		add(getBtnAdMBTIQAEdit());
		add(getBtnAdMBTIQARemove());
		add(getTfAdMBTIQANum());
		add(getTfAdMBTIQA());
		add(getTfAdMBTIAnswer1());
		add(getTfAdMBTIAnswer2());
		add(getLblAdMBTIGroup());
		add(getComboBox());

	}

	private JScrollPane getScrollPane_AdMBTIQA() {
		if (scrollPane_AdMBTIQA == null) {
			scrollPane_AdMBTIQA = new JScrollPane();
			scrollPane_AdMBTIQA.setBounds(20, 17, 338, 156);
			scrollPane_AdMBTIQA.setViewportView(getInner_table_AdMBTIQA());
		}
		return scrollPane_AdMBTIQA;
	}
	private JTable getInner_table_AdMBTIQA() {
		if (inner_table_AdMBTIQA == null) {
			inner_table_AdMBTIQA = new JTable();
			inner_table_AdMBTIQA.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			inner_table_AdMBTIQA.setModel(Outer_Table_AdMBTIQA); // 테이블을 불러오기 위해 ******꼭 써야할 것*****
			
			//관리자 User table 설정
			Outer_Table_AdMBTIQA.addColumn("번호");
			Outer_Table_AdMBTIQA.addColumn("MBTI질문");
			Outer_Table_AdMBTIQA.addColumn("답1");
			Outer_Table_AdMBTIQA.addColumn("답2");
			Outer_Table_AdMBTIQA.setColumnCount(4); // Column이 4개
			
			int i = Outer_Table_AdMBTIQA.getRowCount();
			for(int j=0; j<i; j++) {
				Outer_Table_AdMBTIQA.removeRow(0);
			}
			
//			inner_table_AdManageUser.setAutoResizeMode(inner_table_AdManageUser.AUTO_RESIZE_OFF); // 마음대로 리사이징 x
			
			int vColIndex = 0; // 첫번째 행
			TableColumn col = inner_table_AdMBTIQA.getColumnModel().getColumn(vColIndex);
			int width = 30; // 첫번째 행 가로
			col.setPreferredWidth(width);; // 첫번째 행 가로크기 설정
			
			vColIndex = 1; // 2번째 행
			col = inner_table_AdMBTIQA.getColumnModel().getColumn(vColIndex);
			width = 100; // 2번째 행 가로
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
		return inner_table_AdMBTIQA;
	}
	
	private JLabel getLblAdMBTIQANum() {
		if (lblAdMBTIQANum == null) {
			lblAdMBTIQANum = new JLabel("번호");
			lblAdMBTIQANum.setBounds(20, 194, 61, 16);
		}
		return lblAdMBTIQANum;
	}
	private JLabel getLblAdMBTIQA() {
		if (lblAdMBTIQA == null) {
			lblAdMBTIQA = new JLabel("질문");
			lblAdMBTIQA.setBounds(20, 230, 61, 16);
		}
		return lblAdMBTIQA;
	}
	private JLabel getLblAdMBTIAnswer1() {
		if (lblAdMBTIAnswer1 == null) {
			lblAdMBTIAnswer1 = new JLabel("답1");
			lblAdMBTIAnswer1.setBounds(20, 263, 61, 16);
		}
		return lblAdMBTIAnswer1;
	}
	private JLabel getLblAdMBTIAnswer2() {
		if (lblAdMBTIAnswer2 == null) {
			lblAdMBTIAnswer2 = new JLabel("답2");
			lblAdMBTIAnswer2.setBounds(20, 297, 61, 16);
		}
		return lblAdMBTIAnswer2;
	}
	private JTextField getTfAdMBTIQANum() {
		if (tfAdMBTIQANum == null) {
			tfAdMBTIQANum = new JTextField();
			tfAdMBTIQANum.setBounds(93, 189, 60, 26);
			tfAdMBTIQANum.setColumns(10);
		}
		return tfAdMBTIQANum;
	}
	private JTextField getTfAdMBTIQA() {
		if (tfAdMBTIQA == null) {
			tfAdMBTIQA = new JTextField();
			tfAdMBTIQA.setColumns(10);
			tfAdMBTIQA.setBounds(93, 225, 265, 26);
		}
		return tfAdMBTIQA;
	}
	private JTextField getTfAdMBTIAnswer1() {
		if (tfAdMBTIAnswer1 == null) {
			tfAdMBTIAnswer1 = new JTextField();
			tfAdMBTIAnswer1.setColumns(10);
			tfAdMBTIAnswer1.setBounds(93, 258, 165, 26);
		}
		return tfAdMBTIAnswer1;
	}
	private JTextField getTfAdMBTIAnswer2() {
		if (tfAdMBTIAnswer2 == null) {
			tfAdMBTIAnswer2 = new JTextField();
			tfAdMBTIAnswer2.setColumns(10);
			tfAdMBTIAnswer2.setBounds(93, 292, 165, 26);
		}
		return tfAdMBTIAnswer2;
	}
	private JButton getBtnAdMBTIQACreate() {
		if (btnAdMBTIQACreate == null) {
			btnAdMBTIQACreate = new JButton("생성");
			btnAdMBTIQACreate.setBounds(20, 320, 60, 29);
		}
		return btnAdMBTIQACreate;
	}
	private JButton getBtnAdMBTIQAEdit() {
		if (btnAdMBTIQAEdit == null) {
			btnAdMBTIQAEdit = new JButton("수정");
			btnAdMBTIQAEdit.setBounds(155, 320, 60, 29);
		}
		return btnAdMBTIQAEdit;
	}
	private JButton getBtnAdMBTIQARemove() {
		if (btnAdMBTIQARemove == null) {
			btnAdMBTIQARemove = new JButton("삭제");
			btnAdMBTIQARemove.setBounds(290, 320, 60, 29);
		}
		return btnAdMBTIQARemove;
	}
	private JLabel getLblAdMBTIGroup() {
		if (lblAdMBTIGroup == null) {
			lblAdMBTIGroup = new JLabel("유형");
			lblAdMBTIGroup.setBounds(184, 194, 57, 15);
		}
		return lblAdMBTIGroup;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"EI", "SN", "TF", "JP"}));
			comboBox.setBounds(253, 189, 105, 26);
		}
		return comboBox;
	}
}//-----------------------------------
