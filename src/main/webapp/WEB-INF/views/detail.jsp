<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> <!--jstl 날짜 포맷-->
<%@ taglib prefix="layoutTag" tagdir="/WEB-INF/tags"%>
<layoutTag:layout>

<<<<<<< Updated upstream
    <div class="container">
        <div class="col-xs-12" style="margin:15px auto;">
            <label style="font-size:20px;"><span class="glyphicon glyphicon-list-alt"></span>게시글 상세</label>
        </div>

        <div class="col-xs-12">
            <form action="/insertProc" method="post">
                <dl class="dl-horizontal">
                    <dt>제목</dt>
                    <dd>${detail.subject}</dd>

                    <dt>작성자</dt>
                    <dd>${detail.writer}</dd>

                    <dt>작성날짜</dt>
                    <dd>
                        <fmt:formatDate value="${detail.reg_date}" pattern="yyyy.MM.dd HH:mm:ss"/>
                    </dd>

                    <dt>첨부파일</dt>
                    <dd><a href="/fileDown/${files.bno}">${files.fileOriName}</a></dd>

                    <dt>내용</dt>
                    <dd>${detail.content}</dd>
                </dl>
            </form>
            <div class="btn-group btn-group-sm" role="group" style="float:right;">
                <button type="button" class="btn btn-default" onclick="location.href='/delete/${detail.bno}'">삭제</button>
                <button type="button" class="btn btn-default" onclick="location.href='/update/${detail.bno}'">수정</button>
                <button type="button" class="btn btn-default" onclick="location.href='/list'"> 목록 </button>
            </div>
        </div>

        <!--                     추가                         -->
        <!--  댓글  -->
<%--        <div class="container">--%>
<%--            <label for="content">comment</label>--%>
<%--            <form name="commentInsertForm">--%>
<%--                <div class="input-group">--%>
<%--                    <input type="hidden" name="bno" value="${detail.bno}"/>--%>
<%--                    <input type="text" class="form-control" id="content" name="content" placeholder="내용을 입력하세요.">--%>
<%--                    <span class="input-group-btn">--%>
<%--                    <button class="btn btn-default" type="button" name="commentInsertBtn">등록</button>--%>
<%--               </span>--%>
<%--                </div>--%>
<%--            </form>--%>
<%--        </div>--%>

<%--        <div class="container">--%>
<%--            <div class="commentList"></div>--%>
<%--        </div>--%>
<%--    </div>--%>

    <%@ include file="commentS.jsp" %>
=======

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/stylesheets/detail.css"  type="text/css">
</head>

<body>
    <div class="content">
        <h3 class="title" style="margin:15 auto;">가맹점 상세정보</h3>
        <!--큰 제목-->
        <div class="store-info">
            <div class="img-cover">
                <img src="./img/background.jpg" height="300" alt="지도">
            </div>
            <div class="store-title">
                <p>
                    <!-- 가게 이름 -->
                    <c:out value="${detail.store_name}" />
                </p>
                <a href="https://search.naver.com/search.naver?sm=top_hty&fbm=0&ie=utf8&query=%EC%97%90%EC%9D%B4%EB%B0%94%EC%9A%B0%ED%8A%B8%EC%BB%A4%ED%94%BC+%EC%95%84%EC%A3%BC%EB%8C%80"
                    class="btn" value="Register">길찾기</a>
                <a href="#" class="btn" value="Register">찜하기</a>
                <ion-icon name="thumbs-up-sharp"></ion-icon>
                <ion-icon name="thumbs-up-outline" class="hidden"></ion-icon>
            </div>
            <div class="text-info">
                <p>
                    카테고리 :
                    <c:out value="${detail.category}" /></br>
                    주소 :
                    <c:out value="${detail.address}" /></br>
                    집에서부터 거리 : </br>
                    현재 위치에서부터 거리 : </br>
                </p>
            </div>
        </div>
    </div>
</body>

</html>
>>>>>>> Stashed changes
</layoutTag:layout>