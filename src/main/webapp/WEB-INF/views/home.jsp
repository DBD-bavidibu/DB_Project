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
        <title>List</title>
	</head>
<body>
<div class="content">
        <div class="search-part">
            <h3>가맹점 찾기</h3>
            <div class="textbox">
                <ion-icon name="search-outline"></ion-icon>
                <input id="search-input" type="text" class="search" placeholder="내용을 입력해주세요">
                <button class="search-button">검색</button>
            </div>
            <div class="dropbox-part">
                <div class="dropbox-container">
                    <div class="dropbox-title">
                        <h5 id="standard-label">기준점</h5>
                        <ion-icon name="chevron-down-outline"></ion-icon>
                    </div>
                    <ul class="dropbox-list" id="standard">
                        <li>현재 위치</li>
                        <li>집</li>
                    </ul>
                </div>
                <div class="dropbox-container">
                    <div class="dropbox-title">
                        <h5 id="distance-label">거리</h5>
                        <ion-icon name="chevron-down-outline"></ion-icon>
                    </div>
                    <ul class="dropbox-list" id="distance">
                        <li>100m</li>
                        <li>200m</li>
                    </ul>
                </div>
                <div class="dropbox-container">
                    <div class="dropbox-title">
                        <h5 id="location-si-label"> 지역(시)</h5>
                        <ion-icon name="chevron-down-outline"></ion-icon>
                    </div>
                    <ul class="dropbox-list" id="location-si">
                        <li>수원시</li>
                        <li>화성시</li>
                        <li>오산시</li>
                        <li>암튼 데이터</li>
                    </ul>
                </div>
                <div class="dropbox-container">
                    <div class="dropbox-title">
                        <h5 id="location-gu-label">지역(구)</h5>
                        <ion-icon name="chevron-down-outline"></ion-icon>
                    </div>
                    <ul class="dropbox-list" id="location-gu">
                        <li>영통구</li>
                        <li>권선구</li>
                    </ul>
                </div>
                <div class="dropbox-container">
                    <div class="dropbox-title">
                        <h5 id="category-label">카테고리</h5>
                        <ion-icon name="chevron-down-outline"></ion-icon>
                    </div>
                    <ul class="dropbox-list" id="category">
                        <li>외식</li>
                        <li>한식</li>
                        <li>치킨</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="display-part">
            <h3 id="display-title">조회수 Top 4</h3>
            <div class="info-container">
                <div class="card">
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
                        <ion-icon name="thumbs-up-sharp"></ion-icon>
                        <ion-icon name="thumbs-up-outline" class="hidden"></ion-icon>
                    </div>
                </div>
                <div class="card">
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
                        <ion-icon name="thumbs-up-sharp"></ion-icon>
                        <ion-icon name="thumbs-up-outline" class="hidden"></ion-icon>
                    </div>
                </div>
                <div class="card">
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
                        <ion-icon name="thumbs-up-sharp"></ion-icon>
                        <ion-icon name="thumbs-up-outline" class="hidden"></ion-icon>
                    </div>
                </div>
                <div class="card">
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
                        <ion-icon name="thumbs-up-sharp"></ion-icon>
                        <ion-icon name="thumbs-up-outline" class="hidden"></ion-icon>
                    </div>
                </div>
                <div class="card">
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
                        <ion-icon name="thumbs-up-sharp"></ion-icon>
                        <ion-icon name="thumbs-up-outline" class="hidden"></ion-icon>
                    </div>
                </div>

<<<<<<< Updated upstream
        <div class="col-xs-12">
            <table class="table table-hover">
                <tr>
                    <th>No</th>
                    <th>Subject</th>
                    <th>Writer</th>
                    <th>Date</th>
                </tr>
                <c:forEach var="l" items="${list}">
                    <tr onclick="location.href='/detail/${l.store_id}'">
                        <td>${l.store_name}</td>
                        <td>${l.category}</td>
                        <td>${l.views}</td>
                        <td>
<%--                            <fmt:formatDate value="${l.reg_date}" pattern="yyyy.MM.dd HH:mm:ss"/>--%>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>


=======
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
    <footer>
        <span>디비디바비디부</span>
    </footer>
    
>>>>>>> Stashed changes
    </body>
    </html>

</layoutTag:layout>