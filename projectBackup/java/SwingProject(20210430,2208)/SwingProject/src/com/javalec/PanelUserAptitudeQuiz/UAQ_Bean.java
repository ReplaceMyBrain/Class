package com.javalec.PanelUserAptitudeQuiz;

public class UAQ_Bean {
	//---------------------------------------------------------------------
	//Field
	//---------------------------------------------------------------------
	int aqNum;
	String aqQuestion;
	String aqAnswer1;
	String aqAnswer2;
	String aqScore1;
	String aqScore2;
	
	
	
	//---------------------------------------------------------------------
	//Constructor
	//---------------------------------------------------------------------
	// 우클릭 -> source -> generated constructor using field
	
	
	
	public UAQ_Bean(String aqQuestion, String aqAnswer1, String aqAnswer2) {
		super();
		this.aqQuestion = aqQuestion;
		this.aqAnswer1 = aqAnswer1;
		this.aqAnswer2 = aqAnswer2;
		
	}
	



	public UAQ_Bean(int aqNum, String aqQuestion, String aqAnswer1, String aqAnswer2, String aqScore1,
			String aqScore2) {
		super();
		this.aqNum = aqNum;
		this.aqQuestion = aqQuestion;
		this.aqAnswer1 = aqAnswer1;
		this.aqAnswer2 = aqAnswer2;
		this.aqScore1 = aqScore1;
		this.aqScore2 = aqScore2;
	}


	
	//---------------------------------------------------------------------
	//Method
	//---------------------------------------------------------------------
	public int getAqNum() {
		return aqNum;
	}
	public void setAqNum(int aqNum) {
		this.aqNum = aqNum;
	}
	public String getAqQuestion() {
		return aqQuestion;
	}
	public void setAqQuestion(String aqQuestion) {
		this.aqQuestion = aqQuestion;
	}
	public String getAqAnswer1() {
		return aqAnswer1;
	}
	public void setAqAnswer1(String aqAnswer1) {
		this.aqAnswer1 = aqAnswer1;
	}
	public String getAqAnswer2() {
		return aqAnswer2;
	}
	public void setAqAnswer2(String aqAnswer2) {
		this.aqAnswer2 = aqAnswer2;
	}
	public String getAqScore1() {
		return aqScore1;
	}
	public void setAqScore1(String aqScore1) {
		this.aqScore1 = aqScore1;
	}

	public String getAqScore2() {
		return aqScore2;
	}
	public void setAqScore2(String aqScore2) {
		this.aqScore2 = aqScore2;
	}
	
	
	
}
