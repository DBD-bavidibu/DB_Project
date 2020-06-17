<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> <!--jstl 날짜 포맷-->
<%@ taglib prefix="layoutTag" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/stylesheets/mypage.css"  type="text/css">
    <script src="https://unpkg.com/ionicons@5.0.0/dist/ionicons.js"></script>
    <title>Document</title>
</head>

<body>
    <div class="content">
        <h3 class="box">MyPage</h3>
        <div class="hello">
            <p>안녕하세요, 디비디바비디부님!</p>
            <p>이메일 : fffff@ajou.ac.kr</p>
        </div>
        <div class="user-info-container">
            <div class="control-part box">
                <div class="command">
                    <a href="./updateUser">
                        <ion-icon name="arrow-forward-outline"></ion-icon> 회원 정보 수정
                    </a>
                    <a href="./zimlist">
                        <ion-icon name="arrow-forward-outline"></ion-icon> 찜한 목록 확인
                    </a>
                    <a href="#">
                        <ion-icon name="arrow-forward-outline"></ion-icon> 나의 집 주변 추천
                    </a>
                </div>
                <img src="./img/background.jpg" alt="">
                <h5>(나의 현재 위치)</h5>
            </div>
            <!--user-info-container-->
            <div class="show-part">
                <div class="zim-list box">
                    <h5>최근 찜한 목록</h5>
                    <div class="my-zim">
                        <div class="row title-container">
                            <div class="col1 title">No.</div>
                            <div class="col2 title">가맹점 이름</div>
                        </div>
                        <div class="row">
                            <div class="col1">1</div>
                            <div class="col2">광교 서점</div>
                        </div>
                        <div class="row">
                            <div class="col1">1</div>
                            <div class="col2">광교 서점</div>
                        </div>
                        <div class="row">
                            <div class="col1">1</div>
                            <div class="col2">광교 서점</div>
                        </div>
                        <div class="row">
                            <div class="col1">1</div>
                            <div class="col2">광교 서점</div>
                        </div>
                        <div class="row">
                            <div class="col1">1</div>
                            <div class="col2">광교 서점</div>
                        </div>
                    </div>
                </div>
                <div class="user-info box">
                    <p>
                        <ion-icon name="arrow-forward-outline"></ion-icon> 내 정보
                    </p>
                    <p>전화 번호 : 000-1111-2222</p>
                    <p>집 주소 : 경기도 수원시 영통구 월드컵로 206</p>
                </div>
            </div>
            <!--show-part-->
        </div>
    </div>
</body>

</html>