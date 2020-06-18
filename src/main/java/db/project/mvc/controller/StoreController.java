package db.project.mvc.controller;

import db.project.mvc.domain.StoreVO;
import db.project.mvc.domain.UserVO;
import db.project.mvc.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class StoreController {

    @Autowired
    StoreService storeService;

    @RequestMapping("/")
    private String getHomePage(Model model) throws Exception{
        //가맹점의 전체 리스트를 불러옴
        model.addAttribute("list",storeService.storeList());
        return "home";
    }
    @RequestMapping("/login")
    private String getLoginPage() throws Exception{
        return "login";
    }

    @RequestMapping("/mypage")
    private String getMypage() throws Exception{
        return "mypage";
    }

    @RequestMapping("/register")
    private String getRegisterPage() throws Exception{
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
    @RequestMapping("/detail/{storeID}/{userID}")
    private String storeDetail(@PathVariable(value = "storeID") int storeID,@PathVariable(value="userID") int userID, Model model) throws Exception{
//        상세 정보를 불러올 때 조회수를 증가
        storeService.updateStoreViews(storeID);
        model.addAttribute("detail",storeService.storeDetail(storeID,userID));
        return "detail";  //jsp
    }

    // 집으로부터 특정 거리 이내의 가맹점 리스트
    @RequestMapping(value="/storeList/home/{distance}/user/{userID}")
    @ResponseBody
    private List<StoreVO> storeList_HomeDistance(@PathVariable(value="distance") int distance,@PathVariable(value="userID") int userID, Model model) throws Exception{
        List<StoreVO> stores= storeService.storeList_HomeDistance(distance,userID);
        return stores;
    }

//    집으로부터 특정 거리 이내의 가맹점 중에 특정 카테고리인 가맹점 리스트
    @RequestMapping("/storeList/home/{distance}/user/{userID}/category/{category}")
    @ResponseBody
    private List<StoreVO> storeList_HomeDistanceWithCategory(@PathVariable(value="distance") int distance, @PathVariable(value="userID") int userID, @PathVariable(value="category") String category, Model model) throws Exception{
        List<StoreVO> stores=storeService.storeList_HomeDistanceWithCategory(distance,userID,category);
        return stores;
    }

//    집으로부터 특정 거리 이내의 가맹점 중에 키워드를 포함하는 리스트 (카테고리, 이름)
    @RequestMapping("/storeList/home/{distance}/user/{userID}/keyword/{keyword}")
    @ResponseBody
    private List<StoreVO> storeList_HomeDistanceWithKeyword(@PathVariable(value="distance") int distance, @PathVariable(value="userID") int userID, @PathVariable(value="keyword") String keyword, Model model) throws Exception{
        List<StoreVO> stores = storeService.storeList_HomeDistanceWithKeyword(distance,userID,keyword);
        return stores;
    }

//    지역에 있는 가맹점 리스트
    @RequestMapping("/storeList/city/{city_code}/userID/{userID}")
    @ResponseBody
    private List<StoreVO> storeList_City(@PathVariable(value="city_code") int city_code,@PathVariable(value="userID") int userID, Model model) throws Exception{
        List<StoreVO> stores= storeService.storeList_City(city_code,userID);
        return stores;
    }

    @RequestMapping("/storeList/city/{city_code}/userID/{userID}/category/{category}")
    @ResponseBody
    private List<StoreVO> storeList_CityWithCategory(@PathVariable(value="city_code") int city_code,@PathVariable(value="userID") int userID, @PathVariable(value="category") String category, Model model) throws Exception{
        List<StoreVO> stores=storeService.storeList_CityWithCategory(city_code,userID,category);
        return stores;
    }

    @RequestMapping("/storeList/city/{city_code}/userID/{userID}/keyword/{keyword}")
    @ResponseBody
    private List<StoreVO> storeList_CityWithKeyword(@PathVariable(value="city_code") int city_code,@PathVariable(value="userID") int userID,  @PathVariable(value="keyword") String keyword,Model model) throws Exception {
        List<StoreVO> stores= storeService.storeList_CityWithKeyword(city_code,userID,keyword);
        return stores;
    }


//   유저가 좋아요한 가맹점 리스트
    @RequestMapping("/storeList/UserLike/{userID}}")
    @ResponseBody
    private List<StoreVO> storeList_UserLike(@PathVariable int userID, Model model) throws Exception{
        // 유저가 좋아요한 가맹점 리스트 불러오기
        List<StoreVO> stores = storeService.storeList_UserLike(userID);
        return stores;
    }

//   우리 동네 조회수 높은 순 상점 조회
    @RequestMapping("/TopTenViewsStoreList/{userID}")
    @ResponseBody
    private List<StoreVO> TopTenViewsStoreList(@PathVariable int userID, Model model) throws Exception{
        UserVO user = storeService.getUser(userID);
        List<StoreVO> stores = storeService.TopTenViewsStoreList(user.getLatitude(),user.getLongitude());
        return stores;
    }

//    우리 동네 좋아요 높은 순 상점 조회
    @RequestMapping("/TopTenLikesStoreList/{userID}")
    @ResponseBody
    private List<StoreVO> TopTenLikesStoreList(@PathVariable int userID, Model model) throws Exception{
    UserVO user = storeService.getUser(userID);

    List<StoreVO> stores = storeService.TopTenLikesStoreList(user.getLatitude(),user.getLongitude());
    return stores;
}

//  Like를 DB에 추가
    @RequestMapping(value = "/insertLike/{userID}}/{storeID}")
    @ResponseBody
    private int insertLike(@PathVariable(value="userID") int userID, @PathVariable(value="storeID") int storeID, Model model) throws Exception{
        int result = storeService.insertLike(userID,storeID);
        return result;
    }

//    Like를 DB에서 제거
    @RequestMapping(value ="/deleteLike/{likeID}")
    private void deleteLike(@PathVariable int likeID, Model model) throws Exception{
        storeService.deleteLike(likeID);
    }

    @RequestMapping(value = "/cityList")
    private void getCityList(Model model) throws Exception{
        model.addAttribute("cityList",storeService.getCityList());
    }

    @RequestMapping(value="/categoryList")
    private void getCategoryList(Model model) throws Exception{
        model.addAttribute("categoryList",storeService.getCategoryList());
    }

    @RequestMapping(value="/login/email/{email}/password/{password}")
    private void loginUser(@PathVariable(value="email") String email, @PathVariable(value="password") String password, Model model) throws Exception{
        model.addAttribute("isExisted",storeService.loginUser(email,password));
    }

    @RequestMapping(value = "createUser/name/{userName}/email/{email}/pw/{password}/PH/{phoneNumber}/latitude/{latitude}/longitude/{longitude}")
    private void createUser(@PathVariable(value ="userName") String user_name, @PathVariable(value="email") String email, @PathVariable(value="password") String password,@PathVariable(value = "phoneNumber") String phone_number,@PathVariable(value="latitude") float latitude, @PathVariable(value = "longitude") float longitude, Model model) throws Exception {
        model.addAttribute("isSuccessed",storeService.createUser(user_name,email,password,phone_number,latitude,longitude));
    }

    @RequestMapping(value = "updateUser/{userID}/name/{userName}/email/{email}/pw/{password}/PH/{phoneNumber}/latitude/{latitude}/longitude/{longitude}")
    private void updateUser(@PathVariable(value="userID") int user_id,@PathVariable(value ="userName") String user_name, @PathVariable(value="email") String email, @PathVariable(value="password") String password,@PathVariable(value = "phoneNumber") String phone_number,@PathVariable(value="latitude") float latitude, @PathVariable(value = "longitude") float longitude, Model model) throws Exception {
        model.addAttribute("isSuccessed",storeService.updateUser(user_id,user_name,email,password,phone_number,latitude,longitude));
    }

    @RequestMapping(value = "deleteUser/{userID}/{password}")
    private void deleteuser(@PathVariable(value = "userID") int user_id,@PathVariable(value = "password") String password) throws Exception{
        storeService.deleteUser(user_id,password);
    }
}
