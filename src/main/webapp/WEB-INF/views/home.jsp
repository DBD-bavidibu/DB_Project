<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> <!--jstl 날짜 포맷-->
<%@ taglib prefix="layoutTag" tagdir="/WEB-INF/tags"%>
<layoutTag:layout>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/stylesheets/index.css"  type="text/css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/index.js?ver=1"></script>
        <title>List</title>
	</head>
<body>
<div class="content">
    <div class="content">
        <div class="search-part">
            <h3>가맹점 찾기</h3>
            <div class="textbox">
                <ion-icon name="search-outline"></ion-icon>
                <input id="search-input" type="text" class="search" placeholder="내용을 입력해주세요">
                <button class="search-button">검색</button>
            </div>
            <div class="dropbox-part align-items-">
                <div class="dropbox-container">
                    <div class="dropbox-title">
                        <h5 id="standard-label">기준점</h5>
                        <ion-icon name="chevron-down-outline"></ion-icon>
                    </div>
                    <ul class="dropbox-list" id="standard">
                        <li>지정 안함</li>
                        <li>집</li>
                    </ul>
                </div>
                <div class="dropbox-container">
                    <div class="dropbox-title">
                        <h5 id="distance-label">거리(단위 m)</h5>
                        <ion-icon name="chevron-down-outline"></ion-icon>
                    </div>
                    <ul class="dropbox-list" id="distance">
                        <li>지정 안함</li>
                        <li>100</li>
                        <li>200</li>
                        <li>500</li>
                        <li>1000</li>
                        <li>2000</li>
                        <li>5000</li>
                    </ul>
                </div>
                <div class="dropbox-container">
                    <div class="dropbox-title">
                        <h5 id="location-si-label"> 지역(시)</h5>
                        <ion-icon name="chevron-down-outline"></ion-icon>
                    </div>
                    <ul class="dropbox-list" id="location-si">
                        <li>지정 안함</li>

                    </ul>
                </div>
<%--                <div class="dropbox-container">--%>
<%--                    <div class="dropbox-title">--%>
<%--                        <h5 id="location-gu-label">지역(구)</h5>--%>
<%--                        <ion-icon name="chevron-down-outline"></ion-icon>--%>
<%--                    </div>--%>
<%--                    <ul class="dropbox-list" id="location-gu">--%>
<%--                        <li>지정 안함</li>--%>
<%--                        <li>영통구</li>--%>
<%--                        <li>권선구</li>--%>
<%--                    </ul>--%>
<%--                </div>--%>
                <div class="dropbox-container">
                    <div class="dropbox-title">
                        <h5 id="category-label">카테고리</h5>
                        <ion-icon name="chevron-down-outline"></ion-icon>
                    </div>
                    <ul class="dropbox-list" id="category">
                        <li>지정 안함</li>
                    </ul>
                </div>
            </div>
            <div class="floating">
                <div class="btn btn-dark TopViews">
                    <h5>우리 동네 조회수 Top 10 보기</h5>
                </div>
                <div class="btn btn-dark TopLikes">
                    <h5>우리 동네 좋아요수 Top 10 보기</h5>
                </div>
            </div>

        </div>
        <div class="display-part">
            <h3 id="display-title"></h3>
            <div class="info-container">
                <!-- <div class="card">
                    <img src="img/background.jpg" alt="배경" class="card-img">
                    <h1>에이바우트커피 아주대점</h1>
                    <div class="about">
                        <h5>카테고리 : 카페</h5>
                        <h5>주소 : 경기 수원시 영통구 망포동 570-5</h5>
                    </div>
                    <div class="prefer">
                        <div>
                            <h5>조회수 : 1323</h5>
                            <h5>좋아요수 : 543</h5>
                        </div>
                        <ion-icon name="thumbs-up-sharp" class="liked"></ion-icon>
                        <ion-icon name="thumbs-up-outline" class="notliked hidden"></ion-icon>
                    </div>
                </div> -->
            </div>
            <div class="page-nav">
                <ion-icon name="chevron-back-outline"></ion-icon>
                <a href="#" class="now">1</a>
                <a href="#">2</a>
                <a href="#">3</a>
                <ion-icon name="chevron-forward-outline"></ion-icon>
            </div>
        </div>
    </div>
</div>

    <footer>
        <span>디비디바비디부</span>
    </footer>

    </body>
    </html>

</layoutTag:layout>