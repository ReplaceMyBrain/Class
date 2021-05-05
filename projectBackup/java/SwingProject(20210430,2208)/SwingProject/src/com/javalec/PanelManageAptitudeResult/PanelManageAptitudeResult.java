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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelManageAptitudeResult extends JPanel {
	
	
	private JScrollPane scrollPane_AdAptitideResult;
	private final DefaultTableModel Outer_Table_AdAptitideResult = new DefaultTableModel(); // ################
	private JTable inner_table_AdAptitideResult;
	private JLabel lblAdAptitideResultName;
	private JLabel lblAdAptitideResultarExplain;
	private JTextField tfAdAptitideResultName;
	private JTextField tfAdAptitideResultarExplain;
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
		add(getTfAdAptitideResultarExplain());
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
			scrollPane_AdAptitideResult.setViewportView(inner_table_AdAptitideResult());
		}
		return scrollPane_AdAptitideResult;
	}
	private JTable inner_table_AdAptitideResult() {
		if (inner_table_AdAptitideResult == null) {
			inner_table_AdAptitideResult = new JTable();
			inner_table_AdAptitideResult.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					MAR_TableClick();
				}
			});
			inner_table_AdAptitideResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			inner_table_AdAptitideResult.setModel(Outer_Table_AdAptitideResult); // 테이블을 불러오기 위해 ******꼭 써야할 것*****
			MAR_TableInit();
			MAR_selectList();
		}
		return inner_table_AdAptitideResult;
	}

	
	private JLabel getLblAdAptitideResultName() {
		if (lblAdAptitideResultName == null) {
			lblAdAptitideResultName = new JLabel("적성");
			lblAdAptitideResultName.setBounds(20, 230, 61, 16);
		}
		return lblAdAptitideResultName;
	}
	private JLabel getlblAdMBTIResultExplanation() {
		if (lblAdAptitideResultarExplain == null) {
			lblAdAptitideResultarExplain = new JLabel("적성별설명");
			lblAdAptitideResultarExplain.setBounds(20, 263, 61, 16);
		}
		return lblAdAptitideResultarExplain;
	}
	
	private JTextField getTfAdAptitideResultName() {
		if (tfAdAptitideResultName == null) {
			tfAdAptitideResultName = new JTextField();
			tfAdAptitideResultName.setBounds(93, 225, 265, 26);
			tfAdAptitideResultName.setColumns(10);
		}
		return tfAdAptitideResultName;
	}
	private JTextField getTfAdAptitideResultarExplain() {
		if (tfAdAptitideResultarExplain == null) {
			tfAdAptitideResultarExplain = new JTextField();
			tfAdAptitideResultarExplain.setColumns(10);
			tfAdAptitideResultarExplain.setBounds(93, 258, 265, 54);
		}
		return tfAdAptitideResultarExplain;
	}
	
	private JButton getBtnAdMBTIResultCreate() {
		if (btnAdAptitideResultCreate == null) {
			btnAdAptitideResultCreate = new JButton("생성");
			btnAdAptitideResultCreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MAR_Action(1);
				}
			});
			btnAdAptitideResultCreate.setBounds(20, 320, 60, 29);
		}
		return btnAdAptitideResultCreate;
	}
	private JButton getBtnAdAptitideResultEdit() {
		if (btnAdAptitideResultEdit == null) {
			btnAdAptitideResultEdit = new JButton("수정");
			btnAdAptitideResultEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MAR_Action(2);
				}
			});
			btnAdAptitideResultEdit.setBounds(155, 320, 60, 29);
		}
		return btnAdAptitideResultEdit;
	}
	private JButton getBtnAdAptitideResultRemove() {
		if (btnAdAptitideResultRemove == null) {
			btnAdAptitideResultRemove = new JButton("삭제");
			btnAdAptitideResultRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MAR_Action(3);
					
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
			tfAdAptitideResultNum.setEditable(false);
			tfAdAptitideResultNum.setColumns(10);
			tfAdAptitideResultNum.setBounds(93, 189, 60, 26);
		}
		return tfAdAptitideResultNum;
	}
	
	//-------------------------------
	//메소드정리 
	//-------------------------------
	
	//테이블초기화 Dowoo 2021.04.28 가로길이 수정	
	private void MAR_TableInit() {
			//관리자 User table 설정
			Outer_Table_AdAptitideResult.addColumn("번호");
			Outer_Table_AdAptitideResult.addColumn("이름");
			Outer_Table_AdAptitideResult.addColumn("설명");
			Outer_Table_AdAptitideResult.setColumnCount(3);
			
			int i = Outer_Table_AdAptitideResult.getRowCount();
			for(int j=0; j<i; j++) {
				Outer_Table_AdAptitideResult.removeRow(0);
			}
			
			inner_table_AdAptitideResult.setAutoResizeMode(inner_table_AdAptitideResult.AUTO_RESIZE_OFF); // 마음대로 리사이징 x
			
			int vColIndex = 0; // 첫번째 행
			TableColumn col = inner_table_AdAptitideResult.getColumnModel().getColumn(vColIndex);
			int width = 30; // 첫번째 행 가로
			col.setPreferredWidth(width);; // 첫번째 행 가로크기 설정
			
			vColIndex = 1; // 2번째 행
			col = inner_table_AdAptitideResult.getColumnModel().getColumn(vColIndex);
			width = 50; // 2번째 행 가로
			col.setPreferredWidth(width);; // 2번째 행 가로크기 설정
			
			vColIndex = 2; // 3번째 행
			col = inner_table_AdAptitideResult.getColumnModel().getColumn(vColIndex);
			width = 150; // 3번째 행 가로
			col.setPreferredWidth(width);; // 3번째 행 가로크기 설정

	}

	
	//데이터 초기화
	private void MAR_ClearColumn() {
		tfAdAptitideResultarExplain.setText("");
		tfAdAptitideResultName.setText("");
		tfAdAptitideResultNum.setText("");
	}

	//전제검색 Dowoo 2021.04.29
	private void MAR_selectList(){

		MAR_DbAction dbAction = new MAR_DbAction();
		ArrayList<MAR_Bean> beanlList = dbAction.MAR_selectList();
		
		int listCount =beanlList.size();
		
		for(int i=0; i<listCount; i++) {
			String temp =Integer.toString(beanlList.get(i).getArNum());
			String[] qtxt = {temp, beanlList.get(i).getArName(),beanlList.get(i).getArExplain()};
			Outer_Table_AdAptitideResult.addRow(qtxt);
			}
	}
	
	//클릭시 채우기 Dowoo 2021.04.29
	private void MAR_TableClick() {
	int i = inner_table_AdAptitideResult.getSelectedRow();
	String tmArNum = (String)inner_table_AdAptitideResult.getValueAt(i,0);
	int wkArNUM = Integer.parseInt(tmArNum);
	
	MAR_DbAction mar_DbAction =new MAR_DbAction(wkArNUM);
	MAR_Bean bean =mar_DbAction.MAR_TableClick();
	
	tfAdAptitideResultNum.setText(Integer.toString(bean.getArNum()));
	tfAdAptitideResultName.setText(bean.getArName()); 
	tfAdAptitideResultarExplain.setText(bean.getArExplain());
		
	}
	
		// 공란불가 입력
		private void MAR_Action(int k) {
			int i_chk = MAR_FieldCheck();
			if(i_chk == 0){
				
				switch(k) {
				case 1 : MAR_insertAction();
					break;
				case 2 : MAR_UpdateAction();
					break;
				case 3 : MAR_DeleteAction();
					break;
				}
				MAR_TableInit();
				MAR_selectList();
				MAR_ClearColumn();
			}else {
				JOptionPane.showMessageDialog(this, "공란확인" + "\n" + 
						"Data를 입력하세요 하세요!");			
				}	
			}
	
		
	//실행메소드 Dowoo 2021.04.29
	private void MAR_insertAction(){

		String arName = tfAdAptitideResultName.getText().trim();
		String arExplain = tfAdAptitideResultarExplain.getText().trim();
	
		MAR_DbAction mar_DbAction =new MAR_DbAction(arName, arExplain);
		boolean msg = mar_DbAction.MAR_insertAction();
		
		if(msg=true) {
			JOptionPane.showMessageDialog(this, tfAdAptitideResultName.getText()+" 님의 정보가 입력 되었습니다.!",
		             "입력 완료!", 
		             JOptionPane.INFORMATION_MESSAGE);  
		}else if(msg=false){
			 
			   JOptionPane.showMessageDialog(this, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!",
				          "Critical Error!", 
				          JOptionPane.ERROR_MESSAGE);    
		}
	}
	
	//입력	Dowoo 2021.04.29
	private int MAR_FieldCheck(){
		int i = 0;
		if(tfAdAptitideResultName.getText().length() == 0){
			i++;
			tfAdAptitideResultName.requestFocus();
		}
		if(tfAdAptitideResultarExplain.getText().length() == 0){
			i++;
			tfAdAptitideResultarExplain.requestFocus();
		}
		return i;
	}
		
	
	
	
	
	//수정	Dowoo 2021.04.29
	private void MAR_UpdateAction() {
		int arNum = Integer.parseInt(tfAdAptitideResultNum.getText().trim());
		String arName = tfAdAptitideResultName.getText().trim();
		String arExplain = tfAdAptitideResultarExplain.getText().trim();
		
		MAR_DbAction mar_DbAction =new MAR_DbAction(arNum, arName, arExplain);
		boolean msg = mar_DbAction.MAR_UpdateAction();
		
		if(msg=true) {
			JOptionPane.showMessageDialog(this, tfAdAptitideResultName.getText()+" 님의 정보가 수정되었습니다.!",
		             "입력 완료!", 
		             JOptionPane.INFORMATION_MESSAGE);  
		}else if(msg=false) {
			JOptionPane.showMessageDialog(this, tfAdAptitideResultName.getText()+"DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!",
		             "입력 불가!", 
		             JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	//삭제 Dowoo 2021.04.28 
	private void MAR_DeleteAction() {
		
		int aNum  = Integer.parseInt(tfAdAptitideResultNum.getText());
		
		MAR_DbAction mar_DbAction =new MAR_DbAction(aNum);
		boolean msg = mar_DbAction.MAR_DeleteAction();
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
