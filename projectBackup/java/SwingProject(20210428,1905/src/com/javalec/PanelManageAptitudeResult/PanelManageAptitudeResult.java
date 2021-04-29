package com.javalec.PanelManageAptitudeResult;

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

public class PanelManageAptitudeResult extends JPanel {
	private JScrollPane scrollPane_AdAptitideResult;
	private final DefaultTableModel Outer_Table_AdMBTIResult = new DefaultTableModel(); // ################
	private JTable inner_table_AdMBTIResult;
	private JLabel lblAdAptitideResultName;
	private JLabel lblAdAptitideResultExplanation;
	private JTextField tfAdAptitideResultName;
	private JTextField tfAdAptitideResultExplanation;
	private JButton btnAdAptitideResultCreate;
	private JButton btnAdAptitideResultEdit;
	private JButton btnAdAptitideResultRemove;
	private JLabel lblAdAptitideResultNum;
	private JTextField tfAdAptitideResultNum;

	/**
	 * Create the panel.
	 */
	public PanelManageAptitudeResult() {
		setBackground(Color.RED);
		setBounds(new Rectangle(65, 57, 370, 350));
		setLayout(null);
		add(getScrollPane_AdAptitideResult());
		add(getLblAdAptitideResultName());
		add(getlblAdMBTIResultExplanation());
		add(getTfAdAptitideResultName());
		add(getTfAdAptitideResultExplanation());
		add(getBtnAdMBTIResultCreate());
		add(getBtnAdAptitideResultEdit());
		add(getBtnAdAptitideResultRemove());
		add(getLblAdAptitideResultNum());
		add(getTfAdAptitideResultNum());
		
		

	}
	private JScrollPane getScrollPane_AdAptitideResult() {
		if (scrollPane_AdAptitideResult == null) {
			scrollPane_AdAptitideResult = new JScrollPane();
			scrollPane_AdAptitideResult.setBounds(20, 17, 338, 156);
			scrollPane_AdAptitideResult.setViewportView(getInner_table_AdMBTIResult());
		}
		return scrollPane_AdAptitideResult;
	}

	
	private JLabel getLblAdAptitideResultName() {
		if (lblAdAptitideResultName == null) {
			lblAdAptitideResultName = new JLabel("적성");
			lblAdAptitideResultName.setBounds(20, 230, 61, 16);
		}
		return lblAdAptitideResultName;
	}
	private JLabel getlblAdMBTIResultExplanation() {
		if (lblAdAptitideResultExplanation == null) {
			lblAdAptitideResultExplanation = new JLabel("적성별설명");
			lblAdAptitideResultExplanation.setBounds(20, 263, 61, 16);
		}
		return lblAdAptitideResultExplanation;
	}
	
	private JTextField getTfAdAptitideResultName() {
		if (tfAdAptitideResultName == null) {
			tfAdAptitideResultName = new JTextField();
			tfAdAptitideResultName.setBounds(93, 225, 265, 26);
			tfAdAptitideResultName.setColumns(10);
		}
		return tfAdAptitideResultName;
	}
	private JTextField getTfAdAptitideResultExplanation() {
		if (tfAdAptitideResultExplanation == null) {
			tfAdAptitideResultExplanation = new JTextField();
			tfAdAptitideResultExplanation.setColumns(10);
			tfAdAptitideResultExplanation.setBounds(93, 258, 265, 54);
		}
		return tfAdAptitideResultExplanation;
	}
	
	private JButton getBtnAdMBTIResultCreate() {
		if (btnAdAptitideResultCreate == null) {
			btnAdAptitideResultCreate = new JButton("생성");
			btnAdAptitideResultCreate.setBounds(20, 320, 60, 29);
		}
		return btnAdAptitideResultCreate;
	}
	private JButton getBtnAdAptitideResultEdit() {
		if (btnAdAptitideResultEdit == null) {
			btnAdAptitideResultEdit = new JButton("수정");
			btnAdAptitideResultEdit.setBounds(155, 320, 60, 29);
		}
		return btnAdAptitideResultEdit;
	}
	private JButton getBtnAdAptitideResultRemove() {
		if (btnAdAptitideResultRemove == null) {
			btnAdAptitideResultRemove = new JButton("삭제");
			btnAdAptitideResultRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DeleteAction();
				}
			});
			btnAdAptitideResultRemove.setBounds(290, 320, 60, 29);
		}
		return btnAdAptitideResultRemove;
	}
	private JLabel getLblAdAptitideResultNum() {
		if (lblAdAptitideResultNum == null) {
			lblAdAptitideResultNum = new JLabel("번호");
			lblAdAptitideResultNum.setBounds(20, 194, 61, 16);
		}
		return lblAdAptitideResultNum;
	}
	private JTextField getTfAdAptitideResultNum() {
		if (tfAdAptitideResultNum == null) {
			tfAdAptitideResultNum = new JTextField();
			tfAdAptitideResultNum.setColumns(10);
			tfAdAptitideResultNum.setBounds(93, 189, 60, 26);
		}
		return tfAdAptitideResultNum;
	}
	
	//-------------------------------
	//메소드정리 
	//-------------------------------
	
	////Dowoo 2021.04.28 가로길이 수정
	private JTable getInner_table_AdMBTIResult() {
		if (inner_table_AdMBTIResult == null) {
			inner_table_AdMBTIResult = new JTable();
			inner_table_AdMBTIResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			inner_table_AdMBTIResult.setModel(Outer_Table_AdMBTIResult); // 테이블을 불러오기 위해 ******꼭 써야할 것*****
			
			//관리자 User table 설정
			Outer_Table_AdMBTIResult.addColumn("번호");
			Outer_Table_AdMBTIResult.addColumn("이름");
			Outer_Table_AdMBTIResult.addColumn("설명");
			Outer_Table_AdMBTIResult.setColumnCount(3);
			
			int i = Outer_Table_AdMBTIResult.getRowCount();
			for(int j=0; j<i; j++) {
				Outer_Table_AdMBTIResult.removeRow(0);
			}
			
			inner_table_AdMBTIResult.setAutoResizeMode(inner_table_AdMBTIResult.AUTO_RESIZE_OFF); // 마음대로 리사이징 x
			
			int vColIndex = 0; // 첫번째 행
			TableColumn col = inner_table_AdMBTIResult.getColumnModel().getColumn(vColIndex);
			int width = 30; // 첫번째 행 가로
			col.setPreferredWidth(width);; // 첫번째 행 가로크기 설정
			
			vColIndex = 1; // 2번째 행
			col = inner_table_AdMBTIResult.getColumnModel().getColumn(vColIndex);
			width = 50; // 2번째 행 가로
			col.setPreferredWidth(width);; // 2번째 행 가로크기 설정
			
			vColIndex = 2; // 3번째 행
			col = inner_table_AdMBTIResult.getColumnModel().getColumn(vColIndex);
			width = 150; // 3번째 행 가로
			col.setPreferredWidth(width);; // 3번째 행 가로크기 설정

			
		}
		return inner_table_AdMBTIResult;
	}
	
	//Dowoo 2021.04.28  삭제
	private void DeleteAction() {
		
		int aNum  = Integer.parseInt(tfAdAptitideResultNum.getText());
		
		MAR_DbAction mar_DbAction =new MAR_DbAction(aNum);
		boolean msg=mar_DbAction.DeleteAction();
			if(msg=true) {
				JOptionPane.showMessageDialog(this,tfAdAptitideResultName.getText()+"이 삭제되었습니다.",
				        	"삭제완료!",JOptionPane.INFORMATION_MESSAGE);
       
			}else if(msg=false){	 
				JOptionPane.showMessageDialog(this, "DB에 자료 수정중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!",
						 "Critical Error!", 
						 JOptionPane.ERROR_MESSAGE);    
			}
		}
	
}//---------------------------------
