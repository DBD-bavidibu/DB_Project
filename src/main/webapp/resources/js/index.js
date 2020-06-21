window.onload = function () {

    let location_rep;

    $(".TopViews").on('click', async  function()
    {
        $("#display-title").html(function(){
            var title = "<h1> 우리동네 Top Views </h1>";
            return title;
        });
        let storeList;
        try{
            storeList = await axios({method:'get',url:`http://localhost:8080/TopTenViewsStoreList/${localStorage.getItem('user_id')}`});
        }
        catch(e) {
            console.log(e);
            return;
        }
        makecard(storeList);
    });

    $(".TopLikes").on('click', async  function()
    {
        console.log("눌리나")
        $("#display-title").html(function(){
            var title = "<h1> 우리동네 Top Likes </h1>";
            return title;
        });
        let storeList;
        try{
            storeList = await axios({method:'get',url:`http://localhost:8080/TopTenLikesStoreList/${localStorage.getItem('user_id')}`});
        }
        catch(e){
            console.log(e);
            return;
        }
        makecard(storeList);
    });

    function checklogin() {
        if (localStorage.getItem('user_id')) {
            return true;
        } else {
            location.href = "/login";
        }
    }
    
    function logout() {
        let logout = document.querySelector('#logout');
        logout.addEventListener('click', () => {
            localStorage.removeItem('user_id');
            location.href = "/login";
        })
    }

    //도시 정보를 입력 받는다.
    async function createSi() {
        let location_si = document.getElementById('location-si');
        try {
            location_rep = await axios({ method: 'get', url: 'http://localhost:8080/cityList' });
        } catch (e) {
            console.log(e);
            return;
        }
        childstring = location_si.innerHTML;
        location_rep.data.forEach(element => {
            childstring = childstring + `<li data-city_code=${element.city_code}>${element.city_name}</li>`;
        });
        location_si.innerHTML = childstring;
        clickandchangelabel();
    }

    //카테고리에 값을 집어 넣는다.
    async function createCategory() {
        let category = document.getElementById('category');
        let category_rep;
        try {
            category_rep = await axios({ method: 'get', url: 'http://localhost:8080/categoryList' });
        } catch (e) {
            console.log(e);
            return;
        }
        childstring = category.innerHTML;
        console.log(category_rep.data.forEach(element => {
            childstring = childstring + "<li>" + element + "</li>";
        }));
        category.innerHTML = childstring;
        clickandchangelabel();
    }

    //클릭시 라벨이 바뀌도록 한다.
    function clickandchangelabel() {
        let dropboxcontainer = document.querySelectorAll('.dropbox-container');
        dropboxcontainer.forEach(element => {
            let title = element.querySelector('h5');
            let lilist = element.querySelectorAll('li');

            lilist.forEach(element => {
                element.addEventListener('click', () => {
                    string = element.innerText;
                    title.innerText = string;
                });
            })
        })

    }

    //1. 카드에 상세페이지 링크를 걸어준다. 2. 좋아요 관리하기
    //만들어진 html 요소인 카드를 입력받는다.
    async function cardlink(cards) {
        cards.forEach(element => {
            let store_id = element.dataset.store_id;
            let user_id = localStorage.getItem('user_id');
            let title = element.querySelector('h1');
            title.addEventListener('click', () => {
                location.href = `/detail/${store_id}/${user_id}`;
            })
            let content = element.querySelector('.about');
            content.addEventListener('click', () => {
                let user_id = localStorage.getItem('user_id');
                location.href = `/detail/${store_id}/${user_id}`;
            })
            let liked = element.querySelector('.liked');
            let notliked = element.querySelector('.notliked');

            //상점 아이디와 내 아이디로 좋아요를 알 수 있는 방법이 필요하다.

            //좋아요 한거 클릭시 해제
            liked.addEventListener('click', async () => {
                let response;
           
                try {
                    response = await axios({ method: 'get', url: `http://localhost:8080/deleteLike/${user_id}/${store_id}` });
                } catch (e) {
                    console.log(e);
                }
                liked.classList.add('hidden');
                notliked.classList.remove('hidden');
            });
            notliked.addEventListener('click', async () => {
                let response;
                try {
                    response = await axios({ method: 'get', url: `http://localhost:8080/insertLike/${user_id}/${store_id}` });
                } catch (e) {
                    console.log(e);
                }
                liked.classList.remove('hidden');
                notliked.classList.add('hidden');
            })
        });
    }

    //서버서 응답 받아서 카드 만드는 함수.
    async function makecard(response) {
        let infocontainer = document.querySelector('.info-container');

        jsondata = response.data;
        innerstring = ""
        for (const element of jsondata) {
            let isLiked;
            try {
                isLiked = await axios({ method: 'get', url: `http://localhost:8080/isLiked/${localStorage.getItem('user_id')}/${element.store_id}` });                
                isLiked = isLiked.data;
            } catch (e) {
                console.log(e);
            }
            
            if(isLiked){
                plusstring = `
                <div class="card" data-store_id="${element.store_id}">
                    <div class="topcover"></div>
                    <h1>${element.store_name}</h1>
                    <div class="about">
                        <h5>카테고리 : ${element.category}</h5>
                        <h5>주소 : ${element.address}</h5>
                    </div>
                    <div class="prefer">
                        <div>
                            <h5>조회수 : ${element.views}</h5>
                            <h5>좋아요 수 : ${element.likes_num}</h5>
                            <h5>거리 : ${element.distance} m </h5>
                        </div>
                        <ion-icon name="thumbs-up-sharp" class="liked"></ion-icon>
                        <ion-icon name="thumbs-up-outline" class="notliked hidden"></ion-icon>
                    </div>
                </div>`;
            }
            else {
                plusstring = `
                <div class="card" data-store_id="${element.store_id}">
                    <div class="topcover"></div>
                    <h1>${element.store_name}</h1>
                    <div class="about">
                        <h5>카테고리 : ${element.category}</h5>
                        <h5>주소 : ${element.address}</h5>
                    </div>
                    <div class="prefer">
                        <div>
                            <h5>조회수 : ${element.views}</h5>
                            <h5>좋아요 수 : ${element.likes_num}</h5>
                            <h5>거리 : ${element.distance} m </h5>
                        </div>
                        <ion-icon name="thumbs-up-sharp" class="liked hidden"></ion-icon>
                        <ion-icon name="thumbs-up-outline" class="notliked"></ion-icon>
                    </div>
                </div>`;
            }
            innerstring = innerstring + plusstring;
        }
        infocontainer.innerHTML = innerstring;

        let cards = infocontainer.querySelectorAll('.card');
        cardlink(cards);
    }

    //처음 로딩되는 카드들
    async function firstloading() {
         $("#display-title").html(function(){
             var title = "<h1> 가맹점 리스트 </h1>";
             return title;
         });
        let response;
        let userid = localStorage.getItem('user_id');
        try {
            response = await axios({ method: 'get', url: `http://localhost:8080/storeList/${userid}`})
        } catch (e) {
            console.log(e);
            return;
        }
        makecard(response);
    }

    function parsinglabel() {
        let standardlabel = document.getElementById('standard-label');
        let distancelabel = document.getElementById('distance-label');
        let locationlabel = document.getElementById('location-si-label');
        let categorylabel = document.getElementById('category-label');
        let keyword = document.getElementById('search-input').value;

        let standardtext = standardlabel.innerText;
        let standard;
        let distancetext = distancelabel.innerText;
        let distance;
        let categorytext = categorylabel.innerText;
        let category;
        let locationtext = locationlabel.innerText;
        let location;

        if (standardtext != "지정 안함" && standardtext != "기준점") {
            standard = standardtext;
        } else {
            standard = null;
        }

        if (categorytext != "지정 안함" && categorytext != "카테고리") {
            category = categorytext;
        } else {
            category = null;
        }

        if (distancetext != "지정 안함" && distancetext != "거리(단위 m)") {
            distance = parseInt(distancetext);
        } else {
            distance = null;
        }


        if (locationtext != "지정 안함" && locationtext != "지역(시)") {
            document.querySelectorAll('ul#location-si > li').forEach(element => {
                if (element.innerText == locationtext) {
                    location = element.dataset.city_code;
                }
            })
        } else {
            location = null;
        }

        return {
            distance,
            standard,
            category,
            location,
            keyword
        };
    }

    async function searchquerying() {
        let locationlabel = document.getElementById('location-si-label');
        let locationtext = locationlabel.innerText;

        let { location, category, distance, standard, keyword } = parsinglabel()
        let myquerystring = "";
        let searchstring ="";
        let userid = localStorage.getItem('user_id');

        if (((standard && distance) && location)) {
            alert("기준점 또는 도시 중에서 하나만 고르세요");
        }

        if (standard) {
            if (standard == "집" && distance) {
                if (category) {
                    category = encodeURIComponent(category);
                    myquerystring = `http://localhost:8080/storeList/home/${distance}/user/${userid}/category/${category}`;
                }
                else if (keyword) {
                    keyword = encodeURIComponent(keyword);
                    myquerystring = `http://localhost:8080/storeList/home/${distance}/user/${userid}/keyword/${keyword}`;
                } else {
                    myquerystring = `http://localhost:8080/storeList/home/${distance}/user/${userid}`;
                }
            }
        } else if (location) {
            if (category) {
                category = encodeURIComponent(category);
                myquerystring = `http://localhost:8080/storeList/city/${location}/userID/${userid}/category/${category}`
            } else if (keyword) {
                keyword = encodeURIComponent(keyword);
                myquerystring = `http://localhost:8080/storeList/city/${location}/userID/${userid}/keyword/${keyword}`
            } else {
                myquerystring = `http://localhost:8080/storeList/city/${location}/userID/${userid}`
            }
        }

        else {
            myquerystring = `http://localhost:8080/storeList/${userid}`;
        }
        
        console.log(myquerystring);
        if (!myquerystring) {
            alert("뭔가 입력이 잘못되었어요.");
        }
        else {
            let response;
            try {
                response = await axios({ method: 'get', url: myquerystring });
            } catch (e) {
                console.log(e);
                return;
            }
            makecard(response);
        }
        $("#display-title").html(function(){
            var title = "<h1>"+searchstring+ "</h1>";
            return title;
        });
    }

    function searchbutton() {
        let button = document.querySelector('.search-button');
        button.addEventListener('click', searchquerying);
    }

    checklogin();
    logout();
    createSi();
    createCategory();
    firstloading();
    searchbutton();

    document.getElementById('go-mypage').addEventListener('click',
        () => {
            location.href = "./mypage";
        })

}