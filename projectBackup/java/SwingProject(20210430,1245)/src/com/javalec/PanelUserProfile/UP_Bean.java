package com.javalec.PanelUserProfile;

import com.javalec.Datadefine.data_Enviroment_define;

public class UP_Bean {
	
	//-----------------
	//Field 
	//-----------------
		int userNum;
		String userName;
		String userId;
		String userPw;
		String userEmail;
		String userResultM;
		String userResultA;

	//-----------------
	//Construction
	//-----------------
		
		
		public UP_Bean(String userName, String userId, String userEmail, String userResultM,
				String userResultA) {
			super();
			this.userName = userName;
			this.userId = userId;
			this.userEmail = userEmail;
			this.userResultM = userResultM;
			this.userResultA = userResultA;
		}

		
	//-----------------
	//Method
	//-----------------	
		
		public int getUserNum() {
			return userNum;
		}
		public void setUserNum(int userNum) {
			this.userNum = userNum;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getUserPw() {
			return userPw;
		}
		public void setUserPw(String userPw) {
			this.userPw = userPw;
		}
		public String getUserEmail() {
			return userEmail;
		}
		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
		public String getUserResultM() {
			return userResultM;
		}
		public void setUserResultM(String userResultM) {
			this.userResultM = userResultM;
		}
		public String getUserResultA() {
			return userResultA;
		}
		public void setUserResultA(String userResultA) {
			this.userResultA = userResultA;
		}
		
			
	
	
	
}//////////////