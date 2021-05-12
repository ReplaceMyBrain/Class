package com.jsplec.bbs.dto;

import java.sql.Timestamp;

public class BDto {

		int bID;
		String bName;
		String bTitle;
		String bContent;
		Timestamp bDate;
		
		
		public BDto() {
	
		}
		public BDto(int bID, String bName, String bTitle, String bContent, Timestamp bDate) {
			super();
			this.bID = bID;
			this.bName = bName;
			this.bTitle = bTitle;
			this.bContent = bContent;
			this.bDate = bDate;
		}
		
		
		
		public int getbID() {
			return bID;
		}
		public void setbID(int bID) {
			this.bID = bID;
		}
		public String getbName() {
			return bName;
		}
		public void setbName(String bName) {
			this.bName = bName;
		}
		public String getbTitle() {
			return bTitle;
		}
		public void setbTitle(String bTitle) {
			this.bTitle = bTitle;
		}
		public String getbContent() {
			return bContent;
		}
		public void setbContent(String bContent) {
			this.bContent = bContent;
		}
		public Timestamp getbDate() {
			return bDate;
		}
		public void setbDate(Timestamp bDate) {
			this.bDate = bDate;
		}
		
		
		
}
