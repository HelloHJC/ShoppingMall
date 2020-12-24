package service.impl;

import dao.NoticeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.Notice;
import service.NoticeService;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;
    public List<Notice> selectAll(Notice commodity) {
        return noticeDao.selectAll(commodity);
    }

    public void insert(Notice commodity) {
        noticeDao.insert(commodity);
    }

    public void update(Notice commodity) {
        noticeDao.update(commodity);
    }

    public void delete(Notice commodity) {
        noticeDao.delete(commodity);
    }

    public Notice findByID(Notice commodity) {
        return noticeDao.findByID(commodity);
    }
}
