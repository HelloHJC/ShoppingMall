package service.impl;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.User;
import service.UserService;
import service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao commodityDao;
    public List<User> selectAll(User commodity) {
        return commodityDao.selectAll(commodity);
    }

    public void insert(User commodity) {
        commodityDao.insert(commodity);
    }

    public void update(User commodity) {
        commodityDao.update(commodity);
    }

    public void delete(User commodity) {
        commodityDao.delete(commodity);
    }

    public User findByID(User commodity) {
        return commodityDao.findByID(commodity);
    }
}
