package com.springlec.base0801.dao;

import java.util.ArrayList;

import com.springlec.base0801.dto.ContentDto;

public interface IDao {

	//전체검색
	
	public ArrayList<ContentDto> listDao();
	
	//입력
	public void writeDao(String mWriter, String mContent);
	
	//삭제
	public void deleteDao(String mId);
}
