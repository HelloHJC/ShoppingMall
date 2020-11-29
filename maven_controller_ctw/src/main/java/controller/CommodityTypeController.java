package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import po.CommodityType;
import service.CommodityTypeService;

import java.util.List;

@Controller
@RequestMapping("/commoditytype")
public class CommodityTypeController {
    @Autowired
    private CommodityTypeService commodityTypeService;
    @RequestMapping("/list")
    public String list(CommodityType type, Model model)
    {
        List<CommodityType> commodityTypeList = commodityTypeService.selectAll(type);
        model.addAttribute("list",commodityTypeList);
        for (CommodityType type2:commodityTypeList) {
            System.out.println(type2.getCommdityType_Name());
        }
        return "commoditytype/list";
    }
}
