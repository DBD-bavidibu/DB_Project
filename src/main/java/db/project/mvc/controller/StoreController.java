package db.project.mvc.controller;

import db.project.mvc.domain.StoreVO;
import db.project.mvc.domain.UserVO;
import db.project.mvc.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class StoreController {

    @Autowired
    StoreService storeService;

    @RequestMapping("/")
    private String getHome(Model model) throws Exception{
        //가맹점의 전체 리스트를 불러옴
        model.addAttribute("list",storeService.storeList());
        return "home";
    }
    @RequestMapping("/login")
    private String getLogin() throws Exception{
        return "login";
    }

    @RequestMapping("/mypage")
    private String getMypage() throws Exception{
        return "mypage";
    }

    @RequestMapping("/register")
    private String getRegister() throws Exception{
        return "register";
    }
    @RequestMapping("/updateUser")
    private String updateUser() throws Exception{
        return "fixeduser";
    }

    @RequestMapping("/searchUser")
    private String searchUser() throws Exception{
        return "searchUser";
    }


//   가맹점의 상세 정보를 불러옴
    @RequestMapping("/detail/{storeID}")
    private String storeDetail(@PathVariable int storeID, Model model) throws Exception{
//        상세 정보를 불러올 때 조회수를 증가
        storeService.updateStoreViews(storeID);
        model.addAttribute("detail",storeService.storeDetail(storeID));
        return "detail";  //jsp
    }

    // 집으로부터 특정 거리 이내의 가맹점 리스트
    @RequestMapping("/storeList/home/{distance}/user/{userID}")
    private void storeList_HomeDistance(@PathVariable(value="distance") int distance,@PathVariable(value="userID") int userID, Model model) throws Exception{
        model.addAttribute("list",storeService.storeList_HomeDistance(distance,userID));
    }

//    집으로부터 특정 거리 이내의 가맹점 중에 특정 카테고리인 가맹점 리스트
    @RequestMapping("/storeList/home/{distance}/user/{userID}/category/{category}")
    private void storeList_HomeDistanceWithCategory(@PathVariable(value="distance") int distance, @PathVariable(value="userID") int userID, @PathVariable(value="category") String category, Model model) throws Exception{
        model.addAttribute("list",storeService.storeList_HomeDistanceWithCategory(distance,userID,category));
    }

//    집으로부터 특정 거리 이내의 가맹점 중에 키워드를 포함하는 리스트 (카테고리, 이름)
    @RequestMapping("/storeList/home/{distance}/user/{userID}/keyword/{keyword}")
    private void storeList_HomeDistanceWithKeyword(@PathVariable(value="distance") int distance, @PathVariable(value="userID") int userID, @PathVariable(value="keyword") String keyword, Model model) throws Exception{
        model.addAttribute("list",storeService.storeList_HomeDistanceWithKeyword(distance,userID,keyword));
    }

//    지역에 있는 가맹점 리스트
    @RequestMapping("/storeList/city/{city_code}/userID/{userID}")
    private void storeList_City(@PathVariable(value="city_code") int city_code,@PathVariable(value="userID") int userID, Model model) throws Exception{
        model.addAttribute("list",storeService.storeList_City(city_code,userID));
    }

    @RequestMapping("/storeList/city/{city_code}/userID/{userID}/category/{category}")
    private void storeList_CityWithCategory(@PathVariable(value="city_code") int city_code,@PathVariable(value="userID") int userID, @PathVariable(value="category") String category, Model model) throws Exception{
        model.addAttribute("list",storeService.storeList_CityWithCategory(city_code,userID,category));
    }

    @RequestMapping("/storeList/city/{city_code}/userID/{userID}/keyword/{keyword}")
    private void storeList_CityWithKeyword(@PathVariable(value="city_code") int city_code,@PathVariable(value="userID") int userID,  @PathVariable(value="keyword") String keyword,Model model) throws Exception {
        model.addAttribute("list",storeService.storeList_CityWithKeyword(city_code,userID,keyword));
    }


//   유저가 좋아요한 가맹점 리스트
    @RequestMapping("/storeList/UserLike/{userID}}")
    private String storeList_UserLike(@PathVariable int userID, Model model) throws Exception{
        // 유저가 좋아요한 가맹점 리스트 불러오기
        model.addAttribute("list",storeService.storeList_UserLike(userID));
        return "storeList_UserLike";
    }

//   우리 동네 조회수 높은 순 상점 조회
    @RequestMapping("/TopTenViewsStoreList/{userID}")
    private void TopTenViewsStoreList(@PathVariable int userID, Model model) throws Exception{
        UserVO user = storeService.getUser(userID);
        model.addAttribute("list",storeService.TopTenViewsStoreList(user.getLatitude(),user.getLongitude()));
    }

//    우리 동네 좋아요 높은 순 상점 조회
    @RequestMapping("/TopTenLikesStoreList/{userID}")
    private void TopTenLikesStoreList(@PathVariable int userID, Model model) throws Exception{
    UserVO user = storeService.getUser(userID);

    model.addAttribute("list",storeService.TopTenLikesStoreList(user.getLatitude(),user.getLongitude()));
}

//  Like를 DB에 추가
    @RequestMapping(value = "/insertLike/{userID}}/{storeID}")
    private void insertLike(@PathVariable(value="userID") int userID, @PathVariable(value="storeID") int storeID, Model model) throws Exception{
        storeService.insertLike(userID,storeID);
    }

//    Like를 DB에서 제거
    @RequestMapping(value ="/deleteLike/{likeID}")
    private void deleteLike(@PathVariable int likeID, Model model) throws Exception{
        storeService.deleteLike(likeID);
    }




}
