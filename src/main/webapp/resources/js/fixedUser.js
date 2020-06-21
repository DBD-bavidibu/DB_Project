window.onload = function () {
    let reg = document.querySelector("#submit-fix");
    reg.addEventListener('click', async (e) => {
        e.preventDefault();

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
        form.append('user_id', localStorage.getItem('user_id'));
        let response;
        try {
            response = await axios.post('http://localhost:8080/UpdateUser', form);
        } catch (e) {
            console.error('response error');
            return;
        }

        let result = response.data.result;
        if (result) {
            alert("정보 수정이 완료되었습니다.");
            location.href="/mypage";
        } else {
            alert("오류가 존재합니다.");
        }
    })
}