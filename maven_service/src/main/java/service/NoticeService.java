package service;

import po.Notice;

import java.util.List;


public interface NoticeService {
    public List<Notice> selectAll(Notice user);
    public void insert(Notice user);
    public void update(Notice user);
    public void delete(Notice user);
    public Notice findByID(Notice user);
}
