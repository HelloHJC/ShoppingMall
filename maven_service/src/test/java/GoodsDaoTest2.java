import dao.CommodityTypeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import po.CommodityType;

//使用标准的JUnit @RunWith注释来告诉JUnit使用Spring TestRunner
@RunWith(SpringJUnit4ClassRunner.class)
public class GoodsDaoTest2 {
    @Autowired
    CommodityTypeDao dao;
    @Test
    public void testSelectAll()
    {
        for (CommodityType type:dao.selectAll(null)) {
            System.out.println(type.getCommodityType_Name());
        }
    }
}
