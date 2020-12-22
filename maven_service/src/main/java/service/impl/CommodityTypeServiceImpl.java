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
    private CommodityTypeDao commodityTypeDao;

    public CommodityType findByID(CommodityType commodityType) {
        return commodityTypeDao.findByID(commodityType);
    }

    public List<CommodityType> selectAll(CommodityType commodityType) {
        return commodityTypeDao.selectAll(commodityType);
    }

    public void insert(CommodityType commodityType) {
        commodityTypeDao.insert(commodityType);
    }

    public void update(CommodityType commodityType) {
        commodityTypeDao.update(commodityType);
    }

    public void delete(CommodityType commodityType) {
        commodityTypeDao.delete(commodityType);
    }
}
