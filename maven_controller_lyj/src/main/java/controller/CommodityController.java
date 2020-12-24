package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
import java.util.HashMap;
import java.util.List;

//用了pageHelper分页
//pageNum:第几页
//pageSize:一页多少条数据
//使用pageHelper分页
//pageHelper应用第一条select查询
//最后用pageInfo包装list结果
@Controller
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    @PostMapping(value = "/list")//处理post请求
    @ResponseBody
    public String list(Commodity commodity, Model model) throws JsonProcessingException {
        int pageNum = commodity.getPageNum();   //当前页数
        int pageSize = commodity.getPageSize();//数据总和
        if (pageNum != -1 && pageSize != -1)
        {
            PageHelper.startPage(commodity.getPageNum(), commodity.getPageSize());//分页
        }
        List<Commodity> commodityList = commodityService.selectAll(commodity);
        PageInfo pageInfo = new PageInfo(commodityList);//包装commodityList
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
    public String imgUpload(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String fileName = fileUpload(file,request);//MultipartFile file 前端传来 保存本地 返回前端
        HashMap<String,String> map = new HashMap<String, String>();
        map.put("fileName",fileName);//保存
        return SerialUtils.toJSONString(map);
    }

    public String fileUpload(MultipartFile imageFile,HttpServletRequest request) throws Exception{
        String fileName = null;
        if(!imageFile.isEmpty()){
            //获取项目跟路径
            String filePath = "D:\\Develop\\Environment\\apache-tomcat-9.0.37\\uploadImages";
            System.out.println(filePath);
            //重新生成文件名字
            fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"."+imageFile.getOriginalFilename().split("\\.")[1];
            //将文件保存到指定目录
            imageFile.transferTo(new File(filePath+"\\"+fileName));
        }
        //返回文件名字供保存
        return fileName;
    }
}
