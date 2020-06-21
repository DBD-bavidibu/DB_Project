window.onload = function () {
    deletebutton = document.querySelector('#delUser');

    deletebutton.addEventListener('click', async (e) => {
        e.preventDefault();
        var bool = confirm('수락하시겠습니까?');
        if (bool) {
            axios({ method: "get", url: `http://localhost:8080/deleteUser/${localStorage.getItem('user_id')}` })
            localStorage.removeItem('user_id');
            location = "./login";
        }
    })
}