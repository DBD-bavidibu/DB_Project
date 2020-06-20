window.onload = function () {
	//로그인 관련 헤더 처리
    function headerinfo() {
        let header = document.querySelector('.header-container');
        let logined = checklogin();
        let logincom = header.querySelector('.oklogin');
        let notlogincom = header.querySelectorAll('.notlogin');

        if (logined) {
            logincom.classList.add('hidden');
            notlogincom.forEach(element => {
                element.classList.remove('hidden');
            });
        } else {
            logincom.classList.remove('hidden');
            notlogincom.forEach(element => {
                element.classList.add('hidden');
            });
        }
    }
    
  //로컬스토리지의 id 값 기준으로 로그인을 처리한다.
    function checklogin() {
        if (localStorage.getItem('user_id')) {
            return true;
        } else {
        	location.href="/login";
            return false;
        }
    }

	
    document.getElementById('go-mypage').addEventListener('click',
        () => {
            location.href = "./mypage";
        })
        
    headerinfo();
}