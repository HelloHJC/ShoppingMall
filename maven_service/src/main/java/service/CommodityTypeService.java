package service;

import po.CommodityType;

import java.util.List;


public interface CommodityTypeService {
    public List<CommodityType> selectAll(CommodityType commodityType);
    public void insert(CommodityType commodityType);
    public void update(CommodityType commodityType);
    public void delete(CommodityType commodityType);
}
