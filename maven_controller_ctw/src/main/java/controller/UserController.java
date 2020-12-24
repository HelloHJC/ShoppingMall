package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import po.User;
import service.UserService;
import utils.SerialUtils;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //前台传递邮箱和密码 登录
    @PostMapping(value = "/login")
    @ResponseBody
    public String login(User user) throws JsonProcessingException
    {
       List<User> users = userService.login(user);
       if (users.size()>0)
           return SerialUtils.getSuccessResult();
       else
           return SerialUtils.getErrorResult();
    }

    @PostMapping(value = "/list")
    @ResponseBody
    public String list(User user) throws JsonProcessingException {
        int pageNum = user.getPageNum();
        int pageSize = user.getPageSize();
        if (pageNum != -1 && pageSize != -1)
        {
            PageHelper.startPage(user.getPageNum(),user.getPageSize());
        }
        List<User> userList = userService.selectAll(user);
        PageInfo pageInfo = new PageInfo(userList);
        return SerialUtils.toJSONString(pageInfo);
    }

    @PostMapping(value = "/findByID")
    @ResponseBody
    public String findById(User user) throws JsonProcessingException {
        User findUser = userService.findByID(user);
        return SerialUtils.toJSONString(findUser);
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public String update(User user) throws JsonProcessingException {
        userService.update(user);
        return SerialUtils.getSuccessResult();
    }

    @PostMapping(value = "/delete")
    @ResponseBody
    public String delete(User user) throws JsonProcessingException {
        userService.delete(user);
        return SerialUtils.getSuccessResult();
    }

    @PostMapping(value = "/insert")
    @ResponseBody
    public String insert(User user) throws JsonProcessingException {
        userService.insert(user);
        return SerialUtils.getSuccessResult();
    }
}
