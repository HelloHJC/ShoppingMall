package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import po.CommodityType;
import service.CommodityTypeService;
import utils.SerialUtils;

import java.util.List;

//git delete branch dev
@Controller
@RequestMapping("/commoditytype")
public class CommodityTypeController {
    @Autowired
    private CommodityTypeService commodityTypeService;
    @RequestMapping(value = "/list")
    @ResponseBody
    public String list(CommodityType type, Model model) throws JsonProcessingException {
        List<CommodityType> commodityTypeList = commodityTypeService.selectAll(type);
        model.addAttribute("list",commodityTypeList);
        for (CommodityType type2:commodityTypeList) {
            System.out.println(type2.getCommdityType_Name());
        }
        return SerialUtils.toJSONString(commodityTypeList);
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public String update(CommodityType type) throws JsonProcessingException {
        commodityTypeService.update(type);
        return SerialUtils.getSuccessResult();
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public String delete(CommodityType type) throws JsonProcessingException {
        commodityTypeService.delete(type);
        return SerialUtils.getSuccessResult();
    }

    @RequestMapping(value = "/insert")
    @ResponseBody
    public String insert(CommodityType type) throws JsonProcessingException {
        commodityTypeService.insert(type);
        System.out.println("Pull request test");
        return SerialUtils.getSuccessResult();
    }
}
