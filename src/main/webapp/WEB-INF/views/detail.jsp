<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="layoutTag" tagdir="/WEB-INF/tags"%>
<layoutTag:layout>

 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List</title>
    </head>
      
<body>
<style>
    .content {
        margin : 0 auto;
        width: 500px;
        border: 1px solid black;
        padding : 10px;
    }
    .content h3{
    background-color: rgb(223, 222, 222);
    color: black;
    font-size: 4rem;
    padding-left: 1rem;
    border-radius: 10px;
}
    
</style>
    <div class="content">
        <h3 class = "box" style="margin:15 auto;">가맹점 상세정보</h3> <!--큰 제목-->
        <form action="#" class="form-box login-box" method="post">
          <img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fldb.phinf.naver.net%2F20200114_230%2F1579002346661uOVOA_JPEG%2F1DL6pnp1kveqJ51mpNsmbwqv.jpg" width="400" height="300" alt="지도">
            <div>
                <p style = "font-size : 24px;" >
					<!-- 가게 이름 -->
					<c:out value ="${detail.store_name}"/>
                </p></div>
            <div>
                <a href="https://search.naver.com/search.naver?sm=top_hty&fbm=0&ie=utf8&query=%EC%97%90%EC%9D%B4%EB%B0%94%EC%9A%B0%ED%8A%B8%EC%BB%A4%ED%94%BC+%EC%95%84%EC%A3%BC%EB%8C%80" class="btn" value="Register">길찾기</a>
                <a href="#" class="btn" value="Register">찜하기</a> 
                <a href="#" class="btn" value="Register">좋아요</a> 
                <div class="more">
            </div>
            
            <div>
                <ul>
                    <p style = "font-size : 20px;" >
				                    카테고리 : <c:out value ="${detail.category}"/></br>
				                    주소 : <c:out value ="${detail.address}"/></br>
				                    집에서부터 거리 : </br>
				                    현재 위치에서부터 거리 : </br>

				                    
                    </p>
                </ul>
            </div> 
			
        </form>
    </div>
    <script src="https://unpkg.com/ionicons@5.0.0/dist/ionicons.js"></script>
</body>
</html>
</layoutTag:layout>