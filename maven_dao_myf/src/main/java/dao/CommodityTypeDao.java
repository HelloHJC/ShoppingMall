package dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import po.CommodityType;

import java.util.List;

@Repository("CommodityTypeDao")
@Mapper
public interface CommodityTypeDao {
    public List<CommodityType> selectAll(CommodityType commodityType);
}
