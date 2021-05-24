package com.jspproject.bbs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jspproject.bbs.dto.ContentNoticedto;

public class ContentNoticedao {
	DataSource dataSource;

	public ContentNoticedao() {
		try {
			Context context1 = new InitialContext();
			dataSource = (DataSource) context1.lookup("java:comp/env/jdbc/jsp_project");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 게시물 클릭시 상세페이지
	public ContentNoticedto contentView(String strn_num) {
		ContentNoticedto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		try {
//				System.out.println(dataSource1);
			connection = dataSource.getConnection();

			String query = "select * from notice n, write_notice w, user u where u.email = w.user_email  and n.n_num = w.notice_n_num and n.n_num = ?";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(strn_num));
			resultset = preparedStatement.executeQuery();

//				System.out.println(resultset);
			if (resultset.next()) {
				int n_num = resultset.getInt("n_num");
				String name = resultset.getString("NAME");
				String user_email = resultset.getString("USER_EMAIL");
				String n_title = resultset.getString("n_title");
				String n_content = resultset.getString("n_content");
				int n_hits = resultset.getInt("n_hits");
				Date nw_regist = resultset.getDate("nw_regist");
				// 이미지 출력을 위함
				dto = new ContentNoticedto(n_num, name, user_email, n_title, n_content, n_hits, nw_regist);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 정리 다시 거꾸로 정리해주는것
				if (resultset != null)
					resultset.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		return dto;
	}

	// 게시물 삭제!!
	public String contentDelete(String strn_num) {
		String result = "false";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "update write_notice set nw_delete = now() where notice_n_num = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(strn_num));
			preparedStatement.executeUpdate();
			result = "true";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 정리 다시 거꾸로 정리해주는것
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
				result = "false";
			}
		}
		return result;
	}

	// 게시물 리뷰 작성
	public String commentWrite(String notice_n_num, String user_email, String tc_content) {
		String result = "false";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();

			String query = "insert into comment_notice (user_email, notice_n_num, nc_content, nc_regist) values (?,?,?,now())";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, user_email);
			preparedStatement.setString(2, notice_n_num);
			preparedStatement.setString(3, tc_content);

			preparedStatement.executeUpdate();
			result = "true";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 정리 다시 거꾸로 정리해주는것
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
				result = "false";
			}
		}
		return result;
	}

	// 게시물 리뷰 Lsit
	public ArrayList<ContentNoticedto> commentSelect(String n_num, int start, int pageCnt) {
		ArrayList<ContentNoticedto> dtos = new ArrayList<ContentNoticedto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		// page는 1부터 시작하지만, offset은 0부터 시작.(0~9(10개), 10~19(10개)와같이 offset을 설정해야 하기 때문)
		int offset = start - 1;
		try {
//			System.out.println(dataSource1);
			connection = dataSource.getConnection();
			// LIMIT {OFFSET}, {LIMIT} -> 쿼리결과중 offset번째부터 limit개의 튜플을 출력
			String query = "select * from comment_notice n, user u where  notice_n_num = ? and u.email = n.user_email and nc_delete is null ORDER BY nc_num DESC LIMIT ?, ?";

			preparedStatement = connection.prepareStatement(query);
			// 0을 나누면 에러가 발생하므로 예외처
			preparedStatement.setInt(1, Integer.parseInt(n_num));
			if (offset == 0) {
				preparedStatement.setInt(2, offset);
			} else {
				preparedStatement.setInt(2, offset * pageCnt);
			}
			preparedStatement.setInt(3, pageCnt);
			resultset = preparedStatement.executeQuery();

//				System.out.println(resultset);
			while (resultset.next()) {
				int nc_num = resultset.getInt("nc_num");
				String name = resultset.getString("name");
				String user_email = resultset.getString("user_email");
				String nc_content = resultset.getString("nc_content");
				Date nc_regist = resultset.getDate("nc_regist");

				ContentNoticedto dto = new ContentNoticedto(nc_num, name, user_email, nc_content, nc_regist);
				dtos.add(dto);
//					System.out.println("cContent="+cContent);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 정리 다시 거꾸로 정리해주는것
				if (resultset != null)
					resultset.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		return dtos;
	}

	// list에서 사용하는 릴레이션이 가진 튜플의 총 갯수를 리턴한다.
	public int selectCommnetCnt(String notice_n_num) {
		int count = 0;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;

		try {
			connection = dataSource.getConnection();

			String query = "select count(*) from comment_notice where notice_n_num = ? and nc_delete is null";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(notice_n_num));
			resultset = preparedStatement.executeQuery();

			if (resultset.next()) {
				count = resultset.getInt(1);
				System.out.println("list-count success");
			}

		} catch (Exception e) {
			System.out.println("list-count fail");
			e.printStackTrace();
		} finally {
			try {
				// 정리 다시 거꾸로 정리해주는것
				if (resultset != null)
					resultset.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
				System.out.println("< rs, psmt, conn close success>");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("< rs, psmt, conn close Fail>");

			}
		}
		return count;
	}

	// 상세페이지 리뷰 수정하기 클릭시 상세페이지
	public ContentNoticedto commentContent(String nc_Num) {
		ContentNoticedto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;

		try {
			connection = dataSource.getConnection();

			String query = "SELECT * FROM comment_notice where nc_num = ?";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(nc_Num));
			resultset = preparedStatement.executeQuery();

			if (resultset.next()) {
				int nc_num = resultset.getInt("nc_num");
				String nc_content = resultset.getString("nc_content");
				dto = new ContentNoticedto(nc_num, nc_content);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 정리 다시 거꾸로 정리해주는것
				if (resultset != null)
					resultset.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		return dto;
	}

	// 게시물 리뷰 수정
	public String commentModiey(String nc_num, String nc_content) {
		String result = "false";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "update comment_notice set nc_content = ?, nc_edit = now() where nc_num = ?";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, nc_content);
			preparedStatement.setInt(2, Integer.parseInt(nc_num));
			preparedStatement.executeUpdate();
			result = "true";
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(result);
		} finally {
			try {
				// 정리 다시 거꾸로 정리해주는것
				if (connection != null)
					connection.close();
				if (preparedStatement != null)
					preparedStatement.close();
				System.out.println("< rs, psmt, conn close success>");
			} catch (Exception e) {
				e.printStackTrace();
				result = "false";
				System.out.println("< rs, psmt, conn close Fail>");
			}
		}
		return result;
	}

	// 게시물 리뷰 삭제
	public String commentDelete(String nc_num) {

		String result = "false";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();

			String query = "update comment_notice set nc_delete = now() where nc_num = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(nc_num));
			preparedStatement.executeUpdate();
			result = "true";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 정리 다시 거꾸로 정리해주는것
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
				result = "false";
			}
		}
		return result;
	}
}
