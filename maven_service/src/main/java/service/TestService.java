package service;

import dao.CommodityTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import po.CommodityType;
import service.impl.CommodityTypeServiceImpl;

public class TestService {
    public static void main(String[] args) {
        CommodityTypeService commodityTypeService = new CommodityTypeServiceImpl();
        commodityTypeService.selectAll(null);
    }
}
