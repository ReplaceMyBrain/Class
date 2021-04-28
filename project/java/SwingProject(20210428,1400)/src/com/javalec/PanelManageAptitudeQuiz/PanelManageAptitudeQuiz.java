package com.javalec.PanelManageAptitudeQuiz;

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
		setBackground(Color.ORANGE);
		setBounds(new Rectangle(65, 57, 370, 350));
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
			scrollPane_AdAptitideQA.setBounds(20, 17, 338, 156);
			scrollPane_AdAptitideQA.setViewportView(getInner_table_AdMBTIQA());
		}
		return scrollPane_AdAptitideQA;
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
	
	private JLabel getLblAdAptitideNum() {
		if (lblAdAptitideNum == null) {
			lblAdAptitideNum = new JLabel("번호");
			lblAdAptitideNum.setBounds(20, 194, 61, 16);
		}
		return lblAdAptitideNum;
	}
	private JLabel getLblAdAptitideQA() {
		if (lblAdAptitideQA == null) {
			lblAdAptitideQA = new JLabel("질문");
			lblAdAptitideQA.setBounds(20, 230, 61, 16);
		}
		return lblAdAptitideQA;
	}
	private JLabel getLblAdAptitideAnswer1() {
		if (lblAdAptitideAnswer1 == null) {
			lblAdAptitideAnswer1 = new JLabel("답1");
			lblAdAptitideAnswer1.setBounds(20, 263, 61, 16);
		}
		return lblAdAptitideAnswer1;
	}
	private JLabel getLblAdAptitideAnswer2() {
		if (lblAdAptitideAnswer2 == null) {
			lblAdAptitideAnswer2 = new JLabel("답2");
			lblAdAptitideAnswer2.setBounds(20, 297, 61, 16);
		}
		return lblAdAptitideAnswer2;
	}
	private JTextField getTfAdAptitideQANum() {
		if (tfAdAptitideQANum == null) {
			tfAdAptitideQANum = new JTextField();
			tfAdAptitideQANum.setBounds(93, 189, 60, 26);
			tfAdAptitideQANum.setColumns(10);
		}
		return tfAdAptitideQANum;
	}
	private JTextField getTfAdAptitideQA() {
		if (tfAdAptitideQA == null) {
			tfAdAptitideQA = new JTextField();
			tfAdAptitideQA.setColumns(10);
			tfAdAptitideQA.setBounds(93, 225, 265, 26);
		}
		return tfAdAptitideQA;
	}
	private JTextField getTfAdAptitideAnswer1() {
		if (tfAdAptitideAnswer1 == null) {
			tfAdAptitideAnswer1 = new JTextField();
			tfAdAptitideAnswer1.setColumns(10);
			tfAdAptitideAnswer1.setBounds(93, 258, 122, 26);
		}
		return tfAdAptitideAnswer1;
	}
	private JTextField getTfAdAptitideAnswer2() {
		if (tfAdAptitideAnswer2 == null) {
			tfAdAptitideAnswer2 = new JTextField();
			tfAdAptitideAnswer2.setColumns(10);
			tfAdAptitideAnswer2.setBounds(93, 292, 122, 26);
		}
		return tfAdAptitideAnswer2;
	}
	private JButton getBtnAdAptitideQACreate() {
		if (btnAdAptitideQACreate == null) {
			btnAdAptitideQACreate = new JButton("생성");
			btnAdAptitideQACreate.setBounds(20, 320, 60, 29);
		}
		return btnAdAptitideQACreate;
	}
	private JButton getBtnAdAptitideQAEdit() {
		if (btnAdAptitideQAEdit == null) {
			btnAdAptitideQAEdit = new JButton("수정");
			btnAdAptitideQAEdit.setBounds(155, 320, 60, 29);
		}
		return btnAdAptitideQAEdit;
	}
	private JButton getBtnAdAptitideQARemove() {
		if (btnAdAptitideQARemove == null) {
			btnAdAptitideQARemove = new JButton("삭제");
			btnAdAptitideQARemove.setBounds(290, 320, 60, 29);
		}
		return btnAdAptitideQARemove;
	}
	private JLabel getLblAdAptitideAnswer1Score() {
		if (lblAdAptitideAnswer1Score == null) {
			lblAdAptitideAnswer1Score = new JLabel("답1 점수");
			lblAdAptitideAnswer1Score.setBounds(223, 263, 61, 16);
		}
		return lblAdAptitideAnswer1Score;
	}
	private JLabel getLblAdAptitideAnswer2Score() {
		if (lblAdAptitideAnswer2Score == null) {
			lblAdAptitideAnswer2Score = new JLabel("답2 점수");
			lblAdAptitideAnswer2Score.setBounds(223, 297, 61, 16);
		}
		return lblAdAptitideAnswer2Score;
	}
	private JComboBox getCbAptitideAnswer1Score() {
		if (cbAptitideAnswer1Score == null) {
			cbAptitideAnswer1Score = new JComboBox();
			cbAptitideAnswer1Score.setBounds(296, 258, 62, 26);
		}
		return cbAptitideAnswer1Score;
	}
	private JComboBox getCbAptitideAnswer2Score() {
		if (cbAptitideAnswer2Score == null) {
			cbAptitideAnswer2Score = new JComboBox();
			cbAptitideAnswer2Score.setBounds(297, 292, 61, 26);
		}
		return cbAptitideAnswer2Score;
	}
}//-----------------------------------
