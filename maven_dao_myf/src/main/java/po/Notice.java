package po;

public class Notice {
    private int Notice_ID;
    private String Notice_Title;
    private String Notice_Content;
    private String Notice_Picture;
    private int pageNum;
    private int pageSize;

    public int getNotice_ID() {
        return Notice_ID;
    }

    public void setNotice_ID(int notice_ID) {
        Notice_ID = notice_ID;
    }

    public String getNotice_Title() {
        return Notice_Title;
    }

    public void setNotice_Title(String notice_Title) {
        Notice_Title = notice_Title;
    }

    public String getNotice_Content() {
        return Notice_Content;
    }

    public void setNotice_Content(String notice_Content) {
        Notice_Content = notice_Content;
    }

    public String getNotice_Picture() {
        return Notice_Picture;
    }

    public void setNotice_Picture(String notice_Picture) {
        Notice_Picture = notice_Picture;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
