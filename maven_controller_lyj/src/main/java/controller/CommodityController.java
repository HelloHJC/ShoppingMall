package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import po.Commodity;
import service.CommodityService;
import utils.SerialUtils;

import java.util.List;

//test
@Controller
@RequestMapping("/commodity")
public class CommodityController{
    @Autowired
    private CommodityService commodityService;
    @RequestMapping(value = "/list")
    @ResponseBody
    public String list(Commodity type, Model model) throws JsonProcessingException {
        List<Commodity> commodityList = commodityService.selectAll(type);
        model.addAttribute("list",commodityList);
        for (Commodity type2:commodityList) {
            System.out.println(type2.getCommodity_Name());
        }
        return SerialUtils.toJSONString(commodityList);
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public String update(Commodity type) throws JsonProcessingException {
        commodityService.update(type);
        return SerialUtils.getSuccessResult();
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public String delete(Commodity type) throws JsonProcessingException {
        commodityService.delete(type);
        return SerialUtils.getSuccessResult();
    }

    @RequestMapping(value = "/insert")
    @ResponseBody
    public String insert(Commodity type) throws JsonProcessingException {
        commodityService.insert(type);
        System.out.println("Pull request test");
        return SerialUtils.getSuccessResult();
    }
}
