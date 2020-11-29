package service.impl;

import dao.CommodityTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.CommodityType;
import service.CommodityTypeService;

import java.util.List;

@Service
public class CommodityTypeServiceImpl implements CommodityTypeService {
    @Autowired
    private CommodityTypeDao CommodityTypeDao;
    public List<CommodityType> selectAll(CommodityType commodityType) {
        return CommodityTypeDao.selectAll(commodityType);
    }
}
