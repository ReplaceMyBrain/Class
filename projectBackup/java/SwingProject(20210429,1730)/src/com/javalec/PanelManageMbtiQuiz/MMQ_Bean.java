// 수훈 CRUD 추가 및 화면 불러오기추가 
package com.javalec.PanelManageMbtiQuiz;

public class MMQ_Bean {
   
   //Field
   int mqNum;
   String mqQuestion;
   String mqType;
   String mqAnswer1;
   String mqAnswer2;
   String mqScore1;
   String mqScore2;
   
   //Constructor
   
   public MMQ_Bean() {
      // TODO Auto-generated constructor stub
   }

   public MMQ_Bean(int mqNum, String mqQuestion, String mqAnswer1, String mqAnswer2) {
      super();
      this.mqNum = mqNum;
      this.mqQuestion = mqQuestion;
      this.mqAnswer1 = mqAnswer1;
      this.mqAnswer2 = mqAnswer2;
   }

   
   
   
   public MMQ_Bean(int mqNum, String mqQuestion, String mqType, String mqAnswer1, String mqAnswer2, String mqScore1,
         String mqScore2) {
      super();
      this.mqNum = mqNum;
      this.mqQuestion = mqQuestion;
      this.mqType = mqType;
      this.mqAnswer1 = mqAnswer1;
      this.mqAnswer2 = mqAnswer2;
      this.mqScore1 = mqScore1;
      this.mqScore2 = mqScore2;
   }

   //Method
   
   
   public int getMqNum() {
      return mqNum;
   }

   public void setMqNum(int mqNum) {
      this.mqNum = mqNum;
   }

   public String getMqQuestion() {
      return mqQuestion;
   }

   public void setMqQuestion(String mqQuestion) {
      this.mqQuestion = mqQuestion;
   }

   public String getMqType() {
      return mqType;
   }

   public void setMqType(String mqType) {
      this.mqType = mqType;
   }

   public String getMqAnswer1() {
      return mqAnswer1;
   }

   public void setMqAnswer1(String mqAnswer1) {
      this.mqAnswer1 = mqAnswer1;
   }

   public String getMqAnswer2() {
      return mqAnswer2;
   }

   public void setMqAnswer2(String mqAnswer2) {
      this.mqAnswer2 = mqAnswer2;
   }

   public String getMqScore1() {
      return mqScore1;
   }

   public void setMqScore1(String mqScore1) {
      this.mqScore1 = mqScore1;
   }

   public String getMqScore2() {
      return mqScore2;
   }

   public void setMqScore2(String mqScore2) {
      this.mqScore2 = mqScore2;
   }
   
   
   
   
   
   
   
   

}