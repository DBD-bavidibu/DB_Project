
$(document).ready(function () {
    let isLiked;
    try {
        isLiked = axios({ method: 'get', url: `http://localhost:8080/isLiked/${localStorage.getItem('user_id')}/`+store_id});
        isLiked = isLiked.data;
    } catch (e) {
        console.log(e);
    }
    console.log(isLiked);
    if(isLiked){
        $(".unliked").addClass("hidden");
    }
    else{
        $(".liked").addClass("hidden");
    }

    $(".liked").on("click",async function(){
        let response;
        try{
            response = await axios({method:'get',url:`http://localhost:8080/deleteLike/${localStorage.getItem('user_id')}/`+store_id});
        }
        catch (e){
            console.log(e);
        }

        $(".liked").addClass('hidden');
        $(".unliked").removeClass('hidden');
    });

    $(".unliked").on("click",async function(){
        let response;
        try {
            response = await axios({method: 'get', url: `http://localhost:8080/insertLike/${localStorage.getItem('user_id')}/` + store_id});
        }
        catch(e){
            console.log(e);
        }

        $(".liked").removeClass('hidden');
        $(".unliked").addClass('hidden');
    });
});
