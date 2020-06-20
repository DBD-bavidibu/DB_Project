window.onload = function () {
    async function loadlike() {
        let myzim = document.querySelector(".my-zim");
        let innerstring = myzim.innerHTML;
        let userid = localStorage.getItem('user_id');
        console.log(userid);
        let response;
        try {
            response = await axios({ method: "get", url: `http://localhost:8080/storeList/UserLike/${userid}` });
        } catch (e) {
            console.log(e);
        }
        let jsondata = response.data;
        let index = 1;
        jsondata.forEach(element => {
            let appendstring = `<div class="row now${index}">
            <div class="col1">${index}</div>
            <div class="col2">${element.category}</div>
            <div class="col3">${element.store_name}</div>
            <div class="col4" data-store_id = ${element.store_id} data-index = ${index}>
                <button>삭제</button>
            </div>
            </div>`;
            index = index + 1;
            innerstring = innerstring + appendstring;
        });
        document.querySelector('.my-zim').innerHTML = innerstring;

        butdelete();
    }


    async function butdelete() {
        let delbutton = document.querySelectorAll(`.col4`);
        let myzim = document.querySelector('.my-zim');

        delbutton.forEach(element => {
            // console.log(element);
            let button = element.querySelector('button');
            if (button) {
                let index = element.dataset.index;
                let store_id = element.dataset.store_id;
                let userid = localStorage.getItem('user_id');
                button.addEventListener('click', async () => {
                    let response;
                    try {
                        response = await axios({ method: "get", url: `http://localhost:8080/deleteLike/${userid}/${store_id}` });
                    } catch (e) {
                        console.log(e);
                    }
                    myzim.removeChild(myzim.querySelector(`.now${index}`));
                    index = index + 1;
                });
            }
        });
    }

    loadlike();
}