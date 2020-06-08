package db.project.mvc.mapper;

import db.project.mvc.domain.StoreVO;
import org.springframework.stereotype.Repository;

@Repository("db.project.mvc.mapper.StoreMapper")
public interface StoreMapper {

    int insertStore(StoreVO storeVO) throws Exception;

//    public List<Store> getStoreList() throws Exception;



}
