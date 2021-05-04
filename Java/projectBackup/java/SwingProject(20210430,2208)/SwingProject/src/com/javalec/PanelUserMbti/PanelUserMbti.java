package com.javalec.PanelUserMbti;

import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.javalec.PanelManageMbtiQuiz.MMQ_Bean;
import com.javalec.PanelManageMbtiQuiz.MMQ_DbAction;

import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class PanelUserMbti extends JPanel {
	private JButton btnMbtiNext;
	private JRadioButton rbMbtiResult1;
	private JRadioButton rbMbtiResult2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblMbtiQuestion;
	
	UM_DbAction um_DbAction = new UM_DbAction();
	public int Numchk = 1;
	int test;
	
	
	/**
	 * Create the panel.
	 */
	public PanelUserMbti() {
		setBounds(new Rectangle(180, 10, 500, 420));
		setLayout(null);
		add(getBtnMbtiNext());
		add(getRbMbtiResult1());
		add(getRbMbtiResult2());
		add(getLblMbtiQuestion());
		UM_inputAction(Numchk);
	}
	private JButton getBtnMbtiNext() {
		if (btnMbtiNext == null) {
			btnMbtiNext = new JButton("다음");
			btnMbtiNext.setBounds(190, 303, 97, 23);
			btnMbtiNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					// 메모 
					int i =countMbtiNum();
					if ( i > Numchk) {
						Numchk++;
						UM_inputAction(Numchk);	// 버튼에 int값을 줘서 문제번호를 설정한다.(몇 번째 문제인지)
					}else {
						countMbtiNum();
					}
					 
//					if ( Numchk > (um_DbAction.mqNum)+1) {
//					    	JOptionPane.showMessageDialog(null, "문제가 끝났습니다");
//					    	btnMbtiNext.setVisible(false);
//					    }		
				}
			});
		}
		return btnMbtiNext;
	}
	private JRadioButton getRbMbtiResult1() {
		if (rbMbtiResult1 == null) {
			rbMbtiResult1 = new JRadioButton("New radio button");
			rbMbtiResult1.setBounds(110, 219, 280, 23);
			buttonGroup.add(rbMbtiResult1);
		}
		return rbMbtiResult1;
	}
	private JRadioButton getRbMbtiResult2() {
		if (rbMbtiResult2 == null) {
			rbMbtiResult2 = new JRadioButton("New radio button");
			rbMbtiResult2.setBounds(110, 255, 280, 23);
			buttonGroup.add(rbMbtiResult2);
		}
		return rbMbtiResult2;
	}
	private JLabel getLblMbtiQuestion() { 
		if (lblMbtiQuestion == null) {
			lblMbtiQuestion = new JLabel("New label");
			lblMbtiQuestion.setBounds(40, 67, 420, 123);
			lblMbtiQuestion.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return lblMbtiQuestion;
	}
	
	/* 
	 * =========================
	 * 메소드 정리
	 * =========================
	 */
	
	// 문제와 답 채우는 메소드
	
	private void UM_inputAction(int Numchk) {
	    UM_ClearPanel();
	    
	    UM_DbAction dbAction = new UM_DbAction(Numchk);
	    ArrayList<UM_Bean> beanList = dbAction.selectMbtiQuiz();

	    lblMbtiQuestion.setText(Integer.toString(Numchk)+ ". " + beanList.get(0).getMqQuiestion());
	    rbMbtiResult1.setText(beanList.get(0).getMqAnswer1());
	    rbMbtiResult2.setText(beanList.get(0).getMqAnswer2());
	    
	}
	
	private int countMbtiNum() {
		
		UM_DbAction dbAction1 = new UM_DbAction();
	    ArrayList<UM_Bean> beancount = dbAction1.UM_countMbtiNum();
	    
	    int countNum = beancount.get(0).getCountNum();
	    
	    if( Numchk > countNum) {
	    	JOptionPane.showMessageDialog(null, "문제가 끝났습니다");
	    	btnMbtiNext.setVisible(false);
	    	rbMbtiResult1.setVisible(false);
			rbMbtiResult2.setVisible(false);
	    }
	    return countNum;
	}
	
	
	
	public void UM_ClearPanel() {
		lblMbtiQuestion.setText("");
		rbMbtiResult1.setText("");
		rbMbtiResult2.setText("");
	}
}//======================================================
