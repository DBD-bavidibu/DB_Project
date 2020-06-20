window.onload = function () {
    let reg = document.querySelector('#submit-reg');
    reg.addEventListener('click', async (e) => {
        e.preventDefault();

        let checkflag = true;
        let checkinput = document.querySelectorAll('.input-select');
        checkinput.forEach(element => {
            if (element.checked == false) {
                checkflag = false;
            }
        });
        if (checkflag == false) {
            alert("약관 동의는 필수예요");
            return;
        }

        let textflag = true;
        let textinput = document.querySelectorAll('.input-text');
        textinput.forEach(element => {
            if (!element.value) {
                textflag = false;
            }
        });
        if (textflag == false) {
            alert('모든 입력 값을 입력하세요.');
            return;
        }

        let form = new FormData(document.querySelector('form'));
        let response;
        try {
            response = await axios.post('http://localhost:8080/createUser', form);
        } catch (e) {
            console.error('response error');
            alert("동일한 이름이나 이메일의 회원이 존재합니다.");
            return;
        }

        let result = response.data.result;
        if (result) {
            alert("회원 가입이 완료되었습니다. 로그인 페이지로 이동합니다.")
            location.href = "/login";
        } else {
            alert("오류가 존재합니다.");
        }
    })
}