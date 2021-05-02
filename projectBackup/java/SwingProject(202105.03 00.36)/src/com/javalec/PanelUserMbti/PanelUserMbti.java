package com.javalec.PanelUserMbti;

import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.javalec.Datadefine.data_Enviroment_define;
import com.javalec.PanelManageMbtiQuiz.MMQ_Bean;
import com.javalec.PanelManageMbtiQuiz.MMQ_DbAction;
import com.javalec.Datadefine.data_Enviroment_define;

import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Font;

public class PanelUserMbti extends JPanel {
	
	//MBTI결과 삽입을 위한 데이터 환경정의 불러오기
	data_Enviroment_define data_enviroment_define = new data_Enviroment_define();
	   
	private JButton btnMbtiNext;
	private JRadioButton rbMbtiResult1;
	private JRadioButton rbMbtiResult2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblMbtiQuestion;
	
	UM_DbAction um_DbAction = new UM_DbAction();
	public int Numchk = 1;
	int test;
	int EI_Score = 0;
	int SN_Score = 0;
	int TF_Score = 0;
	int JP_Score = 0;
	String MBTI = "";
	String MBTI_Explain = "";
	String MBTI_Name = "";
	
	UM_DbAction dbAction1 = new UM_DbAction();
    ArrayList<UM_Bean> beancount = dbAction1.UM_countMbtiNum();
    int countNum = beancount.get(0).getCountNum();
	
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
			btnMbtiNext.setFont(new Font("LiHei Pro", Font.PLAIN, 13));
			btnMbtiNext.setBounds(50, 320, 300, 23);
			btnMbtiNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					made_EachType(Numchk);	// 버튼 누를 때 마다 방금 풀었던 문제 가중치 입력
//					UM_ClearPanel();
					
					if( rbMbtiResult1.isSelected() == false && rbMbtiResult2.isSelected() == false) {	// 라디오 버튼 클릭 안돼있으면 메세지 띄우기
						JOptionPane.showMessageDialog(null, "답변을 클릭하세요.");
					}
					
