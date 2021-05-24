package com.jspproject.bbs.dto;

public class DonateDto {
	
	int DONATE_AMOUNT;

	public DonateDto() {
		// TODO Auto-generated constructor stub
	}

	
	public DonateDto(int dONATE_AMOUNT) {
		super();
		DONATE_AMOUNT = dONATE_AMOUNT;
	}


	public int getDONATE_AMOUNT() {
		return DONATE_AMOUNT;
	}

	public void setDONATE_AMOUNT(int dONATE_AMOUNT) {
		DONATE_AMOUNT = dONATE_AMOUNT;
	}

	
	
}
