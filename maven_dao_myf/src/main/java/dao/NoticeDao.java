package dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import po.Commodity;
import po.User;

import java.util.List;
@Repository("UserDao")
@Mapper
public interface UserDao {
    public void update(User user);
    public void delete(User user);
    public void insert(User user);
    public User findByID(User user);
    public List<User> selectAll(User user);
}
