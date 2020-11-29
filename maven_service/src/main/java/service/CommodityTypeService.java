package service;

import po.CommodityType;

import java.util.List;


public interface CommodityTypeService {
    public List<CommodityType> selectAll(CommodityType commodityType);
}
