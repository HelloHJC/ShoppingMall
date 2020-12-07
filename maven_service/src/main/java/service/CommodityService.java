package service;

import org.springframework.stereotype.Service;
import po.Commodity;

import java.util.List;

@Service
public interface CommodityService {
    public List<Commodity> selectAll(Commodity commodity);
    public void insert(Commodity commodity);
    public void update(Commodity commodity);
    public void delete(Commodity commodity);
}
