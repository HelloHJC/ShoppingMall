package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import po.Notice;
import service.NoticeService;
import utils.SerialUtils;

import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    @PostMapping(value = "/list")
    @ResponseBody
    public String list(Notice notice) throws JsonProcessingException {
        int pageNum = notice.getPageNum();
        int pageSize = notice.getPageSize();
        if (pageNum != -1 && pageSize != -1)
        {
            PageHelper.startPage(notice.getPageNum(),notice.getPageSize());
        }
        List<Notice> commodityTypeList = noticeService.selectAll(notice);
        PageInfo pageInfo = new PageInfo(commodityTypeList);
        return SerialUtils.toJSONString(pageInfo);
    }

    @PostMapping(value = "/findByID")
    @ResponseBody
    public String findById(Notice notice) throws JsonProcessingException {
        Notice findNotice = noticeService.findByID(notice);
        return SerialUtils.toJSONString(findNotice);
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public String update(Notice notice) throws JsonProcessingException {
        noticeService.update(notice);
        return SerialUtils.getSuccessResult();
    }

    @PostMapping(value = "/delete")
    @ResponseBody
    public String delete(Notice notice) throws JsonProcessingException {
        noticeService.delete(notice);
        return SerialUtils.getSuccessResult();
    }

    @PostMapping(value = "/insert")
    @ResponseBody
    public String insert(Notice notice) throws JsonProcessingException {
        noticeService.insert(notice);
        return SerialUtils.getSuccessResult();
    }
}
