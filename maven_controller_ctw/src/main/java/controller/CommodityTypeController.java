package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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


    //用了pageHelper分页
    //pageNum:第几页
    //pageSize:一页多少条数据
    //使用pageHelper分页
    //pageHelper应用第一条select查询
    //最后用pageInfo包装list结果
    @PostMapping(value = "/list")
    @ResponseBody
    public String list(CommodityType type) throws JsonProcessingException {
        int pageNum = type.getPageNum();   //当前页数
        int pageSize = type.getPageSize(); //每页多少条数据
        if (pageNum != -1 && pageSize != -1) //如果我传递了两个-1,我就不分页
        {
            PageHelper.startPage(type.getPageNum(),type.getPageSize());
        }
        List<CommodityType> commodityTypeList = commodityTypeService.selectAll(type);
        PageInfo pageInfo = new PageInfo(commodityTypeList);
        return SerialUtils.toJSONString(pageInfo);//把实体对象转换成json字符串
    }

    //传递商品类型id参数  找到指定商品类型
    @PostMapping(value = "/findByID")
    @ResponseBody
    public String findById(CommodityType type) throws JsonProcessingException {
        //通过id找到商品类型
        CommodityType commodityType = commodityTypeService.findByID(type);
        return SerialUtils.toJSONString(commodityType);
    }

    //更新商品类型
    @PostMapping(value = "/update")
    @ResponseBody
    public String update(CommodityType type) throws JsonProcessingException {
        commodityTypeService.update(type);
        return SerialUtils.getSuccessResult();
    }

    //删除商品类型
    @PostMapping(value = "/delete")
    @ResponseBody
    public String delete(CommodityType type) throws JsonProcessingException {
        commodityTypeService.delete(type);
        return SerialUtils.getSuccessResult();
    }


    //新增商品类型
    @PostMapping(value = "/insert")
    @ResponseBody
    public String insert(CommodityType type) throws JsonProcessingException {
        commodityTypeService.insert(type);
        System.out.println("Pull request test");
        return SerialUtils.getSuccessResult();
    }
}
