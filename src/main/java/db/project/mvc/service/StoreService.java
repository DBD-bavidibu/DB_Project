package db.project.mvc.service;

import db.project.mvc.domain.StoreVO;
import db.project.mvc.domain.UserVO;
import db.project.mvc.mapper.StoreMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("db.project.mvc.service.StoreService")
public class StoreService {

    @Resource(name="db.project.mvc.mapper.StoreMapper")
    StoreMapper storeMapper;

    // 가맹점을 추가
    public int insertStore(StoreVO storeVO) throws Exception{
        return storeMapper.insertStore(storeVO);
    }

    // 모든 가맹점 정보들을 리스트로 가져옴
    public List<StoreVO> storeList() throws Exception{
        return storeMapper.storeList();
    }

    // 가맹점의 상세정보를 가져옴
    public StoreVO storeDetail(int storeID) throws Exception{
        return storeMapper.storeDetail(storeID);
    }

    // 가맹점의 조회수를 업데이트
    public int updateStoreViews(int storeID) throws Exception{
        return storeMapper.updateStoreViews(storeID);
    }

    //사용자의 정보를 가져옴
    public UserVO getUser(int userID) throws Exception{
        return storeMapper.getUser(userID);
    }

    public List<StoreVO> TopTenViewsStoreList(float latitude, float longitude) throws Exception{
        return storeMapper.TopTenViewsStoreList(latitude,longitude);
    }

    public List<StoreVO> TopTenLikesStoreList(float latitude, float longitude) throws Exception{
        return storeMapper.TopTenLikesStoreList(latitude,longitude);
    }



    //사용자가 좋아요한 가맹점 리스트들을 가져옴
    public List<StoreVO> storeList_UserLike(int userID) throws Exception{
        return storeMapper.storeList_UserLike(userID);
    }

    // 가맹점을 좋아요함
    public int insertLike(int userID, int storeID) throws Exception{
        return storeMapper.insertLike(userID,storeID);
    }

    // 좋아요를 취소
    public int deleteLike(int likeID) throws Exception{
        return storeMapper.deleteLike(likeID);
    }
}
