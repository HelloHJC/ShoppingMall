package dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import po.Notice;

import java.util.List;

@Repository("NoticeDao")
@Mapper
public interface NoticeDao {
    public void update(Notice user);
    public void delete(Notice user);
    public void insert(Notice user);
    public Notice findByID(Notice user);
    public List<Notice> selectAll(Notice user);
}
