package com.javalec.PanelUserStatistic;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import com.javalec.Datadefine.data_Enviroment_define;

import java.awt.Font;

public class PanelUserStatistic extends JPanel { 	//Dowoo 2021.04.30 완료
	private JLabel lbMbti;
	private JLabel lbMbtiCount;
	private JLabel lbAptitudeCount;
	private JLabel lbAptitude;
	private JLabel lbAptitudeRank2;
	private JLabel lbAptitudeRank1;
	private JLabel lbFullCount1;
	private JLabel lbFullCount2;

	/**
	 * Create the panel.
	 */
	public PanelUserStatistic() {
		setBounds(new Rectangle(180, 10, 500, 420));
		setLayout(null);
		add(getLbMbti());
		add(getLbMbtiCount());
		add(getLbAptitudeCount());
		add(getLbAptitude());
		add(getLbAptitudeRank2());
		add(getLbAptitudeRank1());
		add(getLbFullCount1());
		add(getLbFullCount2());
		US_Infor();
		US_MbtiCount();
		US_AptitudeCount();
		US_FullCount();
		US_Aptitude1Top();
		US_Aptitude2Top();
		
	}
	private JLabel getLbMbti() {
		if (lbMbti == null) {
			lbMbti = new JLabel("");
			lbMbti.setFont(new Font("굴림", Font.PLAIN, 13));
			lbMbti.setBounds(48, 50, 416, 30);
		}
		return lbMbti;
	}
	private JLabel getLbMbtiCount() {
		if (lbMbtiCount == null) {
			lbMbtiCount = new JLabel("");
			lbMbtiCount.setFont(new Font("굴림", Font.PLAIN, 13));
			lbMbtiCount.setBounds(48, 90, 416, 30);
		}
		return lbMbtiCount;
	}
	private JLabel getLbAptitudeCount() {
		if (lbAptitudeCount == null) {
			lbAptitudeCount = new JLabel("");
			lbAptitudeCount.setFont(new Font("굴림", Font.PLAIN, 13));
			lbAptitudeCount.setBounds(48, 210, 416, 30);
		}
		return lbAptitudeCount;
	}
	private JLabel getLbAptitude() {
		if (lbAptitude == null) {
			lbAptitude = new JLabel("");
			lbAptitude.setFont(new Font("굴림", Font.PLAIN, 13));
			lbAptitude.setBounds(48, 170, 416, 30);
		}
		return lbAptitude;
	}
	private JLabel getLbAptitudeRank2() {
		if (lbAptitudeRank2 == null) {
			lbAptitudeRank2 = new JLabel("");
			lbAptitudeRank2.setFont(new Font("굴림", Font.PLAIN, 13));
			lbAptitudeRank2.setBounds(48, 330, 416, 30);
		}
		return lbAptitudeRank2;
	}
	private JLabel getLbAptitudeRank1() {
		if (lbAptitudeRank1 == null) {
			lbAptitudeRank1 = new JLabel("");
			lbAptitudeRank1.setFont(new Font("굴림", Font.PLAIN, 13));
			lbAptitudeRank1.setBounds(48, 290, 416, 30);
		}
		return lbAptitudeRank1;
	}
	private JLabel getLbFullCount1() {
		if (lbFullCount1 == null) {
			lbFullCount1 = new JLabel("");
			lbFullCount1.setFont(new Font("굴림", Font.PLAIN, 13));
			lbFullCount1.setBounds(250, 90, 174, 30);
		}
		return lbFullCount1;
	}
	private JLabel getLbFullCount2() {
		if (lbFullCount2 == null) {
			lbFullCount2 = new JLabel("");
			lbFullCount2.setFont(new Font("굴림", Font.PLAIN, 13));
			lbFullCount2.setBounds(250, 210, 174, 30);
		}
		return lbFullCount2;
	}

	//MBTI와 적성 보여주는 기능. 
	private void US_Infor() {
		
		US_DbAction us_DbAction =new US_DbAction(data_Enviroment_define.userNum);
		US_Bean bean = us_DbAction.US_Infor();
		
		lbMbti.setText(bean.getUserName() + "님의 MBTI는 " + bean.getUserResultM() + "입니다." );
		lbAptitude.setText(bean.getUserName() + "님의 적성은 " + bean.getUserResultA() + "입니다.");
	}
	//본인과 같은 MBTI 명수
	private void US_MbtiCount() {
		US_DbAction us_DbAction =new US_DbAction(data_Enviroment_define.userNum);
		US_Bean bean = us_DbAction.US_MbtiCount();
		
		lbMbtiCount.setText("나와 같은 사람은 " + bean.getCount() + "명 입니다.");
	}
	//본인과 같은 적성 명수
	private void US_AptitudeCount() {
		US_DbAction us_DbAction =new US_DbAction(data_Enviroment_define.userNum);
		US_Bean bean = us_DbAction.US_AptitudeCount();
		
		lbAptitudeCount.setText("나와 같은 사람은 " + bean.getCount() + "명 입니다.");
	}
	//총 인원수
	private void US_FullCount() {
		US_DbAction us_DbAction =new US_DbAction(data_Enviroment_define.userNum);
		US_Bean bean = us_DbAction.US_FullCount();
		
		lbFullCount1.setText("(총" + bean.getCount() + "명)");
		lbFullCount2.setText("(총" + bean.getCount() + "명)");
	}
	
	//적성이 천직인 사람의 탑 MBTI
	private void US_Aptitude1Top() {

		US_DbAction us_DbAction =new US_DbAction();
		US_Bean bean = us_DbAction.US_Aptitude1Top();
		
		lbAptitudeRank1.setText("적성검사 결과 \"천직\"인 사람중 가장 많은 MBTI는 " + bean.getUserResultMA() + "이고 총 " + bean.getCount() + "입니다");
		
	}

	
	//적성이 한번더 생각하기인 사람의 탑 MBTI
	private void US_Aptitude2Top() {

		US_DbAction us_DbAction =new US_DbAction();
		US_Bean bean = us_DbAction.US_Aptitude2Top();
		
		lbAptitudeRank1.setText("적성검사 결과 \"한번더 의심하기\"인 사람중 가장 많은 MBTI는 " + bean.getUserResultMA() + "이고 총 " + bean.getCount() + "입니다");
		
	}

}/////////////////
