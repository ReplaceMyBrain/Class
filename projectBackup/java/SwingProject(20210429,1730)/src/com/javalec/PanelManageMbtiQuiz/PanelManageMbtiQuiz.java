// 수훈 CRUD 추가 및 화면 불러오기추가 
package com.javalec.PanelManageMbtiQuiz;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.PanelManageMbtiQuiz.MMQ_Bean;
import com.javalec.PanelManageMbtiQuiz.MMQ_DbAction;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
   private JComboBox cbType;
   private JLabel lblAdMBTIAnswer1_1;
   private JLabel lblAdMBTIAnswer2_1;
   private JComboBox cbMBTIAnswer1Score;
   private JComboBox cbMBTIAnswer2Score;
   private JButton btnAdMBTIQASearch;

   /**
    * Create the panel.
    */
   public PanelManageMbtiQuiz() {
      setBackground(Color.BLUE);
      setBounds(new Rectangle(0, 57, 500, 350));
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
      add(getCbType());
      add(getLblAdMBTIAnswer1_1());
      add(getLblAdMBTIAnswer2_1());
      add(getCbMBTIAnswer1Score());
      add(getCbMBTIAnswer2Score());
      add(getBtnAdMBTIQASearch());
      MMQ_ClearColumn();

   }

   private JScrollPane getScrollPane_AdMBTIQA() {
      if (scrollPane_AdMBTIQA == null) {
         scrollPane_AdMBTIQA = new JScrollPane();
         scrollPane_AdMBTIQA.setBounds(12, 17, 476, 156);
         scrollPane_AdMBTIQA.setViewportView(getInner_table_AdMBTIQA());
      }
      return scrollPane_AdMBTIQA;
   }
   private JTable getInner_table_AdMBTIQA() {
      if (inner_table_AdMBTIQA == null) {
         inner_table_AdMBTIQA = new JTable();
         inner_table_AdMBTIQA.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	MMQ_TableClick();
            }
         });
         
         inner_table_AdMBTIQA.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         inner_table_AdMBTIQA.setModel(Outer_Table_AdMBTIQA); // 테이블을 불러오기 위해 ******꼭 써야할 것*****
         
         MMQ_TableInit();
      }
      return inner_table_AdMBTIQA;
   }
   
   private JLabel getLblAdMBTIQANum() {
      if (lblAdMBTIQANum == null) {
         lblAdMBTIQANum = new JLabel("번호");
         lblAdMBTIQANum.setBounds(12, 191, 27, 16);
      }
      return lblAdMBTIQANum;
   }
   private JLabel getLblAdMBTIQA() {
      if (lblAdMBTIQA == null) {
         lblAdMBTIQA = new JLabel("질문");
         lblAdMBTIQA.setBounds(12, 227, 27, 16);
      }
      return lblAdMBTIQA;
   }
   private JLabel getLblAdMBTIAnswer1() {
      if (lblAdMBTIAnswer1 == null) {
         lblAdMBTIAnswer1 = new JLabel("답1");
         lblAdMBTIAnswer1.setBounds(12, 260, 27, 16);
      }
      return lblAdMBTIAnswer1;
   }
   private JLabel getLblAdMBTIAnswer2() {
      if (lblAdMBTIAnswer2 == null) {
         lblAdMBTIAnswer2 = new JLabel("답2");
         lblAdMBTIAnswer2.setBounds(12, 294, 27, 16);
      }
      return lblAdMBTIAnswer2;
   }
   private JTextField getTfAdMBTIQANum() {
      if (tfAdMBTIQANum == null) {
         tfAdMBTIQANum = new JTextField();
         tfAdMBTIQANum.setBounds(51, 187, 60, 26);
         tfAdMBTIQANum.setColumns(10);
      }
      return tfAdMBTIQANum;
   }
   private JTextField getTfAdMBTIQA() {
      if (tfAdMBTIQA == null) {
         tfAdMBTIQA = new JTextField();
         tfAdMBTIQA.setColumns(10);
         tfAdMBTIQA.setBounds(51, 223, 437, 26);
      }
      return tfAdMBTIQA;
   }
   private JTextField getTfAdMBTIAnswer1() {
      if (tfAdMBTIAnswer1 == null) {
         tfAdMBTIAnswer1 = new JTextField();
         tfAdMBTIAnswer1.setColumns(10);
         tfAdMBTIAnswer1.setBounds(51, 256, 285, 26);
      }
      return tfAdMBTIAnswer1;
   }
   private JTextField getTfAdMBTIAnswer2() {
      if (tfAdMBTIAnswer2 == null) {
         tfAdMBTIAnswer2 = new JTextField();
         tfAdMBTIAnswer2.setColumns(10);
         tfAdMBTIAnswer2.setBounds(51, 290, 285, 26);
      }
      return tfAdMBTIAnswer2;
   }
   private JButton getBtnAdMBTIQACreate() {
      if (btnAdMBTIQACreate == null) {
         btnAdMBTIQACreate = new JButton("생성");
         btnAdMBTIQACreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	MMQ_InsertCheckAction();
            	}
         });
         btnAdMBTIQACreate.setBounds(52, 320, 60, 29);
      }
      return btnAdMBTIQACreate;
   }
   private JButton getBtnAdMBTIQAEdit() {
      if (btnAdMBTIQAEdit == null) {
         btnAdMBTIQAEdit = new JButton("수정");
         btnAdMBTIQAEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
           MMQ_UpdateCheckAction();
            }
         });
         btnAdMBTIQAEdit.setBounds(164, 320, 60, 29);
      }
      return btnAdMBTIQAEdit;
   }
   private JButton getBtnAdMBTIQARemove() {
      if (btnAdMBTIQARemove == null) {
         btnAdMBTIQARemove = new JButton("삭제");
         btnAdMBTIQARemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            MMQ_DeleteAction();
            MMQ_TableInit();
            MMQ_SearchAction();
            MMQ_ClearColumn();
            }
         });
         btnAdMBTIQARemove.setBounds(276, 320, 60, 29);
      }
      return btnAdMBTIQARemove;
   }
   private JLabel getLblAdMBTIGroup() {
      if (lblAdMBTIGroup == null) {
         lblAdMBTIGroup = new JLabel("유형");
         lblAdMBTIGroup.setBounds(185, 192, 35, 15);
      }
      return lblAdMBTIGroup;
   }
   private JComboBox getCbType() {
      if (cbType == null) {
         cbType = new JComboBox();
         cbType.setModel(new DefaultComboBoxModel(new String[] {"", "EI", "SN", "TF", "JP"}));
         cbType.setBounds(243, 183, 62, 26);
      }
      return cbType;
   }
   private JLabel getLblAdMBTIAnswer1_1() {
      if (lblAdMBTIAnswer1_1 == null) {
         lblAdMBTIAnswer1_1 = new JLabel("답1 점수");
         lblAdMBTIAnswer1_1.setBounds(368, 258, 46, 16);
      }
      return lblAdMBTIAnswer1_1;
   }
   private JLabel getLblAdMBTIAnswer2_1() {
      if (lblAdMBTIAnswer2_1 == null) {
         lblAdMBTIAnswer2_1 = new JLabel("답2 점수");
         lblAdMBTIAnswer2_1.setBounds(368, 294, 46, 16);
      }
      return lblAdMBTIAnswer2_1;
   }
   private JComboBox getCbMBTIAnswer1Score() {
      if (cbMBTIAnswer1Score == null) {
         cbMBTIAnswer1Score = new JComboBox();
         cbMBTIAnswer1Score.setModel(new DefaultComboBoxModel(new String[] {"", "0", "1"}));
         cbMBTIAnswer1Score.setBounds(426, 250, 62, 26);
      }
      return cbMBTIAnswer1Score;
   }
   private JComboBox getCbMBTIAnswer2Score() {
      if (cbMBTIAnswer2Score == null) {
         cbMBTIAnswer2Score = new JComboBox();
         cbMBTIAnswer2Score.setModel(new DefaultComboBoxModel(new String[] {"", "0", "1"}));
         cbMBTIAnswer2Score.setBounds(427, 284, 61, 26);
      }
      return cbMBTIAnswer2Score;
   }
   
   //==========================================================================================
   //==========================================================================================
   
   
   
   
   //Table 초기화
  public void MMQ_TableInit() {
      Outer_Table_AdMBTIQA.addColumn("번호"); //mqNum
      Outer_Table_AdMBTIQA.addColumn("MBTI질문"); //mqQuestion
      Outer_Table_AdMBTIQA.addColumn("답1");   // mqAnswer1
      Outer_Table_AdMBTIQA.addColumn("답2");   //mqAnswer2
      Outer_Table_AdMBTIQA.setColumnCount(4); // Column이 4개
      
      int i = Outer_Table_AdMBTIQA.getRowCount();
      for(int j=0; j<i; j++) {
         Outer_Table_AdMBTIQA.removeRow(0);
      }
      
      inner_table_AdMBTIQA.setAutoResizeMode(inner_table_AdMBTIQA.AUTO_RESIZE_OFF); // 마음대로 리사이징 x
      
      int vColIndex = 0; // 첫번째 행
      TableColumn col = inner_table_AdMBTIQA.getColumnModel().getColumn(vColIndex);
      int width = 30; // 첫번째 행 가로
      col.setPreferredWidth(width);; // 첫번째 행 가로크기 설정
      
      vColIndex = 1; // 2번째 행
      col = inner_table_AdMBTIQA.getColumnModel().getColumn(vColIndex);
      width = 246; // 2번째 행 가로
      col.setPreferredWidth(width);; // 2번째 행 가로크기 설정
      
      vColIndex = 2; // 3번째 행
      col = inner_table_AdMBTIQA.getColumnModel().getColumn(vColIndex);
      width = 100; // 2번째 행 가로
      col.setPreferredWidth(width);; // 3번째 행 가로크기 설정
      
      vColIndex = 3; // 4번째 행
      col = inner_table_AdMBTIQA.getColumnModel().getColumn(vColIndex);
      width = 100; // 3번째 행 가로
      col.setPreferredWidth(width);; // 4번째 행 가로크기 설정
      
   }
   
   //DB to Table
   public void MMQ_SearchAction() {
      
      MMQ_DbAction dbAction = new MMQ_DbAction();
      ArrayList<MMQ_Bean> beanlList = dbAction.selectList();
      
      int listCount =beanlList.size();
      
      for(int i=0; i<listCount; i++) {
         String temp =Integer.toString(beanlList.get(i).getMqNum());
         String[] qtxt = {temp, beanlList.get(i).getMqQuestion(),beanlList.get(i).getMqAnswer1(),beanlList.get(i).getMqAnswer2()};
         Outer_Table_AdMBTIQA.addRow(qtxt);
      }
      
   }
   
   
   //Click the Table
   
   private void MMQ_TableClick() {
        int i = inner_table_AdMBTIQA.getSelectedRow();
        String tmmqNum = (String)inner_table_AdMBTIQA.getValueAt(i, 0);
        int wkSequence = Integer.parseInt(tmmqNum);
        
        
        MMQ_DbAction dbAction =new MMQ_DbAction(wkSequence);
        MMQ_Bean bean = dbAction.TableClick();
        
        tfAdMBTIQANum.setText(Integer.toString(bean.getMqNum()));
        tfAdMBTIQA.setText(bean.getMqQuestion());
        cbType.setSelectedItem(bean.getMqType());
        tfAdMBTIAnswer1.setText(bean.getMqAnswer1());
        tfAdMBTIAnswer2.setText(bean.getMqAnswer2());
        cbMBTIAnswer1Score.setSelectedItem(bean.getMqScore1());
        cbMBTIAnswer2Score.setSelectedItem(bean.getMqScore2());
   }
   
   //입력 메소드
   private void MMQ_insertAction() {
      
      String mqQuestion = tfAdMBTIQA.getText().trim();
      String mqType = cbType.getSelectedItem().toString();
      String mqAnswer1 = tfAdMBTIAnswer1.getText().trim();
      String mqAnswer2 =  tfAdMBTIAnswer2.getText().trim();
      String mqScore1 = cbMBTIAnswer1Score.getSelectedItem().toString();
      String mqScore2 = cbMBTIAnswer2Score.getSelectedItem().toString();
   
      
      MMQ_DbAction dbAction = new MMQ_DbAction(mqQuestion, mqType, mqAnswer1, mqAnswer2, mqScore1, mqScore2);
      boolean msg=dbAction.insertAction();
      
      if(msg=true) {
         JOptionPane.showMessageDialog(this, "문제 입력이 완료되었습니다!");  
      }else if(msg=false){
          
            JOptionPane.showMessageDialog(this, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!",
                      "Critical Error!", 
                      JOptionPane.ERROR_MESSAGE);    
      }
   }
   
   //빈칸메소드 + insertAction
   private void MMQ_InsertCheckAction() {
	   int i_chk = MMQ_InsertFieldCheck();
	  
	   if(i_chk == 0) {
		   MMQ_insertAction();
		   MMQ_TableInit();
		   MMQ_SearchAction();
		   MMQ_ClearColumn();
	   }
	   
   }
   
   
   // 빈값있으면 삽입 안되게.
   private int MMQ_InsertFieldCheck() {
		int i = 0;
		String message = "";
		if(tfAdMBTIQA.getText().length() == 0) {
			i++;
			message = "질문을 ";
			tfAdMBTIQA.requestFocus(); // 커서 띄우기
		}
		if(cbType.getSelectedItem().equals("")) {
			i++;
			message = "유형을 ";
		}
		if(tfAdMBTIAnswer1.getText().length() == 0) {
			i++;
			message = "답1을 ";
			tfAdMBTIAnswer1.requestFocus();
		}
		if(tfAdMBTIAnswer2.getText().length() == 0) {
			i++;
			message = "답2을 ";
			tfAdMBTIAnswer2.requestFocus();
		}
		if(cbMBTIAnswer1Score.getSelectedItem() == null) {
			message = "점수1을 ";
			i++;
		}
		if(cbMBTIAnswer1Score.getSelectedItem() == null) {
			message = "점수2를 ";
			i++;
		}
		if(i>0) {
			JOptionPane.showMessageDialog(null, message + "입력하세요");
		}
		
		return i;
	}
   
      
   
   // 빈값있으면 수정 안되게
  private void MMQ_UpdateCheckAction() {
	  int i_chk = MMQ_InsertFieldCheck();
	   if(i_chk == 0) {
		   MMQ_UpdateAction();
		   MMQ_TableInit();
		   MMQ_SearchAction();
		   MMQ_ClearColumn();
	   }
	   
	  
  }
   //수정 메소드
   private void MMQ_UpdateAction() {
      String mqQuestion = tfAdMBTIQA.getText().trim();
      String mqType = cbType.getSelectedItem().toString();
      String mqAnswer1 = tfAdMBTIAnswer1.getText().trim();
      String mqAnswer2 = tfAdMBTIAnswer2.getText().trim();
      String mqScore1 = cbMBTIAnswer1Score.getSelectedItem().toString();
      String mqScore2 = cbMBTIAnswer2Score.getSelectedItem().toString();
      int mqNum = Integer.parseInt(tfAdMBTIQANum.getText());
      
      System.out.println(mqNum + "mqnum");
      MMQ_DbAction dbAction = new MMQ_DbAction(mqQuestion, mqType, mqAnswer1, mqAnswer2, mqScore1, mqScore2, mqNum);
      boolean msg = dbAction.UpdateAction();
      
      if (msg == true ) {
         JOptionPane.showMessageDialog(null, "MBTI 문제가 수정완료되었습니다.");
      }else if (msg == false){
         JOptionPane.showMessageDialog(this,"DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!",
                   "입력 완료!", 
                   JOptionPane.INFORMATION_MESSAGE); 
      }
   
   }
   
   // Data 삭제
      private void MMQ_DeleteAction() {
            
         int mqNum = Integer.parseInt(tfAdMBTIQANum.getText());
         
         MMQ_DbAction dbAction =new MMQ_DbAction(mqNum);
         boolean msg=dbAction.DeleteAction();
            if(msg=true) {
                 JOptionPane.showMessageDialog(this, "문제가 삭제 되었습니다.!",
                       "삭제 완료!", 
                       JOptionPane.INFORMATION_MESSAGE);         
            }else if(msg=false){
                
                JOptionPane.showMessageDialog(this, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!",
                      "Critical Error!", 
                      JOptionPane.ERROR_MESSAGE);    
            }
         }
   
   // 유형 선택하고 검색 버튼 입력시 
   		private void MMQ_ConditionQueryAction(String selectType) {
//   			selectType = cbType.getSelectedItem().toString();
   			
   			MMQ_DbAction dbAction = new MMQ_DbAction(selectType);
   			ArrayList<MMQ_Bean> beanlList = dbAction.ConditionQueryAction();
   				
   			
   				int listCount =beanlList.size();
   				for(int i=0; i<listCount; i++) {
   					String temp =Integer.toString(beanlList.get(i).getMqNum());
   					String[] qtxt = {temp, beanlList.get(i).getMqQuestion(),beanlList.get(i).getMqAnswer1(),beanlList.get(i).getMqAnswer2()};
   					Outer_Table_AdMBTIQA.addRow(qtxt);
   				}
   				
   		}
      private void MMQ_ConditionQuery() {
    	  int i = cbType.getSelectedIndex();
  		String selectType = "";
  		switch (i) {
  		case 0:
  			selectType = null;
  			break;
  		case 1:
  			selectType = "EI";
  			break;
  		case 2:
  			selectType = "SN";
  			break;
  		case 3:
  			selectType = "TF";
  			break;
  		case 4:
  			selectType = "JP";
  			break;
  		default:
  			break;
  		} 
  		
  		MMQ_TableInit();
  		MMQ_ClearColumn();
  		MMQ_ConditionQueryAction(selectType);

      }
   
   //DataField 정리
   public void MMQ_ClearColumn() {
      tfAdMBTIQANum.setText("");
      tfAdMBTIQA.setText("");
      tfAdMBTIAnswer1.setText("");
      tfAdMBTIAnswer2.setText("");
      cbMBTIAnswer1Score.setSelectedItem(null);
      cbMBTIAnswer2Score.setSelectedItem(null);
   }
   
   //tf 에디터블
   private void MMQ_editabletf() {
	   tfAdMBTIQANum.setEditable(false);
	   tfAdMBTIQA.setEditable(false);
	   cbType.setEditable(false);
	   tfAdMBTIAnswer1.setEditable(false);
	   tfAdMBTIAnswer2.setEditable(false);
	   cbMBTIAnswer1Score.setEditable(false);
	   cbMBTIAnswer2Score.setEditable(false);
   }
   
	private JButton getBtnAdMBTIQASearch() {
		if (btnAdMBTIQASearch == null) {
			btnAdMBTIQASearch = new JButton("검색");
			btnAdMBTIQASearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MMQ_ConditionQuery();
					MMQ_ClearColumn();
	
				}
			});
			btnAdMBTIQASearch.setBounds(388, 320, 60, 29);
		}
		return btnAdMBTIQASearch;
	}
}//==============================