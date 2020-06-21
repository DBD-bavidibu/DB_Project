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
     <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/stylesheets/fixeduser.css"  type="text/css">
     <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/fixedUser.js"></script>
    <title>Document</title>
</head>

<body>
    <div class="form-container fixed-container">
        <h1>회원정보 수정</h1>
        <form action="#" class="form-box fixed-box" method="post">
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
                    <input class="input-text" type="text" placeholder="위도" name="latitude" id="">
                </div>
                <div class="textbox">
                    <strong>경도</strong>
                    <input class="input-text" type="text" placeholder="경도" name="longitude" id="">
                </div>
            </div>

            <input class="btn" type="submit" value="수정완료" id="submit-fix">
        </form>
    </div>
</body>

</html>