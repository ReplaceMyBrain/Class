package com.jspproject.bbs.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.command.Command;
import com.jspproject.bbs.command.CommentContentCommand;
import com.jspproject.bbs.command.CommentDeleteCommand;
import com.jspproject.bbs.command.CommentModifyCommand;
import com.jspproject.bbs.command.CommentWriteCommand;
import com.jspproject.bbs.command.ContentItemCommand;
import com.jspproject.bbs.command.ContentItemDeleteCommand;
import com.jspproject.bbs.command.ContentNoticeCommand;
import com.jspproject.bbs.command.ContentNoticeDeleteCommand;
import com.jspproject.bbs.command.ContentTipCommand;
import com.jspproject.bbs.command.ContentTipDeleteCommand;
import com.jspproject.bbs.command.DonateCommand;
import com.jspproject.bbs.command.DonateSumCommand;
import com.jspproject.bbs.command.LoadItemsCommand;
import com.jspproject.bbs.command.LoadMyAllCommand;
import com.jspproject.bbs.command.LoadMyItemCommand;
import com.jspproject.bbs.command.LoadMyTipCommand;
import com.jspproject.bbs.command.LoadNoticeCommand;
import com.jspproject.bbs.command.NoticeCommentContentCommand;
import com.jspproject.bbs.command.NoticeCommentDeleteCommand;
import com.jspproject.bbs.command.NoticeCommentModifyCommand;
import com.jspproject.bbs.command.NoticeCommentWriteCommand;
import com.jspproject.bbs.command.SearchingCommand;
import com.jspproject.bbs.command.TipCommentContentCommand;
import com.jspproject.bbs.command.TipCommentDeleteCommand;
import com.jspproject.bbs.command.TipCommentModifyCommand;
import com.jspproject.bbs.command.TipCommentWriteCommand;
import com.jspproject.bbs.command.UserEmailSearchCommand;
import com.jspproject.bbs.command.UserLoginCommand;
import com.jspproject.bbs.command.UserPwdSearchCommand;
import com.jspproject.bbs.command.UserRegisterCommand;


/**
 * Servlet implementation class MainController
 */
