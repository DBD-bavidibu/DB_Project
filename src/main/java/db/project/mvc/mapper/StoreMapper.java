package db.project.mvc.mapper;

import db.project.mvc.domain.StoreVO;
import db.project.mvc.domain.UserVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("db.project.mvc.mapper.StoreMapper")
public interface StoreMapper {

    int insertStore(StoreVO storeVO) throws Exception;

//    public List<Store> getStoreList() throws Exception;

    StoreVO storeDetail(int storeID) throws Exception;

    int updateStoreViews(int storeID) throws Exception;

    List<StoreVO> storeList() throws Exception;

    List<StoreVO> storeList_UserLike(int userID) throws Exception;

    UserVO getUser(int userID) throws Exception;

    List<StoreVO> TopTenViewsStoreList(float latitude, float longitude) throws Exception;

    List<StoreVO> TopTenLikesStoreList(float latitude, float longitude) throws Exception;

    int insertLike(int userID, int storeID) throws Exception;

    int deleteLike(int likeID) throws Exception;





}
