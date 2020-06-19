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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/stylesheets/register.css"  type="text/css">
    <title>Document</title>
</head>

<body>
    <div class="form-container register-container">
        <h1>회원 가입</h1>
        <form action="/createUser" class="form-box register-box" method="post">
            <div class="agree-section">
                <input type="checkbox" name="all-agree">이용 약관에 모두 동의합니다.<br>
                <input type="checkbox" name="service-agree">[필수] 서비스 이용약관 동의<br>
                <input type="checkbox" name="collect-agree">[필수] 개인정보 수집 및 이용 동의<br>
            </div>

            <div class="input-section">
                <div class="textbox">
                    <strong>아이디(이메일 주소)</strong>
                    <input class="input-text" type="text" placeholder="이메일 주소 입력" name="email" id="">
                </div>
                <div class="textbox">
                    <strong>비밀번호</strong>
                    <input class="input-text" type="text" placeholder="6~16자 영문, 숫자" name="password" id="">
                </div>
                <div class="textbox">
                    <strong>이름</strong>
                    <input class="input-text" type="text" placeholder="이름" name="user_name" id="">
                </div>
                <div class="textbox">
                    <strong>전화번호</strong>
                    <input class="input-text" type="text" placeholder="전화 번호" name="phone_number" id="">
                </div>
                <div class="textbox">
                    <strong>위도</strong>
                    <input class="input-text" type="text" placeholder="위도 입력" name="latitude" id="">
                </div>
                <div class="textbox">
                    <strong>경도</strong>
                    <input class="input-text" type="text" placeholder="경도 입력" name="longitude" id="">
                </div>
            </div>

            <input class="btn" type="submit" value="가입 완료">
        </form>
    </div>
</body>

</html>