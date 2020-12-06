package service;

import org.springframework.stereotype.Service;
import po.Commodity;

import java.util.List;

@Service
public interface CommodityService {
    public List<Commodity> selectAll(Commodity commodity);
}
