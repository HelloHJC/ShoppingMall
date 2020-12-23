package dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import po.Commodity;
import po.CommodityType;

import java.util.List;

@Repository("CommodityDao")
@Mapper
public interface CommodityDao {
    public void update(Commodity commodityType);
    public void delete(Commodity commodityType);
    public void insert(Commodity commodityType);
    public Commodity findByID(Commodity commodityType);
    public List<Commodity> selectAll(Commodity commodityType);
}
