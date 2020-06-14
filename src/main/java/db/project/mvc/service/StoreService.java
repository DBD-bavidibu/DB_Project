package db.project.mvc.service;

import db.project.mvc.domain.StoreVO;
import db.project.mvc.mapper.StoreMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("db.project.mvc.service.StoreService")
public class StoreService {

    @Resource(name="db.project.mvc.mapper.StoreMapper")
    StoreMapper storeMapper;

    public int insertStore(StoreVO storeVO) throws Exception{
        return storeMapper.insertStore(storeVO);
    }

    public List<StoreVO> storeList() throws Exception{
        return storeMapper.storeList();
    }

    public StoreVO storeDetail(int storeID) throws Exception{
        return storeMapper.storeDetail(storeID);
    }

    public int updateStoreViews(int storeID) throws Exception{
        return storeMapper.updateStoreViews(storeID);
    }

    public List<StoreVO> storeList_UserLike(int userID) throws Exception{
        return storeMapper.storeList_UserLike(userID);
    }

    public int insertLike(int userID, int storeID) throws Exception{
        return storeMapper.insertLike(userID,storeID);
    }

    public int deleteLike(int likeID) throws Exception{
        return storeMapper.deleteLike(likeID);
    }
}
