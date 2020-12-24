package service;

import po.Commodity;
import po.User;

import java.util.List;


public interface UserService {
    public List<User> login(User user);
    public List<User> selectAll(User user);
    public void insert(User user);
    public void update(User user);
    public void delete(User user);
    public User findByID(User user);
}
