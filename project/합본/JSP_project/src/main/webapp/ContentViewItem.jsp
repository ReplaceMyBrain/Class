<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/Header.jsp"%>
<!-- 이거쓰는거 잊지마 라이브러리 실행 안된다.. -->
<!DOCTYPE html>
<html>
<script type="text/javascript">
	
	/* 로그인된 아이디 세션값받기 */
	/* 
	 	-----------------------------
	 	21.05.21 seungyeon
	 	****현재 myEmail 변수 선언해서 진행중
	 	-> 추후 세션으로 받아와서 바꿀 것.
	 	수정하기와 목록으로가는것 수정해야함
	 	이름에 하이퍼링크준것도 수정해야함
	 	-----------------------------
	*/
	<%-- var myEmail = '<%=(String) session.getAttribute("email")%>'; --%>
	<%-- var Admin = '<%=(String) session.getAttribute("admin")%>'; --%>
	/* var myEmail = sessionStorage.getItem("email");*/
	/* var Admin = sessionStorage.getItem("admin");*/
	var myEmail = 'aaa@naver.com';
	var Admin = '0';
	console.log("myEmail=" + myEmail);

	/* 게시물 삭제 */
	function deleteContent() {
		var retVal = confirm("게시물 삭제하시겠습니까?");
		if (retVal == true) {
			var i_num = document.getElementById("deletecontent").value;
			var url = "ContentViewItemdelete.do?i_num=" + i_num;
			open(url,"deleteContent","roolbar=no, location=no,menubar=no,scrollbars=no,resizable=no,width=450,height=230");
		} else {
			return false;
		}
	}
	/* 버튼 숨기기 */
	function buttonHide() {
		
		if (Admin == "1") {
			return false;
		}
		
		const table = document.getElementById('comlist');
		var mdibtns = document.getElementsByName("modifycomment");
		var delbtns = document.getElementsByName("deletecomment");
		
		for (var i = 0; i < mdibtns.length; i++) {
			var str = table.rows[i + 1].cells[0].innerHTML;
			if (myEmail != str || myEmail.value == 'null') {
				mdibtns[i].style.display = "none";
				delbtns[i].style.display = "none";
				
			}
			console.log("btn:" + i + ";value:" + mdibtns[i].value+"작성자;" + str);
		}

		var modifyContent = document.getElementById("modifyContent");
		var deletecontent = document.getElementById("deletecontent");
		var template = '${content_view.user_email}';
		if (myEmail != template || myEmail == 'null') {
			modifyContent.style.display = "none";
			deletecontent.style.display = "none";
		}
		
		var writecomment = document.getElementById("writecomment");
		var commenttext = document.getElementById("commenttext");
		if (myEmail == 'null') {
			writecomment.style.display = "none";
			commenttext.style.display = "none";
		}
	}

	/* 댓글 */
	function writeComment() {
		var form = document.commentWrite;
		if (form.ic_content.value == "") {
			alert("comment를 입력하세요!");
			form.ic_content.focus();
			return false;
		}
		
		var retVal = confirm("댓글 입력하시겠습니까?");
		var i_num = document.getElementById("i_num").value;
		var ic_content = document.getElementById("commenttext").value;
		if (retVal == true) {
			var url = "CommentWriteItem.do?ic_content=" + ic_content + "&i_num=" + i_num;
			open(url,"writeComment","roolbar=no, location=no,menubar=no,scrollbars=no,resizable=no,width=450,height=230");
		} else {
			return false;
		}
	}
	/* 댓글 수정 */
	function modifyComment(ic_num) {
		var url = "CommentContentItem.do?ic_num=" + ic_num;
		open(url,"ModifyComment","roolbar=no, location=no,menubar=no,scrollbars=no,resizable=no,width=450,height=230");
	}
	/* 댓글 삭제 */
	function deleteComment(ic_num) {
		var retVal = confirm("댓글 삭제하시겠습니까?");
		if (retVal == true) {
			var url = "CommentDeleteItem.do?ic_num=" + ic_num;
			open(url,"deleteComment","roolbar=no, location=no,menubar=no,scrollbars=no,resizable=no,width=450,height=230");
		} else {
			return false;
		}
	}