					else if (rbMbtiResult1.isSelected() == true || rbMbtiResult2.isSelected() == true) {	// 라디오 버튼 하나라도 클릭 돼있으면 그대로 진행
						if ( countNum > Numchk) {	// 문제 갯수가 반복횟수보다 많을 경우 메세지 띄우고, 모든 창 가리기
							made_EachType(Numchk);	// 버튼 누를 때 마다 방금 풀었던 문제 가중치 입력
							UM_ClearPanel();	
							Numchk++;
								UM_inputAction(Numchk);	// 버튼에 int값을 줘서 문제번호를 설정한다.(몇 번째 문제인지)
							}
							else {
								EndMbtiQuestion();
								made_MBTI();		
								Final_MBTI(data_enviroment_define.userNum);// 마지막 문제 끝나고 Dialog 뜨고나서 최종 MBTI 형성 후 UserNum에 따른 DB에 MBTI 값 업데이트
								showMbti_Explain(MBTI);
								showMbti_Name(MBTI);
								System.out.println(MBTI_Explain);
								JOptionPane.showMessageDialog(null, "당신의 MBTI 유형 결과는 " + MBTI + " 입니다." + "\n"
																+ "\t" + MBTI_Name + "\n"
																+ "설명: " + MBTI_Explain + "입니다.\n" + 
																"자세한 결과는 통계창에서 확인하세요.");
//								boolean rb1 = rbMbtiResult1.isSelected();
//								boolean rb2 = rbMbtiResult2.isSelected();
//								rb1 = false;
//								rb2 = false;
//								rbMbtiResult2.setSelected(false);		
							}
					}
					 
				}
			});
		}
		return btnMbtiNext;
	}
	private JRadioButton getRbMbtiResult1() {
		if (rbMbtiResult1 == null) {
			rbMbtiResult1 = new JRadioButton("New radio button");
			rbMbtiResult1.setFont(new Font("Didot", Font.PLAIN, 14));
			rbMbtiResult1.setBounds(40, 205, 280, 23);
			buttonGroup.add(rbMbtiResult1);
		}
		return rbMbtiResult1;
	}
	private JRadioButton getRbMbtiResult2() {
		if (rbMbtiResult2 == null) {
			rbMbtiResult2 = new JRadioButton("New radio button");
			rbMbtiResult2.setFont(new Font("Didot", Font.PLAIN, 14));
			rbMbtiResult2.setBounds(40, 250, 280, 23);
			buttonGroup.add(rbMbtiResult2);
		}
		return rbMbtiResult2;
	}
	private JLabel getLblMbtiQuestion() { 
		if (lblMbtiQuestion == null) {
			lblMbtiQuestion = new JLabel("New label");
			lblMbtiQuestion.setFont(new Font("Al Bayan", Font.PLAIN, 15));
			lblMbtiQuestion.setVerticalAlignment(SwingConstants.TOP);
			lblMbtiQuestion.setBounds(40, 70, 420, 123);
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
	    
	    UM_DbAction dbAction = new UM_DbAction(Numchk);
	    ArrayList<UM_Bean> beanList = dbAction.selectMbtiQuiz();

	    lblMbtiQuestion.setText(Integer.toString(Numchk)+ ". " + beanList.get(0).getMqQuiestion());
	    rbMbtiResult1.setText(beanList.get(0).getMqAnswer1());
	    rbMbtiResult2.setText(beanList.get(0).getMqAnswer2());
	    
	}
	
	private int EndMbtiQuestion() {	// 마지막 문제 풀고 끝내기 1.
		
	    System.out.println(countNum);
	    	JOptionPane.showMessageDialog(null, "문제가 끝났습니다");
	    	lblMbtiQuestion.setHorizontalAlignment(JLabel.CENTER);
	    	lblMbtiQuestion.setText("수고하셨습니다.");
	    	btnMbtiNext.setVisible(false);
	    	rbMbtiResult1.setVisible(false);
			rbMbtiResult2.setVisible(false);
			
	    return countNum;
	}
	
	
	private void made_EachType( int Numchk) {	//문제 타입에 따라 int 가중치 값 형성하기

		UM_DbAction dbAction = new UM_DbAction(Numchk);
		ArrayList<UM_Bean> beanList = dbAction.selectTypeScore();

		//	문제 타입에 따라 int 가중치 값 형성하기
		
		if (beanList.get(0).getMqType() == "EI") {	//해당 유형일때
			if (rbMbtiResult1.isSelected()) {					// 1번 rb눌렸을때 해당 가중치 들어가기
				EI_Score = (EI_Score + beanList.get(0).getMqScroe1());
			}else if (rbMbtiResult2.isSelected()) {				// 2번 rb눌렸을때 해당 가중치 들어가기
				EI_Score = (EI_Score + beanList.get(0).getM1Score2());
			}
		}
			
		if (beanList.get(0).getMqType() == "SN") {
			if (rbMbtiResult1.isSelected()) {
				SN_Score = (SN_Score + beanList.get(0).getMqScroe1());
			}else if (rbMbtiResult2.isSelected()) {
				SN_Score = (SN_Score + beanList.get(0).getM1Score2());
			}
		}	
		
		if (beanList.get(0).getMqType() == "TF") {
			if (rbMbtiResult1.isSelected()) {
				TF_Score = (TF_Score + beanList.get(0).getMqScroe1());
			}else if (rbMbtiResult2.isSelected()) {
				TF_Score = (TF_Score + beanList.get(0).getM1Score2());
			}
		}	
		
		if (beanList.get(0).getMqType() == "JP") {
			if (rbMbtiResult1.isSelected()) {
				JP_Score = (JP_Score + beanList.get(0).getMqScroe1());
			}else if (rbMbtiResult2.isSelected()) {
				JP_Score = (JP_Score + beanList.get(0).getM1Score2());
			}
		}
		
	}
		
	
		private String made_MBTI() {// String MBTI에 결과값 집어넣기
		
		if (EI_Score >=3 ) { 			// EI_Score가 3보다 크면 E를  String MBTI에 넣는다.
				MBTI =  MBTI + "E";
			}else {
				MBTI = MBTI + "I";
		}
		
		if (SN_Score >=3 ) {			// 중첩해서 추가시키기
				MBTI =  MBTI + "S";
			}else {
				MBTI = MBTI + "N";
		}
		
		if (TF_Score >=3 ) {
			MBTI =  MBTI + "T";
			}else {
				MBTI = MBTI + "F";
		}
		
		if (JP_Score >=3 ) {
				MBTI =  MBTI + "J";
			}else {
				MBTI = MBTI + "P";
		}
		return MBTI;
	}
		
		
//		=========================
		// 생성된 MBTI 유저의 DB에 넣기. 
//		=========================
		private void Final_MBTI(int userNum) {
			
		PreparedStatement ps = null;
	      try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(data_Enviroment_define.url_mysql, data_Enviroment_define.id_mysql, data_Enviroment_define.pw_mysql);
	          @SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();

	          String A = "update user set userResultM = ? ";
	          String B = " where userNum = " + data_enviroment_define.userNum;
	          
	          ps = conn_mysql.prepareStatement(A+B);
	          ps.setString(1, MBTI.trim());
	          ps.executeUpdate();

	          conn_mysql.close();
	          
	      } catch (Exception e){
	          e.printStackTrace();
	          JOptionPane.showMessageDialog(null, "Error발생 !" + "\n"
	        		  							+ "관리자에게 문의하세요!");
	      }            
		
	}
		// 엠비티아이 결과 불러와서 창 띄우기

		private String showMbti_Explain(String MBTI) {
			 UM_DbAction dbAction = new UM_DbAction(MBTI);
			 ArrayList<UM_Bean> beanList = dbAction.selectExplain();
			 
			MBTI_Explain = (beanList.get(0).getMrExName());
			
			return MBTI_Explain;
		}
		private String showMbti_Name(String MBTI) {
			 UM_DbAction dbAction = new UM_DbAction(MBTI);
			 ArrayList<UM_Bean> beanList = dbAction.selectName();
			 
			MBTI_Name = (beanList.get(0).getMrExName());
			
			return MBTI_Name;
		}
	
	
	public void UM_ClearPanel() {
		lblMbtiQuestion.setText("");
		rbMbtiResult1.setText("");
		rbMbtiResult2.setText("");
		rbMbtiResult1.setSelected(false);
		rbMbtiResult2.setSelected(false);
	}
}//======================================================
