package db.project.mvc.controller;

import db.project.mvc.domain.CityVO;
import db.project.mvc.domain.StoreVO;
import db.project.mvc.domain.UserVO;
import db.project.mvc.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

@Controller
public class StoreController {

    @Autowired
    StoreService storeService;

    @RequestMapping("/")
    private String getHomePage(Model model) throws Exception{
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

//  처음 시작될 때 이거 부릅니다.
    @CrossOrigin(origins="http://localhost")
    @RequestMapping(value="/storeList")
    @ResponseBody
    private List<StoreVO> storeList_default() throws Exception{
    	List<StoreVO> stores = storeService.storeList();
//        System.out.println(stores);
    	return stores;
    }
    
//   가맹점의 상세 정보를 불러옴
    @CrossOrigin(origins="http://localhost")
    @RequestMapping("/detail/{storeID}/{userID}")
    private String storeDetail(@PathVariable(value = "storeID") int storeID,@PathVariable(value="userID") int userID, Model model) throws Exception{
//        상세 정보를 불러올 때 조회수를 증가
        storeService.updateStoreViews(storeID);
        model.addAttribute("detail",storeService.storeDetail(storeID,userID));
        return "detail";  //jsp
    }

    // 집으로부터 특정 거리 이내의 가맹점 리스트
    @CrossOrigin(origins="http://localhost")
    @RequestMapping(value="/storeList/home/{distance}/user/{userID}")
    @ResponseBody
    private List<StoreVO> storeList_HomeDistance(@PathVariable(value="distance") int distance,@PathVariable(value="userID") int userID, Model model) throws Exception{
        List<StoreVO> stores= storeService.storeList_HomeDistance(distance,userID);
        return stores;
    }

//    집으로부터 특정 거리 이내의 가맹점 중에 특정 카테고리인 가맹점 리스트
    @CrossOrigin(origins="http://localhost")
    @RequestMapping("/storeList/home/{distance}/user/{userID}/category/{category}")
    @ResponseBody
    private List<StoreVO> storeList_HomeDistanceWithCategory(@PathVariable(value="distance") int distance, @PathVariable(value="userID") int userID, @PathVariable(value="category") String category, Model model) throws Exception{
        List<StoreVO> stores=storeService.storeList_HomeDistanceWithCategory(distance,userID,category);
        return stores;
    }

//    집으로부터 특정 거리 이내의 가맹점 중에 키워드를 포함하는 리스트 (카테고리, 이름)
    @CrossOrigin(origins="http://localhost")
    @RequestMapping("/storeList/home/{distance}/user/{userID}/keyword/{keyword}")
    @ResponseBody
    private List<StoreVO> storeList_HomeDistanceWithKeyword(@PathVariable(value="distance") int distance, @PathVariable(value="userID") int userID, @PathVariable(value="keyword") String keyword, Model model) throws Exception{
        List<StoreVO> stores = storeService.storeList_HomeDistanceWithKeyword(distance,userID,keyword);
        return stores;
    }

//    지역에 있는 가맹점 리스트
    @CrossOrigin(origins="http://localhost")
    @RequestMapping("/storeList/city/{city_code}/userID/{userID}")
    @ResponseBody
    private List<StoreVO> storeList_City(@PathVariable(value="city_code") int city_code,@PathVariable(value="userID") int userID, Model model) throws Exception{
        List<StoreVO> stores= storeService.storeList_City(city_code,userID);
        return stores;
    }

    @CrossOrigin(origins="http://localhost")
    @RequestMapping("/storeList/city/{city_code}/userID/{userID}/category/{category}")
    @ResponseBody
    private List<StoreVO> storeList_CityWithCategory(@PathVariable(value="city_code") int city_code,@PathVariable(value="userID") int userID, @PathVariable(value="category") String category, Model model) throws Exception{
        List<StoreVO> stores=storeService.storeList_CityWithCategory(city_code,userID,category);
        return stores;
    }

    @CrossOrigin(origins="http://localhost")
    @RequestMapping("/storeList/city/{city_code}/userID/{userID}/keyword/{keyword}")
    @ResponseBody
    private List<StoreVO> storeList_CityWithKeyword(@PathVariable(value="city_code") int city_code,@PathVariable(value="userID") int userID,  @PathVariable(value="keyword") String keyword,Model model) throws Exception {
        List<StoreVO> stores= storeService.storeList_CityWithKeyword(city_code,userID,keyword);
        return stores;
    }


//   유저가 좋아요한 가맹점 리스트
    @CrossOrigin(origins="http://localhost")
    @RequestMapping("/storeList/UserLike/{userID}}")
    @ResponseBody
    private List<StoreVO> storeList_UserLike(@PathVariable int userID, Model model) throws Exception{
        // 유저가 좋아요한 가맹점 리스트 불러오기
        List<StoreVO> stores = storeService.storeList_UserLike(userID);
        return stores;
    }

//   우리 동네 조회수 높은 순 상점 조회
    @CrossOrigin(origins="http://localhost")
    @RequestMapping("/TopTenViewsStoreList/{userID}")
    @ResponseBody
    private List<StoreVO> TopTenViewsStoreList(@PathVariable int userID, Model model) throws Exception{
        List<StoreVO> stores = storeService.TopTenViewsStoreList(userID);
        return stores;
    }

//    우리 동네 좋아요 높은 순 상점 조회
    @CrossOrigin(origins="http://localhost")
    @RequestMapping("/TopTenLikesStoreList/{userID}")
    @ResponseBody
    private List<StoreVO> TopTenLikesStoreList(@PathVariable(value="userID") int userID, Model model) throws Exception{
    List<StoreVO> stores = storeService.TopTenLikesStoreList(userID);
    return stores;
}

    @CrossOrigin(origins="http://localhost")
    @RequestMapping("/isLiked/{userID}/{storeID}")
    @ResponseBody
    private boolean isLiked(@PathVariable(value="userID") int userID, @PathVariable(value="storeID") int storeID) throws Exception{
        boolean isLiked= storeService.isLiked(userID,storeID);
        return isLiked;
    }


//  Like를 DB에 추가
    @CrossOrigin(origins="http://localhost")
    @RequestMapping(value = "/insertLike/{userID}/{storeID}")
    @ResponseBody
    private int insertLike(@PathVariable(value="userID") int userID, @PathVariable(value="storeID") int storeID, Model model) throws Exception{
        int result = storeService.insertLike(userID,storeID);
        return result;
    }

//    Like를 DB에서 제거
    @CrossOrigin(origins="http://localhost")
    @RequestMapping(value ="/deleteLike/{userID}/{storeID}")
    @ResponseBody
    private int deleteLike(@PathVariable(value="userID") int userID, @PathVariable(value="storeID") int storeID, Model model) throws Exception{
        int result = storeService.deleteLike(userID,storeID);
        return result;
    }

    // 도시 정보 ajax
    @CrossOrigin(origins="http://localhost")
    @RequestMapping(value = "/cityList")
    @ResponseBody
    private List<CityVO> getCityList(Model model) throws Exception{
        List<CityVO> list = storeService.getCityList();
        return list;
    }

    // 음식점 정보 ajax
    @CrossOrigin(origins="http://localhost")
    @RequestMapping(value="/categoryList")
    @ResponseBody
    private List<String> getCategoryList(Model model) throws Exception{
        List<String> categoryList= storeService.getCategoryList();
        return categoryList;
    }
    
    //로그인
    @CrossOrigin(origins="http://localhost")
    @RequestMapping(value="/loginUser")
    private String loginUser(HttpServletRequest httpServletRequest, HttpServletResponse response, Model model) throws Exception{
        String password = httpServletRequest.getParameter("password");
        String email = httpServletRequest.getParameter("email");
        System.out.println(password);

        boolean isSuccess = storeService.loginUser(email,password);
        System.out.println(isSuccess);
        return "redirect:/";
    }
    
    //회원 가입
    @CrossOrigin(origins="http://localhost")
    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    private String createUser(HttpServletRequest httpServletRequest, HttpServletResponse response) throws Exception {
    	System.out.println("오냐..");
    	String user_name = httpServletRequest.getParameter("user_name");
    	float latitude = Float.valueOf(httpServletRequest.getParameter("latitude"));
    	float longitude =  Float.valueOf(httpServletRequest.getParameter("longitude"));
    	String password = httpServletRequest.getParameter("password");
    	String email = httpServletRequest.getParameter("email");
    	String phone_number = httpServletRequest.getParameter("phone_number");
        System.out.println(phone_number);
        boolean isSuccess = storeService.createUser(user_name,email,password,phone_number,latitude,longitude);
        String myjson;
        if(isSuccess) {
        	myjson = "{ \"result\" : \"ok\"}";
        }else {
        	myjson = "{ \"result\" : \"no\"}";
        }
        
//        response.getWriter().print(myjson);

        return "redirect:/login";
    }

    //개인적인 테스트 부분입니다. 그냥 무시하세요.
    @CrossOrigin(origins="http://localhost")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    private void test(HttpServletRequest httpServletRequest, HttpServletResponse response) throws Exception {
    	String user_name = httpServletRequest.getParameter("user_name");
    	String password = httpServletRequest.getParameter("password");
    	boolean isSuccess;
    	if(user_name.equals("구교현")) {
    		isSuccess = true;
    	}else {
    		isSuccess = false;
    	}

    	String myjson;
        if(isSuccess) {
        	myjson = "{ \"result\" : true}";
        }else {
        	myjson = "{ \"result\" : false}";
        }
    	response.getWriter().print(myjson);
    }
    
    //회원 정보 수정
    @RequestMapping(value = "updateUser/{userID}/name/{userName}/email/{email}/pw/{password}/PH/{phoneNumber}/latitude/{latitude}/longitude/{longitude}")
    private void updateUser(@PathVariable(value="userID") int user_id,@PathVariable(value ="userName") String user_name, @PathVariable(value="email") String email, @PathVariable(value="password") String password,@PathVariable(value = "phoneNumber") String phone_number,@PathVariable(value="latitude") float latitude, @PathVariable(value = "longitude") float longitude, Model model) throws Exception {
        model.addAttribute("isSuccessed",storeService.updateUser(user_id,user_name,email,password,phone_number,latitude,longitude));
    }

    //회원 탈퇴
    @RequestMapping(value = "deleteUser/{userID}/{password}")
    private void deleteuser(@PathVariable(value = "userID") int user_id,@PathVariable(value = "password") String password) throws Exception{
        storeService.deleteUser(user_id,password);
    }
}