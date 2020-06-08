package db.project.mvc.service;

import db.project.mvc.domain.StoreVO;
import db.project.mvc.mapper.StoreMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("db.project.mvc.service.StoreService")
public class StoreService {

    @Resource(name="db.project.mvc.mapper.StoreMapper")
    StoreMapper storeMapper;

    public int insertStore(StoreVO storeVO) throws Exception{
        return storeMapper.insertStore(storeVO);
    }
}
