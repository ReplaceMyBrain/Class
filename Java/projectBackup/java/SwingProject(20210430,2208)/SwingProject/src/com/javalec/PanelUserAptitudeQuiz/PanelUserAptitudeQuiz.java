package com.javalec.PanelUserAptitudeQuiz;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.javalec.Datadefine.data_Enviroment_define;

import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class PanelUserAptitudeQuiz extends JPanel {
	private JButton btnAptitudeNext;
	private JRadioButton rbAptitudeResult2;
	private JRadioButton rbAptitudeResult1;
	private JTextArea taAptitudeQuiz;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	
	UAQ_DbAction uaq_dbAction = new UAQ_DbAction();//UAQ_DbAction.java 

	/**
	 * Create the panel.
	 */
	public PanelUserAptitudeQuiz() {
		setBounds(new Rectangle(180, 10, 500, 420));
		setLayout(null);
		add(getTaAptitudeQuiz());
		add(getBtnAptitudeNext());
		add(getRbAptitudeResult2());
		add(getRbAptitudeResult1());
		UAQ_ShowQuiz();

	}
	private JButton getBtnAptitudeNext() {
		if (btnAptitudeNext == null) {
			btnAptitudeNext = new JButton("다음");
			btnAptitudeNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UAQ_ShowNextQuiz();
					UAQ_SendScore();
					UAQ_ShowQuiz(); //출력
					UAQ_UpdateResultA_Good();
				}
			});
			btnAptitudeNext.setBounds(356, 319, 97, 23);
		}
		return btnAptitudeNext;
	}
	private JRadioButton getRbAptitudeResult2() {
		if (rbAptitudeResult2 == null) {
			rbAptitudeResult2 = new JRadioButton("New radio button");
			buttonGroup.add(rbAptitudeResult2);
			rbAptitudeResult2.setBounds(40, 249, 414, 23);
		}
		return rbAptitudeResult2;
	}
	private JRadioButton getRbAptitudeResult1() {
		if (rbAptitudeResult1 == null) {
			rbAptitudeResult1 = new JRadioButton("New radio button");
			buttonGroup.add(rbAptitudeResult1);
			rbAptitudeResult1.setBounds(40, 203, 414, 23);
		}
		return rbAptitudeResult1;
	}
	private JTextArea getTaAptitudeQuiz() {
		if (taAptitudeQuiz == null) {
			taAptitudeQuiz = new JTextArea();
			taAptitudeQuiz.setBounds(30, 65, 437, 113);
			taAptitudeQuiz.setLineWrap(true); // 줄바꿔주는 기능
		}
		return taAptitudeQuiz;
	}
	
	
	//------------------------------------------------
	//문제 출력		
	private void UAQ_ShowQuiz() { 		
		uaq_dbAction.UAQ_ShowQuiz();
		UAQ_Bean bean = uaq_dbAction.UAQ_ShowQuiz();
		
		taAptitudeQuiz.setText(bean.getAqQuestion());
		rbAptitudeResult1.setText(bean.getAqAnswer1());
		rbAptitudeResult2.setText(bean.getAqAnswer2());
		
	}
	
	//버튼(다음 문제 출력)
	private void UAQ_ShowNextQuiz() {
		uaq_dbAction.UAQ_ShowNextQuiz();
	}
	
	
	//버튼에 따른 총계 점수 합산
	private void UAQ_SendScore() {
		if(rbAptitudeResult1.isSelected()==true) {
			uaq_dbAction.UAQ_SendScore1();
			
		}else if(rbAptitudeResult2.isSelected()==true) {
			uaq_dbAction.UAQ_SendScore2();
		}
	}
	
	private void UAQ_UpdateResultA_Good() {
		uaq_dbAction.UAQ_UpdateResultA_Good();	
	}

	
}//------------------------------------------------------
