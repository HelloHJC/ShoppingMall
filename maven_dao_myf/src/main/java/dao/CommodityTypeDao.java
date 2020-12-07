package dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import po.Commodity;
import po.CommodityType;

import java.util.List;

@Repository("CommodityTypeDao")
@Mapper
public interface CommodityTypeDao {
    public void update(Commodity commodityType);
    public void delete(Commodity commodityType);
    public void insert(Commodity commodityType);
    public List<CommodityType> selectAll(CommodityType commodityType);
}