</script>
<style>
a:link {
	color: black;
	text-decoration: none;
}

table, th, td {
	border: 1px solid #bcbcbc;
	width: 1200px;
	height: 45px;
	margin-left: auto;
	margin-right: auto;
}

h1 {
	text-align: center;
}

div {
	text-align: center;
	align-items: center;
}

.layer {
	position: absolute;
	top: 50%;
	left: 50%;
	width: 100px;
	height: 100px;
	background: #f00;
	margin: -50px 0 0 -50px;
}

.footer_info {
	display: flex;
	align-items: center;
	justify-content: center;
	flex-direction: column;
}
</style>
<head>
<meta charset="UTF-8">
<title>상세페이지</title>
<!-- <link rel="stylesheet" href="ContentviewItem.css"> -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
	<!-- 상세페이지 -->
	<div class="container">
		<br /> <br />
		<form action="modify.do" method="post">
			<h3 class="m-2">
				<b>${content_view.i_title}</b>
			</h3>
			<br />

			<h6 class="m-2">
				By <a href="content_view.do?user_email=${content_view.user_email }">${content_view.name }</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				Date <i>${content_view.iw_regist}</i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				Views <i>${content_view.i_hits}</i>
			</h6>
			<div>
				<input type="submit" value="수정" id="modifyContent" class="btn btn-primary pull-right">&nbsp;&nbsp;&nbsp;
				<a href="list.do" class="btn btn-primary pull-right">목록</a>&nbsp;&nbsp;&nbsp;
				<button type="button" onclick="deleteContent()" id="deletecontent" value="${content_view.i_num}" class="btn btn-primary pull-right">삭제</button>
			</div>
			<hr />
			<div class="form-group">
				<div class="m-2">${content_view.i_content}</div>
			</div>
		</form>
		<hr />

		<!-- 댓글 박스 -->
		<div class="row bootstrap snippets">
			<div class="col-md-12">
				<div class="comment-wrapper">
					<div class="panel panel-info">
						<div class="panel-heading m-2">
							<b>Comment</b>
						</div>
						<div class="panel-body">
							<!-- 댓글입력 -->
							<form name="commentWrite">
								<input type="hidden" name="i_num" id="i_num" value="${content_view.i_num}">
								<input type="text" name="ic_content" id="commenttext" class="form-control" placeholder="write a comment...">
								<br>
								<input type="button" onclick="writeComment()" id="writecomment" value="댓글입력" class="btn btn-primary pull-right">
							</form>
							<hr />
							<div class="media-body">
								<!-- 댓글 리스트 시작-->
								<table id="comlist" border="1">
									<tr>
										<th>이름</th>
										<th>내용</th>
										<th>날짜</th>
										<th></th>
									</tr>
									<c:forEach items="${comment_view}" var="comment">
										<!-- 리스트커멘드에서 정해줌 아이템즈는  -->
										<tr>
											<td hidden="">${comment.user_email}</td>
											<td>${comment.name}</td>
											<td>${comment.ic_content}</td>
											<td>${comment.ic_regist}</td>
											<td>
												<button type="button" onclick="modifyComment(this.id);" name="modifycomment" id="${comment.ic_num}"
													value="${comment.ic_num}" class="btn btn-primary pull-right">수정하기</button>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<button type="button" onclick="deleteComment(this.id);" name="deletecomment" id="${comment.ic_num}"
													value="${comment.ic_num}" class="btn btn-primary pull-right">삭제하기</button>
										</tr>
									</c:forEach>
									<tr>
										<td colspan="4" align="center">
											<c:forEach items="${pageList }" var="page">
												<a href="ContentViewItem.do?i_num=${content_view.i_num}&page=${page }">${page }</a>
											</c:forEach></td>
									</tr>
								</table>
								<script type="text/javascript">buttonHide();</script>
								<!-- 다출력후 숨기기 위해서!! -->
								<br />
							</div>
							<!-- 댓글 리스트 끝-->
						</div>
					</div>
				</div>

			</div>
		</div>
		<!-- 댓글 박스 끝 -->
	</div>
</body>
</html>
<%@include file="/Footer.jsp"%>
