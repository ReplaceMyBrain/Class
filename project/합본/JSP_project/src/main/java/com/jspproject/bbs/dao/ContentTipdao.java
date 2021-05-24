package com.jspproject.bbs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jspproject.bbs.dto.ContentTipdto;

public class ContentTipdao {
	DataSource dataSource;

	public ContentTipdao() {
		try {
			Context context1 = new InitialContext();
			dataSource = (DataSource) context1.lookup("java:comp/env/jdbc/jsp_project");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 게시물 클릭시 상세페이지
	public ContentTipdto contentView(String strt_num) {
		ContentTipdto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		try {
//				System.out.println(dataSource1);
			connection = dataSource.getConnection();

			String query = "select * from tip t, write_tip w, user u where u.email = w.user_email  and t.t_num = w.tip_t_num and t.t_num = ?";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(strt_num));
			resultset = preparedStatement.executeQuery();

//				System.out.println(resultset);
			if (resultset.next()) {
				int t_num = resultset.getInt("t_num");
				String name = resultset.getString("NAME");
				String user_email = resultset.getString("USER_EMAIL");
				String t_title = resultset.getString("T_TITLE");
				String t_content = resultset.getString("T_CONTENT");
				String t_image = resultset.getString("T_IMAGE");
				// 굳이 이미지 가져올 필요가 없어
				String t_category = resultset.getString("T_CATEGORY");
				int t_hits = resultset.getInt("t_hits");
//				int pLike = resultset.getInt("pLike");// Like수없나요?
				Date tw_regist = resultset.getDate("tw_regist");
				// 이미지 출력을 위함
				t_content = imgcontent(t_content, t_image);
//				System.out.println(pContent);
				dto = new ContentTipdto(t_num, name, user_email, t_title, t_content, t_image, t_category, t_hits, tw_regist);

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

	// 이미치 출력을 위함
	public String imgcontent(String content, String img) {

		String[] arr_img = img.split(",");
		// ,으로 구분하기, 필요없을거같아
		// 오늘 소개할 물건은\n<img_id=macBook.png>\n<img_id=macBook2.png>\n입니다.
		// 오늘 소개할
		// 물건은\n<img_src=\"http://localhost:8080/DeveloperWeb/img/macBook.png>\n<img_id=macBook2.png\">\n입니다.
		// 변경해준다
		content = content.replaceAll("img_id=", "img src=\"http://localhost:8080/DeveloperWeb/img/");
		content = content.replaceAll("png", "png\"");
		content = content.replaceAll("jpg", "jpg\"");

		return content;
	}

	// 게시물 삭제!!
	public String contentDelete(String strt_num) {
		String result = "false";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "update write_tip set tw_delete = now() where tip_t_num = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(strt_num));
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
	public String commentWrite(String tip_t_num, String user_email, String tc_content) {
		String result = "false";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();

			String query = "insert into comment_tip (user_email, tip_t_num, tc_content, tc_regist) values (?,?,?,now())";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, user_email);
			preparedStatement.setString(2, tip_t_num);
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
	public ArrayList<ContentTipdto> commentSelect(String t_num, int start, int pageCnt) {
		ArrayList<ContentTipdto> dtos = new ArrayList<ContentTipdto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		// page는 1부터 시작하지만, offset은 0부터 시작.(0~9(10개), 10~19(10개)와같이 offset을 설정해야 하기 때문)
		int offset = start - 1;
		try {
//			System.out.println(dataSource1);
			connection = dataSource.getConnection();
			// LIMIT {OFFSET}, {LIMIT} -> 쿼리결과중 offset번째부터 limit개의 튜플을 출력
			String query = "select * from comment_tip t, user u where  tip_t_num = ? and u.email = t.user_email and tc_delete is null ORDER BY tc_num DESC LIMIT ?, ?";

			preparedStatement = connection.prepareStatement(query);
			// 0을 나누면 에러가 발생하므로 예외처
			preparedStatement.setInt(1, Integer.parseInt(t_num));
			if (offset == 0) {
				preparedStatement.setInt(2, offset);
			} else {
				preparedStatement.setInt(2, offset * pageCnt);
			}
			preparedStatement.setInt(3, pageCnt);
			resultset = preparedStatement.executeQuery();

//				System.out.println(resultset);
			while (resultset.next()) {
				int tc_num = resultset.getInt("tc_num");
				String name = resultset.getString("name");
				String user_email = resultset.getString("user_email");
				String tc_content = resultset.getString("tc_content");
				Date tc_regist = resultset.getDate("tc_regist");

				ContentTipdto dto = new ContentTipdto(tc_num, name, user_email, tc_content, tc_regist);
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
	public int selectCommnetCnt(String tip_t_num) {
		int count = 0;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;

		try {
			connection = dataSource.getConnection();

			String query = "select count(*) from comment_tip where tip_t_num = ? and tc_delete is null";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(tip_t_num));
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
	public ContentTipdto commentContent(String tc_Num) {
		ContentTipdto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;

		try {
			connection = dataSource.getConnection();

			String query = "SELECT * FROM comment_tip where tc_num = ?";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(tc_Num));
			resultset = preparedStatement.executeQuery();

			if (resultset.next()) {
				int tc_num = resultset.getInt("tc_num");
				String tc_content = resultset.getString("tc_content");
				dto = new ContentTipdto(tc_num, tc_content);

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
	public String commentModiey(String tc_num, String tc_content) {
		String result = "false";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "update comment_tip set tc_content = ?, tc_edit = now() where tc_num = ?";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, tc_content);
			preparedStatement.setInt(2, Integer.parseInt(tc_num));
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
	public String commentDelete(String tc_num) {

		String result = "false";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();

			String query = "update comment_tip set tc_delete = now() where tc_num = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(tc_num));
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
