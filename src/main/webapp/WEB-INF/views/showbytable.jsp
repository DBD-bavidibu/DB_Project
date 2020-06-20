<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> <!--jstl 날짜 포맷-->
<%@ taglib prefix="layoutTag" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/stylesheets/showbytable.css"  type="text/css">
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/zimlist.js"></script>
    <script src="https://unpkg.com/ionicons@5.0.0/dist/ionicons.js"></script>
    <title>Document</title>
</head>

<body>
    <div class="content">
        <h1>찜한 목록</h1>
        <div class="search-part">
            <ion-icon name="search-outline"></ion-icon>
            <input id="search-input" type="text" class="search" placeholder="검색할 가맹점 이름을 입력해주세요">
            <button class="search-button">검색</button>
        </div>
        <div class="my-zim">
            <div class="row title-container">
                <div class="col1 title">No.</div>
                <div class="col2 title">카테고리</div>
                <div class="col3 title">가맹점 이름</div>
                <div class="col4"></div>
            </div>
        </div>
        <div class="page-nav">
            <ion-icon name="chevron-back-outline"></ion-icon>
            <a href="#" class="now">1</a>
            <a href="#">2</a>
            <a href="#">3</a>
            <ion-icon name="chevron-forward-outline"></ion-icon>
        </div>
    </div>
</body>


</html>