package service.impl;

import dao.CommodityDao;
import dao.CommodityTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.Commodity;
import service.CommodityService;

import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityDao commodityDao;
    public List<Commodity> selectAll(Commodity commodity) {
        return commodityDao.selectAll(commodity);
    }

    public void insert(Commodity commodity) {
        commodityDao.insert(commodity);
    }

    public void update(Commodity commodity) {
        commodityDao.update(commodity);
    }

    public void delete(Commodity commodity) {
        commodityDao.delete(commodity);
    }

    public Commodity findByID(Commodity commodity) {
        return commodityDao.findByID(commodity);
    }
}
