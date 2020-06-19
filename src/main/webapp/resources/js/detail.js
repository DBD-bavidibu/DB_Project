$(document).ready(function () {

    $(".liked").on("click",function(){
        let response;
        try{
            response = axios({method:'get',url:'http://localhost:8080/deleteLike/1/'+store_id});
        }
        catch (e){
            console.log(e);
        }

        $(".liked").addClass('hidden');
        $(".unliked").removeClass('hidden');
    });

    $(".unliked").on("click",function(){
        let response;
        try {
            response = axios({method: 'get', url: 'httpL//localhost:8080/insertLike/1' + store_id});
        }
        catch(e){
            console.log(e);
        }

        $(".liked").removeClass('hidden');
        $(".unliked").addClass('hidden');
    });
});
