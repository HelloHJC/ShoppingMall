package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @PostMapping(value = "/list")
    @ResponseBody
    public String list(CommodityType type) throws JsonProcessingException {
        PageHelper.startPage(1,2);
        List<CommodityType> commodityTypeList = commodityTypeService.selectAll(type);
        for (CommodityType type2:commodityTypeList) {
            System.out.println(type2.getCommodityType_Description());
        }
        return SerialUtils.toJSONString(commodityTypeList);
    }

    @PostMapping(value = "/findByID")
    @ResponseBody
    public String findById(CommodityType type) throws JsonProcessingException {
        CommodityType commodityType = commodityTypeService.findByID(type);
        return SerialUtils.toJSONString(commodityType);
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public String update(CommodityType type) throws JsonProcessingException {
        commodityTypeService.update(type);
        return SerialUtils.getSuccessResult();
    }

    @PostMapping(value = "/delete")
    @ResponseBody
    public String delete(CommodityType type) throws JsonProcessingException {
        commodityTypeService.delete(type);
        return SerialUtils.getSuccessResult();
    }

    @PostMapping(value = "/insert")
    @ResponseBody
    public String insert(CommodityType type) throws JsonProcessingException {
        commodityTypeService.insert(type);
        System.out.println("Pull request test");
        return SerialUtils.getSuccessResult();
    }
}