@WebServlet("*.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet()");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doPost()");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("actionDo()");
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		String viewPage = null;
		Command command = null;
		
		switch(com) {
		
		/*
		 * ------------------------------------
		 * 김도우
		 * 
		 * 단순 페이지 이동
		 */
		
		//로그인 창으로 이동
		case("/Login.do"): // 실행시 ~~.do사용
			viewPage = "Login.jsp"; // 실행할 jsp파일
		break;
		
		//회원가입 창으로 이동 
		case("/Signup.do"): // 실행시 ~~.do사용
			viewPage = "Signup.jsp"; // 실행할 jsp파일
			break;
		
		//이용약관
		case("/TermsAndConditions.do"): // 실행시 ~~.do사용
			viewPage = "TermsAndConditions.jsp"; // 실행할 jsp파일
		break;
		
		//개인정보 처리방침
		case("/PrivacyPolicy.do"): // 실행시 ~~.do사용
			viewPage = "PrivacyPolicy.jsp"; // 실행할 jsp파일
		break;
		
		//이메일 찾기창으로
		case("/EmailCheckForm.do"): // 실행시 ~~.do사용
			viewPage = "EmailSearch.jsp"; // 실행할 jsp파일
		break;
		
		//비밀번호 찾기창으로
		case("/PwdCheckForm.do"): // 실행시 ~~.do사용
			viewPage = "PwdSearch.jsp"; // 실행할 jsp파일
		break;
		
		//메인으로
		case("/Main.do"): // 실행시 ~~.do사용
			viewPage = "Main.jsp";
		break;
		
		//로그아웃
		case("/Logout.do"): // 실행시 ~~.do사용
			//세션끔
			session.invalidate();
			viewPage = "Login.jsp"; // 실행할 jsp파일
		break;
		
		//네이버로그인시 콜백
		case("/naver.do"): // 실행시 ~~.do사용
			viewPage = "naverCallback.jsp"; // 실행할 jsp파일
		break;
	
		
		/*
		 * 메소드 실행
		 */
		
		//회원가입
		case("/register.do"):
			command = new UserRegisterCommand(); // 커맨드(메소드)적기
			command.execute(request, response, session);
			viewPage = "SignupSuccess.jsp";
			break;
		//로그인 클릭시	
		case("/loginClick.do"):
			command = new UserLoginCommand(); // 커맨드(메소드)적기
			command.execute(request, response, session);
			
			//세션에 이메일값 저장해서 공백이면 로그인 실패처리시킴 사용엔 문제없지만 사실 이부분 피드백이 필요함...
			if(session.getAttribute("email").equals("")) {
				session.invalidate();
				viewPage = "LoginFail.jsp"; //정보 불일치 실패시
			}else if(session.getAttribute("deletedate")==null) {
				viewPage = "Main.jsp"; //성공시		
			}else {
				session.invalidate();
				viewPage = "LoginWithdraw.jsp"; //탈퇴회원	
			}
			break;
		
		//이메일 중복체크
		case("/EmailCheck.do"):
		command = new UserEmailSearchCommand(); // 커맨드(메소드)적기
		command.execute(request, response, session);
		viewPage = "Signup.do";
		break;
		
		//이메일 찾기 버튼 클릭 후
		case("/EmailSearch.do"):
			command = new UserEmailSearchCommand(); // 커맨드(메소드)적기
			command.execute(request, response, session);
			
			if(session.getAttribute("searchEmail").equals("")) {
				session.invalidate();
				viewPage = "EmailSearchFail.jsp"; //실패시
			
			}else if(session.getAttribute("searchDeletedate")==null) {
				viewPage = "EmailSearchSuccess.jsp"; //성공시	
			
			}else {
				viewPage = "EmailSearchWithdraw.jsp"; //탈퇴회원	
			}

			break;
		
		//패스워드 찾기 버튼 클릭 후
		case("/PwdSearch.do"):
			command = new UserPwdSearchCommand(); // 커맨드(메소드)적기
			command.execute(request, response, session);
			
			if(session.getAttribute("searchPwd").equals("")) {
				session.invalidate();
				viewPage = "PwdSearchFail.jsp"; //실패시
			}else if(session.getAttribute("searchDeletedate")==null) {
				viewPage = "PwdSearchSuccess.jsp"; //성공시
			}else {
				session.invalidate();
				viewPage = "PwdSearchWithdraw.jsp"; //탈퇴회원
			}
			
			break;
			
		//기부
		case("/Donation.do"): // 실행시 ~~.do사용
			command = new DonateSumCommand(); // 커맨드(메소드)적기
			command.execute(request, response, session);
			viewPage = "Donation.jsp"; // 실행할 jsp파일
		break;
		
		//기부버튼 클릭시
		case("/DonateClick.do"): // 실행시 ~~.do사용
			command = new DonateCommand(); // 커맨드(메소드)적기
			command.execute(request, response, session);
			viewPage = "DonationSuccess.jsp"; // 실행할 jsp파일
			break;

			//----------------------------------------김도우
	
			/*
			 * ----------------------------- 
			 * 21.05.21 seungyeon Item 상세페이지 
			 * 현재 userEmail 변수 선언해서 진행중
			 *  -> 상세페이지 게시물 삭제하기 list로 돌아가기 변경해야함
			 *   -----------------------------
			 */
			// Item - 상세페이지 불러오기 0517 이승연
			case ("/ContentViewItem.do"): // 실행시 ~~.do사용
				command = new ContentItemCommand(); // 커맨드(메소드)적기
				command.execute(request, response, session);
				viewPage = "ContentViewItem.jsp"; // 실행할 jsp파일
				break;
			// Item - 상세페이지 게시물 삭제하기 0518 이승연
			case ("/ContentViewItemdelete.do"):
				command = new ContentItemDeleteCommand();
				command.execute(request, response, session);
				viewPage = "ContentDeleteView.jsp"; // 실행할 jsp파일
				break;
			// Item - 상세페이지 댓글입력 0518 이승연
			case ("/CommentWriteItem.do"): // 실행시 ~~.do사용
				command = new CommentWriteCommand(); // 커맨드(메소드)적기
				command.execute(request, response, session);
				viewPage = "CommentWriteView.jsp"; // 실행할 jsp파일
				break;
			// Item - 상세페이지 댓글 불러오기 0521 이승연
			case ("/CommentContentItem.do"):
				command = new CommentContentCommand();
				command.execute(request, response, session);
				viewPage = "CommentContentView.jsp"; // 실행할 jsp파일
				break;
			// Item - 상세페이지 댓글 수정하기 0521 이승연
			case ("/CommentModifyItem.do"):
				command = new CommentModifyCommand();
				command.execute(request, response, session);
				viewPage = "CommentModifyView.jsp"; // 실행할 jsp파일
				break;
			// Item - 상세페이지 댓글 삭제하기 0521 이승연
			case ("/CommentDeleteItem.do"):
				command = new CommentDeleteCommand();
				command.execute(request, response, session);
				viewPage = "CommentDeleteView.jsp"; // 실행할 jsp파일
				break;
			/*
			 * ----------------------------- 
			 * 21.05.23 seungyeon tip 상세페이지 
			 * 현재 userEmail 변수 선언해서 진행중
			 *  -> 상세페이지 게시물 삭제하기 list로 돌아가기 변경해야함
			 *   -----------------------------
			 */	
			// tip - 상세페이지 불러오기 0523 이승연
			case ("/ContentViewTip.do"): // 실행시 ~~.do사용
				command = new ContentTipCommand(); // 커맨드(메소드)적기
				command.execute(request, response, session);
				viewPage = "ContentViewTip.jsp"; // 실행할 jsp파일
				break;
			// tip - 상세페이지 게시물 삭제하기 0518 이승연
			case ("/ContentViewTipdelete.do"):
				command = new ContentTipDeleteCommand();
				command.execute(request, response, session);
				viewPage = "ContentDeleteView.jsp"; // 실행할 jsp파일
				break;
			// tip - 상세페이지 댓글입력 0518 이승연
			case ("/TipCommentWrite.do"): // 실행시 ~~.do사용
				command = new TipCommentWriteCommand(); // 커맨드(메소드)적기
				command.execute(request, response, session);
				viewPage = "CommentWriteView.jsp"; // 실행할 jsp파일
				break;
			// tip - 상세페이지 댓글 불러오기 0521 이승연
			case ("/TipCommentContent.do"):
				command = new TipCommentContentCommand();
				command.execute(request, response, session);
				viewPage = "TipCommentContentView.jsp"; // 실행할 jsp파일
				break;
			// tip - 상세페이지 댓글 수정하기 0521 이승연
			case ("/TipCommentModify.do"):
				command = new TipCommentModifyCommand();
				command.execute(request, response, session);
				viewPage = "CommentModifyView.jsp"; // 실행할 jsp파일
				break;
			// tip - 상세페이지 댓글 삭제하기 0521 이승연
			case ("/TipCommentDelete.do"):
				command = new TipCommentDeleteCommand();
				command.execute(request, response, session);
				viewPage = "CommentDeleteView.jsp"; // 실행할 jsp파일
				break;
			/*
			 * ----------------------------- 
			 * 21.05.23 seungyeon notice 상세페이지 
			 * 현재 userEmail 변수 선언해서 진행중
			 *  -> 상세페이지 게시물 삭제하기 list로 돌아가기 변경해야함
			 *   -----------------------------
			 */	
			// notice - 상세페이지 불러오기 0523 이승연
			case ("/ContentViewNotice.do"): // 실행시 ~~.do사용
				command = new ContentNoticeCommand(); // 커맨드(메소드)적기
				command.execute(request, response, session);
				viewPage = "ContentViewNotice.jsp"; // 실행할 jsp파일
				break;
			// notice - 상세페이지 게시물 삭제하기 0518 이승연
			case ("/ContentViewNoticedelete.do"):
				command = new ContentNoticeDeleteCommand();
				command.execute(request, response, session);
				viewPage = "ContentDeleteView.jsp"; // 실행할 jsp파일
				break;
			// notice - 상세페이지 댓글입력 0518 이승연
			case ("/NoticeCommentWrite.do"): // 실행시 ~~.do사용
				command = new NoticeCommentWriteCommand(); // 커맨드(메소드)적기
				command.execute(request, response, session);
				viewPage = "CommentWriteView.jsp"; // 실행할 jsp파일
				break;
			// notice - 상세페이지 댓글 불러오기 0521 이승연
			case ("/NoticeCommentContent.do"):
				command = new NoticeCommentContentCommand();
				command.execute(request, response, session);
				viewPage = "NoticeCommentContentView.jsp"; // 실행할 jsp파일
				break;
			// notice - 상세페이지 댓글 수정하기 0521 이승연
			case ("/NoticeCommentModify.do"):
				command = new NoticeCommentModifyCommand();
				command.execute(request, response, session);
				viewPage = "CommentModifyView.jsp"; // 실행할 jsp파일
				break;
			// notice - 상세페이지 댓글 삭제하기 0521 이승연
			case ("/NoticeCommentDelete.do"):
				command = new NoticeCommentDeleteCommand();
				command.execute(request, response, session);
				viewPage = "CommentDeleteView.jsp"; // 실행할 jsp파일
				break;
				//-----------------------------------------도영
			
			//아이템목록
			case("/list.do"):
				command = new LoadItemsCommand();
				command.execute(request, response, session);
				viewPage = "ListItem.jsp";
				break;
			
			//팁목록	
			case("/list2.do"):
				command = new LoadMyTipCommand();
				command.execute(request, response, session);
				viewPage = "ListTIp.jsp";
				break;
				
			//공지사항목록	
			case("/list3.do"):
				command = new LoadNoticeCommand();
				command.execute(request, response, session);
				viewPage = "ListNotice.jsp";
				break;
			
			//리스트  검색시
			case("/search.do"):
				command = new SearchingCommand();
				command.execute(request, response, session);
				viewPage = "ListItem.jsp";
				break;
				
				
			//마이페이지 자기가 올린 게시물 보이게함
			case("/profile.do"):
				command = new LoadMyAllCommand();
				command.execute(request, response, session);
				viewPage = "Profile.jsp";
				break;
				
			//마이페이지에서 아이템게시물만 보이게	
			case("/profileOnlyTool.do"):
				command = new LoadMyItemCommand();
				command.execute(request, response, session);
				viewPage = "Profile.jsp";
				break;
				
			//마이페이지에서 팁게시물만 보이게	
			case("/profileOnlyIdea.do"):
				command = new LoadMyTipCommand();
				command.execute(request, response, session);
				viewPage = "Profile.jsp";
				break;
				
			//마이페이지에서 편집페이지로 이동	
			case("/editView.do"):
				viewPage = "EditProfile.jsp";
				break;
				
//			case("/edit.do"):
//				command = new EditProfileCommand();
//				command.execute(request, response, session);
//				viewPage = "profile.do";
//				break;
			
				//-------------------------------------도영
		}		

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
}//---------------
