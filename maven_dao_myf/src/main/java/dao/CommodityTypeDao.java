package dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import po.Commodity;
import po.CommodityType;

import java.util.List;

@Repository("CommodityTypeDao")
@Mapper
public interface CommodityTypeDao {
    public void update(CommodityType commodityType);
    public void delete(CommodityType commodityType);
    public void insert(CommodityType commodityType);
    public CommodityType findByID(CommodityType commodityType);
    public List<CommodityType> selectAll(CommodityType commodityType);
}
