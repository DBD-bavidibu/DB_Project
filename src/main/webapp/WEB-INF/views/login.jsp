<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> <!--jstl 날짜 포맷-->
<%@ taglib prefix="layoutTag" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/stylesheets/frame.css"  type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/stylesheets/login.css"  type="text/css">
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/login.js"></script>
    <title>Document</title>
</head>

<body>
    <div class="form-container login-container">
        <h1>로그인</h1>
        <form action="/loginUser" class="form-box login-box" method="post">
            <div class="textbox">
                <ion-icon name="person-outline"></ion-icon>
                <input class="input-text" type="text" placeholder="Email address" name="email" value="">
            </div>
            <div class="textbox">
                <ion-icon name="apps-outline"></ion-icon>
                <input class="input-text" type="text" placeholder="Password" name="password" value="">
            </div>

            <input type="submit" class="btn login-submit" value="완료"></button>
            <a href="./register" class="btn" value="Register">회원가입</a>
            <div class="more">
                <a href="./searchUser">아이디/비밀번호 찾기</a>
            </div>
        </form>
    </div>
    <script src="https://unpkg.com/ionicons@5.0.0/dist/ionicons.js"></script>
</body>