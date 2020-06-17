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
    <title>Document</title>
</head>

<body>
    <div class="form-container fixed-container">
        <h1>회원정보 수정</h1>
        <form action="#" class="form-box fixed-box" method="post">
            <div class="input-section">
                <div class="textbox">
                    <strong>아이디(이메일 주소)</strong>
                    <input class="input-text" type="text" placeholder="이메일 주소 입력" name="" id="">
                </div>
                <div class="textbox">
                    <strong>비밀번호</strong>
                    <input class="input-text" type="text" placeholder="6~16자 영문, 숫자" name="" id="">
                </div>
                <div class="textbox">
                    <strong>비밀번호 재확인</strong>
                    <input class="input-text" type="text" placeholder="비밀번호 재입력" name="" id="">
                </div>
                <div class="textbox">
                    <strong>이름</strong>
                    <input class="input-text" type="text" placeholder="이름" name="" id="">
                </div>
                <div class="textbox">
                    <strong>전화번호</strong>
                    <input class="input-text" type="text" placeholder="전화 번호" name="" id="">
                </div>
                <div class="textbox">
                    <strong>집 주소</strong>
                    <input class="input-text" type="text" placeholder="집 주소 검색" name="" id="">
                </div>
                <div class="textbox">
                    <strong>전화번호</strong>
                    <input class="input-text" type="text" placeholder="-제외 번호 입력" name="" id="">
                </div>
            </div>

            <input class="btn" type="submit" value="수정완료">
        </form>
    </div>
</body>

</html>