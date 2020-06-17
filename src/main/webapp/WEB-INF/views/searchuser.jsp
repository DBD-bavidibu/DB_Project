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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/stylesheets/frame.css"  type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/stylesheets/searchuser.css"  type="text/css">
    <title>Document</title>
</head>

<body>
    <div class="form-container">
        <h1>아이디 찾기</h1>
        <form action="#" class="form-box" method="post">
            <div class="input-section">
                <div class="textbox">
                    <strong>이름</strong>
                    <input class="input-text" type="text" placeholder="이름">
                </div>
                <div class="textbox">
                    <strong>전화번호</strong>
                    <input class="input-text" type="text" placeholder="전화번호(- 제외 번호 입력)">
                </div>
            </div>
            <input class="btn" type="submit" value="아이디 찾기">
        </form>
    </div>
    <div class="form-container">
        <h1>비밀번호 찾기</h1>
        <form action="#" class="form-box" method="post">
            <div class="input-section">
                <div class="textbox">
                    <strong>이메일 주소</strong>
                    <input class="input-text" type="text" placeholder="이메일 주소">
                </div>
                <div class="textbox">
                    <strong>이름</strong>
                    <input class="input-text" type="text" placeholder="이름">
                </div>
                <div class="textbox">
                    <strong>전화번호</strong>
                    <input class="input-text" type="text" placeholder="전화번호(- 제외 번호 입력)">
                </div>
            </div>
            <input class="btn" type="submit" value="비밀번호 찾기">
        </form>
    </div>
</body>

</html>