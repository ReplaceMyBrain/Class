package com.springlec.addressbook.dao;

import java.util.ArrayList;

import com.springlec.addressbook.dto.ContentDto;

public interface IDao {

	//전체검색
	
	public ArrayList<ContentDto> listDao();
	
	//입력
	public void writeDao(String aName, String aContent, String aAddress, String aEmail, String aRelation);
	
	//삭제
	public void deleteDao(String aId);
	
	//수정
	public void modifyDao(String aId, String aName, String aContent, String aAddress, String aEmail, String aRelation);
	
	//상세보기
	public ContentDto viewDao(String aId);
	
	//검색
	public ArrayList<ContentDto> listQuery(String query, String content);
}
