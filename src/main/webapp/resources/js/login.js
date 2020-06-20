window.onload = function () {
    document.querySelector('.login-submit').addEventListener('click', async (e) => {
        e.preventDefault();
        let response;
        let form = new FormData(document.querySelector('form'));
        try {
            response = await axios.post('http://localhost:8080/loginUser', form);
        } catch (e) {
            console.log(e);
        }
        console.log(response.data);
        if (response.data.result == "ok") {
            location.href = "/";
            localStorage.setItem('user_id', 1);
        } else {
            alert("로그인 실패!");
        }
    });
}