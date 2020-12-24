package po;
public class Commodity {
    private int Commodity_ID;
    private String Commodity_Name;
    private int Commodity_TypeID;
    private double Commodity_Price;
    private String Commodity_Description;
    private String Commodity_Picture;
    private String CommodityType_Name;
    private String Commodity_State;
    private int pageSize;
    private int pageNum;
    public String getCommodity_State() {
        return Commodity_State;
    }

    public void setCommodity_State(String commodity_State) {
        Commodity_State = commodity_State;
    }


    public String getCommodityType_Name() {
        return CommodityType_Name;
    }

    public void setCommodityType_Name(String commodityType_Name) {
        CommodityType_Name = commodityType_Name;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getCommodity_ID() {
        return Commodity_ID;
    }

    public void setCommodity_ID(int commodity_ID) {
        Commodity_ID = commodity_ID;
    }

    public String getCommodity_Name() {
        return Commodity_Name;
    }

    public void setCommodity_Name(String commodity_Name) {
        Commodity_Name = commodity_Name;
    }

    public int getCommodity_TypeID() {
        return Commodity_TypeID;
    }

    public void setCommodity_TypeID(int commodity_TypeID) {
        Commodity_TypeID = commodity_TypeID;
    }

    public double getCommodity_Price() {
        return Commodity_Price;
    }

    public void setCommodity_Price(double commodity_Price) {
        Commodity_Price = commodity_Price;
    }

    public String getCommodity_Description() {
        return Commodity_Description;
    }

    public void setCommodity_Description(String commodity_Description) {
        Commodity_Description = commodity_Description;
    }

    public String getCommodity_Picture() {
        return Commodity_Picture;
    }

    public void setCommodity_Picture(String commodity_Picture) {
        Commodity_Picture = commodity_Picture;
    }
}
