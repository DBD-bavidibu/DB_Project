package db.project.mvc.mapper;

import db.project.mvc.domain.StoreVO;
import db.project.mvc.domain.UserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("db.project.mvc.mapper.StoreMapper")
public interface StoreMapper {

    int insertStore(StoreVO storeVO) throws Exception;

//    public List<Store> getStoreList() throws Exception;

    StoreVO storeDetail(int storeID) throws Exception;

    int updateStoreViews(int storeID) throws Exception;

    List<StoreVO> storeList() throws Exception;

    List<StoreVO> storeList_HomeDistance(@Param("distance") int distance,@Param("userID") int userID) throws Exception;

    List<StoreVO> storeList_HomeDistanceWithKeyword(@Param("distance") int distance, @Param("userID") int userID,@Param("keyword") String keyword) throws Exception;

    List<StoreVO> storeList_HomeDistanceWithCategory(@Param("distance") int distance, @Param("userID") int userID,@Param("category") String category) throws Exception;

    List<StoreVO> storeList_City(@Param("city_code") int city_code, @Param("userID") int userID) throws Exception;

    List<StoreVO> storeList_CityWithCategory(@Param("city_code") int city_code,@Param("userID") int userID,@Param("category") String category) throws Exception;

    List<StoreVO> storeList_CityWithKeyword(@Param("city_code") int city_code,@Param("userID") int userID,@Param("keyword") String keyword) throws Exception;

    List<StoreVO> storeList_UserLike(int userID) throws Exception;

    UserVO getUser(int userID) throws Exception;

    List<StoreVO> TopTenViewsStoreList(float latitude, float longitude) throws Exception;

    List<StoreVO> TopTenLikesStoreList(float latitude, float longitude) throws Exception;

    int insertLike(int userID, int storeID) throws Exception;

    int deleteLike(int likeID) throws Exception;





}
