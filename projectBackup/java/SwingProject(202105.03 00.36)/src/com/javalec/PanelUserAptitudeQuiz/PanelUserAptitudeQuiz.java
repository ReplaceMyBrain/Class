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
import java.util.DoubleSummaryStatistics;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;

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
		uaq_dbAction.UAQ_CountQuiz();
		UAQ_ShowQuiz();

	}
	private JButton getBtnAptitudeNext() {
		if (btnAptitudeNext == null) {
			btnAptitudeNext = new JButton("다음");
			btnAptitudeNext.setFont(new Font("LiHei Pro", Font.PLAIN, 13));
			btnAptitudeNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UAQ_ShowQuiz();	
					UAQ_ShowNextQuiz();			
					UAQ_SendScore();
//					UAQ_UpdateResultA_SendDbAction();

				}
			});
			btnAptitudeNext.setBounds(50, 320, 300, 23);
		}
		return btnAptitudeNext;
	}
	private JRadioButton getRbAptitudeResult2() {
		if (rbAptitudeResult2 == null) {
			rbAptitudeResult2 = new JRadioButton("New radio button");
			rbAptitudeResult2.setFont(new Font("Didot", Font.PLAIN, 14));
			buttonGroup.add(rbAptitudeResult2);
			rbAptitudeResult2.setBounds(40, 250, 414, 23);
		}
		return rbAptitudeResult2;
	}
	private JRadioButton getRbAptitudeResult1() {
		if (rbAptitudeResult1 == null) {
			rbAptitudeResult1 = new JRadioButton("New radio button");
			rbAptitudeResult1.setSelected(true);
			rbAptitudeResult1.setFont(new Font("Didot", Font.PLAIN, 14));
			buttonGroup.add(rbAptitudeResult1);
			rbAptitudeResult1.setBounds(40, 205, 414, 23);
		}
		return rbAptitudeResult1;
	}
	private JTextArea getTaAptitudeQuiz() {
		if (taAptitudeQuiz == null) {
			taAptitudeQuiz = new JTextArea();
			taAptitudeQuiz.setFont(new Font("Al Bayan", Font.PLAIN, 15));
			taAptitudeQuiz.setForeground(new Color(0, 0, 0));
			taAptitudeQuiz.setBackground(new Color(238, 238, 238));
			taAptitudeQuiz.setBounds(40, 70, 435, 107);
			taAptitudeQuiz.setLineWrap(true); // 줄바꿔주는 기능
		}
		return taAptitudeQuiz;
	}
	
	
	//------------------------------------------------
	//문제 출력		
	public void UAQ_ShowQuiz() { 				
		if(uaq_dbAction.countQuizMax>uaq_dbAction.countQuizNum) {
			uaq_dbAction.countQuizNum++;
			uaq_dbAction.UAQ_ShowQuiz();
			UAQ_Bean bean = uaq_dbAction.UAQ_ShowQuiz();
			taAptitudeQuiz.setText(uaq_dbAction.countQuizNum + ". " + bean.getAqQuestion());
			rbAptitudeResult1.setText(bean.getAqAnswer1());
			rbAptitudeResult2.setText(bean.getAqAnswer2());
			
			
		}else {
			uaq_dbAction.countQuizNum++;
		}
		
		
	}
	
	//총계점수(sumScore)에 따른 userResultA DB 업데이트
	public void UAQ_ShowNextQuiz() { 
		if((uaq_dbAction.countQuizNum>uaq_dbAction.countQuizMax) && uaq_dbAction.sumScore>=7) {	//총계점수(sumScore)에 따른 userResultA DB 업데이트
			uaq_dbAction.UAQ_UpdateResultA_Good();
			uaq_dbAction.UAQ_UpdateResultA_SendDB();
			EndAptitudeQuiz();
		}else if((uaq_dbAction.countQuizNum>uaq_dbAction.countQuizMax) && uaq_dbAction.sumScore<7) {//총계점수(sumScore)에 따른 userResultA DB 업데이트
			uaq_dbAction.UAQ_UpdateResultA_Bad();
			uaq_dbAction.UAQ_UpdateResultA_SendDB();
			EndAptitudeQuiz();
		}
		
		
	}
	
	
	//버튼에 따른 총계 점수 합산
	private void UAQ_SendScore() {
		if(rbAptitudeResult1.isSelected()==true) {
			uaq_dbAction.UAQ_SendScore1();
			
		}else if(rbAptitudeResult2.isSelected()==true) {
			uaq_dbAction.UAQ_SendScore2();
		}
	}
	
	//모든 문제를 다 푼 후 메세지 출력
	private void EndAptitudeQuiz() {
		taAptitudeQuiz.setText("수고하셨습니다.");
		rbAptitudeResult1.setVisible(false);
		rbAptitudeResult2.setVisible(false);
		btnAptitudeNext.setVisible(false);
		JOptionPane.showMessageDialog(null, "문제가 끝났습니다");
		JOptionPane.showMessageDialog(null, "당신의 적성검사 결과는 "+ uaq_dbAction.userResultA + "입니다." + "\n" + "자세한 결과는 통계창에서 확인하세요.");
		
	}

	
}//------------------------------------------------------
