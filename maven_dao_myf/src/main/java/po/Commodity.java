package po;
public class Commodity {
    private int Commodity_ID;
    private String Commodity_Name;
    private double Commodity_Price;
    private int Commodity_Stock;

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

    public int getCommodity_Stock() {
        return Commodity_Stock;
    }

    public void setCommodity_Stock(int commodity_Stock) {
        Commodity_Stock = commodity_Stock;
    }
}
