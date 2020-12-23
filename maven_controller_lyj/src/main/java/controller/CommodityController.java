package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import po.Commodity;
import service.CommodityService;
import utils.SerialUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//test
@Controller
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    @PostMapping(value = "/list")
    @ResponseBody
    public String list(Commodity commodity, Model model) throws JsonProcessingException {
        PageHelper.startPage(commodity.getPageNum(), commodity.getPageSize());
        List<Commodity> commodityList = commodityService.selectAll(commodity);
        model.addAttribute("list", commodityList);
        for (Commodity type2 : commodityList) {
            System.out.println(type2.getCommodity_Name());
        }
        PageInfo pageInfo = new PageInfo(commodityList);
        return SerialUtils.toJSONString(pageInfo);
    }

    @PostMapping(value = "/findByID")
    @ResponseBody
    public String findById(Commodity commodity) throws JsonProcessingException {
        Commodity commodity1 = commodityService.findByID(commodity);
        return SerialUtils.toJSONString(commodity1);
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public String update(Commodity type) throws JsonProcessingException {
        commodityService.update(type);
        return SerialUtils.getSuccessResult();
    }

    @PostMapping(value = "/delete")
    @ResponseBody
    public String delete(Commodity type) throws JsonProcessingException {
        commodityService.delete(type);
        return SerialUtils.getSuccessResult();
    }

    @PostMapping(value = "/insert")
    @ResponseBody
    public String insert(Commodity type) throws JsonProcessingException {
        commodityService.insert(type);
        return SerialUtils.getSuccessResult();
    }

    @PostMapping(value = "/imgUpload")
    @ResponseBody
    public String imgUpload(MultipartFile multipartFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
        fileUpload(multipartFile,request);
        return SerialUtils.getSuccessResult();
    }

    public String fileUpload(MultipartFile imageFile,HttpServletRequest request) throws Exception{
        String fileName = null;
        if(!imageFile.isEmpty()){
            //获取项目跟路径
            String filePath = request.getServletContext().getRealPath("/");
            //获取项目名
            String projectName = request.getContextPath();
            //将项目跟路劲下的项目名称置为空，因为图片需要在项目外的webapp下面存放,sub截取下标为1的字符
            filePath=filePath.replace(projectName.substring(1),"");
            System.out.println(filePath);
            //重新生成文件名字
            fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"."+imageFile.getOriginalFilename().split("\\.")[1];
            //将文件保存到指定目录
            imageFile.transferTo(new File(filePath+"staticimage/"+fileName));
        }
        //返回文件名字供保存
        return fileName;
    }
}
