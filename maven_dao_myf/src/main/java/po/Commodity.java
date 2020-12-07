package po;
public class Commodity {
    private int Commodity_ID;
    private String Commodity_Name;
    private int Commodity_TypeID;
    private double Commodity_Price;
    private String Commodity_Descn;
    private int Commodity_Qtyl;

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

    public double getCommodity_Price() {
        return Commodity_Price;
    }

    public void setCommodity_Price(double commodity_Price) {
        Commodity_Price = commodity_Price;
    }

    public int getCommodity_TypeID() {
        return Commodity_TypeID;
    }

    public void setCommodity_TypeID(int commodity_TypeID) {
        Commodity_TypeID = commodity_TypeID;
    }

    public String getCommodity_Descn() {
        return Commodity_Descn;
    }

    public void setCommodity_Descn(String commodity_Descn) {
        Commodity_Descn = commodity_Descn;
    }

    public int getCommodity_Qtyl() {
        return Commodity_Qtyl;
    }

    public void setCommodity_Qtyl(int commodity_Qtyl) {
        Commodity_Qtyl = commodity_Qtyl;
    }
}
