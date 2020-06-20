<%@ tag language="java" pageEncoding="UTF-8"%>


<script src="${pageContext.request.contextPath}/resources/js/header.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/stylesheets/header.css"  type="text/css">
<header>
        <div class="header-container">
            <a href="./login" class="not-logined hidden">로그인</a>
            <a href="./showbytable" class="logined">찜한 목록 보기</a>
            <a href="#" class="logined" id="logout">로그아웃</a>
            <ion-icon name="person-circle-outline" id="go-mypage" class="logined"></ion-icon>
        </div>
</header>